/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.facades;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.Candidato;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.EmpleadoPK;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
*
* @author root
*/
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado, EmpleadoPK>
{
@PersistenceContext(unitName = "PlanillaWeb-ejbPU")
private EntityManager em;

protected EntityManager getEntityManager()
{
return em;
}

public EmpleadoFacade()
{
super(Empleado.class);
}

public List<Empleado> findEmpleadosEvaluados(Campania c)
{
List<Empleado> le = null ;
Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleado.class);
q.setParameter(1, c.getCampaniaPK().getCodCia());
q.setParameter(2, c.getCampaniaPK().getPeriodo());
q.setParameter(3, c.getCampaniaPK().getCodCampania());
le = (List<Empleado>) q.getResultList();
return le;
}

public List<Empleado> findEmpleadosNoEvaluados(Campania c)
{
List<Empleado> le = null ;
Query q = em.createNativeQuery("select em.* from empleado em where (cod_cia, em.cod_emp) not in (select ev.cod_cia, ev.empleado from evaluacion ev where (ev.cod_cia, ev.periodo, ev.cod_campania) in (select c.cod_cia, c.periodo, c.cod_campania from campania c where cod_cia = ? and periodo = ? and cod_campania = ?)) order by em.cod_cia, em.cod_emp", Empleado.class);
q.setParameter(1, c.getCampaniaPK().getCodCia());
q.setParameter(2, c.getCampaniaPK().getPeriodo());
q.setParameter(3, c.getCampaniaPK().getCodCampania());
le = (List<Empleado>) q.getResultList();
return le;
}

public Empleado findByUsuario(String usuario)
{
Empleado e = null ;
TypedQuery tq = em.createNamedQuery("Empleado.findByUsuario", Empleado.class);
tq.setParameter("usuario", usuario);
e = (Empleado) tq.getSingleResult();
return e;
}

    public List<Empleado> findByJefes() {
        List<Empleado> listaJefes = new ArrayList<Empleado>(0);

        Query pue = em.createQuery("select e from Empleado e, PuestoEmpleado p "
                + "where p.puesto.jefatura = 1 "
                +"and p.empleado.empleadoPK = e.empleadoPK", Empleado.class);
        listaJefes = pue.getResultList();

        return listaJefes;
    }
    
    public Long getMax(Long empresa){
        Long max = (Long) em.createQuery("SELECT max(e.empleadoPK.codEmp) FROM Empleado e WHERE e.empleadoPK.codCia = :codCia").setParameter("codCia", empresa).getSingleResult();
        return max != null ? ( ++max ): 1L;
    }
    
    public Empleado toEmpleado(Candidato c){
        Empleado e = new Empleado();
        EmpleadoPK pk = new EmpleadoPK(c.getCandidatoPK().getCodCia(), getMax(c.getCandidatoPK().getCodCia()));
        e.setEmpleadoPK(pk);
        if ( c != null){
            e.setNombres( c.getNombre() );
            e.setApellidos( e.getApellidos() );
            e.setApCasada( c.getApCasada() );
            e.setFechaNac( c.getFechaNacimiento() );
            e.setObservacion( c.getObservacion() );
            e.setCandidato(c);
        }
        return e;
    }
    
    public String generaUsuario( Candidato c ){
        return "ṕrueba";
    }
}
