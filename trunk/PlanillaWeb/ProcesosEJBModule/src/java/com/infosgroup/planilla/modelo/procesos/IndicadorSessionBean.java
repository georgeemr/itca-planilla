/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Indicador;
import com.infosgroup.planilla.modelo.estructuras.ModelIndicadores;
import com.infosgroup.planilla.modelo.facades.IndicadorFacade;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;

/**
 *
 * @author Soporte
 */
@Stateless
@LocalBean
public class IndicadorSessionBean {
    
    @Resource(name = "PlanillaDatasource")
    private DataSource planillaJDBCDatasource;

    @EJB
    private IndicadorFacade indicadorFacade;

    @PermitAll
    public List<Indicador> listarIndicadores(Cias cias) {
        return indicadorFacade.findIndicadoresByCias(cias);
    }

    @PermitAll
    public List<ModelIndicadores> listaIndicadores(Cias cias, Date fechaInicial, Date fechaFinal) {
        calcularIndicadores(cias, fechaInicial, fechaFinal);
        return indicadorFacade.listaIndicadores(cias);
    }

    @PermitAll
    public void calcularIndicadores(Cias empresa, Date fechaInicial, Date fechaFinal) {
        try {
            Connection conexion = planillaJDBCDatasource.getConnection();
            CallableStatement statement = conexion.prepareCall("begin pkg_indicadores.calcular_indicadores( ?, ?, ? ); end;");
            statement.setBigDecimal(1, new BigDecimal( empresa.getCodCia()) );
            statement.setDate(2, new java.sql.Date(fechaInicial.getTime()) );
            statement.setDate(3, new java.sql.Date(fechaFinal.getTime()));
            statement.execute();
            statement.close();
            conexion.close();
            conexion=null;
        } catch (Exception excpt) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Ha ocurrido la siguiente excepción: ", excpt);
        }
    }
}
