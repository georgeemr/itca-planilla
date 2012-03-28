/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.CampaniaPK;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**

 @author root
 */
@Stateless
public class CampaniaFacade extends AbstractFacade<Campania, CampaniaPK>
{

@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager()
{
    return em;
}

public CampaniaFacade()
{
    super(Campania.class);
}

public List<Campania> findByEmpleadoEvaluador(Empleados empleado)
{
    List<Campania> l = new ArrayList<Campania>();
    Query q = em.createNativeQuery("select distinct c.* from campania c where (cod_cia, periodo, cod_campania) in (select distinct eva.cod_cia, eva.periodo, eva.campania from evaluador_evaluaciones eva where cod_cia = ? and evaluador = ?) and c.estado = 'G'", Campania.class);
    q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
    q.setParameter(2, empleado.getEmpleadosPK().getCodEmp());
    l = q.getResultList();
    if (l != null)
        for (Campania c : l)
            c.setEmpleadosEvaluados(calcularEmpleadosEvaluados(c));
    return l != null ? l : new ArrayList<Campania>();
}

public List<Campania> findByEmpleadoEvaluadorReport(Empleados empleado)
{
    List<Campania> l = new ArrayList<Campania>();
    Query q = em.createNativeQuery("select distinct c.* from campania c where (cod_cia, periodo, cod_campania) in (select distinct eva.cod_cia, eva.periodo, eva.campania from evaluador_evaluaciones eva where cod_cia = ? and evaluador = ?) and c.estado = '1'", Campania.class);
    q.setParameter(1, empleado.getEmpleadosPK().getCodCia());
    q.setParameter(2, empleado.getEmpleadosPK().getCodEmp());
    l = q.getResultList();
    if (l != null)
        for (Campania c : l)
            c.setEmpleadosEvaluados(calcularEmpleadosEvaluados(c));
    return l != null ? l : new ArrayList<Campania>();
}

@PermitAll
public Integer calcularEmpleadosEvaluados(Campania c)
{
    Long resultado = 0L;
    Query q = em.createQuery("SELECT count(e.finalizada) FROM Evaluacion e WHERE e.finalizada = '1' and e.campania = :campania");
    q.setParameter("campania", c);
    resultado = (Long) q.getSingleResult();
    return resultado != null ? resultado.intValue() : 0;
}

@PermitAll
public List<Campania> findAllByCia(Short empresa)
{
    List<Campania> l = em.createQuery("SELECT c FROM Campania c WHERE c.campaniaPK.codCia = :codCia AND c.estado = 'G'", Campania.class).setParameter("codCia", empresa).getResultList();
    return l != null ? l : new ArrayList<Campania>();
}
}
