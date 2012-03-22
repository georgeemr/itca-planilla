/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.EmpleadosPK;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.estructuras.reportes.DetalleReporteEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.reportes.ReporteEvaluacion;
import com.infosgroup.planilla.modelo.facades.CiasFacade;
import com.infosgroup.planilla.modelo.facades.EscalaEvaluacionFacade;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author root
 */
@Stateless(name = "ReportesStatelessBean")
@LocalBean
public class ReportesStatelessBean {

    @EJB
    private CiasFacade ciasFacade;
    @EJB
    private EscalaEvaluacionFacade escalaEvaluacionFacade;
    @Resource(name = "jdbc/PlanillaDatasource")
    private DataSource planillaJDBCDatasource;

    @PermitAll
    public Boolean generarReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte) {
        String rutaReporte;
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
        String rutaReporte;
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
    public byte[] generarDatosReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, FormatoReporte type) {
        String rutaReporte;
        try {
            Connection conexion = planillaJDBCDatasource.getConnection();
            String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[REPORTE] Ruta:      " + rutaReporte);
            System.out.println("[REPORTE] Parametros:" + parametros);
            System.out.println("[REPORTE] Conexion:  " + conexion);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
            if((conexion != null) && !conexion.isClosed())
            conexion.close();
            return bytesReporte;
        } catch (Exception excpt) {
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
            excpt.printStackTrace(System.err);
            return null;
        }
    }

    @PermitAll
    public byte[] generarDatosReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos) {
        String rutaReporte;
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
        for (DetEvaluacion de : lde) {
            ReporteEvaluacion reporte = new ReporteEvaluacion();
            reporte.setIdEmpresa(new Integer(evaluacion.getPlantilla1().getTipoEvaluacion().getTipoEvaluacionPK().getCodCia()));
            reporte.setNombreEmpresa(ciasFacade.find(evaluacion.getPlantilla1().getTipoEvaluacion().getTipoEvaluacionPK().getCodCia()).getNomComercial());
            reporte.setNombreTipoEvaluacion(evaluacion.getPlantilla1().getTipoEvaluacion().getNomTipoEvaluacion());
            reporte.setIdEmpleado(evaluacion.getEmpleados().getEmpleadosPK().getCodEmp().intValue());
            reporte.setNombreEmpleado(evaluacion.getEmpleados().getNombreCompleto());
            reporte.setFechaInicioCampania(evaluacion.getCampania().getFechaInicial());
            reporte.setFechaFinCampania(evaluacion.getCampania().getFechaFinal());
            reporte.setIdPuesto(new Integer(evaluacion.getEmpleados().getPuestos().getPuestosPK().getCodPuesto()));
            reporte.setNombrePuesto(evaluacion.getEmpleados().getPuestos().getNomPuesto());
            reporte.setIdDepartamento(new Integer(evaluacion.getEmpleados().getDepartamentos().getDepartamentosPK().getCodDepto()));
            reporte.setNombreDepartamento(evaluacion.getEmpleados().getDepartamentos().getNomDepto());
            reporte.setCalificacionFinal(getNotaFinal(evaluacion));
            reporte.setIdFactor(new Integer(de.getPregunta().getFactor().getFactorPK().getCodFactor()));
            reporte.setPregunta(de.getPregunta().getDescripcion());
            reporte.setIdPregunta(de.getPregunta().getPreguntaPK().getCodPregunta());
            reporte.setRespuesta(de.getRespuesta().getNivel());
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
                    e.getRespuesta().getValor().intValue(), 100,
                    puntajeObtenido * e.getRespuesta().getValor().intValue() * 100 / 100));
        }
        return (det != null) ? det : new ArrayList<DetalleReporteEvaluacion>();
    }

    @PermitAll
    public List<DetEvaluacion> eliminarRepetidos(List<DetEvaluacion> detalle) {
        List<DetEvaluacion> elementos = detalle;
        Set<DetEvaluacion> auxiliar = new HashSet<DetEvaluacion>();
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
        String rutaReporte;
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

    @PermitAll
    public void generarConstanciaSueldo(EmpleadosPK empleadosPK) {
        Double val_isss = 0.0;
        Double val_afp = 0.0;
        Double val_renta = 0.0;
        try {
            Connection conexion = planillaJDBCDatasource.getConnection();
            CallableStatement statement = conexion.prepareCall("begin DEDUC_LEYREPORTS(?, ?, ?, ?, ?); end;");
            statement.setBigDecimal(1, new BigDecimal(empleadosPK.getCodCia()));
            statement.setBigDecimal(2, new BigDecimal(empleadosPK.getCodEmp()));
            statement.registerOutParameter(3, Types.DOUBLE);
            statement.registerOutParameter(4, Types.DOUBLE);
            statement.registerOutParameter(5, Types.DOUBLE);
            statement.execute();
            val_isss = statement.getDouble(3);
            val_afp = statement.getDouble(4);
            val_renta = statement.getDouble(5);
        } catch (Exception excpt) {
            val_isss = 0.0;
            val_afp = 0.0;
            val_renta = 0.0;
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, excpt.getLocalizedMessage());
        }
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("pCia", new BigDecimal(empleadosPK.getCodCia()));
        parametros.put("pCodEmp", new BigDecimal(empleadosPK.getCodEmp()));
        parametros.put("val_Isss", new BigDecimal(val_isss));
        parametros.put("val_AFP", new BigDecimal(val_afp));
        parametros.put("val_Renta", new BigDecimal(val_renta));
        generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "ReportRH_HUMANOS");
    }
}
