/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Agencias;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "planilla$horasExtras")
@ViewScoped
public class HorasExtrasBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<ResumenAsistencia> horasExtras;
    private List<Planilla> listaPlanillas;
    private Planilla planillaSeleccionada;
    private Agencias agenciaSeleccionada;
    private List<Agencias> listaAgencias;

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
    }

    public Agencias getAgenciaSeleccionada() {
        return agenciaSeleccionada;
    }

    public void setAgenciaSeleccionada(Agencias agenciaSeleccionada) {
        this.agenciaSeleccionada = agenciaSeleccionada;
    }

    @PostConstruct
    public void init() {
        listaAgencias = planillaSessionBean.listarAgencias();
        listaPlanillas = planillaSessionBean.listarPlanilla();
    }

    public List<Agencias> getListaAgencias() {
        return listaAgencias;
    }

    public void setListaAgencias(List<Agencias> listaAgencias) {
        this.listaAgencias = listaAgencias;
    }

    public List<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<ResumenAsistencia> getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(List<ResumenAsistencia> horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void rowEditListener(RowEditEvent event) {
        boolean hayError = false;
        ResumenAsistencia resumen = (ResumenAsistencia) event.getObject();
        if (resumen.getPlanilla().getStatus().equals("G")) {
            hayError = true;
        }
        if (hayError) {
            planillaSessionBean.editar$action(resumen);
        } else {
            addMessage("Registro de Resumen de Asistencias", "La planilla no está en estado grabado", TipoMensaje.INFORMACION);
        }
        mostrarResumenAsistencias$action();
        hayError = false;
    }

    public String mostrarResumenAsistencias$action() {
        Boolean hayError = Boolean.FALSE;
        if (planillaSeleccionada == null) {
            addMessage("RRHH", "Seleccione la planilla", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
        }
        if (agenciaSeleccionada == null) {
            addMessage("RRHH", "Seleccione la sucursal", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
        }
        if (hayError) {
            return null;
        }
        horasExtras = planillaSessionBean.listarResumenByPlanillaSucursal(planillaSeleccionada, agenciaSeleccionada);
        return null;
    }
}