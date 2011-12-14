/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.entidades.GerenciaPK;
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
public class GerenciaFacade extends AbstractFacade<Gerencia, GerenciaPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public GerenciaFacade()
{
super(Gerencia.class);
}

@PermitAll
public List<Object> generarHeadCount(Gerencia g)
{
Long compania = (g != null) ? g.getGerenciaPK().getCodCia() : 1L ;
Long gerencia = (g != null) ? g.getGerenciaPK().getCodGerencia() : 0L ;
Query q = em.createNativeQuery("select c.id_compania, g.cod_gerencia, g.nom_gerencia, d.id_departamento, d.nom_departamento, s.cod_seccion, s.nom_seccion, p.cod_puesto, p.nombre, count(e.cod_emp) empleados, sum(p.salario_minimo) salario_base from compania c inner join gerencia g on (g.cod_cia = c.id_compania) inner join departamento d on (d.id_compania = g.cod_cia and d.gerencia = g.cod_gerencia) inner join seccion s on (s.cod_cia = g.cod_cia and s.cod_depto = d.id_departamento) inner join tipo_puesto t on (t.cod_cia = g.cod_cia) inner join puesto p on (p.cod_cia = g.cod_cia and p.tipo = t.cod_tipo_puesto) inner join empleado e on (e.cod_cia = g.cod_cia) inner join sucursal su on (su.id_compania = g.cod_cia) inner join puesto_empleado pe on ((pe.id_compania = e.cod_cia and pe.id_empleado = e.cod_emp) and (pe.id_compania = p.cod_cia and pe.id_puesto = p.cod_puesto and pe.id_tipo_puesto = p.tipo) and (t.cod_cia = pe.id_compania and t.cod_tipo_puesto = pe.id_tipo_puesto) and (pe.id_compania = su.id_compania and pe.id_sucursal = su.id_sucursal)) where g.cod_cia = decode(?, 0, g.cod_cia, ?)  and g.cod_gerencia = decode(?, 0, g.cod_gerencia, ?) group by c.id_compania, g.cod_gerencia, g.nom_gerencia, d.id_departamento, d.nom_departamento, s.cod_seccion, s.nom_seccion, p.cod_puesto, p.nombre order by 1, 3, 5, 7");
q.setParameter(1, compania);
q.setParameter(2, compania);
q.setParameter(3, gerencia);
q.setParameter(4, gerencia);
return q.getResultList();
}

}
