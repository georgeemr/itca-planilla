/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$CargarDatosBackendBean")
@ViewScoped
public class CargarDatosBackendBean extends AbstractJSFPage implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    private List<DeducPresta> listaDeduccionPrestacion;
    private Short tipoPlanilla = -1;
    private Integer deduccionPrestacion = -1;
    private String planilla = "-1";
    private String anio;
    private String mes;
    private String numeroPlanilla;
    private DeducPresta deduccionPrestacionSeleccionada;
    private Short empresa;
    private List<Empleados> listaEmpleados;

    public CargarDatosBackendBean() {
    }

    @PostConstruct
    public void _initPage() {
        empresa = getSessionBeanADM().getCompania().getCodCia();
    }

    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();

        if (file == null) {
            addMessage("Carga de Datos", "Seleccione un archivo.", TipoMensaje.ERROR);
            return;
        }

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(file.getInputstream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            setListaEmpleados(new ArrayList<Empleados>());
            while (bufferedReader.ready()) {
                Integer codDeduccion = null;
                Integer codEmpleado = null;
                Short codEmpresa = 1; //-----Validar con archivo obtenido
                Double valor = null;
                String linea = bufferedReader.readLine();
                String[] valores = linea.split(",");

                try {
                    codDeduccion = Integer.parseInt(valores[0]);
                } catch (Exception excpt) {
                    codDeduccion = 0;
                }

                try {
                    codEmpleado = Integer.parseInt(valores[1]);
                } catch (Exception excpt) {
                    codEmpleado = 0;
                }

                try {
                    valor = Double.parseDouble(valores[2]);
                } catch (Exception excpt) {
                    valor = 0.00d;
                }

                if (codDeduccion.equals(deduccionPrestacion) && codEmpresa.equals(empresa)) {
                    //if (planillaSessionBean.existeEnResumen(new ResumenAsistenciaPK(empresa, new Short(anio), new Short(mes), new Short(numeroPlanilla), codEmpleado, tipoPlanilla))) {
                    listaEmpleados.add(planillaSessionBean.findEmpleadosByID(new EmpleadosPK(empresa, codEmpleado)));
                    //}
                }
            }

            addMessage("Carga de Datos", "Datos obtenidos con exito, " + listaEmpleados.size() + " empleados cargados.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Carga de Datos", "Ha sido imposible reconocer la estructura del archivo seleccionado.", TipoMensaje.ERROR);
            e.printStackTrace();
        }
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getAnio() {
        anio = planilla != null ? planilla.split(":")[1] : "";
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        mes = planilla != null ? planilla.split(":")[2] : "";
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public DeducPresta getDeduccionPrestacionSeleccionada() {
        deduccionPrestacionSeleccionada = planillaSessionBean.findDeducPrestaByPK(new DeducPrestaPK(deduccionPrestacion, getSessionBeanADM().getCompania().getCodCia()));
        return deduccionPrestacionSeleccionada;
    }

    public void setDeduccionPrestacionSeleccionada(DeducPresta deduccionPrestacionSeleccionada) {
        this.deduccionPrestacionSeleccionada = deduccionPrestacionSeleccionada;
    }

    public String getNumeroPlanilla() {
        numeroPlanilla = planilla != null ? planilla.split(":")[3] : "";
        return numeroPlanilla;
    }

    public void setNumeroPlanilla(String numeroPlanilla) {
        this.numeroPlanilla = numeroPlanilla;
    }

    public Integer getDeduccionPrestacion() {
        return deduccionPrestacion;
    }

    public void setDeduccionPrestacion(Integer deduccionPrestacion) {
        this.deduccionPrestacion = deduccionPrestacion;
    }

    public List<DeducPresta> getListaDeduccionPrestacion() {
        listaDeduccionPrestacion = planillaSessionBean.findDeducPrestaByCias(getSessionBeanADM().getCompania());
        return listaDeduccionPrestacion;
    }

    public void setListaDeduccionPrestacion(List<DeducPresta> listaDeduccionPrestacion) {
        this.listaDeduccionPrestacion = listaDeduccionPrestacion;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    @Override
    protected void limpiarCampos() {
        tipoPlanilla = -1;
        deduccionPrestacion = -1;
        planilla = "-1";
    }

    public String procesar() {
        // Eliminando los movimientos para ese tipo de planilla
        // planillaSessionBean.eliminarMovimientosDP(empresa, new Short(anio), new Short(mes), tipoPlanilla, new Short(numeroPlanilla), deduccionPrestacion.shortValue());

        if (listaEmpleados == null || listaEmpleados.size() <= 0) {
            addMessage("Cargar Datos", "No se han ingresado datos de empleados.", TipoMensaje.ERROR);
            return null;
        }

        addMessage("Cargar Datos", "Datos procesados con exito.", TipoMensaje.INFORMACION);
        limpiarCampos();
        return null;
    }
}