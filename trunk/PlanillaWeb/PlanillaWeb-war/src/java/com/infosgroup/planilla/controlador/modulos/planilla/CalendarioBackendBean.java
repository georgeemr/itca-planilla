/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EmpleadoPK;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
*
* @author root
*/
@ManagedBean(name = "planilla$calendario")
@ViewScoped
public class CalendarioBackendBean extends JSFUtil implements Serializable
{
@EJB
private EmpleadosSessionBean empleadosBean;

@EJB
private PlanillaSessionBean planillaBean;

@PostConstruct
public void init()
{
anio = "" + Calendar.getInstance().get(Calendar.YEAR);
}

@Override
protected void limpiarCampos()
{
}

public String volver$action()
{
return "accionesPersonal?faces-redirect=true";
}

private String anio;

public String getAnio()
{
return anio;
}

public void setAnio(String anio)
{
this.anio = anio;
}

private List<SelectItem> empleadosListModel;

public List<SelectItem> getEmpleadosListModel()
{
List<Empleado> listaEmpleados = empleadosBean.listarEmpleados();
empleadosListModel = new ArrayList<SelectItem>(0);
for (Empleado empleado : listaEmpleados)
    {
    EmpleadoPK empleadoPK = empleado.getEmpleadoPK();
    empleadosListModel.add(new SelectItem(empleadoPK.getCodCia() + ":" + empleadoPK.getCodEmp(), empleado.getNombreCompleto()));
    }
return empleadosListModel;
}

public void setEmpleadosListModel(List<SelectItem> empleadosListModel)
{
this.empleadosListModel = empleadosListModel;
}

private String empleadoSeleccionado;

public String getEmpleadoSeleccionado()
{
return empleadoSeleccionado;
}

public void setEmpleadoSeleccionado(String empleadoSeleccionado)
{
this.empleadoSeleccionado = empleadoSeleccionado;
}

public String mostrarAcciones$action()
{
String[] pkEmpleado = empleadoSeleccionado.split(":");
EmpleadoPK empleadoPK = new EmpleadoPK(Long.parseLong(pkEmpleado[0]), Long.parseLong(pkEmpleado[1]));
Empleado empleado = empleadosBean.buscarEmpleadoPorPK(empleadoPK);
Integer tipo = null;
if (estilo == null)
    {
    addMessage("RRHH", "Seleccione la acci&oacute;n que desea mostrar en el calendario", TipoMensaje.INFORMACION);
    return null;
    }

if (estilo.equals("festivos"))
    tipo = 1;
else if (estilo.equals("laborales"))
    tipo = 2;
else if (estilo.equals("vacaciones"))
    tipo = 3;
fechas = planillaBean.cadenaDiasCalendario(tipo, empleado, null, null, Long.parseLong(anio));
System.out.println(fechas);
return null;
}

private List<SelectItem> listaAniosModel;

public List<SelectItem> getListaAniosModel()
{
listaAniosModel = new ArrayList<SelectItem>(0);
for (Integer i = 2000; i < 2100; i++)
    {
    listaAniosModel.add(new SelectItem(i.toString()));
    }
return listaAniosModel;
}

public void setListaAniosModel(List<SelectItem> listaAniosModel)
{
this.listaAniosModel = listaAniosModel;
}

private String fechas;

public String getFechas()
{
return fechas;
}

public void setFechas(String fechas)
{
this.fechas = fechas;
}

private String estilo;

public String getEstilo()
{
return estilo;
}

public void setEstilo(String estilo)
{
this.estilo = estilo;
}
}
