/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.DepartamentosPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Elicia Chopin
 */
@ManagedBean(name = "planilla$envioBoletas")
@ViewScoped
public class envioBoletasBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private MailStatelessBean mailStatelessBean;
    @EJB
    private ReportesStatelessBean reportesBean;
    private List<ProgramacionPla> listaProgPla;
    private List<Planilla> listaPlanillas;
    private List<Empleados> listaJefesDeptos;
    private List<Departamentos> listaDeptos;
    private Planilla planillaSeleccionada;
    private ProgramacionPla proPlaSeleccionada;
    private Short codDepto;
    private Departamentos deptoSeleccionado;
    private Boolean todos = true;

    @PostConstruct
    public void init() {
        listaProgPla = planillaSessionBean.findProPlaByCia(getSessionBeanADM().getCompania());
        listaDeptos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
    }

    public List<Departamentos> getListaDeptos() {
        return listaDeptos;
    }

    public void setListaDeptos(List<Departamentos> listaDeptos) {
        this.listaDeptos = listaDeptos;
    }

    public List<Empleados> getListaJefesDeptos() {
        return listaJefesDeptos;
    }

    public void setListaJefesDeptos(List<Empleados> listaJefesDeptos) {
        this.listaJefesDeptos = listaJefesDeptos;
    }

    public List<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<ProgramacionPla> getListaProgPla() {
        return listaProgPla;
    }

    public void setListaProgPla(List<ProgramacionPla> listaProgPla) {
        this.listaProgPla = listaProgPla;
    }

    public Planilla getPlanillaSeleccionada() {
        return planillaSeleccionada;
    }

    public void setPlanillaSeleccionada(Planilla planillaSeleccionada) {
        this.planillaSeleccionada = planillaSeleccionada;
    }

    public ProgramacionPla getProPlaSeleccionada() {
        return proPlaSeleccionada;
    }

    public void setProPlaSeleccionada(ProgramacionPla proPlaSeleccionada) {
        this.proPlaSeleccionada = proPlaSeleccionada;
    }

    public Short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(Short codDepto) {
        this.codDepto = codDepto;
    }

    public Departamentos getDeptoSeleccionado() {
        return deptoSeleccionado;
    }

    public void setDeptoSeleccionado(Departamentos deptoSeleccionado) {
        this.deptoSeleccionado = deptoSeleccionado;
    }

    public Boolean getTodos() {
        return todos;
    }

    public void setTodos(Boolean todos) {
        this.todos = todos;
    }

    @Override
    protected void limpiarCampos() {
        return;
    }

    @PermitAll
    public void onRowSelectProPla(SelectEvent event) {
        setProPlaSeleccionada((ProgramacionPla) event.getObject());
        listaPlanillas = planillaSessionBean.findByProPla(proPlaSeleccionada);
        listaDeptos = planillaSessionBean.findDepByPla(proPlaSeleccionada);
        deptoSeleccionado = null;
    }

    @PermitAll
    public void depto_change(ValueChangeEvent Event) {
        Short valor = (Short) Event.getNewValue();
        todos = false;
        if (valor != null) {
            DepartamentosPK pk = new DepartamentosPK();
            pk.setCodCia(getSessionBeanADM().getCompania().getCodCia());
            pk.setCodDepto(valor);
            deptoSeleccionado = planillaSessionBean.findDeptoById(pk);
            listaPlanillas = planillaSessionBean.findByProPlaAndDepto(proPlaSeleccionada, deptoSeleccionado.getDepartamentosPK().getCodDepto());
            todos = false;
        } else {
            todos = true;
            deptoSeleccionado = null;
            listaPlanillas = planillaSessionBean.findByProPla(proPlaSeleccionada);
        }
    }

    public String enviar$correo$action() {
        ProgramacionPla ev = proPlaSeleccionada;
        if (ev == null) {
            addMessage("Envio de Boletas", "No ha seleccionado ninguna planilla", TipoMensaje.ERROR);
            return null;
        }
        try {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("\n\nBoletas de Pago");
            if (todos) {
                for (Departamentos deptoPlanilla : listaDeptos) {
                    listaJefesDeptos = planillaSessionBean.findJefesByDepto(deptoPlanilla);
                    envioCorreo$action(listaJefesDeptos, mensaje, deptoPlanilla);
                }
            } else {
                listaJefesDeptos = planillaSessionBean.findJefesByDepto(deptoSeleccionado);
                envioCorreo$action(listaJefesDeptos, mensaje, deptoSeleccionado);
            }
            addMessage("Envio Boletas", "las Boletas han sido enviadas a los jefes", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Envio de Boletas.", "Ha ocurrido un error al enviar correos con Boletas.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void envioCorreo$action(List<Empleados> listaJefes, StringBuilder mensaje, Departamentos dep) {
        List<DetalleAdjuntoCorreo> adjunto = new ArrayList<DetalleAdjuntoCorreo>(0);
        Short anio = proPlaSeleccionada.getAnio();
        Short cia = proPlaSeleccionada.getProgramacionPlaPK().getCodCia();
        Short depto = dep.getDepartamentosPK().getCodDepto();
        Short tipo = proPlaSeleccionada.getProgramacionPlaPK().getCodTipopla();
        Integer codEmp = 999999;
        Short mes = proPlaSeleccionada.getMes();
        Short numPla = proPlaSeleccionada.getNumPlanilla();

        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("pAnio", anio.toString());
        parametros.put("pCia", cia.toString());
        parametros.put("pCodDepto", depto.toString());
        parametros.put("pCodPla", tipo.toString());
        parametros.put("pEmp", codEmp.toString());
        parametros.put("pMes", mes.toString());
        parametros.put("pNumPla", numPla.toString());
        String nombreBoleta = "Boletas";
        byte[] reporteBoleta = new byte[0];
        reporteBoleta = reportesBean.generarDatosReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA018", FormatoReporte.PDF);
        DetalleAdjuntoCorreo detalleAdjunto = new DetalleAdjuntoCorreo(nombreBoleta, "application/pdf", reporteBoleta);
        adjunto.add(detalleAdjunto);
        //mensaje.append("\n\nDepartamento: ").append(dep.getNomDepto());
        for (Empleados jefe : listaJefesDeptos) {
            mailStatelessBean.enviarCorreoElectronicoAdjuntos("Boletas De Pago", mensaje.toString() + "\n\nDepartamento: " + dep.getNomDepto(), jefe.getCorreo(), adjunto);
        }
    }
}
