/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.entidades.Profesion;
import com.infosgroup.planilla.modelo.entidades.TipoSangre;
import com.infosgroup.planilla.modelo.entidades.Deptos;
import com.infosgroup.planilla.modelo.entidades.Municipios;
import com.infosgroup.planilla.modelo.entidades.Paises;
import com.infosgroup.planilla.modelo.facades.DeptosFacade;
import com.infosgroup.planilla.modelo.facades.MunicipiosFacade;
import com.infosgroup.planilla.modelo.facades.NivelAcademicoFacade;
import com.infosgroup.planilla.modelo.facades.PaisFacade;
import com.infosgroup.planilla.modelo.facades.ProfesionesFacade;
import com.infosgroup.planilla.modelo.facades.TipoSangreFacade;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless(name = "SessionBeanParametros")
@LocalBean
public class SessionBeanParametros {

    @EJB
    private PaisFacade paisFacade;
    @EJB
    private DeptosFacade departamentosFacade;
    @EJB
    private MunicipiosFacade municipiosFacade;
    @EJB
    private TipoSangreFacade tipoSangreFacade;
    @EJB
    private NivelAcademicoFacade nivelAcademicoFacade;
    @EJB
    private ProfesionesFacade profesionesFacade;

    @PermitAll
    public List<Paises> getListaPaises() {
        return paisFacade.findAll();
    }

    @PermitAll
    public List<Deptos> getListaDepartamentos() {
        return departamentosFacade.findAll();
    }

    @PermitAll
    public List<Municipios> getListaMunicipios() {
        return municipiosFacade.findAll();
    }

    @PermitAll
    public List<Deptos> findDepartamentosByPais(Paises pais) {
        return departamentosFacade.findByPais(pais);
    }

    @PermitAll
    public List<Municipios> findMunicipiosByDepartamento(Deptos departamento) {
        return municipiosFacade.findByDepartamento(departamento);
    }

    @PermitAll
    public List<TipoSangre> getListaTipoSangre() {
        return tipoSangreFacade.findAll();
    }

    @PermitAll
    public List<NivelAcademico> getListaNivelAcademicos() {
        return nivelAcademicoFacade.findAll();
    }

    @PermitAll
    public List<Profesion> getListaProfesiones() {
        return profesionesFacade.findAll();
    }
}
