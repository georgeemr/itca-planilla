/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.*;
import com.infosgroup.planilla.modelo.procesos.ReclutamientoSessionBean;
import com.infosgroup.planilla.modelo.procesos.SessionBeanParametros;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.NotNull;

/**

 @author root
 */
@ManagedBean(name = "reclutamiento$candidato")
@ViewScoped
public class CandidatoBackendBean extends AbstractJSFPage implements Serializable
{

@EJB
private ReclutamientoSessionBean reclutamientoFacade;
@EJB
private SessionBeanParametros sessionBeanParametros;
// ===========================================================================================================
// = Candidato ===============================================================================================
// ===========================================================================================================
private Date fechaSolicitud;
private String nombre;
private String apellido;
private String apellidoCasada;
private String sexo;
private String observaciones;
// ===========================================================================================================
// = Generales ===============================================================================================
// ===========================================================================================================
private String generales$pais;
private String generales$departamento;
private String generales$municipio;
private String generales$telefono;
private String generales$direccion;
// = o =
@NotNull
private Date generales$fechaNacimiento;
private String generales$paisNacimiento;
private String generales$departamentoNacimiento;
private String generales$municipioNacimiento;
private String generales$paisNacionalidad;
private String generales$grupoSanguineo;
// = o =
private String generales$dui;
private String generales$nit;
private Date generales$fechaExpDui;
private String generales$departamentoExpDui;
private String generales$municipioExpDui;
private String generales$licenciaConducir;
private String generales$pasaporte;
private String generales$nombreISSS;
private String generales$nombreNIT;
// ===========================================================================================================
// = Preparacion academica ===================================================================================
// ===========================================================================================================
private String preparacion$nombreInstitucion;
private String preparacion$pais;
private String preparacion$departamento;
private String preparacion$nivelAcademico;
private String preparacion$profesion;
private Short preparacion$anioIngreso;
private Short preparacion$anioEgreso;
// ===========================================================================================================
// = Emergencias =============================================================================================
// ===========================================================================================================
private String emergencias$conyuge;
private String emergencias$trabajo;
private String emergencias$telefono;
// = o =
private Integer emergencias$condicionSalud;
private Boolean emergencias$actividadLimitada;
private Boolean emergencias$haSufridoAccidentes;
private Integer emergencias$tipoAccidente;
private Double emergencias$pesoActual;
private Integer emergencias$estatura;
// = o =
private String emergencias$nombreContacto;
private String emergencias$telefonoContacto;
private String emergencias$parentescoContacto;
// ===========================================================================================================
// = Experiencia laboral =====================================================================================
// ===========================================================================================================
private String experiencia$lugarTrabajo;
private String experiencia$puesto;
private Date experiencia$fechaInicio;
private Date experiencia$fechaFin;
private String experiencia$motivoRetiro;
// ===========================================================================================================
// = Referencias =============================================================================================
// ===========================================================================================================
private String referencias$rl$nombre;
private String referencias$rl$lugarTrabajo;
private String referencias$rl$puesto;
private String referencias$rl$telefono;
private String referencias$rl$correoElectronico;
// = o =
private String referencias$rp$nombre;
private String referencias$rp$lugarTrabajo;
private Integer referencias$rp$tiempoConocerle;
private String referencias$rp$telefono;
private String referencias$rp$correoElectronico;
// ===========================================================================================================
// = Documentos ===============================================================================================
// ===========================================================================================================
private String documentos$tipo;
private Integer documentos$numero;
// ===========================================================================================================
// = Capacitaciones ==========================================================================================
// ===========================================================================================================
private String capacitacion$capacitacion;
private String capacitacion$descripcion;
private String capacitacion$institucion;
private Date capacitacion$fecha;
// ===========================================================================================================
// = Dependientes ============================================================================================
// ===========================================================================================================
private String dependientes$nombre;
private Date dependientes$fechaNacimiento;
private String dependientes$parentesco;
// ===========================================================================================================
// = Idiomas =================================================================================================
// ===========================================================================================================
private String idiomas$idioma;
private Boolean idiomas$lee;
private Boolean idiomas$escribe;
private Integer idiomas$nivel;
// ===========================================================================================================
// = Beneficiarios ===========================================================================================
// ===========================================================================================================
private String beneficiarios$nombre;
// ===========================================================================================================
// = Equipos de oficina ======================================================================================
// ===========================================================================================================
private String equipos$equipo;
private Integer equipos$estado;
// ===========================================================================================================
// = Pruebas =================================================================================================
// ===========================================================================================================
private String pruebas$tipoPrueba;
private String pruebas$resultado;
private Double pruebas$nota;
private Double pruebas$costo;
private Date pruebas$fecha;
// ===========================================================================================================
// = Puestos =================================================================================================
// ===========================================================================================================
private String puestos$puesto;
private Double puestos$salarioAspirado;
// ===========================================================================================================
// = Entrevistas =============================================================================================
// ===========================================================================================================
private Date puestos$entrevistas$fecha;
private String puestos$entrevistas$entrevistador;
private String puestos$entrevistas$descripcion;
private String puestos$entrevistas$resultado;
// ===========================================================================================================
// ===========================================================================================================
// ===========================================================================================================
private List<TipoDocumento> listaTipoDocumentos;
private List<Candidato> listaCandidatos;
private List<Paises> paisesSelectItemListModel;
private List<Deptos> deptosDomicilioSelectItemListModel;
private List<Municipios> municipiosDomicilioSelectItemListModel;
private List<Deptos> deptosNacSelectItemListModel;
private List<Municipios> municipiosNacDomicilioSelectItemListModel;
private List<Deptos> deptosExpDUISelectItemListModel;
private List<Municipios> municipiosExpDUISelectItemListModel;
private List<Deptos> deptosPrepAcadSelectItemListModel;
//private List<Municipios> municipiosPrepAcadSelectItemListModel;
private List<TipoSangre> listaTipoSangre;
private List<NivelAcademico> listaNivelAcademico;
private List<Profesion> listaProfesiones;
// ======================================
private List<Puestos> puestosSelectItemListModel;
private List<Parentesco> parentescoSelectItemListModel;
private List<Capacitacion> capacitacionesSelectItemListModel;
private List<Instituciones> institucionesSelectItemListModel;
private List<Idioma> idiomasSelectItemListModel;
private List<Equipo> equiposSelectItemListModel;
private List<TipoPrueba> tiposPruebaSelectItemListModel;
private List<Empleados> empleadosSelectItemListModel;

public List<Deptos> getDeptosDomicilioSelectItemListModel()
{
    return deptosDomicilioSelectItemListModel;
}

public void setDeptosDomicilioSelectItemListModel(List<Deptos> deptosDomicilioSelectItemListModel)
{
    this.deptosDomicilioSelectItemListModel = deptosDomicilioSelectItemListModel;
}

public List<Deptos> getDeptosExpDUISelectItemListModel()
{
    return deptosExpDUISelectItemListModel;
}

public void setDeptosExpDUISelectItemListModel(List<Deptos> deptosExpDUISelectItemListModel)
{
    this.deptosExpDUISelectItemListModel = deptosExpDUISelectItemListModel;
}

public List<Deptos> getDeptosNacSelectItemListModel()
{
    return deptosNacSelectItemListModel;
}

public void setDeptosNacSelectItemListModel(List<Deptos> deptosNacSelectItemListModel)
{
    this.deptosNacSelectItemListModel = deptosNacSelectItemListModel;
}

public List<Municipios> getMunicipiosDomicilioSelectItemListModel()
{
    return municipiosDomicilioSelectItemListModel;
}

public void setMunicipiosDomicilioSelectItemListModel(List<Municipios> municipiosDomicilioSelectItemListModel)
{
    this.municipiosDomicilioSelectItemListModel = municipiosDomicilioSelectItemListModel;
}

public List<Municipios> getMunicipiosExpDUISelectItemListModel()
{
    return municipiosExpDUISelectItemListModel;
}

public void setMunicipiosExpDUISelectItemListModel(List<Municipios> municipiosExpDUISelectItemListModel)
{
    this.municipiosExpDUISelectItemListModel = municipiosExpDUISelectItemListModel;
}

public List<Municipios> getMunicipiosNacDomicilioSelectItemListModel()
{
    return municipiosNacDomicilioSelectItemListModel;
}

public void setMunicipiosNacDomicilioSelectItemListModel(List<Municipios> municipiosNacDomicilioSelectItemListModel)
{
    this.municipiosNacDomicilioSelectItemListModel = municipiosNacDomicilioSelectItemListModel;
}

public List<Paises> getPaisesSelectItemListModel()
{
    return paisesSelectItemListModel;
}

public void setPaisesSelectItemListModel(List<Paises> paisesSelectItemListModel)
{
    this.paisesSelectItemListModel = paisesSelectItemListModel;
}

public List<Deptos> getDeptosPrepAcadSelectItemListModel()
{
    return deptosPrepAcadSelectItemListModel;
}

public void setDeptosPrepAcadSelectItemListModel(List<Deptos> deptosPrepAcadSelectItemListModel)
{
    this.deptosPrepAcadSelectItemListModel = deptosPrepAcadSelectItemListModel;
}

public List<Puestos> getPuestosSelectItemListModel()
{
    return puestosSelectItemListModel;
}

public void setPuestosSelectItemListModel(List<Puestos> puestosSelectItemListModel)
{
    this.puestosSelectItemListModel = puestosSelectItemListModel;
}

public List<Parentesco> getParentescoSelectItemListModel()
{
    return parentescoSelectItemListModel;
}

public void setParentescoSelectItemListModel(List<Parentesco> parentescoSelectItemListModel)
{
    this.parentescoSelectItemListModel = parentescoSelectItemListModel;
}

public List<Capacitacion> getCapacitacionesSelectItemListModel()
{
    return capacitacionesSelectItemListModel;
}

public void setCapacitacionesSelectItemListModel(List<Capacitacion> capacitacionesSelectItemListModel)
{
    this.capacitacionesSelectItemListModel = capacitacionesSelectItemListModel;
}

public List<Instituciones> getInstitucionesSelectItemListModel()
{
    return institucionesSelectItemListModel;
}

public void setInstitucionesSelectItemListModel(List<Instituciones> institucionesSelectItemListModel)
{
    this.institucionesSelectItemListModel = institucionesSelectItemListModel;
}

public List<Idioma> getIdiomasSelectItemListModel()
{
    return idiomasSelectItemListModel;
}

public void setIdiomasSelectItemListModel(List<Idioma> idiomasSelectItemListModel)
{
    this.idiomasSelectItemListModel = idiomasSelectItemListModel;
}

public List<Equipo> getEquiposSelectItemListModel()
{
    return equiposSelectItemListModel;
}

public void setEquiposSelectItemListModel(List<Equipo> equiposSelectItemListModel)
{
    this.equiposSelectItemListModel = equiposSelectItemListModel;
}

public List<TipoPrueba> getTiposPruebaSelectItemListModel()
{
    return tiposPruebaSelectItemListModel;
}

public void setTiposPruebaSelectItemListModel(List<TipoPrueba> tiposPruebaSelectItemListModel)
{
    this.tiposPruebaSelectItemListModel = tiposPruebaSelectItemListModel;
}

public List<Empleados> getEmpleadosSelectItemListModel()
{
    return empleadosSelectItemListModel;
}

public void setEmpleadosSelectItemListModel(List<Empleados> empleadosSelectItemListModel)
{
    this.empleadosSelectItemListModel = empleadosSelectItemListModel;
}
// ======================================
private Boolean isError;
// ===========================================================================================================
// ===========================================================================================================
// ===========================================================================================================

@PermitAll
@PostConstruct
public void init()
{
    fechaSolicitud = Calendar.getInstance().getTime();
    listaCandidatos = reclutamientoFacade.getCandidatosByEmpresa(getSessionBeanADM().getCompania());

    paisesSelectItemListModel = sessionBeanParametros.getListaPaises();

    deptosDomicilioSelectItemListModel = new ArrayList<Deptos>();
    municipiosDomicilioSelectItemListModel = new ArrayList<Municipios>();

    deptosNacSelectItemListModel = new ArrayList<Deptos>();
    municipiosNacDomicilioSelectItemListModel = new ArrayList<Municipios>();

    //deptosExpDUISelectItemListModel = new ArrayList<Deptos>();
    deptosExpDUISelectItemListModel = sessionBeanParametros.findDepartamentosByPais(sessionBeanParametros.findPaisesByid(new Short("1")));
    municipiosExpDUISelectItemListModel = new ArrayList<Municipios>();

//    listaDepartamentos = sessionBeanParametros.getListaDepartamentos();
//    listaMunicipios = sessionBeanParametros.getListaMunicipios();
    listaNivelAcademico = sessionBeanParametros.getListaNivelAcademicos();
    listaTipoSangre = sessionBeanParametros.getListaTipoSangre();
    listaProfesiones = sessionBeanParametros.getListaProfesiones();
    listaTipoDocumentos = reclutamientoFacade.findAllTipoDocumento();
    // ===================================================================
    puestosSelectItemListModel = sessionBeanParametros.findAllPuestos(getSessionBeanADM().getCompania());
    parentescoSelectItemListModel = sessionBeanParametros.findAllParentescos(getSessionBeanADM().getCompania());
    capacitacionesSelectItemListModel = sessionBeanParametros.findAllCapacitaciones(getSessionBeanADM().getCompania());
    institucionesSelectItemListModel = sessionBeanParametros.findAllInstituciones(getSessionBeanADM().getCompania());
    idiomasSelectItemListModel = sessionBeanParametros.findAllIdiomas(getSessionBeanADM().getCompania());
    equiposSelectItemListModel = sessionBeanParametros.findAllEquipos(getSessionBeanADM().getCompania());
    tiposPruebaSelectItemListModel = sessionBeanParametros.findAllTipoPrueba(getSessionBeanADM().getCompania());
    empleadosSelectItemListModel = sessionBeanParametros.findAllEmpleados(getSessionBeanADM().getCompania());
    // ===================================================================
    emergencias$pesoActual = 0.00d;
    emergencias$estatura = 0;
    referencias$rp$tiempoConocerle = 0;
    emergencias$haSufridoAccidentes = Boolean.FALSE;
    // ===================================================================
    preparacionesAcademicasCandidato = new ArrayList<PreparacionAcademicaCandidato>();
    parentescosCandidatos = new ArrayList<ParentescoCandidato>();
    experienciasLaboralesCandidato = new ArrayList<ExperienciaLaboralCandidato>();
    referenciasLaboralesCandidato = new ArrayList<ReferenciaLaboralCandidato>();
    referenciasPersonalesCandidato = new ArrayList<ReferenciaPersonalCandidato>();
    documentosCandidato = new ArrayList<DocumentoCandidato>();
    capacitacionesCandidato = new ArrayList<CapacitacionCandidato>();
    dependientesCandidato = new ArrayList<DependienteCandidato>();
    idiomasCandidato = new ArrayList<IdiomaCandidato>();
    beneficiariosCandidato = new ArrayList<String>();
    equiposCandidato = new ArrayList<EquipoCandidato>();
    pruebasCandidato = new ArrayList<PruebaCandidato>();
    entrevistasCandidato = new ArrayList<EntrevistaCandidato>();
}

// == Acciones ======================================================================================================
// ==================================================================================================================
@PermitAll
public String preparacionAcademica$agregar$action()
{
    try
        {
        String[] deptoPKStr = preparacion$departamento.split(":");
        String[] nivelAcademicoPKStr = preparacion$nivelAcademico.split(":");
        String[] profesionPKStr = preparacion$profesion.split(":");

        boolean hayError = false;

        if ((preparacion$nombreInstitucion == null) || preparacion$nombreInstitucion.trim().isEmpty())
            {
            addMessage("Preparacion academica", "Ingrese el nombre de la institucion", TipoMensaje.INFORMACION);
            hayError = true;
            }

        if (preparacion$anioIngreso == null)
            {
            addMessage("Preparacion academica", "Ingrese el año de ingreso", TipoMensaje.INFORMACION);
            hayError = true;
            }

        if (preparacion$anioEgreso == null)
            {
            addMessage("Preparacion academica", "Ingrese el año de egreso", TipoMensaje.INFORMACION);
            hayError = true;
            }

        if ((preparacion$anioIngreso != null) && (preparacion$anioEgreso != null) && (preparacion$anioIngreso > preparacion$anioEgreso))
            {
            addMessage("Preparacion academica", "El año de ingreso debe ser menor o igual que el año de egreso", TipoMensaje.INFORMACION);
            hayError = true;
            }

        if (hayError)
            return null;

        DeptosPK deptoPK = new DeptosPK(new Short(deptoPKStr[0]), new Short(deptoPKStr[1]));
        NivelAcademicoPK nivelAcademicoPK = new NivelAcademicoPK(new Short(nivelAcademicoPKStr[0]), new Short(nivelAcademicoPKStr[1]));
        ProfesionPK profesionPK = new ProfesionPK(new Short(profesionPKStr[0]), new Short(profesionPKStr[1]));

        PreparacionAcademicaCandidato p = new PreparacionAcademicaCandidato();
        p.setNombreInstitucion(preparacion$nombreInstitucion);
        p.setDepartamentoInstitucion(sessionBeanParametros.findDepartamentoById(deptoPK));
        p.setNivelAcademico(sessionBeanParametros.findNivelAcademicoById(nivelAcademicoPK));
        p.setProfesion(sessionBeanParametros.findProfesionById(profesionPK));
        p.setAnioIngreso(preparacion$anioIngreso);
        p.setAnioEgreso(preparacion$anioEgreso);

        preparacionesAcademicasCandidato.add(p);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

@PermitAll
public String emergencias$agregarParentesco$action()
{
    Boolean hayError = Boolean.FALSE;

    if ((emergencias$nombreContacto == null) || emergencias$nombreContacto.trim().isEmpty())
        {
        addMessage("Emergencias", "Ingrese el nombre del contacto", TipoMensaje.INFORMACION);
        hayError = Boolean.TRUE;
        }

    if ((emergencias$telefonoContacto == null) || emergencias$telefonoContacto.trim().isEmpty())
        {
        addMessage("Emergencias", "Ingrese el tel&eacute;fono del contacto", TipoMensaje.INFORMACION);
        hayError = Boolean.TRUE;
        }

    if (hayError)
        return null;

    String[] parentescoPKStr = emergencias$parentescoContacto.split(":");
    ParentescoPK parentescoPK = new ParentescoPK(new Short(parentescoPKStr[0]), new Short(parentescoPKStr[1]));

    ParentescoCandidato pc = new ParentescoCandidato();
    pc.setNombre(emergencias$nombreContacto);
    pc.setTelefono(emergencias$telefonoContacto);
    pc.setParentesco(sessionBeanParametros.findParentescoById(parentescoPK));
    parentescosCandidatos.add(pc);
    return null;
}

@PermitAll
public String experienciaLaboral$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((experiencia$lugarTrabajo == null) || experiencia$lugarTrabajo.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre del lugar de trabajo", TipoMensaje.ADVERTENCIA);
            hayError = Boolean.TRUE;
            }

        if (experiencia$fechaInicio == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la fecha de inicio", TipoMensaje.ADVERTENCIA);
            hayError = Boolean.TRUE;
            }

        if (experiencia$fechaFin == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la fecha de finalizaci&oacute;n", TipoMensaje.ADVERTENCIA);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        String[] puestoPKStr = experiencia$puesto.split(":");
        PuestosPK puestoPK = new PuestosPK(new Short(puestoPKStr[0]), new Short(puestoPKStr[1]));

        ExperienciaLaboralCandidato e = new ExperienciaLaboralCandidato();
        e.setLugar(experiencia$lugarTrabajo);
        e.setPuesto(sessionBeanParametros.findPuestosById(puestoPK));
        e.setFechaInicio(experiencia$fechaInicio);
        e.setFechaFin(experiencia$fechaFin);
        e.setMotivoRetiro(experiencia$motivoRetiro);
        experienciasLaboralesCandidato.add(e);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

@PermitAll
public String referenciaLaboral$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((referencias$rl$nombre == null) || referencias$rl$nombre.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rl$lugarTrabajo == null) || referencias$rl$lugarTrabajo.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre del lugar de trabajo", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rl$puesto == null) || referencias$rl$puesto.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el puesto de trabajo de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rl$telefono == null) || referencias$rl$telefono.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el tel&eacute;fono de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rl$correoElectronico == null) || referencias$rl$correoElectronico.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el correo electr&oacute;nico de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        ReferenciaLaboralCandidato r = new ReferenciaLaboralCandidato();
        r.setNombre(referencias$rl$nombre);
        r.setLugarTrabajo(referencias$rl$lugarTrabajo);
        r.setPuesto(referencias$rl$puesto);
        r.setTelefono(referencias$rl$telefono);
        r.setCorreoElectronico(referencias$rl$correoElectronico);

        referenciasLaboralesCandidato.add(r);

        referencias$rl$nombre = null;
        referencias$rl$lugarTrabajo = null;
        referencias$rl$puesto = null;
        referencias$rl$telefono = null;
        referencias$rl$correoElectronico = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String referenciaPersonal$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((referencias$rp$nombre == null) || referencias$rp$nombre.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rp$lugarTrabajo == null) || referencias$rp$lugarTrabajo.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre del lugar de trabajo", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (referencias$rp$tiempoConocerle == null)
            {
            addMessage("Infosweb RRHH", "Ingrese el tiempo (en años) de conocer con la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rp$telefono == null) || referencias$rp$telefono.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el tel&eacute;fono de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((referencias$rp$correoElectronico == null) || referencias$rp$correoElectronico.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el correo electr&oacute;nico de la referencia", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        ReferenciaPersonalCandidato r = new ReferenciaPersonalCandidato();
        r.setNombre(referencias$rp$nombre);
        r.setLugarTrabajo(referencias$rp$lugarTrabajo);
        r.setTiempoConocerle(referencias$rp$tiempoConocerle);
        r.setTelefono(referencias$rp$telefono);
        r.setCorreoElectronico(referencias$rp$correoElectronico);

        referenciasPersonalesCandidato.add(r);

        referencias$rp$nombre = null;
        referencias$rp$lugarTrabajo = null;
        referencias$rp$tiempoConocerle = 0;
        referencias$rp$telefono = null;
        referencias$rp$correoElectronico = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

@PermitAll
public String documento$agregar$action()
{
    try
        {
        String[] documentoPKStr = documentos$tipo.split(":");
        TipoDocumentoPK tipoDocumentoPK = new TipoDocumentoPK(new Short(documentoPKStr[0]), new Short(documentoPKStr[1]));

        DocumentoCandidato d = new DocumentoCandidato();
        d.setTipo(reclutamientoFacade.findTipoDocumentoById(tipoDocumentoPK));
        d.setNumero(documentos$numero);

        documentosCandidato.add(d);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

@PermitAll
public String capacitaciones$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.TRUE;

        if (capacitacion$fecha == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la fecha de la capacitaci&oacute;n", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        String[] capacitacionPKStr = capacitacion$capacitacion.split(":");
        String[] institucionPKStr = capacitacion$institucion.split(":");

        CapacitacionPK capacitacionPK = new CapacitacionPK(new Short(capacitacionPKStr[0]), new Integer(capacitacionPKStr[1]));
        InstitucionesPK institucionesPK = new InstitucionesPK(new Short(institucionPKStr[0]), new Short(institucionPKStr[1]));

        CapacitacionCandidato c = new CapacitacionCandidato();
        c.setCapacitacion(sessionBeanParametros.findCapacitacionById(capacitacionPK));
        c.setInstitucion(sessionBeanParametros.findInstitucionById(institucionesPK));
        c.setDescripcion(capacitacion$descripcion);
        c.setFecha(capacitacion$fecha);

        capacitacionesCandidato.add(c);

        capacitacion$capacitacion = null;
        capacitacion$descripcion = null;
        capacitacion$institucion = null;
        capacitacion$fecha = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

@PermitAll
public String dependientes$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((dependientes$nombre == null) || dependientes$nombre.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre del dependiente", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if ((dependientes$fechaNacimiento == null))
            {
            addMessage("Infosweb RRHH", "Ingrese fecha de nacimiento del dependiente", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        String[] parentescoPKStr = dependientes$parentesco.split(":");
        ParentescoPK parentescoPK = new ParentescoPK(new Short(parentescoPKStr[0]), new Short(parentescoPKStr[1]));
        DependienteCandidato d = new DependienteCandidato();
        d.setNombre(dependientes$nombre);
        d.setFechaNacimiento(dependientes$fechaNacimiento);
        d.setParentesco(sessionBeanParametros.findParentescoById(parentescoPK));
        dependientesCandidato.add(d);

        dependientes$parentesco = null;
        dependientes$nombre = null;
        dependientes$fechaNacimiento = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String idiomas$agregar$action()
{
    try
        {
        String[] idiomaPKStr = idiomas$idioma.split(":");
        IdiomaPK idiomaPK = new IdiomaPK(new Short(idiomaPKStr[0]), new Integer(idiomaPKStr[1]));
        IdiomaCandidato i = new IdiomaCandidato();
        i.setIdioma(sessionBeanParametros.findIdiomaById(idiomaPK));
        i.setLee(idiomas$lee);
        i.setEscribe(idiomas$escribe);
        i.setNivel(idiomas$nivel);
        idiomasCandidato.add(i);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String beneficiarios$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((beneficiarios$nombre == null) || beneficiarios$nombre.isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el nombre del beneficiario", TipoMensaje.ADVERTENCIA);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        beneficiariosCandidato.add(beneficiarios$nombre);
        beneficiarios$nombre = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String equipos$agregar$action()
{
    try
        {
        String[] equipoPKStr = equipos$equipo.split(":");
        EquipoPK equipoPK = new EquipoPK(new Short(equipoPKStr[0]), new Short(equipoPKStr[1]));

        EquipoCandidato e = new EquipoCandidato();
        e.setEquipo(sessionBeanParametros.findEquipoById(equipoPK));
        e.setEstado(equipos$estado);
        equiposCandidato.add(e);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String pruebas$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if ((pruebas$resultado == null) || pruebas$resultado.trim().isEmpty())
            {
            addMessage("Infosweb RRHH", "Ingrese el resultado de la prueba", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (pruebas$nota == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la nota de la prueba", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (pruebas$costo == null)
            {
            addMessage("Infosweb RRHH", "Ingrese el costo de la prueba", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (pruebas$fecha == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la fecha de la prueba", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        String[] tipoPruebaPKStr = pruebas$tipoPrueba.split(":");
        TipoPruebaPK tipoPruebaPK = new TipoPruebaPK(new Short(tipoPruebaPKStr[0]), new Short(tipoPruebaPKStr[1]));

        PruebaCandidato p = new PruebaCandidato();
        p.setTipoPrueba(sessionBeanParametros.findTipoPruebaById(tipoPruebaPK));
        p.setResultado(pruebas$resultado);
        p.setNota(pruebas$nota);
        p.setCosto(pruebas$costo);
        p.setFecha(pruebas$fecha);

        pruebasCandidato.add(p);

        pruebas$resultado = null;
        pruebas$nota = null;
        pruebas$costo = null;
        pruebas$fecha = null;
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

/* @PermitAll
 public String puestos$agregar$action()
 {
 try
 {


 PuestoCandidato p = new PuestoCandidato();
 //p.setPuesto();
 p.setSalarioAspirado(puestos$salarioAspirado);
 p.setEntrevistas(new ArrayList<EntrevistaCandidato>());

 puestosCandidato.add(p);
 }
 catch (Exception excpt)
 {
 addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
 }
 return null;
 } */
@PermitAll
public String entrevistas$agregar$action()
{
    try
        {
        Boolean hayError = Boolean.FALSE;

        if (puestos$salarioAspirado == null)
            {
            addMessage("Infosweb RRHH", "Ingrese el salario aspirado", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (puestos$entrevistas$fecha == null)
            {
            addMessage("Infosweb RRHH", "Ingrese la fecha de la entrevista", TipoMensaje.INFORMACION);
            hayError = Boolean.TRUE;
            }

        if (hayError)
            return null;

        String[] puestoPKStr = puestos$puesto.split(":");
        PuestosPK puestoPK = new PuestosPK(new Short(puestoPKStr[0]), new Short(puestoPKStr[1]));

        String[] empleadoPKStr = puestos$entrevistas$entrevistador.split(":");
        EmpleadosPK empleadoPK = new EmpleadosPK(new Short(empleadoPKStr[0]), new Integer(empleadoPKStr[1]));

        EntrevistaCandidato e = new EntrevistaCandidato();
        e.setPuesto(sessionBeanParametros.findPuestosById(puestoPK));
        e.setSalarioAspirado(puestos$salarioAspirado);
        e.setFecha(puestos$entrevistas$fecha);
        e.setEntrevistador(sessionBeanParametros.findEmpleadoById(empleadoPK));
        e.setDescripcion(puestos$entrevistas$descripcion);
        e.setResultado(puestos$entrevistas$resultado);

        entrevistasCandidato.add(e);
        }
    catch (Exception excpt)
        {
        addMessage("Infosweb RRHH", excpt.toString(), TipoMensaje.INFORMACION);
        }
    return null;
}

@PermitAll
public String guardar$action()
{
    try
        {
        Short c = getSessionBeanADM().getCompania().getCodCia();

        CandidatoPK pkCandidato = new CandidatoPK();
        Candidato candidato = new Candidato();

        pkCandidato.setCodCia(c);
        Integer i = reclutamientoFacade.getMaxCandidato(getSessionBeanADM().getCompania());
        pkCandidato.setCodCandidato(i);

        candidato.setCandidatoPK(pkCandidato);
        candidato.setFecSolicitud(fechaSolicitud);
        candidato.setNombre(nombre);
        candidato.setApellido(apellido);
        candidato.setApCasada(apellidoCasada);
        candidato.setSexo(new Short(sexo));

        //candidato.setCodPaisDomic();
        //candidato.setCodDepartamentoDomic(null);
        //candidato.setCodMunicipioDomic(c);
        candidato.setTelefono(generales$telefono);
        candidato.setDireccion(generales$direccion);

        candidato.setFechaNac(generales$fechaNacimiento);
        //candidato.setCodPaisNacimiento(c);
        //candidato.setCodDepartamentoNacim(preparacion$anioEgreso);
        //candidato.setCodMunicipioNacim(c);
        //candidato.setCodPaisNacionalidad(preparacion$anioEgreso);
        TipoSangre tipoSangre = sessionBeanParametros.findTipoSangreById(generales$grupoSanguineo);

        candidato.setTipoSangre(tipoSangre);

        candidato.setNumDui(generales$dui);
        candidato.setNumNit(generales$nit);
        candidato.setFechaExpDui(generales$fechaExpDui);
        //candidato.setExpedicionDui();
        //candidato.setMuniExpDui();
        candidato.setNumLicencia(generales$licenciaConducir);
        candidato.setNomIsss(generales$nombreISSS);
        candidato.setNumPasaporte(generales$pasaporte);
        candidato.setNomNit(generales$nombreNIT);

        candidato.setNombreConyuge(emergencias$conyuge);
        candidato.setTrabajoConyuge(emergencias$trabajo);
        candidato.setTelefono(emergencias$telefono);

        candidato.setObservacion(observaciones);
        candidato.setEstado("A");
        reclutamientoFacade.guardarCandidato(candidato);

        candidato = reclutamientoFacade.findCandidatoById(pkCandidato);

        for (PreparacionAcademicaCandidato preparacionCandidato : preparacionesAcademicasCandidato)
            {
            NivelesXCandidatoPK nivelCandidatoPK = new NivelesXCandidatoPK();
            nivelCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            nivelCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            nivelCandidatoPK.setCodNivel(reclutamientoFacade.maxNivelXCandidato(candidato));

            NivelesXCandidato nivelCandidato = new NivelesXCandidato();
            nivelCandidato.setNivelesXCandidatoPK(nivelCandidatoPK);
            nivelCandidato.setCandidato(candidato);
            nivelCandidato.setNomInstitucion(preparacionCandidato.getNombreInstitucion());
            nivelCandidato.setCodPais(preparacionCandidato.getDepartamentoInstitucion().getDeptosPK().getCodPais());
            nivelCandidato.setCodDepto(preparacionCandidato.getDepartamentoInstitucion().getDeptosPK().getCodDepto());
            nivelCandidato.setAnioIngreso(preparacionCandidato.getAnioIngreso());
            nivelCandidato.setAnioEgreso(preparacionCandidato.getAnioEgreso());
            nivelCandidato.setEstadoNivel("A");
            reclutamientoFacade.crearNivelXCandidato(nivelCandidato);
            }

        for (ParentescoCandidato parentescoCandidato : parentescosCandidatos)
            {
            EmergenciaXCandidatoPK emergenciaCandidatoPK = new EmergenciaXCandidatoPK();
            emergenciaCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            emergenciaCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            emergenciaCandidatoPK.setCodEmergencia(reclutamientoFacade.getMaxEmergenciaCandidato(candidato));

            EmergenciaXCandidato emergenciaCandidato = new EmergenciaXCandidato();
            emergenciaCandidato.setEmergenciaXCandidatoPK(emergenciaCandidatoPK);
            emergenciaCandidato.setCandidato(candidato);
            emergenciaCandidato.setNombre(parentescoCandidato.getNombre());
            emergenciaCandidato.setTelefono(parentescoCandidato.getTelefono());
            emergenciaCandidato.setCodParentesco(parentescoCandidato.getParentesco().getParentescoPK().getCodParentesco());
            reclutamientoFacade.crearEmergenciaCandidato(emergenciaCandidato);
            }

        for (ExperienciaLaboralCandidato experienciaCandidato : experienciasLaboralesCandidato)
            {
            experienciaCandidato.toString();
            }

        for (ReferenciaLaboralCandidato referenciaLaboral : referenciasLaboralesCandidato)
            {
            ReferenciaPK referenciaPK = new ReferenciaPK();
            referenciaPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            referenciaPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            referenciaPK.setCodReferencia(reclutamientoFacade.maxReferencia(candidato));

            Referencia referencia = new Referencia();
            referencia.setReferenciaPK(referenciaPK);
            referencia.setCandidato(candidato);
            referencia.setTipoReferencia('L');
            referencia.setNomReferencia(referenciaLaboral.getNombre());
            referencia.setLugar(referenciaLaboral.getLugarTrabajo());
            referencia.setEmail(referenciaLaboral.getCorreoElectronico());
            referencia.setTelefono(referenciaLaboral.getTelefono());

            reclutamientoFacade.crearRererencia(referencia);
            }

        for (ReferenciaPersonalCandidato referenciaPersonal : referenciasPersonalesCandidato)
            {
            ReferenciaPK referenciaPK = new ReferenciaPK();
            referenciaPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            referenciaPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            referenciaPK.setCodReferencia(reclutamientoFacade.maxReferencia(candidato));

            Referencia referencia = new Referencia();
            referencia.setReferenciaPK(referenciaPK);
            referencia.setCandidato(candidato);
            referencia.setTipoReferencia('P');
            referencia.setNomReferencia(referenciaPersonal.getNombre());
            referencia.setLugar(referenciaPersonal.getLugarTrabajo());
            referencia.setTiempo(referenciaPersonal.getTiempoConocerle().toString());
            referencia.setEmail(referenciaPersonal.getCorreoElectronico());
            referencia.setTelefono(referenciaPersonal.getTelefono());

            reclutamientoFacade.crearRererencia(referencia);
            }

        for (DocumentoCandidato documentoCandidato : documentosCandidato)
            {
            DocumentoPresentadoPK dPK = new DocumentoPresentadoPK();
            dPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            dPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            dPK.setCodDocumentoPres(reclutamientoFacade.getMaxDocumentoPresentado(candidato));

            DocumentoPresentado d = new DocumentoPresentado();
            d.setDocumentoPresentadoPK(dPK);
            d.setCandidato(candidato);
            d.setTipoDocumento(documentoCandidato.getTipo());
            d.setObservacion((documentoCandidato.getNumero() != null) ? documentoCandidato.getNumero().toString() : "");

            reclutamientoFacade.crearDocumentoPresentado(d);
            }

        for (CapacitacionCandidato capacitacionCandidato : capacitacionesCandidato)
            {
            CapacitacionXCandidatoPK capacitacionXCandidatoPK = new CapacitacionXCandidatoPK();
            capacitacionXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            capacitacionXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            capacitacionXCandidatoPK.setCodCapacitacion(reclutamientoFacade.getMaxCapacitacionXCandidato(candidato));

            CapacitacionXCandidato capacitacionXCandidato = new CapacitacionXCandidato();
            capacitacionXCandidato.setCapacitacionXCandidatoPK(capacitacionXCandidatoPK);
            capacitacionXCandidato.setCandidato(candidato);
            capacitacionXCandidato.setCapacitacion(capacitacionCandidato.getCapacitacion());
            capacitacionXCandidato.setCodInsti(capacitacionCandidato.getInstitucion().getInstitucionesPK().getCodInsti());
            capacitacionXCandidato.setFecha(capacitacionCandidato.getFecha().toString());
            capacitacionXCandidato.setNomInstitucion(capacitacionCandidato.getInstitucion().getDesInsti());
            capacitacionXCandidato.setDescripcion(capacitacionCandidato.getDescripcion());

            reclutamientoFacade.crearCapacitacionXCandidato(capacitacionXCandidato);
            }

        for (DependienteCandidato dependienteCandidato : dependientesCandidato)
            {
            DependienteXCandidatoPK dependienteXCandidatoPK = new DependienteXCandidatoPK();
            dependienteXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            dependienteXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            dependienteXCandidatoPK.setCodDependiente(reclutamientoFacade.getMaxBeneficiarioXCandidato(candidato));

            DependienteXCandidato dependienteXCandidato = new DependienteXCandidato();
            dependienteXCandidato.setDependienteXCandidatoPK(dependienteXCandidatoPK);
            dependienteXCandidato.setCandidato(candidato);
            dependienteXCandidato.setCodParentesco(dependienteCandidato.getParentesco().getParentescoPK().getCodParentesco());
            dependienteXCandidato.setFechaNacimiento(dependienteCandidato.getFechaNacimiento());
            dependienteXCandidato.setNombre(dependienteCandidato.getNombre());

            reclutamientoFacade.crearDependienteXCandidato(dependienteXCandidato);
            }

        for (IdiomaCandidato idiomaCandidato : idiomasCandidato)
            {
            IdiomaXCandidatoPK idiomaXCandidatoPK = new IdiomaXCandidatoPK();
            idiomaXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            idiomaXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            idiomaXCandidatoPK.setCodIdioma(reclutamientoFacade.getMaxIdiomaXCandidato(candidato));

            IdiomaXCandidato idiomaXCandidato = new IdiomaXCandidato(idiomaXCandidatoPK);
            idiomaXCandidato.setCandidato(candidato);
            idiomaXCandidato.setLee(idiomaCandidato.getLee() ? "S" : "N");
            idiomaXCandidato.setEscribe(idiomaCandidato.getEscribe() ? "S" : "N");
            idiomaXCandidato.setNivel(idiomaCandidato.getNivel().toString());

            reclutamientoFacade.crearIdiomaXCandidato(idiomaXCandidato);
            }

        for (String beneficiarioCandidato : beneficiariosCandidato)
            {
            BeneficiarioXCandidatoPK beneficiarioXCandidatoPK = new BeneficiarioXCandidatoPK();
            beneficiarioXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            beneficiarioXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            beneficiarioXCandidatoPK.setCodBeneficiario(reclutamientoFacade.getMaxBeneficiarioXCandidato(candidato));

            BeneficiarioXCandidato beneficiarioXCandidato = new BeneficiarioXCandidato(beneficiarioXCandidatoPK);
            beneficiarioXCandidato.setCandidato(candidato);
            beneficiarioXCandidato.setNombre(beneficiarioCandidato);

            reclutamientoFacade.crearBeneficiarioXCandidato(beneficiarioXCandidato);
            }

        for (EquipoCandidato equipoCandidato : equiposCandidato)
            {
            candidato.getEquipoList().add(equipoCandidato.getEquipo());
            }
        reclutamientoFacade.editarCandidato(candidato);

        for (PruebaCandidato pruebaCandidato : pruebasCandidato)
            {
            TipoPruebaXCandidatoPK tipoPruebaXCandidatoPK = new TipoPruebaXCandidatoPK();
            tipoPruebaXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            tipoPruebaXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            tipoPruebaXCandidatoPK.setCodTipoPrueba(reclutamientoFacade.getMaxTipoPruebaXCandidato(candidato));

            TipoPruebaXCandidato tipoPruebaXCandidato = new TipoPruebaXCandidato(tipoPruebaXCandidatoPK);
            tipoPruebaXCandidato.setCandidato(candidato);
            tipoPruebaXCandidato.setTipoPrueba(pruebaCandidato.getTipoPrueba());
            tipoPruebaXCandidato.setFecha(pruebaCandidato.getFecha());
            tipoPruebaXCandidato.setCosto(new BigDecimal(pruebaCandidato.getCosto()));
            tipoPruebaXCandidato.setNota(new BigDecimal(pruebaCandidato.getNota()));
            tipoPruebaXCandidato.setResultado(tipoPruebaXCandidato.getResultado());

            reclutamientoFacade.crearTipoPruebaXCandidatoFacade(tipoPruebaXCandidato);
            }

        for (EntrevistaCandidato entrevistaCandidato : entrevistasCandidato)
            {
            EntrevistaXCandidatoPK entrevistaXCandidatoPK = new EntrevistaXCandidatoPK();
            entrevistaXCandidatoPK.setCodCia(candidato.getCandidatoPK().getCodCia());
            entrevistaXCandidatoPK.setCodCandidato(candidato.getCandidatoPK().getCodCandidato());
            entrevistaXCandidatoPK.setCodPuesto(entrevistaCandidato.getPuesto().getPuestosPK().getCodPuesto());
            entrevistaXCandidatoPK.setCodEntrevista(reclutamientoFacade.getMaxEntrevistaXCandidato(entrevistaCandidato.getPuesto(), candidato));

            EntrevistaXCandidato entrevistaXCandidato = new EntrevistaXCandidato(entrevistaXCandidatoPK);
            entrevistaXCandidato.setEntrevistaXCandidatoPK(entrevistaXCandidatoPK);
            entrevistaXCandidato.setCandidato(candidato);
            entrevistaXCandidato.setPuesto(entrevistaCandidato.getPuesto());
            entrevistaXCandidato.setEmpleado(entrevistaCandidato.getEntrevistador());
            entrevistaXCandidato.setDescripcion(entrevistaCandidato.getDescripcion());
            entrevistaXCandidato.setResultado(entrevistaCandidato.getResultado());

            reclutamientoFacade.crearEntrevistaXCandidato(entrevistaXCandidato);
            }

        addMessage("Registro de Candidatos", "Datos guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        }
    catch (Exception e)
        {
        e.printStackTrace(System.err);
        addMessage("Registro de Candidatos", e.toString(), TipoMensaje.ERROR_FATAL);
        }
    return null;
}

public void nuevo$vh$action()
{
    setEstadoAccion(0);
}

public void consultar$vh$action()
{
    setEstadoAccion(2);
}

public String editar$crud$action()
{
    getSessionBeanADM().setEstadoAccion(1);
    return null;
}

public void setEstadoAccion(Integer estadoAccion)
{
    getSessionBeanADM().setEstadoAccion(estadoAccion);
    limpiarCampos();
}

public String guardar$crud$action()
{
    isError = Boolean.FALSE;
    return null;
}

@Override
protected void limpiarCampos()
{
    nombre = null;
    apellido = null;
    apellidoCasada = null;
    generales$fechaNacimiento = null;
    sexo = null;
    //observaciones = null;
}

// ==================================================================================================================
// ==================================================================================================================
// ==================================================================================================================
public String getApellido()
{
    return apellido;
}

public void setApellido(String apellido)
{
    this.apellido = apellido;
}

public String getApellidoCasada()
{
    return apellidoCasada;
}

public void setApellidoCasada(String apellidoCasada)
{
    this.apellidoCasada = apellidoCasada;
}

public String getCapacitacion$capacitacion()
{
    return capacitacion$capacitacion;
}

public void setCapacitacion$capacitacion(String capacitacion$capacitacion)
{
    this.capacitacion$capacitacion = capacitacion$capacitacion;
}

public String getCapacitacion$descripcion()
{
    return capacitacion$descripcion;
}

public void setCapacitacion$descripcion(String capacitacion$descripcion)
{
    this.capacitacion$descripcion = capacitacion$descripcion;
}

public Date getCapacitacion$fecha()
{
    return capacitacion$fecha;
}

public void setCapacitacion$fecha(Date capacitacion$fecha)
{
    this.capacitacion$fecha = capacitacion$fecha;
}

public String getCapacitacion$institucion()
{
    return capacitacion$institucion;
}

public void setCapacitacion$institucion(String capacitacion$institucion)
{
    this.capacitacion$institucion = capacitacion$institucion;
}

public Integer getDocumentos$numero()
{
    return documentos$numero;
}

public void setDocumentos$numero(Integer documentos$numero)
{
    this.documentos$numero = documentos$numero;
}

public String getDocumentos$tipo()
{
    return documentos$tipo;
}

public void setDocumentos$tipo(String documentos$tipo)
{
    this.documentos$tipo = documentos$tipo;
}

public Boolean getEmergencias$actividadLimitada()
{
    return emergencias$actividadLimitada;
}

public void setEmergencias$actividadLimitada(Boolean emergencias$actividadLimitada)
{
    this.emergencias$actividadLimitada = emergencias$actividadLimitada;
}

public Integer getEmergencias$condicionSalud()
{
    return emergencias$condicionSalud;
}

public void setEmergencias$condicionSalud(Integer emergencias$condicionSalud)
{
    this.emergencias$condicionSalud = emergencias$condicionSalud;
}

public String getEmergencias$conyuge()
{
    return emergencias$conyuge;
}

public void setEmergencias$conyuge(String emergencias$conyuge)
{
    this.emergencias$conyuge = emergencias$conyuge;
}

public Integer getEmergencias$estatura()
{
    return emergencias$estatura;
}

public void setEmergencias$estatura(Integer emergencias$estatura)
{
    this.emergencias$estatura = emergencias$estatura;
}

public Boolean getEmergencias$haSufridoAccidentes()
{
    return emergencias$haSufridoAccidentes;
}

public void setEmergencias$haSufridoAccidentes(Boolean emergencias$haSufridoAccidentes)
{
    this.emergencias$haSufridoAccidentes = emergencias$haSufridoAccidentes;
}

public String getEmergencias$nombreContacto()
{
    return emergencias$nombreContacto;
}

public void setEmergencias$nombreContacto(String emergencias$nombreContacto)
{
    this.emergencias$nombreContacto = emergencias$nombreContacto;
}

public String getEmergencias$parentescoContacto()
{
    return emergencias$parentescoContacto;
}

public void setEmergencias$parentescoContacto(String emergencias$parentescoContacto)
{
    this.emergencias$parentescoContacto = emergencias$parentescoContacto;
}

public Double getEmergencias$pesoActual()
{
    return emergencias$pesoActual;
}

public void setEmergencias$pesoActual(Double emergencias$pesoActual)
{
    this.emergencias$pesoActual = emergencias$pesoActual;
}

public String getEmergencias$telefono()
{
    return emergencias$telefono;
}

public void setEmergencias$telefono(String emergencias$telefono)
{
    this.emergencias$telefono = emergencias$telefono;
}

public String getEmergencias$telefonoContacto()
{
    return emergencias$telefonoContacto;
}

public void setEmergencias$telefonoContacto(String emergencias$telefonoContacto)
{
    this.emergencias$telefonoContacto = emergencias$telefonoContacto;
}

public Integer getEmergencias$tipoAccidente()
{
    return emergencias$tipoAccidente;
}

public void setEmergencias$tipoAccidente(Integer emergencias$tipoAccidente)
{
    this.emergencias$tipoAccidente = emergencias$tipoAccidente;
}

public String getEmergencias$trabajo()
{
    return emergencias$trabajo;
}

public void setEmergencias$trabajo(String emergencias$trabajo)
{
    this.emergencias$trabajo = emergencias$trabajo;
}

public Date getExperiencia$fechaFin()
{
    return experiencia$fechaFin;
}

public void setExperiencia$fechaFin(Date experiencia$fechaFin)
{
    this.experiencia$fechaFin = experiencia$fechaFin;
}

public Date getExperiencia$fechaInicio()
{
    return experiencia$fechaInicio;
}

public void setExperiencia$fechaInicio(Date experiencia$fechaInicio)
{
    this.experiencia$fechaInicio = experiencia$fechaInicio;
}

public String getExperiencia$lugarTrabajo()
{
    return experiencia$lugarTrabajo;
}

public void setExperiencia$lugarTrabajo(String experiencia$lugarTrabajo)
{
    this.experiencia$lugarTrabajo = experiencia$lugarTrabajo;
}

public String getExperiencia$motivoRetiro()
{
    return experiencia$motivoRetiro;
}

public void setExperiencia$motivoRetiro(String experiencia$motivoRetiro)
{
    this.experiencia$motivoRetiro = experiencia$motivoRetiro;
}

public String getExperiencia$puesto()
{
    return experiencia$puesto;
}

public void setExperiencia$puesto(String experiencia$puesto)
{
    this.experiencia$puesto = experiencia$puesto;
}

public Date getFechaSolicitud()
{
    return fechaSolicitud;
}

public void setFechaSolicitud(Date fechaSolicitud)
{
    this.fechaSolicitud = fechaSolicitud;
}

public String getGenerales$departamento()
{
    return generales$departamento;
}

public void setGenerales$departamento(String generales$departamento)
{
    this.generales$departamento = generales$departamento;
}

public String getGenerales$departamentoExpDui()
{
    return generales$departamentoExpDui;
}

public void setGenerales$departamentoExpDui(String generales$departamentoExpDui)
{
    this.generales$departamentoExpDui = generales$departamentoExpDui;
}

public String getGenerales$departamentoNacimiento()
{
    return generales$departamentoNacimiento;
}

public void setGenerales$departamentoNacimiento(String generales$departamentoNacimiento)
{
    this.generales$departamentoNacimiento = generales$departamentoNacimiento;
}

public String getGenerales$direccion()
{
    return generales$direccion;
}

public void setGenerales$direccion(String generales$direccion)
{
    this.generales$direccion = generales$direccion;
}

public String getGenerales$dui()
{
    return generales$dui;
}

public void setGenerales$dui(String generales$dui)
{
    this.generales$dui = generales$dui;
}

public Date getGenerales$fechaExpDui()
{
    return generales$fechaExpDui;
}

public void setGenerales$fechaExpDui(Date generales$fechaExpDui)
{
    this.generales$fechaExpDui = generales$fechaExpDui;
}

public Date getGenerales$fechaNacimiento()
{
    return generales$fechaNacimiento;
}

public void setGenerales$fechaNacimiento(Date generales$fechaNacimiento)
{
    this.generales$fechaNacimiento = generales$fechaNacimiento;
}

public String getGenerales$grupoSanguineo()
{
    return generales$grupoSanguineo;
}

public void setGenerales$grupoSanguineo(String generales$grupoSanguineo)
{
    this.generales$grupoSanguineo = generales$grupoSanguineo;
}

public String getGenerales$licenciaConducir()
{
    return generales$licenciaConducir;
}

public void setGenerales$licenciaConducir(String generales$licenciaConducir)
{
    this.generales$licenciaConducir = generales$licenciaConducir;
}

public String getGenerales$municipio()
{
    return generales$municipio;
}

public void setGenerales$municipio(String generales$municipio)
{
    this.generales$municipio = generales$municipio;
}

public String getGenerales$municipioExpDui()
{
    return generales$municipioExpDui;
}

public void setGenerales$municipioExpDui(String generales$municipioExpDui)
{
    this.generales$municipioExpDui = generales$municipioExpDui;
}

public String getGenerales$municipioNacimiento()
{
    return generales$municipioNacimiento;
}

public void setGenerales$municipioNacimiento(String generales$municipioNacimiento)
{
    this.generales$municipioNacimiento = generales$municipioNacimiento;
}

public String getGenerales$nit()
{
    return generales$nit;
}

public void setGenerales$nit(String generales$nit)
{
    this.generales$nit = generales$nit;
}

public String getGenerales$nombreISSS()
{
    return generales$nombreISSS;
}

public void setGenerales$nombreISSS(String generales$nombreISSS)
{
    this.generales$nombreISSS = generales$nombreISSS;
}

public String getGenerales$nombreNIT()
{
    return generales$nombreNIT;
}

public void setGenerales$nombreNIT(String generales$nombreNIT)
{
    this.generales$nombreNIT = generales$nombreNIT;
}

public String getGenerales$pais()
{
    return generales$pais;
}

public void setGenerales$pais(String generales$pais)
{
    this.generales$pais = generales$pais;
}

public String getGenerales$paisNacimiento()
{
    return generales$paisNacimiento;
}

public void setGenerales$paisNacimiento(String generales$paisNacimiento)
{
    this.generales$paisNacimiento = generales$paisNacimiento;
}

public String getGenerales$paisNacionalidad()
{
    return generales$paisNacionalidad;
}

public void setGenerales$paisNacionalidad(String generales$paisNacionalidad)
{
    this.generales$paisNacionalidad = generales$paisNacionalidad;
}

public String getGenerales$pasaporte()
{
    return generales$pasaporte;
}

public void setGenerales$pasaporte(String generales$pasaporte)
{
    this.generales$pasaporte = generales$pasaporte;
}

public String getGenerales$telefono()
{
    return generales$telefono;
}

public void setGenerales$telefono(String generales$telefono)
{
    this.generales$telefono = generales$telefono;
}

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public Short getPreparacion$anioEgreso()
{
    return preparacion$anioEgreso;
}

public void setPreparacion$anioEgreso(Short preparacion$anioEgreso)
{
    this.preparacion$anioEgreso = preparacion$anioEgreso;
}

public Short getPreparacion$anioIngreso()
{
    return preparacion$anioIngreso;
}

public void setPreparacion$anioIngreso(Short preparacion$anioIngreso)
{
    this.preparacion$anioIngreso = preparacion$anioIngreso;
}

public String getPreparacion$pais()
{
    return preparacion$pais;
}

public void setPreparacion$pais(String preparacion$pais)
{
    this.preparacion$pais = preparacion$pais;
}

public String getPreparacion$departamento()
{
    return preparacion$departamento;
}

public void setPreparacion$departamento(String preparacion$departamento)
{
    this.preparacion$departamento = preparacion$departamento;
}

public String getPreparacion$nivelAcademico()
{
    return preparacion$nivelAcademico;
}

public void setPreparacion$nivelAcademico(String preparacion$nivelAcademico)
{
    this.preparacion$nivelAcademico = preparacion$nivelAcademico;
}

public String getPreparacion$nombreInstitucion()
{
    return preparacion$nombreInstitucion;
}

public void setPreparacion$nombreInstitucion(String preparacion$nombreInstitucion)
{
    this.preparacion$nombreInstitucion = preparacion$nombreInstitucion;
}

public String getPreparacion$profesion()
{
    return preparacion$profesion;
}

public void setPreparacion$profesion(String preparacion$profesion)
{
    this.preparacion$profesion = preparacion$profesion;
}

public String getReferencias$rl$correoElectronico()
{
    return referencias$rl$correoElectronico;
}

public void setReferencias$rl$correoElectronico(String referencias$rl$correoElectronico)
{
    this.referencias$rl$correoElectronico = referencias$rl$correoElectronico;
}

public String getReferencias$rl$lugarTrabajo()
{
    return referencias$rl$lugarTrabajo;
}

public void setReferencias$rl$lugarTrabajo(String referencias$rl$lugarTrabajo)
{
    this.referencias$rl$lugarTrabajo = referencias$rl$lugarTrabajo;
}

public String getReferencias$rl$nombre()
{
    return referencias$rl$nombre;
}

public void setReferencias$rl$nombre(String referencias$rl$nombre)
{
    this.referencias$rl$nombre = referencias$rl$nombre;
}

public String getReferencias$rl$puesto()
{
    return referencias$rl$puesto;
}

public void setReferencias$rl$puesto(String referencias$rl$puesto)
{
    this.referencias$rl$puesto = referencias$rl$puesto;
}

public String getReferencias$rl$telefono()
{
    return referencias$rl$telefono;
}

public void setReferencias$rl$telefono(String referencias$rl$telefono)
{
    this.referencias$rl$telefono = referencias$rl$telefono;
}

public String getReferencias$rp$correoElectronico()
{
    return referencias$rp$correoElectronico;
}

public void setReferencias$rp$correoElectronico(String referencias$rp$correoElectronico)
{
    this.referencias$rp$correoElectronico = referencias$rp$correoElectronico;
}

public String getReferencias$rp$lugarTrabajo()
{
    return referencias$rp$lugarTrabajo;
}

public void setReferencias$rp$lugarTrabajo(String referencias$rp$lugarTrabajo)
{
    this.referencias$rp$lugarTrabajo = referencias$rp$lugarTrabajo;
}

public String getReferencias$rp$nombre()
{
    return referencias$rp$nombre;
}

public void setReferencias$rp$nombre(String referencias$rp$nombre)
{
    this.referencias$rp$nombre = referencias$rp$nombre;
}

public String getReferencias$rp$telefono()
{
    return referencias$rp$telefono;
}

public void setReferencias$rp$telefono(String referencias$rp$telefono)
{
    this.referencias$rp$telefono = referencias$rp$telefono;
}

public Integer getReferencias$rp$tiempoConocerle()
{
    return referencias$rp$tiempoConocerle;
}

public void setReferencias$rp$tiempoConocerle(Integer referencias$rp$tiempoConocerle)
{
    this.referencias$rp$tiempoConocerle = referencias$rp$tiempoConocerle;
}

public Date getDependientes$fechaNacimiento()
{
    return dependientes$fechaNacimiento;
}

public void setDependientes$fechaNacimiento(Date dependientes$fechaNacimiento)
{
    this.dependientes$fechaNacimiento = dependientes$fechaNacimiento;
}

public String getDependientes$nombre()
{
    return dependientes$nombre;
}

public void setDependientes$nombre(String dependientes$nombre)
{
    this.dependientes$nombre = dependientes$nombre;
}

public String getDependientes$parentesco()
{
    return dependientes$parentesco;
}

public void setDependientes$parentesco(String dependientes$parentesco)
{
    this.dependientes$parentesco = dependientes$parentesco;
}

public Boolean getIdiomas$escribe()
{
    return idiomas$escribe;
}

public void setIdiomas$escribe(Boolean idiomas$escribe)
{
    this.idiomas$escribe = idiomas$escribe;
}

public String getIdiomas$idioma()
{
    return idiomas$idioma;
}

public void setIdiomas$idioma(String idiomas$idioma)
{
    this.idiomas$idioma = idiomas$idioma;
}

public Boolean getIdiomas$lee()
{
    return idiomas$lee;
}

public void setIdiomas$lee(Boolean idiomas$lee)
{
    this.idiomas$lee = idiomas$lee;
}

public Integer getIdiomas$nivel()
{
    return idiomas$nivel;
}

public void setIdiomas$nivel(Integer idiomas$nivel)
{
    this.idiomas$nivel = idiomas$nivel;
}

public String getBeneficiarios$nombre()
{
    return beneficiarios$nombre;
}

public void setBeneficiarios$nombre(String beneficiarios$nombre)
{
    this.beneficiarios$nombre = beneficiarios$nombre;
}

public String getEquipos$equipo()
{
    return equipos$equipo;
}

public void setEquipos$equipo(String equipos$equipo)
{
    this.equipos$equipo = equipos$equipo;
}

public Integer getEquipos$estado()
{
    return equipos$estado;
}

public void setEquipos$estado(Integer equipos$estado)
{
    this.equipos$estado = equipos$estado;
}

public Double getPruebas$costo()
{
    return pruebas$costo;
}

public void setPruebas$costo(Double pruebas$costo)
{
    this.pruebas$costo = pruebas$costo;
}

public Date getPruebas$fecha()
{
    return pruebas$fecha;
}

public void setPruebas$fecha(Date pruebas$fecha)
{
    this.pruebas$fecha = pruebas$fecha;
}

public Double getPruebas$nota()
{
    return pruebas$nota;
}

public void setPruebas$nota(Double pruebas$nota)
{
    this.pruebas$nota = pruebas$nota;
}

public String getPruebas$tipoPrueba()
{
    return pruebas$tipoPrueba;
}

public void setPruebas$tipoPrueba(String pruebas$tipoPrueba)
{
    this.pruebas$tipoPrueba = pruebas$tipoPrueba;
}

public String getPruebas$resultado()
{
    return pruebas$resultado;
}

public void setPruebas$resultado(String pruebas$resultado)
{
    this.pruebas$resultado = pruebas$resultado;
}

public String getPuestos$entrevistas$descripcion()
{
    return puestos$entrevistas$descripcion;
}

public void setPuestos$entrevistas$descripcion(String puestos$entrevistas$descripcion)
{
    this.puestos$entrevistas$descripcion = puestos$entrevistas$descripcion;
}

public String getPuestos$entrevistas$entrevistador()
{
    return puestos$entrevistas$entrevistador;
}

public void setPuestos$entrevistas$entrevistador(String puestos$entrevistas$entrevistador)
{
    this.puestos$entrevistas$entrevistador = puestos$entrevistas$entrevistador;
}

public Date getPuestos$entrevistas$fecha()
{
    return puestos$entrevistas$fecha;
}

public void setPuestos$entrevistas$fecha(Date puestos$entrevistas$fecha)
{
    this.puestos$entrevistas$fecha = puestos$entrevistas$fecha;
}

public String getPuestos$entrevistas$resultado()
{
    return puestos$entrevistas$resultado;
}

public void setPuestos$entrevistas$resultado(String puestos$entrevistas$resultado)
{
    this.puestos$entrevistas$resultado = puestos$entrevistas$resultado;
}

public String getPuestos$puesto()
{
    return puestos$puesto;
}

public void setPuestos$puesto(String puestos$puesto)
{
    this.puestos$puesto = puestos$puesto;
}

public Double getPuestos$salarioAspirado()
{
    return puestos$salarioAspirado;
}

public void setPuestos$salarioAspirado(Double puestos$salarioAspirado)
{
    this.puestos$salarioAspirado = puestos$salarioAspirado;
}

public String getSexo()
{
    return sexo;
}

public void setSexo(String sexo)
{
    this.sexo = sexo;
}

public String getObservaciones()
{
    return observaciones;
}

public void setObservaciones(String observaciones)
{
    this.observaciones = observaciones;
}

// ==================================================================================================================
// ==================================================================================================================
// ==================================================================================================================
public List<Candidato> getListaCandidatos()
{
    return listaCandidatos;
}

public void setListaCandidatos(List<Candidato> listaCandidatos)
{
    this.listaCandidatos = listaCandidatos;
}

//public List<Deptos> getListaDepartamentos()
//{
//    return listaDepartamentos;
//}
//
//public void setListaDepartamentos(List<Deptos> listaDepartamentos)
//{
//    this.listaDepartamentos = listaDepartamentos;
//}
//
//public List<Municipios> getListaMunicipios()
//{
//    return listaMunicipios;
//}
//
//public void setListaMunicipios(List<Municipios> listaMunicipios)
//{
//    this.listaMunicipios = listaMunicipios;
//}
public List<NivelAcademico> getListaNivelAcademico()
{
    return listaNivelAcademico;
}

public void setListaNivelAcademico(List<NivelAcademico> listaNivelAcademico)
{
    this.listaNivelAcademico = listaNivelAcademico;
}

//public List<Paises> getListaPaises()
//{
//    return listaPaises;
//}
//
//public void setListaPaises(List<Paises> listaPaises)
//{
//    this.listaPaises = listaPaises;
//}
public List<Profesion> getListaProfesiones()
{
    return listaProfesiones;
}

public void setListaProfesiones(List<Profesion> listaProfesiones)
{
    this.listaProfesiones = listaProfesiones;
}

public List<TipoDocumento> getListaTipoDocumentos()
{
    return listaTipoDocumentos;
}

public void setListaTipoDocumentos(List<TipoDocumento> listaTipoDocumentos)
{
    this.listaTipoDocumentos = listaTipoDocumentos;
}

public List<TipoSangre> getListaTipoSangre()
{
    return listaTipoSangre;
}

public void setListaTipoSangre(List<TipoSangre> listaTipoSangre)
{
    this.listaTipoSangre = listaTipoSangre;
}
// =============================================================================================================
// =============================================================================================================
// =============================================================================================================
private List<PreparacionAcademicaCandidato> preparacionesAcademicasCandidato;
private List<ParentescoCandidato> parentescosCandidatos;
private List<ExperienciaLaboralCandidato> experienciasLaboralesCandidato;
private List<ReferenciaLaboralCandidato> referenciasLaboralesCandidato;
private List<ReferenciaPersonalCandidato> referenciasPersonalesCandidato;
private List<DocumentoCandidato> documentosCandidato;
private List<CapacitacionCandidato> capacitacionesCandidato;
private List<DependienteCandidato> dependientesCandidato;
private List<IdiomaCandidato> idiomasCandidato;
private List<String> beneficiariosCandidato;
private List<EquipoCandidato> equiposCandidato;
private List<PruebaCandidato> pruebasCandidato;
private List<EntrevistaCandidato> entrevistasCandidato;
//=======================================
public List<PreparacionAcademicaCandidato> getPreparacionesAcademicasCandidato()
{
    return preparacionesAcademicasCandidato;
}

public void setPreparacionesAcademicasCandidato(List<PreparacionAcademicaCandidato> preparacionesAcademicasCandidato)
{
    this.preparacionesAcademicasCandidato = preparacionesAcademicasCandidato;
}

public List<ParentescoCandidato> getParentescosCandidatos()
{
    return parentescosCandidatos;
}

public void setParentescosCandidatos(List<ParentescoCandidato> parentescosCandidatos)
{
    this.parentescosCandidatos = parentescosCandidatos;
}

public List<ExperienciaLaboralCandidato> getExperienciasLaboralesCandidato()
{
    return experienciasLaboralesCandidato;
}

public void setExperienciasLaboralesCandidato(List<ExperienciaLaboralCandidato> experienciasLaboralesCandidato)
{
    this.experienciasLaboralesCandidato = experienciasLaboralesCandidato;
}

public List<ReferenciaLaboralCandidato> getReferenciasLaboralesCandidato()
{
    return referenciasLaboralesCandidato;
}

public void setReferenciasLaboralesCandidato(List<ReferenciaLaboralCandidato> referenciasLaboralesCandidato)
{
    this.referenciasLaboralesCandidato = referenciasLaboralesCandidato;
}

public List<ReferenciaPersonalCandidato> getReferenciasPersonalesCandidato()
{
    return referenciasPersonalesCandidato;
}

public void setReferenciasPersonalesCandidato(List<ReferenciaPersonalCandidato> referenciasPersonalesCandidato)
{
    this.referenciasPersonalesCandidato = referenciasPersonalesCandidato;
}

public List<DocumentoCandidato> getDocumentosCandidato()
{
    return documentosCandidato;
}

public void setDocumentosCandidato(List<DocumentoCandidato> documentosCandidato)
{
    this.documentosCandidato = documentosCandidato;
}

public List<CapacitacionCandidato> getCapacitacionesCandidato()
{
    return capacitacionesCandidato;
}

public void setCapacitacionesCandidato(List<CapacitacionCandidato> capacitacionesCandidato)
{
    this.capacitacionesCandidato = capacitacionesCandidato;
}

public List<DependienteCandidato> getDependientesCandidato()
{
    return dependientesCandidato;
}

public void setDependientesCandidato(List<DependienteCandidato> dependientesCandidato)
{
    this.dependientesCandidato = dependientesCandidato;
}

public List<IdiomaCandidato> getIdiomasCandidato()
{
    return idiomasCandidato;
}

public void setIdiomasCandidato(List<IdiomaCandidato> idiomasCandidato)
{
    this.idiomasCandidato = idiomasCandidato;
}

public List<String> getBeneficiariosCandidato()
{
    return beneficiariosCandidato;
}

public void setBeneficiariosCandidato(List<String> beneficiariosCandidato)
{
    this.beneficiariosCandidato = beneficiariosCandidato;
}

public List<EquipoCandidato> getEquiposCandidato()
{
    return equiposCandidato;
}

public void setEquiposCandidato(List<EquipoCandidato> equiposCandidato)
{
    this.equiposCandidato = equiposCandidato;
}

public List<PruebaCandidato> getPruebasCandidato()
{
    return pruebasCandidato;
}

public void setPruebasCandidato(List<PruebaCandidato> pruebasCandidato)
{
    this.pruebasCandidato = pruebasCandidato;
}

public List<EntrevistaCandidato> getEntrevistasCandidato()
{
    return entrevistasCandidato;
}

public void setEntrevistasCandidato(List<EntrevistaCandidato> entrevistasCandidato)
{
    this.entrevistasCandidato = entrevistasCandidato;
}

// ============================================================================================
public void paisDomicilio_ajaxListener(AjaxBehaviorEvent event)
{
    Paises pais = sessionBeanParametros.findPaisesByid(new Short(generales$pais));
    deptosDomicilioSelectItemListModel = sessionBeanParametros.findDepartamentosByPais(pais);
    municipiosDomicilioSelectItemListModel = new ArrayList<Municipios>();
}

public void deptoDomicilio_ajaxListener(AjaxBehaviorEvent event)
{
    String[] deptoDomicilioPKStr = generales$departamento.split(":");
    DeptosPK departamentoPK = new DeptosPK(new Short(deptoDomicilioPKStr[0]), new Short(deptoDomicilioPKStr[1]));
    Deptos departamento = sessionBeanParametros.findDepartamentoById(departamentoPK);
    municipiosDomicilioSelectItemListModel = sessionBeanParametros.findMunicipiosByDepartamento(departamento);
}

// ============================================================================================
public void paisNacimiento_ajaxListener(AjaxBehaviorEvent event)
{
    Paises pais = sessionBeanParametros.findPaisesByid(new Short(generales$paisNacimiento));
    deptosNacSelectItemListModel = sessionBeanParametros.findDepartamentosByPais(pais);
    municipiosNacDomicilioSelectItemListModel = new ArrayList<Municipios>();
}

public void deptoNacimiento_ajaxListener(AjaxBehaviorEvent event)
{
    String[] deptoDomicilioPKStr = generales$departamentoNacimiento.split(":");
    DeptosPK departamentoPK = new DeptosPK(new Short(deptoDomicilioPKStr[0]), new Short(deptoDomicilioPKStr[1]));
    Deptos departamento = sessionBeanParametros.findDepartamentoById(departamentoPK);
    municipiosNacDomicilioSelectItemListModel = sessionBeanParametros.findMunicipiosByDepartamento(departamento);
}

// ============================================================================================
public void deptoExpDUI_ajaxListener(AjaxBehaviorEvent event)
{
    String[] deptoDomicilioPKStr = generales$departamentoExpDui.split(":");
    DeptosPK departamentoPK = new DeptosPK(new Short(deptoDomicilioPKStr[0]), new Short(deptoDomicilioPKStr[1]));
    Deptos departamento = sessionBeanParametros.findDepartamentoById(departamentoPK);
    municipiosExpDUISelectItemListModel = sessionBeanParametros.findMunicipiosByDepartamento(departamento);
}
// ============================================================================================

public void paisPrepAcad_ajaxListener(AjaxBehaviorEvent event)
{
    Paises pais = sessionBeanParametros.findPaisesByid(new Short(preparacion$pais));
    deptosPrepAcadSelectItemListModel = sessionBeanParametros.findDepartamentosByPais(pais);
}
}
