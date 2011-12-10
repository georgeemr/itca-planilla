/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

/**
*
* @author root
*/
@ManagedBean(name = "empleados$definirEvaluaciones")
@ViewScoped
public class DefinirEvaluacionesBackendBean extends JSFUtil implements Serializable
{
///** Creates a new instance of DefinirEvaluacionesBackendBean */
//public DefinirEvaluacionesBackendBean()
//{
//}

@EJB
private EmpleadosSessionBean empleadosBean;

@Override
protected void limpiarCampos()
{
throw new UnsupportedOperationException("Not supported yet.");
}

// =========================================================================================================
private DualListModel<Empleado> modeloEmpleadosEvaluadores;

public DualListModel getModeloEmpleadosEvaluadores()
{
return modeloEmpleadosEvaluadores;
}

public void setModeloEmpleadosEvaluadores(DualListModel modeloEmpleadosEvaluadores)
{
this.modeloEmpleadosEvaluadores = modeloEmpleadosEvaluadores;
}

@PostConstruct
public void init()
{
List<Empleado> listaEvaluadoresSource = empleadosBean.listarEmpleados();
List<Empleado> listaEvaluadoresTarget = new ArrayList<Empleado>(0);
modeloEmpleadosEvaluadores = new DualListModel<Empleado>(listaEvaluadoresSource, listaEvaluadoresTarget);
}
}
