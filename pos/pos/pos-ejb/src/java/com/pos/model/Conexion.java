/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Soporte
 */
public class Conexion {

    private static java.sql.Connection conexion = null;
    private static java.sql.Connection conexionPool = null;
    private String url = "";
    private String driver = "";
    private String usuario = "";
    private String password = "";

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Conexion() {
    }

    public Conexion(String url, String driver, String usuario, String password) {
        this.url = url;
        this.driver = driver;
        this.usuario = usuario;
        this.password = password;
    }

    public java.sql.Connection getConexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        try {
            if (conexion == null || conexion.isClosed()) {
                try {
                    Class.forName(driver).newInstance();
                    conexion = java.sql.DriverManager.getConnection(url, usuario, password);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Conexion establecida con exito");
        return conexion;
    }

    public java.sql.Connection getConexionPool() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection con;
        DataSource ds;
        try {
            if (this.conexionPool == null || this.conexionPool.isClosed() == true) {
                try {
                    ds = (DataSource) InitialContext.doLookup("jdbc/POSDatasource");
                    con = ds.getConnection();
                    conexionPool = con;
                } catch (NamingException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return this.conexionPool;
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error al intentar acceder al pool de conexiones");
            ex.printStackTrace();
        }
        return null;
    }
}
