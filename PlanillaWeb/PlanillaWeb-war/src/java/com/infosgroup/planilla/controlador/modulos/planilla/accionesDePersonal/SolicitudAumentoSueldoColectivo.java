/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla.accionesDePersonal;

import com.infosgroup.planilla.controlador.modulos.planilla.AccionesPersonalBackendBean;
import com.infosgroup.planilla.modelo.entidades.Departamentos;
import com.infosgroup.planilla.modelo.entidades.DepartamentosPK;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import java.math.BigDecimal;
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

        return null;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void limpiarCampos() {
        setSalarioMaximo(0.0);
        setSalarioMinimo(0.0);
        setEmpleadosAfectados(0);
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
