/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author root
 */
public class SolicitudVacacionColectiva extends SolicitudDePersonal implements java.io.Serializable {

    private String criterioSeleccionado;
    private java.util.List<Departamentos> listaDepartamentos;
    private Short departamento;
    private Short tipoPlanilla;
    private String planilla;
    private Integer valorAfectados = 0;
    private List<Empleados> listaEmpleadosAfectar;
    private Empleados[] empleadosSeleccionados;
    private List<ProgramacionPla> listaPlanillas;

    public SolicitudVacacionColectiva(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean().getProgramacionPlaByTipo(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public Empleados[] getEmpleadosSeleccionados() {
        return empleadosSeleccionados;
    }

    public void setEmpleadosSeleccionados(Empleados[] empleadosSeleccionados) {
        this.empleadosSeleccionados = empleadosSeleccionados;
    }

    public List<Empleados> getListaEmpleadosAfectar() {
        return listaEmpleadosAfectar;
    }

    public void setListaEmpleadosAfetar(List<Empleados> listaEmpleadosAfectar) {
        this.listaEmpleadosAfectar = listaEmpleadosAfectar;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(String criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = planillaSessionBean().findDepartamentos(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public void limpiarFormaAplicar(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public Integer getValorAfectados() {
        return valorAfectados;
    }

    public void setValorAfectados(Integer valorAfectados) {
        this.valorAfectados = valorAfectados;
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) {
            return null;
        }
        List<Empleados> e = Arrays.asList(empleadosSeleccionados);
        if (criterioSeleccionado.equals("departamentos")) {
            //Si ha seleccionado empleados guarda la seleccion, de lo contrario se guarda la solicitud para todos.
            if (e == null || e.size() <= 0) {
                e = planillaSessionBean().listaAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)));
            }

        } else if (criterioSeleccionado.equals("tipoPlanilla")) {
            if (e == null || e.size() <= 0) {
                e = planillaSessionBean().listaAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getEncabezadoSolicitud().getEmpresa(), tipoPlanilla)));
            }
        }
        try {
            planillaSessionBean().registrarVacacionColetiva(getAccionesPersonal(e));
            addMessage("Solicitud de Vacaciones Colectivas", "Datos guardados exitosamente.", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception exception) {
            addMessage("Solicitud de Vacaciones Colectivas", exception.getMessage(), TipoMensaje.ERROR);
        }

        return null;
    }

    public List<AccionPersonal> getAccionesPersonal(List<Empleados> empleados) throws Exception {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        if (empleados == null || empleados.size() <= 0) {
            throw new Exception("No ha seleccionado ningun empleado para generar la solicitud.");
        }
        for (Empleados e : empleados) {
            l.add(getAccionPersonal(e));
        }
        return l != null ? l : new ArrayList<AccionPersonal>();
    }

    public AccionPersonal getAccionPersonal(Empleados e) {
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), e));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(e);
        accionPersonal.setFecha(new java.util.Date());
        accionPersonal.setObservacion(getEncabezadoSolicitud().getObservacion());
        accionPersonal.setDepartamentos(e.getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setPuestos(e.getPuestos());
        accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
        accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
        accionPersonal.setCodTipopla(tipoPlanilla);
        return accionPersonal;
    }

    @Override
    boolean validarSolicitud() {
        Boolean error = Boolean.FALSE;
        if (criterioSeleccionado == null || criterioSeleccionado.equals("-1")) {
            addMessage("Acciones de Personal", "Seleccione el Criterio.", TipoMensaje.ERROR);
            error = Boolean.TRUE;
        }
        if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1")) {
            if (criterioSeleccionado.equals("departamentos")) {
                if (departamento == null || departamento == -1) {
                    addMessage("Acciones de Personal", "Departamento es un campo requerido.", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                }
            } else if (criterioSeleccionado.equals("tipoPlanilla")) {
                if (tipoPlanilla == null || tipoPlanilla == -1) {
                    addMessage("Acciones de Personal", "Tipo Planilla es un campo requerido.", TipoMensaje.ERROR);
                    error = Boolean.TRUE;
                }
            }

            if (tipoPlanilla == null || tipoPlanilla == -1) {
                addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }

            if ((tipoPlanilla != null && tipoPlanilla != -1) && (planilla == null || planilla.equals("-1"))) {
                addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
                error = Boolean.TRUE;
            }
        }
        return error;
    }

    public void calcularAfectados(AjaxBehaviorEvent event) {
        calcularEmpleados();
        empleadosSeleccionados = null;
    }

    public void calcularEmpleados() {
        valorAfectados = 0;
        if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1")) {
            if (criterioSeleccionado.equals("departamentos")) {
                if (departamento != null && departamento != -1) {
                    valorAfectados = planillaSessionBean().totalAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)));
                }
            } else if (criterioSeleccionado.equals("tipoPlanilla")) {
                if (tipoPlanilla != null && tipoPlanilla != -1) {
                    valorAfectados = planillaSessionBean().totalAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getEncabezadoSolicitud().getEmpresa(), tipoPlanilla)));
                }
            }
        }
    }

    public String listarEmpleados() {
        listaEmpleadosAfectar = new ArrayList<Empleados>();
        if (criterioSeleccionado != null && !criterioSeleccionado.equals("-1")) {
            if (criterioSeleccionado.equals("departamentos")) {
                if (departamento != null && departamento != -1) {
                    listaEmpleadosAfectar = planillaSessionBean().listaAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)));
                }
            } else if (criterioSeleccionado.equals("tipoPlanilla")) {
                if (tipoPlanilla != null && tipoPlanilla != -1) {
                    listaEmpleadosAfectar = planillaSessionBean().listaAfectadosTipoPlanilla(new TiposPlanilla(new TiposPlanillaPK(getEncabezadoSolicitud().getEmpresa(), tipoPlanilla)));
                }
            }
        }
        return null;
    }

    public String actualizarAfectados() {
        calcularEmpleados();
        valorAfectados = (empleadosSeleccionados != null && empleadosSeleccionados.length != 0) ? empleadosSeleccionados.length : valorAfectados;
        return null;
    }

    @Override
    protected void limpiarCampos() {
        departamento = -1;
        tipoPlanilla = -1;
        planilla = null;
        valorAfectados = 0;
        empleadosSeleccionados = null;
        listaEmpleadosAfectar = new ArrayList<Empleados>();
        getEncabezadoSolicitud().setObservacion(null);
    }
}
