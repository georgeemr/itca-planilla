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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
// = o =
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
// ===========================================================================================================
// = Generales ===============================================================================================
// ===========================================================================================================
private Integer generales$pais;
private Integer generales$departamento;
private Integer generales$municipio;
private String generales$telefono;
private String generales$direccion;
// = o =
@NotNull
private Date generales$fechaNacimiento;
private Integer generales$paisNacimiento;
private Integer generales$departamentoNacimiento;
private Integer generales$municipioNacimiento;
private Integer generales$paisNacionalidad;
private Integer generales$grupoSanguineo;
// = o =
private String generales$dui;
private String generales$nit;
private Date generales$fechaExpDui;
private Integer generales$departamentoExpDui;
private Integer generales$municipioExpDui;
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
// = o =
// ===========================================================================================================
// = Pruebas =================================================================================================
// ===========================================================================================================
// = o =
// ===========================================================================================================
// = Puestos =================================================================================================
// ===========================================================================================================
// = o =
// ===========================================================================================================
// = Entrevistas =============================================================================================
// ===========================================================================================================
// = o =
// ===========================================================================================================
// ===========================================================================================================
// ===========================================================================================================
private List<TipoDocumento> listaTipoDocumentos;
private List<Candidato> listaCandidatos;
private List<Paises> listaPaises;
private List<Deptos> listaDepartamentos;
private List<Municipios> listaMunicipios;
private List<TipoSangre> listaTipoSangre;
private List<NivelAcademico> listaNivelAcademico;
private List<Profesion> listaProfesiones;
// ======================================
private List<Puestos> puestosSelectItemListModel;
private List<Parentesco> parentescoSelectItemListModel;
private List<Capacitacion> capacitacionesSelectItemListModel;
private List<Instituciones> institucionesSelectItemListModel;
private List<Idioma> idiomasSelectItemListModel;

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
// ======================================
private Boolean isError;
// ===========================================================================================================
// ===========================================================================================================
// ===========================================================================================================

@PostConstruct
public void init()
{
    fechaSolicitud = Calendar.getInstance().getTime();
    listaCandidatos = reclutamientoFacade.getCandidatosByEmpresa(getSessionBeanADM().getCompania());
    listaPaises = sessionBeanParametros.getListaPaises();
    listaDepartamentos = sessionBeanParametros.getListaDepartamentos();
    listaMunicipios = sessionBeanParametros.getListaMunicipios();
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
}

// ==================================================================================================================
@PermitAll
public String preparacionAcademica$agregar$action()
{
    //String[] paisPKStr = preparacion$pais.split(":");
    String[] deptoPKStr = preparacion$departamento.split(":");
    String[] nivelAcademicoPKStr = preparacion$nivelAcademico.split(":");
    String[] profesionPKStr = preparacion$profesion.split(":");

    boolean hayError = false;

    if ((preparacion$nombreInstitucion == null) || preparacion$nombreInstitucion.trim().isEmpty())
        {
        addMessage("Preparacion academica", "Ingrese el nombre de la institucion", TipoMensaje.INFORMACION);
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
    return null;
}

@PermitAll
public String emergencias$agregarParentesco$action()
{
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
    ExperienciaLaboralCandidato e = new ExperienciaLaboralCandidato();
    e.setLugar(experiencia$lugarTrabajo);
    String[] puesto = experiencia$puesto.split(":");
    PuestosPK puestoPK = new PuestosPK(new Short(puesto[0]), new Short(puesto[1]));
    e.setPuesto(sessionBeanParametros.findPuestosById(puestoPK));
    e.setFechaInicio(experiencia$fechaInicio);
    e.setFechaFin(experiencia$fechaFin);
    e.setMotivoRetiro(experiencia$motivoRetiro);
    experienciasLaboralesCandidato.add(e);
    return null;
}

@PermitAll
public String referenciaLaboral$agregar$action()
{
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
    return null;
}

@PermitAll
public String referenciaPersonal$agregar$action()
{
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
    return null;
}

@PermitAll
public String documento$agregar$action()
{
    String[] documentoPKStr = documentos$tipo.split(":");
    TipoDocumentoPK tipoDocumentoPK = new TipoDocumentoPK(new Short(documentoPKStr[0]), new Short(documentoPKStr[1]));

    DocumentoCandidato d = new DocumentoCandidato();
    d.setTipo(reclutamientoFacade.findTipoDocumentoById(tipoDocumentoPK));
    d.setNumero(documentos$numero);

    documentosCandidato.add(d);
    return null;
}

@PermitAll
public String capacitaciones$agregar$action()
{
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
    return null;
}

@PermitAll
public String dependientes$agregar$action()
{
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

    return null;
}

@PermitAll
public String idiomas$agregar$action()
{
    String[] idiomaPKStr = idiomas$idioma.split(":");
    IdiomaPK idiomaPK = new IdiomaPK(new Short(idiomaPKStr[0]), new Integer(idiomaPKStr[1]));
    IdiomaCandidato i = new IdiomaCandidato();
    i.setIdioma(sessionBeanParametros.findIdiomaById(idiomaPK));
    i.setLee(idiomas$lee);
    i.setEscribe(idiomas$escribe);
    i.setNivel(idiomas$nivel);
    idiomasCandidato.add(i);
    return null;
}

@PermitAll
public String beneficiarios$agregar$action()
{
    if((beneficiarios$nombre == null) || beneficiarios$nombre.isEmpty())
        {
        addMessage("Infosweb RRHH", "Ingrese el nombre del beneficiario", TipoMensaje.ADVERTENCIA);
        return null;
        }
    beneficiariosCandidato.add(beneficiarios$nombre);
    beneficiarios$nombre = null ;
    return null;
}

@PermitAll
public String guardar$action()
{
    Short c = getSessionBeanADM().getCompania().getCodCia();

    CandidatoPK pkCandidato = new CandidatoPK();
    Candidato candidato = new Candidato();

    //GregorianCalendar calendarioHoy = (GregorianCalendar) GregorianCalendar.getInstance();
    //GregorianCalendar calendarioNacimiento = (GregorianCalendar) GregorianCalendar.getInstance();
    //calendarioNacimiento.setTime(generales$fechaNacimiento);

    //Integer anioHoy = calendarioHoy.get(GregorianCalendar.YEAR);
    //Integer nac = calendarioNacimiento.get(GregorianCalendar.YEAR);
    //Integer edad = anioHoy - nac;
    try
        {
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
        //candidato.setTipoSangre(null);        

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

        //candidato.setObservacion(observaciones);
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
            //referencia.setEmail(referenciaLaboral.getCorreoElectronico())
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
            //referencia.setEmail(referenciaLaboral.getCorreoElectronico())
            referencia.setTelefono(referenciaPersonal.getTelefono());

            reclutamientoFacade.crearRererencia(referencia);

            for (DocumentoCandidato documentoCandidato : documentosCandidato)
                {
                documentoCandidato.toString();
                }
            }
        addMessage("Registro de Candidatos", "Datos guardados satisfactoriamente.", TipoMensaje.INFORMACION);
        }
    catch (Exception e)
        {
        e.printStackTrace(System.err);
        addMessage("Registro de Candidatos", "El candidato ingresado ya existe.", TipoMensaje.ERROR_FATAL);
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

public Integer getGenerales$departamento()
{
    return generales$departamento;
}

public void setGenerales$departamento(Integer generales$departamento)
{
    this.generales$departamento = generales$departamento;
}

public Integer getGenerales$departamentoExpDui()
{
    return generales$departamentoExpDui;
}

public void setGenerales$departamentoExpDui(Integer generales$departamentoExpDui)
{
    this.generales$departamentoExpDui = generales$departamentoExpDui;
}

public Integer getGenerales$departamentoNacimiento()
{
    return generales$departamentoNacimiento;
}

public void setGenerales$departamentoNacimiento(Integer generales$departamentoNacimiento)
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

public Integer getGenerales$grupoSanguineo()
{
    return generales$grupoSanguineo;
}

public void setGenerales$grupoSanguineo(Integer generales$grupoSanguineo)
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

public Integer getGenerales$municipio()
{
    return generales$municipio;
}

public void setGenerales$municipio(Integer generales$municipio)
{
    this.generales$municipio = generales$municipio;
}

public Integer getGenerales$municipioExpDui()
{
    return generales$municipioExpDui;
}

public void setGenerales$municipioExpDui(Integer generales$municipioExpDui)
{
    this.generales$municipioExpDui = generales$municipioExpDui;
}

public Integer getGenerales$municipioNacimiento()
{
    return generales$municipioNacimiento;
}

public void setGenerales$municipioNacimiento(Integer generales$municipioNacimiento)
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

public Integer getGenerales$pais()
{
    return generales$pais;
}

public void setGenerales$pais(Integer generales$pais)
{
    this.generales$pais = generales$pais;
}

public Integer getGenerales$paisNacimiento()
{
    return generales$paisNacimiento;
}

public void setGenerales$paisNacimiento(Integer generales$paisNacimiento)
{
    this.generales$paisNacimiento = generales$paisNacimiento;
}

public Integer getGenerales$paisNacionalidad()
{
    return generales$paisNacionalidad;
}

public void setGenerales$paisNacionalidad(Integer generales$paisNacionalidad)
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

public String getSexo()
{
    return sexo;
}

public void setSexo(String sexo)
{
    this.sexo = sexo;
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

public List<Deptos> getListaDepartamentos()
{
    return listaDepartamentos;
}

public void setListaDepartamentos(List<Deptos> listaDepartamentos)
{
    this.listaDepartamentos = listaDepartamentos;
}

public List<Municipios> getListaMunicipios()
{
    return listaMunicipios;
}

public void setListaMunicipios(List<Municipios> listaMunicipios)
{
    this.listaMunicipios = listaMunicipios;
}

public List<NivelAcademico> getListaNivelAcademico()
{
    return listaNivelAcademico;
}

public void setListaNivelAcademico(List<NivelAcademico> listaNivelAcademico)
{
    this.listaNivelAcademico = listaNivelAcademico;
}

public List<Paises> getListaPaises()
{
    return listaPaises;
}

public void setListaPaises(List<Paises> listaPaises)
{
    this.listaPaises = listaPaises;
}

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
}
