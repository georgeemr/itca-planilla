/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.sessionbean;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.List;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBeanEMP")
@SessionScoped
public class SessionBeanEMP
{
public SessionBeanEMP()
{
}

private Campania campania;

private Plantilla plantilla;

private TipoEvaluacion tipoEvaluacion;

private Empleado empleado;

public Campania getCampania()
{
    return campania;
}

public void setCampania(Campania campania)
{
    this.campania = campania;
}

public Empleado getEmpleado()
{
    return empleado;
}

public void setEmpleado(Empleado empleado)
{
    this.empleado = empleado;
}

public Plantilla getPlantilla()
{
    return plantilla;
}

public void setPlantilla(Plantilla plantilla)
{
    this.plantilla = plantilla;
}

public TipoEvaluacion getTipoEvaluacion()
{
    return tipoEvaluacion;
}

public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
    this.tipoEvaluacion = tipoEvaluacion;
}

private Factor factor;

public Factor getFactor()
{
    return factor;
}

public void setFactor(Factor factor)
{
    this.factor = factor;
}

private List<Factor> listaFactores;

public List<Factor> getListaFactores()
{
    return listaFactores;
}

public void setListaFactores(List<Factor> listaFactores)
{
    this.listaFactores = listaFactores;
}

private List<DetalleEvaluacion> detalleEvaluacionTemporal;

public List<DetalleEvaluacion> getDetalleEvaluacionTemporal()
{
    return detalleEvaluacionTemporal;
}

public void setDetalleEvaluacionTemporal(List<DetalleEvaluacion> detalleEvaluacionTemporal)
{
    this.detalleEvaluacionTemporal = detalleEvaluacionTemporal;
}
}
