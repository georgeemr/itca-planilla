/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.DepartamentosPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import com.infosgroup.planilla.modelo.estructuras.FormatoReporte;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.modelo.procesos.ReportesStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Root
 */
@ViewScoped
@ManagedBean(name = "planilla$envioBoletas")
public class envioBoletasBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    @EJB
    private MailStatelessBean mailStatelessBean;
    @EJB
    private ReportesStatelessBean reportesBean;
    private List<ProgramacionPla> listaProgPla;
    private List<Empleados> listaJefesDeptos;
    private List<Departamentos> listaDeptos;
    private ProgramacionPla proPlaSeleccionada;
    private Short codDepto;
    private List<TiposPlanilla> listaTiposPlanilla;
    private Short tipoPlanilla;
    private AutocompleteProgramacionPlaConverter planillaConverter;

    @PostConstruct
    public void init() {
        listaTiposPlanilla = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        listaDeptos = planillaSessionBean.findDepartamentos(getSessionBeanADM().getCompania());
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public List<TiposPlanilla> getListaTiposPlanilla() {
        return listaTiposPlanilla;
    }

    public void setListaTiposPlanilla(List<TiposPlanilla> listaTiposPlanilla) {
        this.listaTiposPlanilla = listaTiposPlanilla;
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

    public List<ProgramacionPla> getListaProgPla() {
        return listaProgPla;
    }

    public void setListaProgPla(List<ProgramacionPla> listaProgPla) {
        this.listaProgPla = listaProgPla;
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

    @Override
    protected void limpiarCampos() {
        setTipoPlanilla(new Short("-1"));
        setProPlaSeleccionada(null);
        setCodDepto(new Short("-1"));
    }

    public AutocompleteProgramacionPlaConverter getPlanillaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            planillaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla));
        } else {
            planillaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return planillaConverter;
    }

    public void setPlanillaConverter(AutocompleteProgramacionPlaConverter planillaConverter) {
        this.planillaConverter = planillaConverter;
    }

    public List<ProgramacionPla> completePlanillaEmpleado(String query) {
        List<ProgramacionPla> suggestions = new ArrayList<ProgramacionPla>();
        for (ProgramacionPla p : planillaConverter.listaProgramacionPla) {
            if (p.getPkAsString().contains(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public String enviar$correo$action() {

        if (proPlaSeleccionada == null) {
            addMessage("Envio de Boletas", "Seleccione una planilla.", TipoMensaje.ERROR);
            return null;
        }
        if (codDepto != null && codDepto.equals(new Short("-1"))) {
            addMessage("Envio de Boletas", "Seleccione un departamento.", TipoMensaje.ERROR);
            return null;
        }

        try {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("\n\nBoletas de Pago");
            if (codDepto.equals(new Short("0"))) {
                for (Departamentos departamento : listaDeptos) {
                    listaJefesDeptos = planillaSessionBean.findJefesByDepto(departamento);
                    envioCorreo$action(listaJefesDeptos, mensaje, departamento);
                }
            } else {
                Departamentos d = planillaSessionBean.findDeptoById(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), codDepto));
                listaJefesDeptos = planillaSessionBean.findJefesByDepto(d);
                envioCorreo$action(listaJefesDeptos, mensaje, d);
            }
            addMessage("Envio Boletas", "Las Boletas han sido enviadas a los jefes", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Envio de Boletas.", "Ha ocurrido un error al enviar correos con Boletas.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void envioCorreo$action(List<Empleados> listaJefes, StringBuilder mensaje, Departamentos departamento) {
        List<DetalleAdjuntoCorreo> adjunto = new ArrayList<DetalleAdjuntoCorreo>(0);
        try {
            HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pAnio", String.valueOf(proPlaSeleccionada.getAnio()));
            parametros.put("pCia", String.valueOf(proPlaSeleccionada.getProgramacionPlaPK().getCodCia()));
            parametros.put("pCodDepto", String.valueOf(departamento.getDepartamentosPK().getCodDepto()));
            parametros.put("pCodPla", String.valueOf(proPlaSeleccionada.getProgramacionPlaPK().getCodTipopla()));
            parametros.put("pMes", String.valueOf(proPlaSeleccionada.getMes()));
            parametros.put("pNumPla", String.valueOf(proPlaSeleccionada.getNumPlanilla()));
            parametros.put("pEmp", "-1");
            byte[] reporteBoleta = new byte[0];
            reporteBoleta = reportesBean.generarDatosReporteSQL(FacesContext.getCurrentInstance(), parametros, "RPLA019", FormatoReporte.PDF);
            DetalleAdjuntoCorreo detalleAdjunto = new DetalleAdjuntoCorreo("Boletas_" + departamento.getNomDepto(), "application/pdf", reporteBoleta);
            adjunto.add(detalleAdjunto);
            for (Empleados jefe : listaJefes) {
                mailStatelessBean.enviarCorreoElectronicoAdjuntos("Boletas De Pago", mensaje.toString() + "\n\nDepartamento: " + departamento.getNomDepto(), jefe.getCorreo(), adjunto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
