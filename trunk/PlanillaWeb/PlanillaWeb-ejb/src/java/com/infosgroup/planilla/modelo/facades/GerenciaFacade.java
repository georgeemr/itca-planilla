/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Cias;
import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.entidades.GerenciaPK;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class GerenciaFacade extends AbstractFacade<Gerencia, GerenciaPK> {

    @PersistenceContext(unitName = "PlanillaWeb-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GerenciaFacade() {
        super(Gerencia.class);
    }

    @PermitAll
    public List<Object> generarHeadCount(Gerencia g) {
        Long compania = (g != null) ? g.getGerenciaPK().getCodCia() : 1L;
        Long gerencia = (g != null) ? g.getGerenciaPK().getCodGerencia() : 0L;
        //Query q = em.createNativeQuery("select c.id_compania, g.cod_gerencia, g.nom_gerencia, d.id_departamento, d.nom_departamento, s.cod_seccion, s.nom_seccion, p.cod_puesto, p.nombre, count(e.cod_emp) empleados, sum(p.salario_minimo) salario_base from compania c inner join gerencia g on (g.cod_cia = c.id_compania) inner join departamento d on (d.id_compania = g.cod_cia and d.gerencia = g.cod_gerencia) inner join seccion s on (s.cod_cia = g.cod_cia and s.cod_depto = d.id_departamento) inner join tipo_puesto t on (t.cod_cia = g.cod_cia) inner join puesto p on (p.cod_cia = g.cod_cia and p.tipo = t.cod_tipo_puesto) inner join empleado e on (e.cod_cia = g.cod_cia) inner join sucursal su on (su.id_compania = g.cod_cia) inner join puesto_empleado pe on ((pe.id_compania = e.cod_cia and pe.id_empleado = e.cod_emp) and (pe.id_compania = p.cod_cia and pe.id_puesto = p.cod_puesto and pe.id_tipo_puesto = p.tipo) and (t.cod_cia = pe.id_compania and t.cod_tipo_puesto = pe.id_tipo_puesto) and (pe.id_compania = su.id_compania and pe.id_sucursal = su.id_sucursal)) where g.cod_cia = decode(?, 0, g.cod_cia, ?)  and g.cod_gerencia = decode(?, 0, g.cod_gerencia, ?) group by c.id_compania, g.cod_gerencia, g.nom_gerencia, d.id_departamento, d.nom_departamento, s.cod_seccion, s.nom_seccion, p.cod_puesto, p.nombre order by 1, 3, 5, 7");
        //Query q = em.createNativeQuery("select c.id_compania as id_compania, g.cod_gerencia as id_gerencia, g.nom_gerencia as nombre_gerencia, d.id_departamento id_departamento, d.nom_departamento as nombre_departamento, p.cod_puesto id_puesto, p.nombre as nombre_puesto, count(e.cod_emp) empleados, sum(p.salario_minimo) salario_minimo from gerencia g, compania c, departamento d, puesto p, empleado e, puesto_empleado pe where g.cod_cia = decode(?, 0, g.cod_cia, ?) and g.cod_gerencia = decode(?, 0, g.cod_gerencia, ?) and g.cod_cia = c.id_compania and g.cod_cia = p.cod_cia and g.cod_cia = e.cod_cia and g.cod_cia = pe.id_compania and g.cod_gerencia = d.gerencia and pe.id_empleado = e.cod_emp and p.cod_puesto = pe.id_puesto and pe.id_tipo_puesto = p.tipo and e.departamento = d.id_departamento group by c.id_compania, g.cod_gerencia, g.nom_gerencia, d.id_departamento, d.nom_departamento, p.cod_puesto, p.nombre order by 1, 2, 4, 6");
        StringBuilder query = new StringBuilder();
        query.append("select c.cod_cia as id_compania, g.cod_gerencia as id_gerencia, g.nom_gerencia as nombre_gerencia, d.cod_depto as id_departamento, d.nom_depto as nombre_departamento, p.cod_puesto as id_puesto, p.nom_puesto as nombre_puesto, count(e.cod_emp) empleados, sum(nvl(p.sal_minimo,0)) salario_minimo ");
        query.append("from gerencia g, cias c, departamentos d, puestos p, empleados e ");
        query.append("where c.cod_cia = ? and g.cod_cia = c.cod_cia and g.cod_gerencia = decode(?, 0, g.cod_gerencia, ? ) and e.cod_cia = g.cod_cia and d.cod_cia = e.cod_cia and d.cod_depto = e.cod_depto and g.cod_gerencia = d.cod_gerencia and p.cod_cia = e.cod_cia and p.cod_puesto = e.cod_puesto ");
        query.append("group by c.cod_cia, g.cod_gerencia, g.nom_gerencia, d.cod_depto, d.nom_depto, p.cod_puesto, p.nom_puesto ");
        query.append("order by 1, 2, 4, 6");
        Query q = em.createNativeQuery(query.toString()).setParameter(1, compania).setParameter(2, gerencia).setParameter(3, gerencia);
        List<Object> l = q.getResultList();
        return l != null ? l : new ArrayList<Object>();
    }

    @PermitAll
    public List<Gerencia> findGerenciasByCias(Cias cias) {
        List<Gerencia> g = em.createQuery("SELECT g FROM Gerencia g WHERE g.gerenciaPK.codCia = :codCia ORDER BY g.nomGerencia", Gerencia.class).setParameter("codCia", cias.getCodCia()).getResultList();
        return g != null ? g : new ArrayList<Gerencia>();
    }
}
