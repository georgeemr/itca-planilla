/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Cias;
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

    @EJB
    private IndicadorFacade indicadorFacade;

    public List<Indicador> listarIndicadores( Cias cias ) {
        return indicadorFacade.findIndicadoresByCias(cias);
    }
}
