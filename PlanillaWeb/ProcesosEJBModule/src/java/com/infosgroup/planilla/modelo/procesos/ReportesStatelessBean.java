/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.estructuras.reportes.DetalleReporteEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.reportes.ReporteEvaluacion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
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
        ReporteEvaluacion reporte = new ReporteEvaluacion();
        reporte.setIdEmpresa( evaluacion.getPlantilla1().getTipoEvaluacion().getCompania().getIdCompania().intValue() );
        reporte.setNombreEmpresa(evaluacion.getPlantilla1().getTipoEvaluacion().getCompania().getNomCompania());
        reporte.setNombreTipoEvaluacion( evaluacion.getPlantilla1().getTipoEvaluacion().getNomTipoEvaluacion() );
        reporte.setIdEmpleado( evaluacion.getEmpleado1().getEmpleadoPK().getCodEmp().intValue() );
        reporte.setNombreEmpleado(evaluacion.getEmpleado1().getNombreCompleto() );
        reporte.setFechaInicioCampania(evaluacion.getCampania().getFechaInicial());
        reporte.setFechaFinCampania(evaluacion.getCampania().getFechaFinal());
        reporte.setDetalleEvaluacion( getDetalleReporteEvaluacion(evaluacion.getDetEvaluacionList() ));
        l.add(reporte);
        return l;
    }
    
    public List<DetalleReporteEvaluacion> getDetalleReporteEvaluacion( List<DetEvaluacion> detalle ){
        List<DetalleReporteEvaluacion> det = new ArrayList<DetalleReporteEvaluacion>();
        for ( DetEvaluacion e: detalle ){            
            det.add( new DetalleReporteEvaluacion( e.getRespuesta().getNivel(), 0  , e.getRespuesta().getValor().intValue(), e.getPregunta().getFactor().getPonderacion().intValue(), 0  ));
        }
        return det != null ? det:new ArrayList<DetalleReporteEvaluacion>();
    }

    /*@PermitAll
    public List<ReporteEvaluacion> listarReporteEvaluacion() {
        List<ReporteEvaluacion> l = new ArrayList<ReporteEvaluacion>();
        ReporteEvaluacion reporte = new ReporteEvaluacion();
        reporte.setNombreEmpresa("Prueba");
        reporte.setNombreEmpleado("Prueba");
        l.add(reporte);
        return l;
    }*/
}
