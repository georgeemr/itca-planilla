/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.ejb;

import com.pos.entity.VentasDiarias;
import com.pos.model.Conexion;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Soporte
 */
@Stateless
public class VentasDiariasFacade extends AbstractFacade<VentasDiarias> {

    @PersistenceContext(unitName = "pos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasDiariasFacade() {
        super(VentasDiarias.class);
    }

    public List<VentasDiarias> consolidadoVentas(Integer cia, Integer agencia, java.util.Date fechaInicial, java.util.Date fechaFinal) {

        String consulta = "select cod_cia, cod_agencia, 0 fecha, sum(cantidad) as cantidad, sum(monto_venta) as monto_venta, tipo from ventas_diarias "
                + "where cod_cia    = ? "
                + "and cod_agencia  = decode(?, 0, cod_agencia, ?) "
                + "and trunc(fecha) between trunc(?) and trunc(?) "
                + "group by cod_cia, cod_agencia, 0, 0, tipo";

        javax.persistence.Query q = getEntityManager().createNativeQuery(consulta);
        q.setParameter(1, cia);
        q.setParameter(2, agencia);
        q.setParameter(3, agencia);
        q.setParameter(4, fechaInicial);
        q.setParameter(5, fechaFinal);
        List<Object> listaObjetos = q.getResultList();
        List<VentasDiarias> listaVentas = new ArrayList<VentasDiarias>();

        for (Object objeto : listaObjetos) {
            Object[] fila = (Object[]) objeto;
            VentasDiarias l = new VentasDiarias();
            BigDecimal cantidad = (BigDecimal) fila[3];
            BigDecimal sucursal = (BigDecimal) fila[2];
            BigDecimal monto = (BigDecimal) fila[4];

            try {
                l.setCantidad(cantidad.longValue());
                l.setSucursal(sucursal.toString());
                l.setMontoVenta(monto);
                l.setTipo((String) fila[5]);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            listaVentas.add(l);
        }
        return listaVentas;
    }

    /**
     *
     * @return (String) que contiene las sucursales donde fallo la conexion.
     */
    public String ejecutaProcedureVentas(Integer cia) {
        String mensaje = "";
        Conexion conexion = new Conexion();

        try {
            Connection con = conexion.getConexionPool();
            con = conexion.getConexionPool();
            CallableStatement cs;
            cs = con.prepareCall("{call frogs.pkg_pos.registra_ventas_diarias(?,?)}");
            cs.setInt(1, cia);
            cs.setString(2, "");

            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            mensaje = cs.getString(2);
            cs.close();
            con.close();
            con = null;

        } catch (InstantiationException ex) {
            ex.printStackTrace();
            mensaje = "Error al intentar acceder al pool";
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            mensaje = "Error al intentar acceder al pool";
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            mensaje = "Error al intentar acceder al pool";
        } catch (Exception ex) {
            ex.printStackTrace();
            mensaje = "Error al intentar acceder al pool";
        }
        System.out.println("Procedimiento ejecutado con exito");
        System.out.println("mensaje: " + mensaje);
        return mensaje;
    }
}
