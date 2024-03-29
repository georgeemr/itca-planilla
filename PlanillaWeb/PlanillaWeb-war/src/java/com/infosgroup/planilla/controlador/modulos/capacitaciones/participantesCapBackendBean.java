/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.capacitaciones;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistencia;
import com.infosgroup.planilla.modelo.entidades.CapacitacionAsistenciaPK;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleadoPK;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.procesos.CapacitacionesSessionBean;
import com.infosgroup.planilla.modelo.procesos.MailStatelessBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author infosgroup
 */
@ManagedBean(name = "capacitaciones$participantesCapacitacion")
@ViewScoped
public class participantesCapBackendBean extends AbstractJSFPage implements Serializable
{

    @Override
    protected void limpiarCampos()
    {
        getSessionBeanCAP().setEmpleadoSeleccionado(null);
        setNomEmp(null);
    }
    @EJB
    private CapacitacionesSessionBean capacitacionSessionBean;
    @EJB
    private MailStatelessBean mailStatelessBean;
    // ==
    private Boolean isError;
    private String nomCapacitacion;
    private Short inst;
    private Date fechaInicial;
    private Date fechaFinal;
    private String impartido;
    private String status;
    private String nomInst;
    private String nomEmp;
    private String nomArea;
    private String nomTema;
    private String nomCapacitador;
    private List<Capacitacion> listaCap;
    private List<CapacitacionXEmpleado> listaDetalle;
    private List<Empleados> listaEmpleado;
    private transient DataTable tableCapacitaciones;
    private transient DataTable tableDetalles;
    private Dialog dialogBuscaEmp;

    public Dialog getDialogBuscaEmp()
    {
        return dialogBuscaEmp;
    }

    public void setDialogBuscaEmp(Dialog dialogBuscaEmp)
    {
        this.dialogBuscaEmp = dialogBuscaEmp;
    }

    public Date getFechaFinal()
    {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal)
    {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial()
    {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial)
    {
        this.fechaInicial = fechaInicial;
    }

    public String getImpartido()
    {
        return impartido;
    }

    public void setImpartido(String impartido)
    {
        this.impartido = impartido;
    }

    public Short getInst()
    {
        return inst;
    }

    public void setInst(Short inst)
    {
        this.inst = inst;
    }

    public Boolean getIsError()
    {
        return isError;
    }

    public void setIsError(Boolean isError)
    {
        this.isError = isError;
    }

    public String getNomArea()
    {
        return nomArea;
    }

    public void setNomArea(String nomArea)
    {
        this.nomArea = nomArea;
    }

    public String getNomCapacitador()
    {
        return nomCapacitador;
    }

    public void setNomCapacitador(String nomCapacitador)
    {
        this.nomCapacitador = nomCapacitador;
    }

    public String getNomTema()
    {
        return nomTema;
    }

    public void setNomTema(String nomTema)
    {
        this.nomTema = nomTema;
    }

    public List<Capacitacion> getListaCap()
    {
        listaCap = capacitacionSessionBean.findCapByEmpresa(getSessionBeanADM().getCompania());
        return listaCap;
    }

    public void setListaCap(List<Capacitacion> listaCap)
    {
        this.listaCap = listaCap;
    }

    public List<CapacitacionXEmpleado> getListaDetalle()
    {
        return listaDetalle;
    }

    public void setListaDetalle(List<CapacitacionXEmpleado> listaDetalle)
    {
        this.listaDetalle = listaDetalle;
    }

    public List<Empleados> getListaEmpleado()
    {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado)
    {
        this.listaEmpleado = listaEmpleado;
    }

    public String getNomCapacitacion()
    {
        return nomCapacitacion;
    }

    public void setNomCapacitacion(String nomCapacitacion)
    {
        this.nomCapacitacion = nomCapacitacion;
    }

    public String getNomEmp()
    {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp)
    {
        this.nomEmp = nomEmp;
    }

    public String getNomInst()
    {
        return nomInst;
    }

    public void setNomInst(String nomInst)
    {
        this.nomInst = nomInst;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public DataTable getTableCapacitaciones()
    {
        return tableCapacitaciones;
    }

    public void setTableCapacitaciones(DataTable tableCapacitaciones)
    {
        this.tableCapacitaciones = tableCapacitaciones;
    }

    public DataTable getTableDetalles()
    {
        return tableDetalles;
    }

    public void setTableDetalles(DataTable tableDetalles)
    {
        this.tableDetalles = tableDetalles;
    }

    public void nuevo$vh$action()
    {
        setEstadoAccion(2);
    }

    public void consultar$vh$action()
    {
        setEstadoAccion(0);
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }

    public void setEstadoAccion(Integer estadoAccion)
    {
        getSessionBeanADM().setEstadoAccion(estadoAccion);
        limpiarCampos();
    }

    public String guardar$cap$action()
    {
        isError = Boolean.FALSE;
        //validaCampos$action();
        Short c = getSessionBeanADM().getCompania().getCodCia();
        if (isError)
            {
            return null;
            }
        CapacitacionXEmpleado detalleCap = new CapacitacionXEmpleado();
        /*
         * Crear Detalle
         */
        if (!(getSessionBeanCAP().getCapacitacionSeleccionada().getStatus().equals("N")))
            {
            CapacitacionXEmpleado detalle = new CapacitacionXEmpleado();
            CapacitacionXEmpleadoPK pk = new CapacitacionXEmpleadoPK();
            pk.setCodCia(c);
            Cias ciaCod = getSessionBeanADM().getCompania();
//            Integer cod = capacitacionSessionBean.getMaxCapacitacion(ciaCod);
//            pk.setCodCapacitacion(cod);
            pk.setCodCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionPK().getCodCapacitacion());
            pk.setCodEmp(getSessionBeanCAP().getEmpleadoSeleccionado().getEmpleadosPK().getCodEmp());
            detalle.setCapacitacionXEmpleadoPK(pk);
            detalle.setEmpleados(getSessionBeanCAP().getEmpleadoSeleccionado());
            detalle.setNota(BigDecimal.ZERO);
            try
                {
                capacitacionSessionBean.guardarDetalleCapacitacion(detalle);
                addMessage("Mantenimiento de Detalle de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
                limpiarCampos();
                listaDetalle = capacitacionSessionBean.findDetByCap(ciaCod, getSessionBeanCAP().getCapacitacionSeleccionada());
                }
            catch (Exception e)
                {
                addMessage("Mantenimiento de Detalle de Capacitaciones.", "Este participante ya ha sido agregado a esta Capacitación.", TipoMensaje.ERROR);
                System.out.println(e.getMessage());
                }
            }
        return null;
    }

    public void onRowSelectCapacitacion(SelectEvent event)
    {
        getSessionBeanCAP().setCapacitacionSeleccionada((Capacitacion) event.getObject());
    }

    public void onRowUnSelectCapacitacion(UnselectEvent event)
    {
        getSessionBeanCAP().setCapacitacionSeleccionada(null);
    }

    public void onRowSelectEmpleado(SelectEvent event)
    {
        getSessionBeanCAP().setEmpleadoSeleccionado((Empleados) event.getObject());
        nomEmp = getSessionBeanCAP().getEmpleadoSeleccionado().getNombreCompleto();
        //Guardar Empleado
        isError = Boolean.FALSE;
        //validaCampos$action();
        Short c = getSessionBeanADM().getCompania().getCodCia();
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if (cap.getStatus().equals("N"))
            {
            addMessage("Mantenimiento Participantes", "Esta Capacitacion ya fue notificada, no se pueden agregar más participantes", TipoMensaje.INFORMACION);
            isError = true;
            }
        if (isError)
            {
            return;
            }
        CapacitacionXEmpleado detalleCap = new CapacitacionXEmpleado();
        /*
         * Crear Detalle
         */

        CapacitacionXEmpleado detalle = new CapacitacionXEmpleado();
        CapacitacionXEmpleadoPK pk = new CapacitacionXEmpleadoPK();
        pk.setCodCia(c);
        Cias ciaCod = getSessionBeanADM().getCompania();
        Integer cod = capacitacionSessionBean.getMaxCapacitacion(ciaCod);
        pk.setCodCapacitacion(cod);
        pk.setCodCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionPK().getCodCapacitacion());
        pk.setCodEmp(getSessionBeanCAP().getEmpleadoSeleccionado().getEmpleadosPK().getCodEmp());
        detalle.setCapacitacionXEmpleadoPK(pk);
        detalle.setEmpleados(getSessionBeanCAP().getEmpleadoSeleccionado());
        detalle.setNota(BigDecimal.ZERO);
        try
            {
            capacitacionSessionBean.guardarDetalleCapacitacion(detalle);
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Datos guardados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
            listaDetalle = capacitacionSessionBean.findDetByCap(ciaCod, getSessionBeanCAP().getCapacitacionSeleccionada());
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Detalle de Capacitaciones.", "Este participante ya ha sido agregado a esta Capacitación.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
            }

    }

    public void onRowSelectDetalle(SelectEvent event)
    {
        getSessionBeanCAP().setDetalleCapSeleccionada((CapacitacionXEmpleado) event.getObject());
    }

    public String editar$Det$action()
    {
        if (getSessionBeanCAP().getCapacitacionSeleccionada() == null)
            {
            addMessage("Mantenimiento de Capacitaciones.", "No ha seleccionado ninguna capacitacion para editar.", TipoMensaje.ERROR);
            return null;
            }
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        setStatus(cap.getStatus());
        setInst(cap.getInstituciones().getInstitucionesPK().getCodInsti());
        setNomCapacitacion(cap.getNomCapacitacion());
        setNomInst(cap.getInstituciones().getDesInsti());
        setFechaInicial(cap.getFechaDesde());
        setFechaFinal(cap.getFechaHasta());
        setImpartido(cap.getImpartidaPor());
        setNomArea(cap.getCapacitacionAreas().getNomArea());
        setNomTema(cap.getCapacitacionTemas().getNomTema());
        setNomCapacitador(cap.getCapacitadores().getNombre());
        Cias comp = getSessionBeanADM().getCompania();
        listaEmpleado = capacitacionSessionBean.findEmpByEmpresa(comp);
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), cap);
        getSessionBeanADM().setEstadoAccion(2);
        return null;
    }

    public void eliminar$crud$action(ActionEvent actionEvent)
    {
        isError = false;
        Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
        if (cap.getStatus().equals("N"))
            {
            addMessage("Mantenimiento Participantes", "Esta Capacitacion ya fue notificada, no se pueden eliminar participantes", TipoMensaje.INFORMACION);
            isError = true;
            }
        if (getSessionBeanCAP().getDetalleCapSeleccionada() == null)
            {
            addMessage("Mantenimiento de Participantes", "Primero seleccione un Participante", TipoMensaje.ERROR);
            isError = true;
            }
        if (isError)
            return;
        try
            {
            CapacitacionXEmpleado participante = getSessionBeanCAP().getDetalleCapSeleccionada();
            capacitacionSessionBean.eliminarDetalleCapacitacion(participante);
            addMessage("Mantenimiento de participantes.", "Datos eliminados con éxito", TipoMensaje.INFORMACION);
            limpiarCampos();
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al intentar remover al Participante.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
            }
        listaDetalle = capacitacionSessionBean.findDetByCap(getSessionBeanADM().getCompania(), getSessionBeanCAP().getCapacitacionSeleccionada());
    }

    @PermitAll
    public void enviar$correo$action()
    {
        try
            {
            for (CapacitacionXEmpleado det : listaDetalle)
                {
                //Creacion de registros para asistencia
                try
                    {
                    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
                    Long dias = (getSessionBeanCAP().getCapacitacionSeleccionada().getFechaHasta().getTime() - getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde().getTime()) / MILLSECS_PER_DAY;
                    Integer total = dias.intValue() + 2;
                    for (Integer i = 1; i < total; i++)
                        {
                        CapacitacionAsistencia asistencia = new CapacitacionAsistencia();
                        CapacitacionAsistenciaPK pk = new CapacitacionAsistenciaPK();
                        pk.setCodCia(det.getCapacitacionXEmpleadoPK().getCodCia());
                        pk.setCodCapacitacion(det.getCapacitacionXEmpleadoPK().getCodCapacitacion());
                        pk.setCodEmp(det.getCapacitacionXEmpleadoPK().getCodEmp());
                        pk.setFecha(sumarFechasDias(getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde(), i - 1));
                        asistencia.setCapacitacionAsistenciaPK(pk);
                        asistencia.setCapacitacion(getSessionBeanCAP().getCapacitacionSeleccionada());
                        asistencia.setEmpleados(det.getEmpleados());
                        asistencia.setAsistio("N");
                        capacitacionSessionBean.guardarAsistencia(asistencia);
                        }
                    }
                catch (Exception e)
                    {
                    addMessage("Mantenimiento de Particiantes.", "Ya se han enviado las notificaciones.", TipoMensaje.ERROR);
                    System.out.println(e.getMessage());
                    return;
                    }
                //Enviar correos
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("\n\nPor medio de la presente se le comunica que ha sido convocado a la siguiente Capacitación");
                mensaje.append("\n\nNombre: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getNomCapacitacion());
                mensaje.append("\n\nArea: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionAreas().getNomArea());
                mensaje.append("\n\nTema: ").append(getSessionBeanCAP().getCapacitacionSeleccionada().getCapacitacionTemas().getNomTema());
                mensaje.append("\n\nA celebrarse el día: ").append(new SimpleDateFormat("dd/MM/yyyy").format(getSessionBeanCAP().getCapacitacionSeleccionada().getFechaDesde()));

                mailStatelessBean.enviarCorreoElectronico("Capacitacion", mensaje.toString(), det.getEmpleados().getCorreo());

                }
            Capacitacion cap = getSessionBeanCAP().getCapacitacionSeleccionada();
            cap.setStatus("N");
            capacitacionSessionBean.editarCapacitacion(cap);

            addMessage("Mantenimiento de participantes.", "Correos enviados a los Participantes de esta capacitación ", TipoMensaje.INFORMACION);
            }
        catch (Exception e)
            {
            addMessage("Mantenimiento de Particiantes.", "Ha ocurrido un error al enviar correos a Participantes.", TipoMensaje.ERROR);
            System.out.println(e.getMessage());
            }
    }

    public static Date sumarFechasDias(Date fch, int dias)
    {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }
}
