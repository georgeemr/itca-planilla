/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.facades.*;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**

 @author root
 */
@Stateless
@LocalBean
public class CapacitacionesSessionBean
{

@EJB
private CapacitacionFacade capacitacionFacade;
@EJB
private InstitucionesFacade institucionFacade;
@EJB
private CapacitacionXEmpleadoFacade detalleFacade;
@EJB
private EmpleadoFacade empleadoFacade;
@EJB
private CapacitacionAreasFacade areaFacade;
@EJB
private CapacitacionAsistenciaFacade asistenciaFacade;
@EJB
private CapacitacionTemasFacade temasFacade;
@EJB
private CapacitadoresFacade capacitadoresFacade;

@PermitAll
public List<Capacitacion> findAllCapacitacion()
{
    return capacitacionFacade.findAll();
}

public Integer getMaxCapacitacion(Cias empresa)
{
    return capacitacionFacade.max(empresa).intValue();
}

public void guardarCapacitacion(Capacitacion cap)
{
    capacitacionFacade.create(cap);
}

public void editarCapacitacion(Capacitacion c)
{
    capacitacionFacade.edit(c);
}

public void eliminarCapacitacion(Capacitacion cap)
{
    capacitacionFacade.remove(cap);
}

@PermitAll
public List<Capacitacion> findCapByEmpresa(Cias emp)
{
    return capacitacionFacade.findCapByEmpresa(emp);
}

@PermitAll
public List<Instituciones> findInstByEmpresa(Cias emp)
{
    return institucionFacade.findInstitucionByEmpresa(emp);
}

public Instituciones findByInstId(InstitucionesPK id)
{
    return institucionFacade.find(id);
}

@PermitAll
public List<CapacitacionXEmpleado> findDetByCap(Cias emp, Capacitacion cap)
{
    return detalleFacade.findCapByEmpresaCap(emp, cap);
}

public void guardarDetalleCapacitacion(CapacitacionXEmpleado det)
{
    detalleFacade.create(det);
}

public void editarDetalleCapacitacion(CapacitacionXEmpleado det)
{
    detalleFacade.edit(det);
}

public void eliminarDetalleCapacitacion(CapacitacionXEmpleado det)
{
    detalleFacade.remove(det);
}

@PermitAll
public List<Empleados> findEmpByEmpresa(Cias emp)
{
    return empleadoFacade.findEmpleadosByCias(emp);
}

@PermitAll
public List<CapacitacionAreas> findAreaByCap(Cias emp)
{
    return areaFacade.findAreaByEmpresa(emp);
}

@PermitAll
public List<CapacitacionTemas> findTemaByArea(Cias emp, Integer area)
{
    CapacitacionAreas area1 = findByAreaId(new CapacitacionAreasPK(emp.getCodCia(), area));
    return temasFacade.findTemasByArea(emp, area1);
}

@PermitAll
public CapacitacionTemas findByTemaId(CapacitacionTemasPK id)
{
    return temasFacade.find(id);
}

public CapacitacionAreas findByAreaId(CapacitacionAreasPK id)
{
    return areaFacade.find(id);
}

@PermitAll
public List<Capacitadores> findCapacitadoresByCap(Cias emp)
{
    return capacitadoresFacade.findCapByEmpresa(emp);
}

public Capacitadores findByCapId(CapacitadoresPK id)
{
    return capacitadoresFacade.find(id);
}

@PermitAll
public void guardarAsistencia(CapacitacionAsistencia asis)
{
    asistenciaFacade.create(asis);
}

@PermitAll
public void editarAsistencia(CapacitacionAsistencia asis)
{
    asistenciaFacade.edit(asis);
}

@PermitAll
public List<CapacitacionAsistencia> findAsistenciaByDet(Cias cia, Capacitacion cap, Empleados emp)
{
    return asistenciaFacade.findAsistenciaByEmpresa(cia, cap, emp);
}
}
