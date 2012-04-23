/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.catalogos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "puestosBackendBean")
@ViewScoped
public class PuestosBackendBean extends AbstractJSFPage implements java.io.Serializable {

    /*EJB*/
    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    /* Campos */
    private String nombre;
    private Boolean horasExtras;
    private Boolean horasDobles;
    private Boolean viaticos;
    private Boolean comision;
    private Boolean informacionConfidencial;
    private Boolean jefatura;
    private Double salarioMinimo;
    private Double salarioMaximo;
    private Short tipoPuesto;
    private String estado;
    private Short departamento;
    private Short area;
    private String descripcion;
    private String objetivo;
    private Criterio criterioSeleccionado;
//    private String valor;
//    private String valorInicialRango;
//    private String valorFinalRango;
    /* Listas */
    private List<TipoPuesto> listaTipoPuesto;
    private List<Departamentos> listaDepartamentos;
    private List<AreasStaff> listaAreas;
    private List<Puestos> listaPuestos;
    private java.util.List<CriteriosXPuesto> listaCriteriosXPuestos;
    private List<Criterio> listaCriterios;

    private DataTable tablaPuestos;
    private Puestos puestoSeleccionado;
    private CriteriosXPuesto criterioXPuestoSeleccionado;
    private Integer estadoAccion;
    private String etiqueta;
    
    public PuestosBackendBean() {
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Boolean getJefatura() {
        return jefatura;
    }

    public void setJefatura(Boolean jefatura) {
        this.jefatura = jefatura;
    }

//    public String getValor() {
//        return valor;
//    }
//
//    public void setValor(String valor) {
//        this.valor = valor;
//    }
//
//    public String getValorFinalRango() {
//        return valorFinalRango;
//    }
//
//    public void setValorFinalRango(String valorFinalRango) {
//        this.valorFinalRango = valorFinalRango;
//    }
//
//    public String getValorInicialRango() {
//        return valorInicialRango;
//    }
//
//    public void setValorInicialRango(String valorInicialRango) {
//        this.valorInicialRango = valorInicialRango;
//    }

    public Criterio getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public List<Criterio> getListaCriterios() {
        listaCriterios = reclutamientoFacade.getListaCriteriosByCias(getSessionBeanADM().getCompania().getCodCia());
        return listaCriterios;
    }

    public void setListaCriterios(List<Criterio> listaCriterios) {
        this.listaCriterios = listaCriterios;
    }

    public List<CriteriosXPuesto> getListaCriteriosXPuestos() {
        return listaCriteriosXPuestos;
    }

    public void setListaCriteriosXPuestos(List<CriteriosXPuesto> listaCriteriosXPuestos) {
        this.listaCriteriosXPuestos = listaCriteriosXPuestos;
    }

    public CriteriosXPuesto getCriterioXPuestoSeleccionado() {
        return criterioXPuestoSeleccionado;
    }

    public void setCriterioXPuestoSeleccionado(CriteriosXPuesto criterioXPuestoSeleccionado) {
        this.criterioXPuestoSeleccionado = criterioXPuestoSeleccionado;
    }

    public Integer getEstadoAccion() {
        return estadoAccion;
    }

    public void setEstadoAccion(Integer estadoAccion) {
        this.estadoAccion = estadoAccion;
    }

    public Puestos getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(Puestos puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }

    public DataTable getTablaPuestos() {
        return tablaPuestos;
    }

    public void setTablaPuestos(DataTable tablaPuestos) {
        this.tablaPuestos = tablaPuestos;
    }

    public Short getArea() {
        return area;
    }

    public void setArea(Short area) {
        this.area = area;
    }

    public Boolean getComision() {
        return comision;
    }

    public void setComision(Boolean comision) {
        this.comision = comision;
    }

    public Short getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Short departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getHorasDobles() {
        return horasDobles;
    }

    public void setHorasDobles(Boolean horasDobles) {
        this.horasDobles = horasDobles;
    }

    public Boolean getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Boolean horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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

    public Short getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(Short tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public Boolean getViaticos() {
        return viaticos;
    }

    public void setViaticos(Boolean viaticos) {
        this.viaticos = viaticos;
    }

    public Boolean getInformacionConfidencial() {
        return informacionConfidencial;
    }

    public void setInformacionConfidencial(Boolean informacionConfidencial) {
        this.informacionConfidencial = informacionConfidencial;
    }

    public List<AreasStaff> getListaAreas() {
        listaAreas = reclutamientoFacade.findAreasStaffByCias(getSessionBeanADM().getCompania());
        return listaAreas;
    }

    public void setListaAreas(List<AreasStaff> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = reclutamientoFacade.findDepartamentosByCias(getSessionBeanADM().getCompania());
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<TipoPuesto> getListaTipoPuesto() {
        listaTipoPuesto = reclutamientoFacade.getTipoPuestosByEmpresa(getSessionBeanADM().getCompania());
        return listaTipoPuesto;
    }

    public void setListaTipoPuesto(List<TipoPuesto> listaTipoPuesto) {
        this.listaTipoPuesto = listaTipoPuesto;
    }

    public List<Puestos> getListaPuestos() {
        listaPuestos = reclutamientoFacade.getPuestosByEmpresa(getSessionBeanADM().getCompania());
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    /* Acciones */
    public String guardar$crud$action() {
        if (validarFormulario().equals(Boolean.FALSE)) {
            return null;
        }
        Puestos nuevoPuesto = new Puestos();
        nuevoPuesto.setNomPuesto(nombre);
        nuevoPuesto.setHorasExt(horasExtras == true ? "S" : "N");
        nuevoPuesto.setHorasDob(horasDobles == true ? "S" : "N");
        nuevoPuesto.setJefatura(jefatura == true ? "SI" : "NO");
        nuevoPuesto.setViaticos(viaticos == true ? "S" : "N");
        nuevoPuesto.setComision(comision == true ? "S" : "N");
        nuevoPuesto.setInfConf(informacionConfidencial == true ? "S" : "N");
        nuevoPuesto.setSalMinimo(salarioMinimo != null ? new BigDecimal(salarioMinimo) : BigDecimal.ZERO);
        nuevoPuesto.setSalMaximo(salarioMaximo != null ? new BigDecimal(salarioMaximo) : BigDecimal.ZERO);
        nuevoPuesto.setTipoPuesto((tipoPuesto != null && tipoPuesto != -1) ? new TipoPuesto(new TipoPuestoPK(getSessionBeanADM().getCompania().getCodCia(), tipoPuesto)) : null);
        nuevoPuesto.setStatus(estado);
        nuevoPuesto.setDepartamentos((departamento != null && departamento != -1) ? new Departamentos(new DepartamentosPK(getSessionBeanADM().getCompania().getCodCia(), departamento)) : null);
        nuevoPuesto.setAreasStaff((area != null && area != -1) ? new AreasStaff(new AreasStaffPK(getSessionBeanADM().getCompania().getCodCia(), area)) : null);
        nuevoPuesto.setDescPuesto(descripcion);
        nuevoPuesto.setObjetivo(objetivo);
        try {
            if (getEstadoAccion() == null || getEstadoAccion().equals(0)) {
                reclutamientoFacade.guardarPuesto(nuevoPuesto, getSessionBeanADM().getCompania());
            } else if (getEstadoAccion() != null && getEstadoAccion().equals(1)) {
                reclutamientoFacade.editarPuesto(nuevoPuesto);
            }
            addMessage("Mantenimiento de Puestos", "Datos guardados con éxito.", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Puestos", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.INFORMACION);
            e.printStackTrace();
        }

        return null;
    }

    public Boolean validarFormulario() {
        Boolean e = Boolean.TRUE;
        if (nombre == null || nombre.length() <= 0) {
            addMessage("Puestos", "El nombre del puesto es un campo requerido.", TipoMensaje.ERROR);
            e = Boolean.FALSE;
        }

        if (salarioMinimo == null) {
            addMessage("Puestos", "Salario Minimo es un campo requerido.", TipoMensaje.ERROR);
            e = Boolean.FALSE;
        }

        if (salarioMaximo == null) {
            addMessage("Puestos", "Salario Máximo es un campo requerido.", TipoMensaje.ERROR);
            e = Boolean.FALSE;
        }

        if ((estado == null) || (estado.equals("-1"))) {
            addMessage("Puestos", "Seleccione el estado del puesto.", TipoMensaje.ERROR);
            e = Boolean.FALSE;
        }

        if (descripcion == null || descripcion.length() <= 0) {
            addMessage("Puestos", "La descripcion del puesto es un campo Obligatorio.", TipoMensaje.ERROR);
            e = Boolean.FALSE;
        }

        return e;
    }

    public void nuevo$crud$action() {
        setPuestoSeleccionado(null);
        setEstadoAccion(0);
        limpiarCampos();
    }

    public String consultar$crud$action() {
        setPuestoSeleccionado(null);
        setEstadoAccion(2);
        limpiarCampos();
        return null;
    }

    public String editar$crud$action() {
        if (getPuestoSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos.", "No ha seleccionado ningún puesto para editar. Consulte uno primero.", TipoMensaje.ERROR);
            return null;
        }
        setNombre(getPuestoSeleccionado().getNomPuesto());
        setHorasExtras((getPuestoSeleccionado().getHorasExt() != null && getPuestoSeleccionado().getHorasExt().equals("S")) ? Boolean.TRUE : Boolean.FALSE);
        setHorasDobles((getPuestoSeleccionado().getHorasDob() != null && getPuestoSeleccionado().getHorasDob().equals("S")) ? Boolean.TRUE : Boolean.FALSE);
        setViaticos((getPuestoSeleccionado().getViaticos() != null && getPuestoSeleccionado().getViaticos().equals("S")) ? Boolean.TRUE : Boolean.FALSE);
        setComision((getPuestoSeleccionado().getComision() != null && getPuestoSeleccionado().getComision().equals("S")) ? Boolean.TRUE : Boolean.FALSE);
        setJefatura((getPuestoSeleccionado().getJefatura() != null && getPuestoSeleccionado().getJefatura().equals("SI")) ? Boolean.TRUE : Boolean.FALSE);
        setInformacionConfidencial((getPuestoSeleccionado().getInfConf() != null && getPuestoSeleccionado().getInfConf().equals("S")) ? Boolean.TRUE : Boolean.FALSE);
        setSalarioMinimo(getPuestoSeleccionado().getSalMinimo() != null ? new Double(getPuestoSeleccionado().getSalMinimo().toString()) : 0);
        setSalarioMaximo(getPuestoSeleccionado().getSalMaximo() != null ? new Double(getPuestoSeleccionado().getSalMaximo().toString()) : 0);
        setTipoPuesto(getPuestoSeleccionado().getTipoPuesto() != null ? getPuestoSeleccionado().getTipoPuesto().getTipoPuestoPK().getCodTipoPuesto() : new Short("-1"));
        setEstado(getPuestoSeleccionado().getStatus() != null ? getPuestoSeleccionado().getStatus() : "-1");
        setDepartamento(getPuestoSeleccionado().getDepartamentos() != null ? getPuestoSeleccionado().getDepartamentos().getDepartamentosPK().getCodDepto() : new Short("-1"));
        setArea(getPuestoSeleccionado().getAreasStaff() != null ? getPuestoSeleccionado().getAreasStaff().getAreasStaffPK().getCodArea().shortValue()/*getPuestoSeleccionado().getPuestosPK().getCodPuesto()*/ : new Short("-1"));
        setDescripcion(getPuestoSeleccionado().getDescPuesto());
        setObjetivo(getPuestoSeleccionado().getObjetivo());
        setEstadoAccion(1);
        return null;
    }

    public String criterios$crud$action() {
        if (getPuestoSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos.", "No ha seleccionado ningún puesto para ver Criterios. Consulte uno primero.", TipoMensaje.ERROR);
            return null;
        }
        listaCriteriosXPuestos = reclutamientoFacade.criteriosPorPuesto(getPuestoSeleccionado().getPuestosPK());
        setEstadoAccion(3);
        return null;
    }

    public String guardarCriterio$crud$action() {

        if (getCriterioSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos.", "No ha seleccionado ningun criterio.", TipoMensaje.ERROR);
            return null;
        } else if (getPuestoSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos.", "No ha seleccionado ningun puesto.", TipoMensaje.ERROR);
            return null;
        }

//        if (getCriterioSeleccionado().getOperador().equals("equal")) {
//            if (valor == null || valor.length() <= 0) {
//                addMessage("Mantenimiento de Puestos.", "Ingrese on valor para el criterio.", TipoMensaje.ERROR);
//                return null;
//            }
//        } else if (getCriterioSeleccionado().getOperador().equals("between")) {
//            if ((valorInicialRango == null || valorInicialRango.length()<= 0) || (valorFinalRango == null || valorFinalRango.length()<=0)) {
//                addMessage("Mantenimiento de Puestos.", "Complemente los dos valores para el criterio.", TipoMensaje.ERROR);
//                return null;
//            }
//        }
//        
//        if (etiqueta == null || etiqueta.length() <= 0) {
//            addMessage("Puestos", "Ingrese el nombre del Criterio.", TipoMensaje.ERROR);
//            return null;
//        }

        CriteriosXPuesto cxp = new CriteriosXPuesto();
        CriteriosXPuestoPK pk = new CriteriosXPuestoPK(getSessionBeanADM().getCompania().getCodCia(), getPuestoSeleccionado().getPuestosPK().getCodPuesto(), getCriterioSeleccionado().getCriterioPK().getCodigo());
        cxp.setCriterio(getCriterioSeleccionado());
        cxp.setPuestos(getPuestoSeleccionado());
        cxp.setCriteriosXPuestoPK(pk);
        
        if (listaCriteriosXPuestos!=null && !listaCriteriosXPuestos.isEmpty()){
            if (listaCriteriosXPuestos.contains(cxp)){
               addMessage("Mantenimiento de Puestos.", "Este criterio ya existe para este puesto.", TipoMensaje.INFORMACION);    
               return null; 
            }
        }
        
        try {
            reclutamientoFacade.guardarCriterioXPuesto(cxp);
            addMessage("Mantenimiento de Puestos.", "Datos Guardados con éxito.", TipoMensaje.INFORMACION);
            listaCriteriosXPuestos = reclutamientoFacade.criteriosPorPuesto(getPuestoSeleccionado().getPuestosPK());
//            setValor(null);
//            setValorInicialRango(null);
//            setValorFinalRango(null);
        } catch (Exception e) {
            addMessage("Mantenimiento de Puestos.", "Ocurrio un error al intentar guardar los datos.", TipoMensaje.ERROR);
            e.printStackTrace();
        }
        return null;
    }

    public String limpiarCriterio() {
        setCriterioSeleccionado(null);
        return null;
    }

    @Override
    protected void limpiarCampos() {
        setNombre("");
        setHorasExtras(Boolean.FALSE);
        setHorasDobles(Boolean.FALSE);
        setViaticos(Boolean.FALSE);
        setComision(Boolean.FALSE);
        setJefatura(Boolean.FALSE);
        setInformacionConfidencial(Boolean.FALSE);
        setSalarioMinimo(0.0);
        setSalarioMaximo(0.0);
        setTipoPuesto(new Short("-1"));
        setEstado("-1");
        setDepartamento(new Short("-1"));
        setArea(new Short("-1"));
        setDescripcion("");
        setObjetivo("");
    }

    public void eliminar$crud$action(ActionEvent actionEvent) {
        if (getPuestoSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos", "Primero seleccione un Puesto", TipoMensaje.ERROR);
            return;
        }
        try {
            reclutamientoFacade.eliminarPuesto(getPuestoSeleccionado());
            addMessage("Mantenimiento de Puestos.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Puesto.", "Ha ocurrido un error al intentar remover el Puesto.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
        listaPuestos = reclutamientoFacade.getPuestosByEmpresa(getSessionBeanADM().getCompania());
    }

    public void eliminarCriterio$crud$action(ActionEvent actionEvent) {
        if (getCriterioXPuestoSeleccionado() == null) {
            addMessage("Mantenimiento de Puestos", "Primero seleccione un Criterio", TipoMensaje.ERROR);
            return;
        }
        try {
            reclutamientoFacade.eliminarCriterioXPuesto(getCriterioXPuestoSeleccionado());
            addMessage("Mantenimiento de Puestos.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
            listaCriteriosXPuestos = reclutamientoFacade.criteriosPorPuesto(getPuestoSeleccionado().getPuestosPK());
        } catch (Exception e) {
            addMessage("Mantenimiento de Puesto.", "Ha ocurrido un error al intentar remover el Criterio.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }
    }

//    public void onRowSelectPuesto(SelectEvent event) {
//        setPuestoSeleccionado((Puestos) event.getObject());
//    }
//
//    public void onRowUnSelectPuesto(UnselectEvent event) {
//        setPuestoSeleccionado(null);
//    }

//    public void onRowSelectCriterioPuesto(SelectEvent event) {
//        setCriterioXPuestoSeleccionado((CriteriosXPuesto) event.getObject());
//    }
//
//    public void onRowUnSelectCriterioPuesto(UnselectEvent event) {
//        setCriterioXPuestoSeleccionado(null);
//    }

//    public void onRowSelectCriterio(SelectEvent event) {
//        setCriterioSeleccionado((Criterio) event.getObject());
//    }
//
//    public void onRowUnSelectCriterio(UnselectEvent event) {
//        setCriterioSeleccionado(null);
//    }
}
