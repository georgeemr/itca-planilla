/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Soporte
 */
public class AdapterConsulta {

    List<MontoSucursal> sucursalesConectadas = new ArrayList<MontoSucursal>();
    List<String> sucursalesNoConectadas = new ArrayList<String>();

    public AdapterConsulta() {
    }

    public List<MontoSucursal> getSucursalesConectadas() {
        return sucursalesConectadas;
    }

    public void setSucursalesConectadas(List<MontoSucursal> sucursalesConectadas) {
        this.sucursalesConectadas = sucursalesConectadas;
    }

    public List<String> getSucursalesNoConectadas() {
        return sucursalesNoConectadas;
    }

    public void setSucursalesNoConectadas(List<String> sucursalesNoConectadas) {
        this.sucursalesNoConectadas = sucursalesNoConectadas;
    }
}
