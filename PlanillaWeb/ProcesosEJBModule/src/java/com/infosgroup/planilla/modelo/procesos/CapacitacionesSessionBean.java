/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Capacitacion;
import com.infosgroup.planilla.modelo.entidades.CapacitacionXEmpleado;
import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Instituciones;
import com.infosgroup.planilla.modelo.entidades.InstitucionesPK;
import com.infosgroup.planilla.modelo.facades.CapacitacionFacade;
import com.infosgroup.planilla.modelo.facades.CapacitacionXEmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.InstitucionesFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;
import javax.annotation.security.PermitAll;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class CapacitacionesSessionBean {

    @EJB
    private CapacitacionFacade capacitacionFacade;
    @EJB
    private InstitucionesFacade institucionFacade;
    @EJB
    private CapacitacionXEmpleadoFacade detalleFacade;
    
    @PermitAll
    public List<Capacitacion> findAllCapacitacion(){
        return capacitacionFacade.findAll();
    }
    
    public Integer getMaxCapacitacion(Cias empresa) {
        return capacitacionFacade.max(empresa).intValue();
    }
    
    public void guardarCapacitacion(Capacitacion cap){
        capacitacionFacade.create(cap);
    }
    
    public void editarCapacitacion(Capacitacion c) {
        capacitacionFacade.edit(c);
    }
    
    @PermitAll
    public List<Capacitacion> findCapByEmpresa(Cias emp){
        return capacitacionFacade.findCapByEmpresa(emp);
    }
    
    @PermitAll
    public List<Instituciones> findInstByEmpresa(Cias emp){
        return institucionFacade.findInstitucionByEmpresa(emp);
    }
    
    public Instituciones findByInstId(InstitucionesPK id){
        return institucionFacade.find(id);
    }
    
    @PermitAll
    public List<CapacitacionXEmpleado> findDetByCap(Cias emp, Capacitacion cap){
        return detalleFacade.findCapByEmpresaCap(emp, cap);
    }
}
