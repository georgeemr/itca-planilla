/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.model;

import com.pos.entity.Agencias;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Soporte
 */
public class ConexionSucursal {
    public static AdapterConsulta consultaOperaciones(Integer cia, Integer sucursal, Date fechaInicial, Date fechaFinal, List<Agencias> lAgencias) {

        String QUERY_CONSULTA = "select 'c' as tipo, sum(cantidad) as cantidad, sum(monto_venta) as venta "
                + "from ventas_diarias "
                + "where cod_cia = ? and cod_sucursal = ? and tipo = 'C' ";

        List<Agencias> listaAgencias = new ArrayList<Agencias>();
        AdapterConsulta adapter = new AdapterConsulta();
        Conexion c = null;
        Connection conexion = null;
        ResultSet resultset = null;
        PreparedStatement cmdSQL = null;

        listaAgencias = lAgencias;
        /* Iterando todas las agencias registradas */

        for (Agencias a : listaAgencias) {
            try {

                c = new Conexion("jdbc:oracle:thin:@" + a.getIp() + ":1521:" + a.getSid(), "", a.getUsuario(), a.getPass());
                conexion = c.getConexion();
                cmdSQL = conexion.prepareStatement(QUERY_CONSULTA);
                cmdSQL.setInt(1, cia);
                cmdSQL.setInt(2, sucursal);

                resultset = cmdSQL.executeQuery(QUERY_CONSULTA);

                BigDecimal monto = BigDecimal.ZERO;
                Long cantidad = new Long("0");
                String tipo = "";
                /*Iterando el resultset*/
                while (resultset.next()) {
                    monto = resultset.getBigDecimal("venta");
                    cantidad = resultset.getLong("cantidad");
                    tipo = resultset.getString("tipo");
                }

                adapter.getSucursalesConectadas().add(new MontoSucursal(a.getNomAgencia(), monto, cantidad, tipo));

            } catch (Exception e) {
                adapter.getSucursalesNoConectadas().add(a.getNomAgencia());
                System.out.println("Error al intentar conectarse a: " + a.getNomAgencia() + " \n " + e.getMessage());
            } finally {
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al intentar cerrar conexion "
                            + "u statement. \n" + ex.getMessage());
                }
            }
        }
        return adapter;
    }
}
