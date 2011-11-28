/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;


import com.infosgroup.planilla.modelo.entidades.Indicador;
import com.infosgroup.planilla.modelo.facades.IndicadorFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Soporte
 */
@Stateless
@LocalBean
public class IndicadorSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
     private IndicadorFacade indicadorFacade;
    
    public List<Indicador> listarIndicadores()
    {
       return indicadorFacade.findAll();
    }
    
}
