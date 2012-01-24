/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.estructuras.reportes.DetalleReporteEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.reportes.ReporteEvaluacion;
import com.infosgroup.planilla.modelo.facades.EscalaEvaluacionFacade;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author root
 */
@Stateless(name = "ReportesStatelessBean")
@LocalBean
public class ReportesStatelessBean {

    @EJB
    private EscalaEvaluacionFacade escalaEvaluacionFacade;
    @Resource(name = "jdbc/PlanillaDatasource")
    private DataSource planillaJDBCDatasource;

    @PermitAll
    public Boolean generarReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte) {
        String rutaReporte = null;
        try {
            Connection conexion = planillaJDBCDatasource.getConnection();
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[REPORTE] Ruta:      " + rutaReporte);
            System.out.println("[REPORTE] Parametros:" + parametros);
            System.out.println("[REPORTE] Conexion:  " + conexion);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
            response.getOutputStream().write(bytesReporte);
            response.getOutputStream().flush();
            conexion.close();
            facesContext.responseComplete();
            return Boolean.TRUE;
        } catch (Exception excpt) {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            excpt.printStackTrace(System.err);
            return Boolean.FALSE;
        }
    }

    @PermitAll
    public Boolean generarReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos) {
        String rutaReporte = null;
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[ReporteBean] Ruta:       " + rutaReporte);
            System.out.println("[ReporteBean] Parametros: " + parametros);
            System.out.println("[ReporteBean] Datasource: " + ds);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
            response.getOutputStream().write(bytesReporte);
            response.getOutputStream().flush();
            facesContext.responseComplete();
            return Boolean.TRUE;
        } catch (Exception excpt) {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            return Boolean.FALSE;
        }
    }

    @PermitAll
    public byte[] generarDatosReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos) {
        String rutaReporte = null;
        try {
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[ReporteBean] Ruta:       " + rutaReporte);
            System.out.println("[ReporteBean] Parametros: " + parametros);
            System.out.println("[ReporteBean] Datasource: " + ds);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            return bytesReporte;
        } catch (Exception excpt) {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            return null;
        }
    }

    @PermitAll
    public List<ReporteEvaluacion> listarReporteEvaluacion(Evaluacion evaluacion) {
        List<ReporteEvaluacion> l = new ArrayList<ReporteEvaluacion>(0);
        List<DetEvaluacion> lde = evaluacion.getDetEvaluacionList();
        Evaluacion e = evaluacion;
        for (DetEvaluacion de : /*evaluacion.getDetEvaluacionList()*/ lde) {
            ReporteEvaluacion reporte = new ReporteEvaluacion();
            reporte.setIdEmpresa(evaluacion.getPlantilla1().getTipoEvaluacion().getCompania().getIdCompania().intValue());
            reporte.setNombreEmpresa(evaluacion.getPlantilla1().getTipoEvaluacion().getCompania().getNomCompania());
            reporte.setNombreTipoEvaluacion(evaluacion.getPlantilla1().getTipoEvaluacion().getNomTipoEvaluacion());
            reporte.setIdEmpleado(evaluacion.getEmpleado1().getEmpleadoPK().getCodEmp().intValue());
            reporte.setNombreEmpleado(evaluacion.getEmpleado1().getNombreCompleto());
            reporte.setFechaInicioCampania(evaluacion.getCampania().getFechaInicial());
            reporte.setFechaFinCampania(evaluacion.getCampania().getFechaFinal());
            reporte.setIdPuesto(evaluacion.getEmpleado1().getUltimoPuesto().getPuestoPK().getCodPuesto().intValue());
            reporte.setNombrePuesto(evaluacion.getEmpleado1().getUltimoPuesto().getNombre());
            reporte.setIdDepartamento(evaluacion.getEmpleado1().getDepartamento().getDepartamentoPK().getIdDepartamento().intValue());
            reporte.setNombreDepartamento(evaluacion.getEmpleado1().getDepartamento().getNomDepartamento());
            reporte.setCalificacionFinal(getNotaFinal(evaluacion));
            reporte.setIdFactor(de.getPregunta().getFactor().getFactorPK().getCodFactor().intValue());
            reporte.setPregunta(de.getPregunta().getDescripcion());
            reporte.setIdPregunta(de.getPregunta().getPreguntaPK().getCodPregunta());
            reporte.setRespuesta(de.getRespuesta().getNivel());
            //reporte.setDetalleEvaluacion(getDetalleReporteEvaluacion(e.getDetEvaluacionList()));
            l.add(reporte);
        }

        return l;
    }

    @PermitAll
    public List<DetalleReporteEvaluacion> getDetalleReporteEvaluacion(List<DetEvaluacion> detalle) {
        List<DetalleReporteEvaluacion> det = new ArrayList<DetalleReporteEvaluacion>();
        for (DetEvaluacion e : eliminarRepetidos(detalle)) {
            Integer puntajeObtenido = getPuntajeObtenido(detalle, e);
            det.add(new DetalleReporteEvaluacion(e.getRespuesta().getNivel(),
                    puntajeObtenido,
                    e.getRespuesta().getValor().intValue(),
                    e.getPregunta().getFactor().getPonderacion().intValue(),
                    puntajeObtenido * e.getRespuesta().getValor().intValue() * e.getPregunta().getFactor().getPonderacion().intValue() / 100));
        }
        return det != null ? det : new ArrayList<DetalleReporteEvaluacion>();
    }

    @PermitAll
    public List<DetEvaluacion> eliminarRepetidos(List<DetEvaluacion> detalle) {
        List<DetEvaluacion> elementos = detalle;
        Set auxiliar = new HashSet();
        auxiliar.addAll(elementos);
        elementos.clear();
        elementos.addAll(auxiliar);
        return elementos;
    }

    @PermitAll
    public Integer getPuntajeObtenido(List<DetEvaluacion> detalle, DetEvaluacion e) {
        int d = 0;
        for (DetEvaluacion deta : detalle) {
            if (deta.getRespuesta().getNivel().equals(e.getRespuesta().getNivel())) {
                d++;
            }
        }
        return d;
    }

    @PermitAll
    public Integer totalEvaluacion(List<DetEvaluacion> detalle) {
        Integer nota = 0;
        for (DetEvaluacion e : detalle) {
            nota += e.getRespuesta().getValor().intValue();
        }
        return nota != null ? nota : 0;
    }

    @PermitAll
    public String getNotaFinal(Evaluacion e) {
        return escalaEvaluacionFacade.getEscalaByEvaluacion(e, totalEvaluacion(e.getDetEvaluacionList()));
    }

    @PermitAll
    public Boolean generarReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, FormatoReporte type) {
        String rutaReporte = null;
        try {
            Connection conexion = planillaJDBCDatasource.getConnection();
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[REPORTE] Ruta:      " + rutaReporte);
            System.out.println("[REPORTE] Parametros:" + parametros);
            System.out.println("[REPORTE] Conexion:  " + conexion);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);
            switch (type) {
                case PDF:
                    byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
                    response.setContentType("application/pdf");
                    response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
                    response.getOutputStream().write(bytesReporte);
                    response.getOutputStream().flush();
                    break;
                case EXCEL:
                    JRExporter exporter = new net.sf.jasperreports.engine.export.JRXlsExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jrPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".xls\";");
                    exporter.exportReport();
                    response.getOutputStream().flush();
                    break;
            }
            conexion.close();
            facesContext.responseComplete();
            return Boolean.TRUE;
        } catch (Exception excpt) {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            excpt.printStackTrace(System.err);
            return Boolean.FALSE;
        }
    }
}
