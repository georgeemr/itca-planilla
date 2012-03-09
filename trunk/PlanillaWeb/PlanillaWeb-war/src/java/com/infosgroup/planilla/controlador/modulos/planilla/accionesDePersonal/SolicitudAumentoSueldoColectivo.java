/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author root
 */
public class SolicitudAumentoSueldoColectivo extends SolicitudDePersonal implements java.io.Serializable {

    private String criterioSeleccionado;
    private String formaAumento = "V";
    private Double sueldoNuevo;
    private java.util.Date fechaInicial;
    private java.util.List<ProgramacionPla> listaPlanillas;
    private Short tipoPlanilla;
    private String planilla;
    private Integer empleadosAfectados = 0;
    private Double salarioMaximo;
    private Double salarioMinimo;
    private Short departamento;
    private java.util.List<Departamentos> listaDepartamentos;
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public SolicitudAumentoSueldoColectivo(AccionesPersonalBackendBean encabezadoSolicitud) {
        super(encabezadoSolicitud);
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean().getProgramacionPlaByTipo(getEncabezadoSolicitud().getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new java.util.ArrayList<ProgramacionPla>();
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

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Double getSueldoNuevo() {
        return sueldoNuevo;
    }

    public void setSueldoNuevo(Double sueldoNuevo) {
        this.sueldoNuevo = sueldoNuevo;
    }

    public String getFormaAumento() {
        return formaAumento;
    }

    public void setFormaAumento(String formaAumento) {
        this.formaAumento = formaAumento;
    }

    public String getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(String criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public void limpiarFormaAplicar(AjaxBehaviorEvent event) {
        limpiarCampos();
    }

    public String guardarSolicitud$action() {
        if (validarSolicitud()) {
            return null;
        }
        try {
            if (criterioSeleccionado.equals("rangoSalario")) {
                planillaSessionBean().registrarAccionPersonalColectiva(obtenerAccionesPersonal(planillaSessionBean().listarAfectadosRangoSalarios(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), new BigDecimal(salarioMinimo), new BigDecimal(salarioMaximo))));
            } else if (criterioSeleccionado.equals("departamentos")) {
                planillaSessionBean().registrarAccionPersonalColectiva(obtenerAccionesPersonal(planillaSessionBean().listaAfectadosDepartamentos( new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)) )));
            }
            addMessage("Solicitud de Aumentos de Sueldo Colectivo", "Datos guardados exitosamente.", TipoMensaje.INFORMACION);
            getEncabezadoSolicitud().setListaSolicitudes(planillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
            planillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
        } catch (Exception exception) {
            addMessage("Solicitud de Vacaciones Colectivas", exception.getMessage(), TipoMensaje.ERROR);
        }
        limpiarCampos();
        return null;
    }

    public List<AccionPersonal> obtenerAccionesPersonal(List<Empleados> listaEmpleados) throws Exception {
        List<AccionPersonal> l = new ArrayList<AccionPersonal>();
        if (listaEmpleados == null || listaEmpleados.size() <= 0) {
            throw new Exception("No ha seleccionado ningun empleado para generar la solicitud.");
        }
        for (Empleados e : listaEmpleados) {
            l.add(getAccionPersonal(e));
        }
        return l;
    }

    public AccionPersonal getAccionPersonal(Empleados e) {
        AccionPersonal accionPersonal = new AccionPersonal();
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), e));
        accionPersonal.setTipoAccion(getTipoAccion());
        accionPersonal.setEmpleados(e);
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(e.getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setAnio(new Short(planilla.split(":")[1].toString()));
        accionPersonal.setMes(new Short(planilla.split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(planilla.split(":")[3].toString()));
        accionPersonal.setCodTipopla(tipoPlanilla);
        accionPersonal.setSueldoAnterior(e.getSalario());
        accionPersonal.setCantidad(formaAumento.equals("V") ? new BigDecimal(sueldoNuevo) : new BigDecimal(e.getSalario().doubleValue() + (sueldoNuevo / 100) * e.getSalario().doubleValue()));
        accionPersonal.setPorcentaje(formaAumento.equals("P") ? new BigDecimal(sueldoNuevo) : BigDecimal.ZERO);
        accionPersonal.setPuestos(e.getPuestos());
        return accionPersonal;
    }

    public Double getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    @Override
    boolean validarSolicitud() {
        Boolean e = Boolean.FALSE;
        if (criterioSeleccionado.equals("-1")) {
            addMessage("Acciones de Personal", "Seleccione un criterio.", TipoMensaje.ERROR);
            return Boolean.TRUE;
        }
        if (criterioSeleccionado.equals("rangoSalario")) {
            if (salarioMinimo == null || salarioMaximo == null) {
                addMessage("Acciones de Personal", "Complete los datos de rango de salario.", TipoMensaje.ERROR);
                e = Boolean.TRUE;
            }
        }

        if (empleadosAfectados == null || empleadosAfectados <= 0) {
            addMessage("Acciones de Personal", "Los datos ingresados no han generado datos para aplicar esta solicitud.", TipoMensaje.ERROR);
            return Boolean.TRUE;
        }

        if (sueldoNuevo == null) {
            addMessage("Acciones de Personal", "El valor del sueldo es un campo requerido.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }

        if (sueldoNuevo != null && sueldoNuevo <= 0) {
            addMessage("Acciones de Personal", "El valor del sueldo debe ser positivo y mayor que cero.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }

        if (fechaInicial == null) {
            addMessage("Acciones de Personal", "Fecha inicial es un campo requerido.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }

        if (tipoPlanilla == null || tipoPlanilla == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }

        if ((tipoPlanilla != null && tipoPlanilla != -1) && (planilla == null || planilla.equals("-1"))) {
            addMessage("Acciones de Personal", "Debe seleccionar una planilla.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }
        return e;
    }

    @Override
    protected void limpiarCampos() {
        setSalarioMaximo(0.0);
        setSalarioMinimo(0.0);
        setEmpleadosAfectados(0);
        setFechaInicial(null);
        setFormaAumento("V");
        setDepartamento(new Short("-1"));
        tipoPlanilla = -1;
        planilla = null;
        setSueldoNuevo(0.0);
        setObservacion("");
    }

    public Integer getEmpleadosAfectados() {
        return empleadosAfectados;
    }

    public void setEmpleadosAfectados(Integer empleadosAfectados) {
        this.empleadosAfectados = empleadosAfectados;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = planillaSessionBean().findDepartamentos(getEncabezadoSolicitud().getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public void calcularAfectador(AjaxBehaviorEvent event) {
        calcularEmpleados();
    }

    public void calcularEmpleados() {
        if (criterioSeleccionado.equals("-1")) {
            empleadosAfectados = 0;
        } else if (criterioSeleccionado.equals("rangoSalario")) {
            empleadosAfectados = planillaSessionBean().totalAfectadosRangoSalarios(getEncabezadoSolicitud().getSessionBeanADM().getCompania(), new BigDecimal(salarioMinimo != null ? salarioMinimo : 0), new BigDecimal(salarioMaximo != null ? salarioMaximo : 0));
        } else if (criterioSeleccionado.equals("departamentos")) {
            if (departamento != -1) {
                empleadosAfectados = planillaSessionBean().totalAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getEncabezadoSolicitud().getEmpresa(), departamento)));
            } else {
                empleadosAfectados = 0;
            }
        }
    }
}
