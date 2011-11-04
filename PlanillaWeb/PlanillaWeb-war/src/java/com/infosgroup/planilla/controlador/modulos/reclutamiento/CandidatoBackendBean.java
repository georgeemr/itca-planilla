/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.view.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@ManagedBean(name = "reclutamiento$candidato")
@ViewScoped
public class CandidatoBackendBean extends JSFUtil implements Serializable {

    private String nombre;
    private String apellido;
    private String apellidoDeCasada;
    private Date fechaNacimiento;
    private String sexo;
    private String observaciones;
    private List<SelectItem> selectSexo;

    public CandidatoBackendBean() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellidoDeCasada() {
        return apellidoDeCasada;
    }

    public void setApellidoDeCasada(String apellidoDeCasada) {
        this.apellidoDeCasada = apellidoDeCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SelectItem> getSelectSexo() {
        selectSexo = new ArrayList<SelectItem>();
        selectSexo.add(new SelectItem("M", "Masculino"));
        selectSexo.add(new SelectItem("F", "Femenino"));
        return selectSexo;
    }

    public void setSelectSexo(List<SelectItem> selectSexo) {
        this.selectSexo = selectSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
