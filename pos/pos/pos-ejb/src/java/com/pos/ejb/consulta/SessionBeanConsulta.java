/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb.consulta;

import com.pos.ejb.VentasDiariasFacade;
import com.pos.entity.VentasDiarias;
import com.pos.model.AdapterConsulta;
import com.pos.model.MontoSucursal;
import com.pos.model.TipoConsulta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
@LocalBean
public class SessionBeanConsulta {

    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;
    @EJB
    private VentasDiariasFacade ventasDiarias;

    protected EntityManager getEntityManager() {
        return em;
    }

    /*
     * Consulta Dinamica de ventas.
     */
    public AdapterConsulta consultaOperaciones(Integer cia, Integer agencia, Date fechaInicial, Date fechaFinal, TipoConsulta tipo) {

        List<VentasDiarias> listaVentas = new ArrayList<VentasDiarias>();
        AdapterConsulta adapter = new AdapterConsulta();

        /* Si la consulta que se hace es en tiempo real
         * entonces ejecutar primero el procedure de actualizacion.
         */
        if (tipo.equals(tipo.TIEMPO_REAL)) {
            /*En caso de error, agregamos un objeto para obtener la sucursales donde no se pudo conectar. */
            adapter.getSucursalesNoConectadas().add(ventasDiarias.ejecutaProcedureVentas(1));
        }

        listaVentas = ventasDiarias.consolidadoVentas(cia, agencia, fechaInicial, fechaFinal);
        /* Iterando todas las agencias registradas */
        for (VentasDiarias a : listaVentas) {
            adapter.getSucursalesConectadas().add(new MontoSucursal(a.getSucursal(), a.getMontoVenta(), a.getCantidad(), a.getTipo()));
        }

        return adapter;
    }
}
