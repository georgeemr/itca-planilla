/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author root
 */
@ManagedBean(name="solicitudAumentoSueldoColectivo")
@ViewScoped
public class SolicitudAumentoSueldoColectivo extends SolicitudDePersonal implements java.io.Serializable {

    private String criterioSeleccionado;
    private String formaAumento = "V";
    private Double sueldoNuevo;
    private java.util.Date fechaInicial;
    private Integer empleadosAfectados = 0;
    private Double salarioMaximo;
    private Double salarioMinimo;
    private Short departamento;
    private List<Departamentos> listaDepartamentos;

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
                getPlanillaSessionBean().registrarAccionPersonalColectiva(obtenerAccionesPersonal(getPlanillaSessionBean().listarAfectadosRangoSalarios(getSessionBeanADM().getCompania(), new BigDecimal(salarioMinimo), new BigDecimal(salarioMaximo))));
            } else if (criterioSeleccionado.equals("departamentos")) {
                getPlanillaSessionBean().registrarAccionPersonalColectiva(obtenerAccionesPersonal(getPlanillaSessionBean().listaAfectadosDepartamentos( new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento)) )));
            }
            addMessage("Solicitud de Aumentos de Sueldo Colectivo", "Datos guardados exitosamente.", TipoMensaje.INFORMACION);
            //getEncabezadoSolicitud().setListaSolicitudes(getPlanillaSessionBean().getAccionesByRol(getEncabezadoSolicitud().getSessionBeanEMP().getEmpleadoSesion()));
            //getPlanillaSessionBean().listarAccionporTipo(getEncabezadoSolicitud().getEmpresa(), getEncabezadoSolicitud().getTipo());
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
        TipoAccion tipoAccion = new TipoAccion(new TipoAccionPK(getSessionBeanADM().getCompania().getCodCia(), new Short("7")));
        accionPersonal.setAccionPersonalPK(getAccionPersonalPK(getSessionBeanADM().getCompania(), tipoAccion, e));
        accionPersonal.setTipoAccion(tipoAccion);
        accionPersonal.setEmpleados(e);
        accionPersonal.setEmpleados1( e.getEmpleados() );
        accionPersonal.setFecha(new Date());
        accionPersonal.setObservacion(getObservacion());
        accionPersonal.setDepartamentos(e.getDepartamentos());
        accionPersonal.setStatus("G");
        accionPersonal.setUsuarioCreacion(getSessionBeanEMP().getEmpleadoSesion().getUsuario() );
        accionPersonal.setFechaInicial(fechaInicial);
        accionPersonal.setAnio(new Short(getPlanilla().split(":")[1].toString()));
        accionPersonal.setMes(new Short(getPlanilla().split(":")[2].toString()));
        accionPersonal.setNumPlanilla(new Short(getPlanilla().split(":")[3].toString()));
        accionPersonal.setCodTipopla(getTipoPlanilla());
        accionPersonal.setSueldoAnterior(e.getSalario());
        accionPersonal.setCantidad(formaAumento.equals("V") ? new BigDecimal(sueldoNuevo + e.getSalario().doubleValue()) : new BigDecimal(e.getSalario().doubleValue() + (sueldoNuevo / 100) * e.getSalario().doubleValue()));
        accionPersonal.setPorcentaje(formaAumento.equals("P") ? new BigDecimal(sueldoNuevo) : BigDecimal.ZERO);
        accionPersonal.setMonto(formaAumento.equals("V") ? new BigDecimal(sueldoNuevo) : BigDecimal.ZERO);
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

        if (getTipoPlanilla() == null || getTipoPlanilla() == -1) {
            addMessage("Acciones de Personal", "Debe seleccionar el Tipo de Planilla.", TipoMensaje.ERROR);
            e = Boolean.TRUE;
        }

        if ((getTipoPlanilla() != null && getTipoPlanilla() != -1) && (getPlanilla() == null || getPlanilla().equals("-1"))) {
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
        setTipoPlanilla(new Short("-1"));
        setPlanilla(null);
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
        listaDepartamentos = getPlanillaSessionBean().findDepartamentos(getSessionBeanADM().getCompania());
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
            empleadosAfectados = getPlanillaSessionBean().totalAfectadosRangoSalarios(getSessionBeanADM().getCompania(), new BigDecimal(salarioMinimo != null ? salarioMinimo : 0), new BigDecimal(salarioMaximo != null ? salarioMaximo : 0));
        } else if (criterioSeleccionado.equals("departamentos")) {
            if (departamento != -1) {
                empleadosAfectados = getPlanillaSessionBean().totalAfectadosDepartamentos(new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento)));
            } else {
                empleadosAfectados = 0;
            }
        }
    }
}
