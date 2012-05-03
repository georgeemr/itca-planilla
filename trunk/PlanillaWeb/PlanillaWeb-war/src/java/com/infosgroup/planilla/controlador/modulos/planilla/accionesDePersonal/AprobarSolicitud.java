/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import com.infosgroup.planilla.modelo.entidades.TiposPlanilla;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "aprobarSolicitud")
@ViewScoped
public class AprobarSolicitud extends AbstractJSFPage implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    enum APRUEBA {JEFE, RECURSOS_HUMANOS};
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    private String planilla;
    private Short tipoPlanilla;
    private Cias empresa;
    private Boolean renderPlanilla = Boolean.FALSE;

    public AprobarSolicitud() {
    }

    public Boolean getRenderPlanilla() {
        switch (getTipoAccion()) {
            case 1: //Vacaciones Anuales
            case 2: //Dia de vacacion
            case 5: //Permiso sin goce de sueldo
                renderPlanilla = Boolean.TRUE;
                break;
            default:
                renderPlanilla = Boolean.FALSE;
                break;
        }
        return renderPlanilla;
    }

    public void setRenderPlanilla(Boolean renderPlanilla) {
        this.renderPlanilla = renderPlanilla;
    }

    @PostConstruct
    public void _init() {
        setEmpresa(getSessionBeanADM().getCompania());
    }

    public Cias getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Cias empresa) {
        this.empresa = empresa;
    }

    public String aprobarSolicitudJefe() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null) {
            addMessage("Aprobar Solicitud", "No ha seleccionado ninguna solicitud.", TipoMensaje.ERROR);
            return null;
        }
//        if (validaPlanilla()) return null;
        try {
//            switch (getTipoAccion()) {
//                case 1:
//                case 2:
//                case 5:
//                a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
//                a.setMes(new Short(getPlanilla().split(":")[2].toString()));
//                a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
//                a.setCodTipopla(getTipoPlanilla());
//                break;
//            }
            planillaSessionBean.jefeEditaSolicitud(a, "A");
            getSessionBeanPLA().setAccionSeleccionada(a);
            addMessage("Aprobar Solicitud", "Datos Guardados con éxito. \n\n", TipoMensaje.INFORMACION);
            enviarCorreoAccionPersonal(a, getManifiestoCorreo(APRUEBA.JEFE, a));
        } catch (Exception e) {
            addMessage("Aprobar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Usted no esta autorizado para realizar esta acción", e);
        }
        return null;
    }

    public String aprobarSolicitudRH() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null) {
            addMessage("Aprobar Solicitud", "No ha seleccionado ninguna solicitud.", TipoMensaje.ERROR);
            return null;
        }
        if (validaPlanilla()) return null;
        try {
            switch (getTipoAccion()) {
                case 1:
                case 2:
                case 5:
                a.setAnio(new Short(getPlanilla().split(":")[1].toString()));
                a.setMes(new Short(getPlanilla().split(":")[2].toString()));
                a.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
                a.setCodTipopla(getTipoPlanilla());
                break;
            }
            planillaSessionBean.rrhhEditaSolicitud(a, "A");
            getSessionBeanPLA().setAccionSeleccionada(a);
            addMessage("Aprobar Solicitud", "Datos Guardados con éxito. \n\n", TipoMensaje.INFORMACION);
            enviarCorreoAccionPersonal(a, getManifiestoCorreo(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Aprobar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Usted no esta autorizado para realizar esta acción", e);
        }
        return null;
    }

    public Short getTipoAccion() {
        if (getSessionBeanPLA().getAccionSeleccionada() == null) {
            return new Short("0");
        }
        return getSessionBeanPLA().getAccionSeleccionada().getAccionPersonalPK().getCodTipoaccion();
    }

    public String rechazarSolicitudRH() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null) {
            addMessage("Aprobar Solicitud", "No ha seleccionado ninguna solicitud.", TipoMensaje.ERROR);
            return null;
        }
        try {
            planillaSessionBean.rrhhEditaSolicitud(a, "R");
            getSessionBeanPLA().getAccionSeleccionada().setStatus("R");
            addMessage("Aprobar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            enviarCorreoAccionPersonal(a, getManifiestoCorreo(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Aprobar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Usted no esta autorizado para realizar esta acción", e);
        }
        return null;
    }

    public String rechazarSolicitudJefe() {
        AccionPersonal a = getSessionBeanPLA().getAccionSeleccionada();
        if (a == null) {
            addMessage("Aprobar Solicitud", "No ha seleccionado ninguna solicitud.", TipoMensaje.ERROR);
            return null;
        }
        try {
            planillaSessionBean.jefeEditaSolicitud(a, "R");
            getSessionBeanPLA().getAccionSeleccionada().setStatus("R");
            addMessage("Aprobar Solicitud", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            enviarCorreoAccionPersonal(a, getManifiestoCorreo(APRUEBA.RECURSOS_HUMANOS, a));
        } catch (Exception e) {
            addMessage("Aprobar Solicitud", "Usted no esta autorizado para realizar esta acción", TipoMensaje.ERROR);
            logger.log(Level.SEVERE, "Usted no esta autorizado para realizar esta acción", e);
        }
        return null;
    }

    public String regresar() {
        limpiarCampos();
        return "./../accionesPersonal.xhtml?faces-redirect=true";
    }

    @Override
    protected void limpiarCampos() {
        getSessionBeanPLA().setAccionSeleccionada(null);
    }

    public Boolean validaPlanilla() {
        Boolean error = Boolean.FALSE;
        switch (getTipoAccion()) {
            case 1:
            case 2:
            case 5:
            if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
                addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
                addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
            break;
        }
        return error;
    }

    public String getManifiestoCorreo(APRUEBA eaprueba, AccionPersonal a) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Solicitud Procesada.\n\n");
        mensaje.append("\n\nFecha: ").append(a.getFecha());
        mensaje.append("Detalle:\n\n\n\n");
        mensaje.append("\n\nResultado: Solicitud ").append(a.getAccEstado());
        if (eaprueba.equals(APRUEBA.JEFE)) {
            mensaje.append("\n\nProcesado por: ").append(getSessionBeanEMP().getEmpleadoSesion().getNombreCompleto()).append(" ( Jefe Inmediato ) ");
        } else {
            mensaje.append("\n\nProcesado por: ").append(getSessionBeanEMP().getEmpleadoSesion().getNombreCompleto()).append(" ( Recursos Humanos ) ");
        }
        mensaje.append("\n\nAtte. \n\nDepartamento de Recursos Humanos ").append(getSessionBeanADM().getCompania().getNomComercial());
        return mensaje.toString();
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = getPlanillaSessionBean().listarTipos(getEmpresa());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (getTipoPlanilla() != null && getTipoPlanilla() != -1) {
            listaPlanillas = getPlanillaSessionBean().getProgramacionPlaByTipo(getEmpresa().getCodCia(), getTipoPlanilla());
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public PlanillaSessionBean getPlanillaSessionBean() {
        return planillaSessionBean;
    }
}
