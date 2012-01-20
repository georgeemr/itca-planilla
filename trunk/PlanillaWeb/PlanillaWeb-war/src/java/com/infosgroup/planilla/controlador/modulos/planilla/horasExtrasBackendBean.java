/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.Sucursal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

/**
*
* @author infosgroup
*/
@ManagedBean(name = "planilla$horasExtras")
@ViewScoped
public class horasExtrasBackendBean extends AbstractJSFPage implements Serializable
{
@EJB
private PlanillaSessionBean planillaSessionBean;

private List<ResumenAsistencia> horasExtras;

private List<Planilla> listaPlanillas;

private Planilla planillaSeleccionada;

public Planilla getPlanillaSeleccionada()
{
return planillaSeleccionada;
}

public void setPlanillaSeleccionada(Planilla planillaSeleccionada)
{
this.planillaSeleccionada = planillaSeleccionada;
}

private Sucursal sucursalSeleccionada;

public Sucursal getSucursalSeleccionada()
{
return sucursalSeleccionada;
}

public void setSucursalSeleccionada(Sucursal sucursalSeleccionada)
{
this.sucursalSeleccionada = sucursalSeleccionada;
}

private List<Sucursal> listaSucursales;

@PostConstruct
public void init()
{
listaSucursales = planillaSessionBean.listarSucursal();
listaPlanillas = planillaSessionBean.listarPlanilla();
}

public List<Sucursal> getListaSucursales()
{
return listaSucursales;
}

public void setListaSucursales(List<Sucursal> listaSucursales)
{
this.listaSucursales = listaSucursales;
}

public List<Planilla> getListaPlanillas()
{
return listaPlanillas;
}

public void setListaPlanillas(List<Planilla> listaPlanillas)
{
this.listaPlanillas = listaPlanillas;
}

public List<ResumenAsistencia> getHorasExtras()
{
return horasExtras;
}

public void setHorasExtras(List<ResumenAsistencia> horasExtras)
{
this.horasExtras = horasExtras;
}

@Override
protected void limpiarCampos()
{
throw new UnsupportedOperationException("Not supported yet.");
}

public void rowEditListener(RowEditEvent event)
{
boolean hayError = false;
ResumenAsistencia resumen = (ResumenAsistencia) event.getObject();
if (resumen.getEstadoPla().matches("G"))
    {
    hayError = true;
    }
if (hayError)
    {
    planillaSessionBean.editar$action(resumen);
    }
else
    {
    addMessage("Registro de Resumen de Asistencias", "La planilla no está en estado grabado", TipoMensaje.INFORMACION);
    }
mostrarResumenAsistencias$action();
hayError = false;
}

public String mostrarResumenAsistencias$action()
{
Boolean hayError = Boolean.FALSE;
if (planillaSeleccionada == null)
    {
    addMessage("RRHH", "Seleccione la planilla", TipoMensaje.INFORMACION);
    hayError = Boolean.TRUE;
    }
if (sucursalSeleccionada == null)
    {
    addMessage("RRHH", "Seleccione la sucursal", TipoMensaje.INFORMACION);
    hayError = Boolean.TRUE;
    }
if (hayError)
    return null;
horasExtras = planillaSessionBean.listarResumenByPlanillaSucursal(planillaSeleccionada, sucursalSeleccionada);
return null;
}
}