/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.reportes.ReporteEvaluacion;
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
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 * @author root
 */
@Stateless(name = "ReportesStatelessBean")
@LocalBean
public class ReportesStatelessBean
{

@Resource(name="jdbc/PlanillaDatasource")
private DataSource planillaJDBCDatasource;

@PermitAll
public Boolean generarReporteSQL(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte)
{
String rutaReporte = null;
try
    {
    Connection conexion = planillaJDBCDatasource.getConnection();
    String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();    
    rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
    parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
    System.out.println("[REPORTE] Ruta:      " + rutaReporte);
    System.out.println("[REPORTE] Parametros:" + parametros);
    System.out.println("[REPORTE] Conexion:  " + conexion);
//    JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, conexion);
//    byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
//    response.getOutputStream().write(bytesReporte);
    response.getOutputStream().flush();
    conexion.close();
    facesContext.responseComplete();
    return Boolean.TRUE;
    }
catch (Exception excpt)
    {
    System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
    System.out.println(excpt.getMessage());
    return Boolean.FALSE;
    }    
}

@PermitAll
public Boolean generarReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos)
{
String rutaReporte = null;
try
    {
//    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
    String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
    rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
    parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
    System.out.println("[ReporteBean] Ruta:       " + rutaReporte);
    System.out.println("[ReporteBean] Parametros: " + parametros);
//    System.out.println("[ReporteBean] Datasource: " + ds);
//    JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds) ;
//    byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
//    response.getOutputStream().write(bytesReporte);
    response.getOutputStream().flush();
    facesContext.responseComplete();
    return Boolean.TRUE;
    }
catch (Exception excpt)
    {
    System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
    System.out.println(excpt.getMessage());
    return Boolean.FALSE;
    }    
}

//@PermitAll
//public byte[] generarDatosReporteBean(FacesContext facesContext, HashMap<String, Object> parametros, String nombreArchivoReporte, Collection datos)
//{
//String rutaReporte = null;
//try
//    {
////    JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datos);
//    String r = ((ServletContext) facesContext.getExternalContext().getContext()).getRealPath("/");
//    rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
//    parametros.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
//    System.out.println("[ReporteBean] Ruta:       " + rutaReporte);
//    System.out.println("[ReporteBean] Parametros: " + parametros);
////    System.out.println("[ReporteBean] Datasource: " + ds);
////    JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametros, ds) ;
////    byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);
//    return bytesReporte;
//    }
//catch (Exception excpt)
//    {
//    System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
//    System.out.println(excpt.getMessage());
//    return null;
//    }    
//}

@PermitAll
public List<ReporteEvaluacion> listarReporteEvaluacion(Evaluacion evaluacion)
{
List<ReporteEvaluacion> l = new ArrayList<ReporteEvaluacion>(0);
ReporteEvaluacion reporte = new ReporteEvaluacion();
reporte.setCompania(evaluacion.getPlantilla1().getTipoEvaluacion().getCompania().getNomCompania());
reporte.setEmpleado(evaluacion.getEmpleado1().getNombres());
l.add(reporte);
return l;
}

}
