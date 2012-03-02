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
@Stateless(name = "SessionBeanParametros")
@LocalBean
public class SessionBeanParametros
{

@EJB
private PaisFacade paisFacade;
@EJB
private DeptosFacade departamentosFacade;
@EJB
private MunicipiosFacade municipiosFacade;
@EJB
private TipoSangreFacade tipoSangreFacade;
@EJB
private NivelAcademicoFacade nivelAcademicoFacade;
@EJB
private ProfesionesFacade profesionesFacade;
@EJB
private PuestoFacade puestosFacade;
@EJB
private ParentescoFacade parentescoFacade;
@EJB
private InstitucionesFacade institucionesFacade;
@EJB
private CapacitacionFacade capacitacionFacade;
@EJB
private IdiomaFacade idiomaFacade;
@EJB
private EquipoFacade equipoFacade;
@EJB
private TipoPruebaFacade tipoPruebaFacade;
@EJB
private EmpleadoFacade empleadoFacade;

@PermitAll
public List<Paises> getListaPaises()
{
    return paisFacade.findAll();
}

@PermitAll
public List<Deptos> getListaDepartamentos()
{
    return departamentosFacade.findAll();
}

@PermitAll
public List<Municipios> getListaMunicipios()
{
    return municipiosFacade.findAll();
}

@PermitAll
public List<Deptos> findDepartamentosByPais(Paises pais)
{
    return departamentosFacade.findByPais(pais);
}

@PermitAll
public List<Municipios> findMunicipiosByDepartamento(Deptos departamento)
{
    return municipiosFacade.findByDepartamento(departamento);
}

@PermitAll
public List<TipoSangre> getListaTipoSangre()
{
    return tipoSangreFacade.findAll();
}

@PermitAll
public NivelAcademico findNivelAcademicoById(NivelAcademicoPK nivelAcademicoPK)
{
    return nivelAcademicoFacade.find(nivelAcademicoPK);
}

@PermitAll
public List<NivelAcademico> getListaNivelAcademicos()
{
    return nivelAcademicoFacade.findAll();
}

@PermitAll
public Profesion findProfesionById(ProfesionPK profesionPK)
{
    return profesionesFacade.find(profesionPK);
}

@PermitAll
public List<Profesion> getListaProfesiones()
{
    return profesionesFacade.findAll();
}

@PermitAll
public Deptos findDepartamentoById(DeptosPK deptoPK)
{
    return departamentosFacade.find(deptoPK);
}

@PermitAll
public Municipios findMunicipiosById(MunicipiosPK municipioPK)
{
    return municipiosFacade.find(municipioPK);
}

@PermitAll
public Puestos findPuestosById(PuestosPK puestoPK)
{
    return puestosFacade.find(puestoPK);
}

@PermitAll
public List<Puestos> findAllPuestos(Cias cia)
{
    return puestosFacade.findPuestoByEmpresa(cia);
}

@PermitAll
public List<Parentesco> findAllParentescos(Cias cia)
{
    return parentescoFacade.findAllByCia(cia);
}

@PermitAll
public Parentesco findParentescoById(ParentescoPK parentescoPK)
{
    return parentescoFacade.find(parentescoPK);
}

@PermitAll
public Instituciones findInstitucionById(InstitucionesPK institucionPK)
{
    return institucionesFacade.find(institucionPK);
}

@PermitAll
public List<Instituciones> findAllInstituciones(Cias cia)
{
    return institucionesFacade.findInstitucionByEmpresa(cia);
}

@PermitAll
public Capacitacion findCapacitacionById(CapacitacionPK capacitacionPK)
{
    return capacitacionFacade.find(capacitacionPK);
}

@PermitAll
public List<Capacitacion> findAllCapacitaciones(Cias cia)
{
    return capacitacionFacade.findCapByEmpresa(cia);
}

@PermitAll
public Idioma findIdiomaById(IdiomaPK idiomaPK)
{
    return idiomaFacade.find(idiomaPK);
}

@PermitAll
public List<Idioma> findAllIdiomas(Cias cia)
{
    return idiomaFacade.findAllByCia(cia);
}

@PermitAll
public Equipo findEquipoById(EquipoPK equipoPK)
{
    return equipoFacade.find(equipoPK);
}

@PermitAll
public List<Equipo> findAllEquipos(Cias cia)
{
    return equipoFacade.findAllByCia(cia);
}

@PermitAll
public TipoPrueba findTipoPruebaById(TipoPruebaPK tipoPruebaPK)
{
    return tipoPruebaFacade.find(tipoPruebaPK);
}

@PermitAll
public List<TipoPrueba> findAllTipoPrueba(Cias cia)
{
    return tipoPruebaFacade.findAllByCia(cia);
}

@PermitAll
public Empleados findEmpleadoById(EmpleadosPK empleadoPK)
{
    return empleadoFacade.find(empleadoPK);
}

@PermitAll
public List<Empleados> findAllEmpleados(Cias cia)
{
    return empleadoFacade.findEmpleadosByCias(cia);
}

@PermitAll
public TipoSangre findTipoSangreById(String tipoSangreId)
{
    return tipoSangreFacade.find(tipoSangreId);
}

@PermitAll
public Paises findPaisesByid(short paisId)
{
    return paisFacade.find(paisId);
}
}
