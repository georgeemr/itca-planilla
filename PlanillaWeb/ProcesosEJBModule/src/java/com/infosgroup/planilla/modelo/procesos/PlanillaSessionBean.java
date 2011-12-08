/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.DetPlanilla;
import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ResumenAsistencia;
import com.infosgroup.planilla.modelo.entidades.TipoPlanilla;
import com.infosgroup.planilla.modelo.entidades.TipoPlanillaPK;
import com.infosgroup.planilla.modelo.estructuras.DetallePlanilla;
import com.infosgroup.planilla.modelo.facades.DetPlanillaFacade;
import com.infosgroup.planilla.modelo.facades.PlanillaFacade;
import com.infosgroup.planilla.modelo.facades.ResumenAsistenciaFacade;
import com.infosgroup.planilla.modelo.facades.TipoPlanillaFacade;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Stateless(name="PlanillaSessionBean")
@LocalBean
public class PlanillaSessionBean {
    @EJB
    private DetPlanillaFacade detPlanillaFacade;
    @EJB
    private PlanillaFacade planillaFacade;
    @EJB
    private TipoPlanillaFacade tipoPlaFacade;
    @EJB
    private ResumenAsistenciaFacade resumenFacade;
    
    public List<DetallePlanilla> listarDetalle(/*int pla, int anio, int mes*/){
        return detPlanillaFacade.findDetalles(/*pla, anio, mes*/);
    }
    
    public List<DetallePlanilla> getDetalle(DetallePlanilla c) {
        return (List<DetallePlanilla>) ((c != null) ? detPlanillaFacade.findDetalles(/*0,0,0*/) :  new ArrayList<DetPlanilla>());
    }
    
    public List<ResumenAsistencia> getResumen(ResumenAsistencia c) {
        return (c != null) ? resumenFacade.findAll() : new ArrayList<ResumenAsistencia>();
    }
    
    public TipoPlanilla findByTipoID(TipoPlanillaPK tipoId){
        return tipoPlaFacade.find(tipoId);
    }
    
    public List<Planilla> getPlaByTipo(TipoPlanilla tipo){
        return planillaFacade.findByTipoPLanilla(tipo);
    }
    
    public List<ResumenAsistencia> getAsistencia(){
        return resumenFacade.findAll();
    }
    
    public String editar$action(ResumenAsistencia resumen){
        resumenFacade.edit(resumen);
        return null;
    }
    
    
    
}
