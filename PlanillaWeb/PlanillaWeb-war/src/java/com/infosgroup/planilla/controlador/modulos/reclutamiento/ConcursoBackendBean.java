/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$concursos")
@ViewScoped
public class ConcursoBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private ReclutamientoSessionBean reclutamientoFacade;
    private Boolean isError;
    private Date fechaInicial;
    private String nombreConcurso;
    private Date fechaFinal;
    private Long numeroPlazas;
    private Short puesto;
    private String estadoConcurso;
    private List<Puestos> listaPuestos;
    private List<EstadoConcurso> listaEstadoConcurso;
    private List<Concurso> listaConcursos;
    //private DataTable tableConcursos;
    private SelectItem[] itemEstado;

    public ConcursoBackendBean() {
    }

    /* getter & setter */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
    }

    public Long getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(Long numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public Short getPuesto() {
        return puesto;
    }

    public void setPuesto(Short puesto) {
        this.puesto = puesto;
    }

    public List<Puestos> getListaPuestos() {
        listaPuestos = reclutamientoFacade.getPuestosByEmpresa( getSessionBeanADM().getCompania() );
        return listaPuestos;
    }

    public void setListaPuestos(List<Puestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public String getEstadoConcurso() {
        return estadoConcurso;
    }

    public void setEstadoConcurso(String estadoConcurso) {
        this.estadoConcurso = estadoConcurso;
    }

    public List<EstadoConcurso> getListaEstadoConcurso() {
        listaEstadoConcurso = reclutamientoFacade.getEstadoConcursosByEmpresa( getSessionBeanADM().getCompania());
        return listaEstadoConcurso;
    }

    public void setListaEstadoConcurso(List<EstadoConcurso> listaEstadoConcurso) {
        this.listaEstadoConcurso = listaEstadoConcurso;
    }

    public List<Concurso> getListaConcursos() {
        listaConcursos = reclutamientoFacade.getConcursoByEmpresa(getSessionBeanADM().getCompania());
        return listaConcursos;
    }

    public void setListaConcursos(List<Concurso> listaConcursos) {
        this.listaConcursos = listaConcursos;
    }

//    public DataTable getTableConcursos() {
//        return tableConcursos;
//    }
//
//    public void setTableConcursos(DataTable tableConcursos) {
//        this.tableConcursos = tableConcursos;
//    }

    public SelectItem[] getItemEstado() {
        List<EstadoConcurso> k = reclutamientoFacade.getEstadoConcursosByEmpresa(getSessionBeanADM().getCompania());
        itemEstado = new SelectItem[k.size()];
        for (int f = 0; f < k.size(); f++) {
            SelectItem s = new SelectItem(k.get(f).getNombre(), k.get(f).getNombre());
            itemEstado[f] = s;
        }
        return itemEstado;
    }

    public void setItemEstado(SelectItem[] itemEstado) {
        this.itemEstado = itemEstado;
    }

    public String guardar$crud$action() {
        isError = Boolean.FALSE;
        validaCampos$action();
        Short c = getSessionBeanADM().getCompania().getCodCia();
        if (isError) {
            return null;
        }

        Concurso concurso = new Concurso();
        /* Crear Concurso */
        if (getSessionBeanADM().getEstadoAccion() == null || getSessionBeanADM().getEstadoAccion().equals(0)) {
            ConcursoPK pk = new ConcursoPK();
            pk.setCodCia(c);
            pk.setCodConcurso(reclutamientoFacade.getMaxConcurso(getSessionBeanADM().getCompania()));
            concurso.setConcursoPK(pk);
            concurso.setNombre(nombreConcurso);
            concurso.setFechaInicial(fechaInicial);
            concurso.setFechaFinal(fechaFinal);
            concurso.setNumeroPlazas(numeroPlazas);
            concurso.setPuestos(reclutamientoFacade.findPuestoById(new PuestosPK(c, puesto)));
            concurso.setEstadoConcurso(reclutamientoFacade.findEstadoConcursoById(new EstadoConcursoPK(c, estadoConcurso)));
            try {
                reclutamientoFacade.guardarConcurso(concurso);
                addMessage("Mantenimiento de Concursos.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Concursos.", "Ha ocurrido un error al intentar guardar el Concurso.", TipoMensaje.ERROR);
                System.out.println(e.getMessage());
            }
        } else if (getSessionBeanADM().getEstadoAccion().equals(1)) {
            /* Modificar Concurso */
            concurso = getSessionBeanREC().getConcursoSeleccionado();
            if (concurso == null) {
                addMessage("Mantenimiento de Concursos.", "No ha seleccionado ningún concurso para editar.", TipoMensaje.ERROR);
                return null;
            }
            concurso.setNombre(nombreConcurso);
            concurso.setFechaInicial(fechaInicial);
            concurso.setFechaFinal(fechaFinal);
            concurso.setNumeroPlazas(numeroPlazas);
            concurso.setPuestos(reclutamientoFacade.findPuestoById(new PuestosPK(c, puesto)));
            concurso.setEstadoConcurso(reclutamientoFacade.findEstadoConcursoById(new EstadoConcursoPK(c, estadoConcurso)));
            try {
                reclutamientoFacade.editarConcurso(concurso);
                addMessage("Mantenimiento de Concursos.", "Datos actualizados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
            } catch (Exception e) {
                addMessage("Mantenimiento de Concursos.", "Ha ocurrido un error al intentar actualizar el Concurso.", TipoMensaje.ERROR);
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

    public void eliminar$crud$action(ActionEvent actionEvent) {
        if (getSessionBeanREC().getConcursoSeleccionado() == null) {
            addMessage("Mantenimiento de Concursos", "Primero seleccione un concurso", TipoMensaje.ERROR);
            return;
        }
        try {
            reclutamientoFacade.eliminarConcurso(getSessionBeanREC().getConcursoSeleccionado());
            addMessage("Mantenimiento de Concursos.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Mantenimiento de Concursos.", "Ha ocurrido un error al intentar remover el Concurso.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
        }

    }

    public String editar$crud$action() {
        if (getSessionBeanREC().getConcursoSeleccionado() == null) {
        addMessage("Mantenimiento de Concursos.", "No ha seleccionado ningún concurso para editar.", TipoMensaje.ERROR);
        return null;
        }
        Concurso c = getSessionBeanREC().getConcursoSeleccionado();
        setNombreConcurso(c.getNombre());
        setFechaInicial(c.getFechaInicial());
        setFechaFinal(c.getFechaFinal());
        setNumeroPlazas(c.getNumeroPlazas());
        setPuesto(c.getPuestos().getPuestosPK().getCodPuesto());
        setEstadoConcurso(c.getEstadoConcurso().getEstadoConcursoPK().getCodigo());
        getSessionBeanADM().setEstadoAccion( 1 );
        return null;
    }

    public void nuevo$vh$action() {
        setEstadoAccion(0);
    }

    public void consultar$vh$action() {
        setEstadoAccion(2);
    }

    public void setEstadoAccion(Integer estadoAccion) {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }

    public void validaCampos$action() {
        if (!validaFechas(fechaInicial, fechaFinal)) {
            addMessage("Mantenimiento de Concursos", "Los rangos de fecha ingresados no son consistentes.", TipoMensaje.ERROR);
            isError = Boolean.TRUE;
        }
    }

//    public void onRowSelectConcurso(SelectEvent event) {
//        getSessionBeanREC().setConcursoSeleccionado((Concurso) event.getObject());
//    }
//
//    public void onRowUnSelectConcurso(UnselectEvent event) {
//        getSessionBeanREC().setConcursoSeleccionado(null);
//    }

    @Override
    protected void limpiarCampos() {
        //if (tableConcursos != null){tableConcursos.setSelection(null);}
        setNombreConcurso(null);
        setFechaInicial(null);
        setFechaFinal(null);
        setNumeroPlazas(null);
        setPuesto(null);
        setEstadoConcurso(null);
        getSessionBeanREC().setConcursoSeleccionado(null);
    }
}
