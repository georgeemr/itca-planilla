/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
*
* @author root
*/
public class DetallePlanilla implements Serializable
{
private PuestoEmpleado puestoEmpleado;

private Planilla planilla;

private BigDecimal prestaciones;

private BigDecimal deducciones;

private BigDecimal total;

private List<DetPlanilla> listaIng;

private List<DetPlanilla> listaEgr;

public BigDecimal getDeducciones()
{
return deducciones;
}

public void setDeducciones(BigDecimal deducciones)
{
this.deducciones = deducciones;
}

public List<DetPlanilla> getListaEgr()
{
return listaEgr;
}

public void setListaEgr(List<DetPlanilla> listaEgr)
{
this.listaEgr = listaEgr;
}

public List<DetPlanilla> getListaIng()
{
return listaIng;
}

public void setListaIng(List<DetPlanilla> listaIng)
{
this.listaIng = listaIng;
}

public Planilla getPlanilla()
{
return planilla;
}

public void setPlanilla(Planilla planilla)
{
this.planilla = planilla;
}

public BigDecimal getPrestaciones()
{
return prestaciones;
}

public void setPrestaciones(BigDecimal prestaciones)
{
this.prestaciones = prestaciones;
}

public PuestoEmpleado getPuestoEmpleado()
{
return puestoEmpleado;
}

public void setPuestoEmpleado(PuestoEmpleado puestoEmpleado)
{
this.puestoEmpleado = puestoEmpleado;
}

public BigDecimal getTotal()
{
return total;
}

public void setTotal(BigDecimal total)
{
this.total = total;
}
}
