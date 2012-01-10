/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.applicationbean;

import com.pos.model.FormatoReporte;
import java.sql.Connection;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Soporte
 */
@ManagedBean(name = "ApplicationBeanPOS")
@ApplicationScoped
public class ApplicationBeanPOS {

    /** Creates a new instance of ApplicationBeanPOS */
    public ApplicationBeanPOS() {
    }

    public void imprimirReport(Map<String, Object> parametrosReporte, String nombreArchivoReporte, FormatoReporte formato) {
        String rutaReporte = null;
        Map<String, Object> parametrosRep = null;
        Connection conexion = null;
        String rutaImagen = "";
        DataSource ds;
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ServletContext sc = (ServletContext) ec.getContext();
            String r = sc.getRealPath("/");
            HttpServletResponse response = (HttpServletResponse) ec.getResponse();
            rutaReporte = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + nombreArchivoReporte + ".jasper";
            rutaImagen = r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator + "imagenes" + java.io.File.separator;
            parametrosReporte.put("RUTA_IMAGEN", rutaImagen);
            parametrosRep = parametrosReporte;
            ds = (DataSource) InitialContext.doLookup("jdbc/POSDatasource");
            conexion = ds.getConnection();
            parametrosRep.put("SUBREPORT_DIR", r + "resources" + java.io.File.separator + "reportes" + java.io.File.separator);
            System.out.println("[REPORTE] Ruta          ::: " + rutaReporte);
            System.out.println("[REPORTE] Parametros    ::: " + parametrosRep);
            System.out.println("[REPORTE] Conexion      ::: " + conexion);
            JasperPrint jrPrint = JasperFillManager.fillReport(rutaReporte, parametrosRep, conexion);
            byte[] bytesReporte = JasperExportManager.exportReportToPdf(jrPrint);

            switch (formato) {
                case PDF:
                    response.setContentType("application/pdf");
                    break;
                case EXCEL:
                    response.setContentType("application/xls");
                    break;
            }

            response.setHeader("Content-Disposition", "attachment;filename=\"" + nombreArchivoReporte + ".pdf\";");
            response.getOutputStream().write(bytesReporte);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            conexion.close();
            conexion = null;
        } catch (Exception excpt) {
            excpt.printStackTrace();
            System.out.println(excpt.getClass().getName() + ": " + excpt.getLocalizedMessage());
            System.out.println(excpt.getMessage());
        }
    }
}
