/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "DEPARTAMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByCodCia", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.codCia = :codCia"),
    @NamedQuery(name = "Departamentos.findByCodDepto", query = "SELECT d FROM Departamentos d WHERE d.departamentosPK.codDepto = :codDepto"),
    @NamedQuery(name = "Departamentos.findByNomDepto", query = "SELECT d FROM Departamentos d WHERE d.nomDepto = :nomDepto"),
    @NamedQuery(name = "Departamentos.findByEmpleados", query = "SELECT d FROM Departamentos d WHERE d.empleados = :empleados"),
    @NamedQuery(name = "Departamentos.findByBcta1", query = "SELECT d FROM Departamentos d WHERE d.bcta1 = :bcta1"),
    @NamedQuery(name = "Departamentos.findByBcta2", query = "SELECT d FROM Departamentos d WHERE d.bcta2 = :bcta2"),
    @NamedQuery(name = "Departamentos.findByBcta3", query = "SELECT d FROM Departamentos d WHERE d.bcta3 = :bcta3"),
    @NamedQuery(name = "Departamentos.findByBcta4", query = "SELECT d FROM Departamentos d WHERE d.bcta4 = :bcta4"),
    @NamedQuery(name = "Departamentos.findByBcta5", query = "SELECT d FROM Departamentos d WHERE d.bcta5 = :bcta5"),
    @NamedQuery(name = "Departamentos.findByBcta6", query = "SELECT d FROM Departamentos d WHERE d.bcta6 = :bcta6"),
    @NamedQuery(name = "Departamentos.findByBcta7", query = "SELECT d FROM Departamentos d WHERE d.bcta7 = :bcta7"),
    @NamedQuery(name = "Departamentos.findByBcta8", query = "SELECT d FROM Departamentos d WHERE d.bcta8 = :bcta8"),
    @NamedQuery(name = "Departamentos.findByEcta1", query = "SELECT d FROM Departamentos d WHERE d.ecta1 = :ecta1"),
    @NamedQuery(name = "Departamentos.findByEcta2", query = "SELECT d FROM Departamentos d WHERE d.ecta2 = :ecta2"),
    @NamedQuery(name = "Departamentos.findByEcta3", query = "SELECT d FROM Departamentos d WHERE d.ecta3 = :ecta3"),
    @NamedQuery(name = "Departamentos.findByEcta4", query = "SELECT d FROM Departamentos d WHERE d.ecta4 = :ecta4"),
    @NamedQuery(name = "Departamentos.findByEcta5", query = "SELECT d FROM Departamentos d WHERE d.ecta5 = :ecta5"),
    @NamedQuery(name = "Departamentos.findByEcta6", query = "SELECT d FROM Departamentos d WHERE d.ecta6 = :ecta6"),
    @NamedQuery(name = "Departamentos.findByEcta7", query = "SELECT d FROM Departamentos d WHERE d.ecta7 = :ecta7"),
    @NamedQuery(name = "Departamentos.findByEcta8", query = "SELECT d FROM Departamentos d WHERE d.ecta8 = :ecta8"),
    @NamedQuery(name = "Departamentos.findByCta1", query = "SELECT d FROM Departamentos d WHERE d.cta1 = :cta1"),
    @NamedQuery(name = "Departamentos.findByCta2", query = "SELECT d FROM Departamentos d WHERE d.cta2 = :cta2"),
    @NamedQuery(name = "Departamentos.findByCta3", query = "SELECT d FROM Departamentos d WHERE d.cta3 = :cta3"),
    @NamedQuery(name = "Departamentos.findByCta4", query = "SELECT d FROM Departamentos d WHERE d.cta4 = :cta4"),
    @NamedQuery(name = "Departamentos.findByCta5", query = "SELECT d FROM Departamentos d WHERE d.cta5 = :cta5"),
    @NamedQuery(name = "Departamentos.findByCta6", query = "SELECT d FROM Departamentos d WHERE d.cta6 = :cta6"),
    @NamedQuery(name = "Departamentos.findByCta7", query = "SELECT d FROM Departamentos d WHERE d.cta7 = :cta7"),
    @NamedQuery(name = "Departamentos.findByCta8", query = "SELECT d FROM Departamentos d WHERE d.cta8 = :cta8"),
    @NamedQuery(name = "Departamentos.findByActa1", query = "SELECT d FROM Departamentos d WHERE d.acta1 = :acta1"),
    @NamedQuery(name = "Departamentos.findByActa2", query = "SELECT d FROM Departamentos d WHERE d.acta2 = :acta2"),
    @NamedQuery(name = "Departamentos.findByActa3", query = "SELECT d FROM Departamentos d WHERE d.acta3 = :acta3"),
    @NamedQuery(name = "Departamentos.findByActa4", query = "SELECT d FROM Departamentos d WHERE d.acta4 = :acta4"),
    @NamedQuery(name = "Departamentos.findByActa5", query = "SELECT d FROM Departamentos d WHERE d.acta5 = :acta5"),
    @NamedQuery(name = "Departamentos.findByActa6", query = "SELECT d FROM Departamentos d WHERE d.acta6 = :acta6"),
    @NamedQuery(name = "Departamentos.findByActa7", query = "SELECT d FROM Departamentos d WHERE d.acta7 = :acta7"),
    @NamedQuery(name = "Departamentos.findByActa8", query = "SELECT d FROM Departamentos d WHERE d.acta8 = :acta8"),
    @NamedQuery(name = "Departamentos.findByVcta1", query = "SELECT d FROM Departamentos d WHERE d.vcta1 = :vcta1"),
    @NamedQuery(name = "Departamentos.findByVcta2", query = "SELECT d FROM Departamentos d WHERE d.vcta2 = :vcta2"),
    @NamedQuery(name = "Departamentos.findByVcta3", query = "SELECT d FROM Departamentos d WHERE d.vcta3 = :vcta3"),
    @NamedQuery(name = "Departamentos.findByVcta4", query = "SELECT d FROM Departamentos d WHERE d.vcta4 = :vcta4"),
    @NamedQuery(name = "Departamentos.findByVcta5", query = "SELECT d FROM Departamentos d WHERE d.vcta5 = :vcta5"),
    @NamedQuery(name = "Departamentos.findByVcta6", query = "SELECT d FROM Departamentos d WHERE d.vcta6 = :vcta6"),
    @NamedQuery(name = "Departamentos.findByVcta7", query = "SELECT d FROM Departamentos d WHERE d.vcta7 = :vcta7"),
    @NamedQuery(name = "Departamentos.findByVcta8", query = "SELECT d FROM Departamentos d WHERE d.vcta8 = :vcta8"),
    @NamedQuery(name = "Departamentos.findByDep1", query = "SELECT d FROM Departamentos d WHERE d.dep1 = :dep1"),
    @NamedQuery(name = "Departamentos.findByDep2", query = "SELECT d FROM Departamentos d WHERE d.dep2 = :dep2"),
    @NamedQuery(name = "Departamentos.findByDep3", query = "SELECT d FROM Departamentos d WHERE d.dep3 = :dep3"),
    @NamedQuery(name = "Departamentos.findByDep4", query = "SELECT d FROM Departamentos d WHERE d.dep4 = :dep4"),
    @NamedQuery(name = "Departamentos.findByDep5", query = "SELECT d FROM Departamentos d WHERE d.dep5 = :dep5"),
    @NamedQuery(name = "Departamentos.findByDep6", query = "SELECT d FROM Departamentos d WHERE d.dep6 = :dep6"),
    @NamedQuery(name = "Departamentos.findByDep7", query = "SELECT d FROM Departamentos d WHERE d.dep7 = :dep7"),
    @NamedQuery(name = "Departamentos.findByDep8", query = "SELECT d FROM Departamentos d WHERE d.dep8 = :dep8"),
    @NamedQuery(name = "Departamentos.findBySxpcta1", query = "SELECT d FROM Departamentos d WHERE d.sxpcta1 = :sxpcta1"),
    @NamedQuery(name = "Departamentos.findBySxpcta2", query = "SELECT d FROM Departamentos d WHERE d.sxpcta2 = :sxpcta2"),
    @NamedQuery(name = "Departamentos.findBySxpcta3", query = "SELECT d FROM Departamentos d WHERE d.sxpcta3 = :sxpcta3"),
    @NamedQuery(name = "Departamentos.findBySxpcta4", query = "SELECT d FROM Departamentos d WHERE d.sxpcta4 = :sxpcta4"),
    @NamedQuery(name = "Departamentos.findBySxpcta5", query = "SELECT d FROM Departamentos d WHERE d.sxpcta5 = :sxpcta5"),
    @NamedQuery(name = "Departamentos.findBySxpcta6", query = "SELECT d FROM Departamentos d WHERE d.sxpcta6 = :sxpcta6"),
    @NamedQuery(name = "Departamentos.findBySxpcta7", query = "SELECT d FROM Departamentos d WHERE d.sxpcta7 = :sxpcta7"),
    @NamedQuery(name = "Departamentos.findBySxpcta8", query = "SELECT d FROM Departamentos d WHERE d.sxpcta8 = :sxpcta8"),
    @NamedQuery(name = "Departamentos.findByDepacum1", query = "SELECT d FROM Departamentos d WHERE d.depacum1 = :depacum1"),
    @NamedQuery(name = "Departamentos.findByDepacum2", query = "SELECT d FROM Departamentos d WHERE d.depacum2 = :depacum2"),
    @NamedQuery(name = "Departamentos.findByDepacum3", query = "SELECT d FROM Departamentos d WHERE d.depacum3 = :depacum3"),
    @NamedQuery(name = "Departamentos.findByDepacum4", query = "SELECT d FROM Departamentos d WHERE d.depacum4 = :depacum4"),
    @NamedQuery(name = "Departamentos.findByDepacum5", query = "SELECT d FROM Departamentos d WHERE d.depacum5 = :depacum5"),
    @NamedQuery(name = "Departamentos.findByDepacum6", query = "SELECT d FROM Departamentos d WHERE d.depacum6 = :depacum6"),
    @NamedQuery(name = "Departamentos.findByDepacum7", query = "SELECT d FROM Departamentos d WHERE d.depacum7 = :depacum7"),
    @NamedQuery(name = "Departamentos.findByDepacum8", query = "SELECT d FROM Departamentos d WHERE d.depacum8 = :depacum8"),
    @NamedQuery(name = "Departamentos.findByIcta1", query = "SELECT d FROM Departamentos d WHERE d.icta1 = :icta1"),
    @NamedQuery(name = "Departamentos.findByIcta2", query = "SELECT d FROM Departamentos d WHERE d.icta2 = :icta2"),
    @NamedQuery(name = "Departamentos.findByIcta3", query = "SELECT d FROM Departamentos d WHERE d.icta3 = :icta3"),
    @NamedQuery(name = "Departamentos.findByIcta4", query = "SELECT d FROM Departamentos d WHERE d.icta4 = :icta4"),
    @NamedQuery(name = "Departamentos.findByIcta5", query = "SELECT d FROM Departamentos d WHERE d.icta5 = :icta5"),
    @NamedQuery(name = "Departamentos.findByIcta6", query = "SELECT d FROM Departamentos d WHERE d.icta6 = :icta6"),
    @NamedQuery(name = "Departamentos.findByIcta7", query = "SELECT d FROM Departamentos d WHERE d.icta7 = :icta7"),
    @NamedQuery(name = "Departamentos.findByIcta8", query = "SELECT d FROM Departamentos d WHERE d.icta8 = :icta8"),
    @NamedQuery(name = "Departamentos.findByCopcta1", query = "SELECT d FROM Departamentos d WHERE d.copcta1 = :copcta1"),
    @NamedQuery(name = "Departamentos.findByCopcta2", query = "SELECT d FROM Departamentos d WHERE d.copcta2 = :copcta2"),
    @NamedQuery(name = "Departamentos.findByCopcta3", query = "SELECT d FROM Departamentos d WHERE d.copcta3 = :copcta3"),
    @NamedQuery(name = "Departamentos.findByCopcta4", query = "SELECT d FROM Departamentos d WHERE d.copcta4 = :copcta4"),
    @NamedQuery(name = "Departamentos.findByCopcta5", query = "SELECT d FROM Departamentos d WHERE d.copcta5 = :copcta5"),
    @NamedQuery(name = "Departamentos.findByCopcta6", query = "SELECT d FROM Departamentos d WHERE d.copcta6 = :copcta6"),
    @NamedQuery(name = "Departamentos.findByCopcta7", query = "SELECT d FROM Departamentos d WHERE d.copcta7 = :copcta7"),
    @NamedQuery(name = "Departamentos.findByCopcta8", query = "SELECT d FROM Departamentos d WHERE d.copcta8 = :copcta8"),
    @NamedQuery(name = "Departamentos.findByCocta1", query = "SELECT d FROM Departamentos d WHERE d.cocta1 = :cocta1"),
    @NamedQuery(name = "Departamentos.findByCocta2", query = "SELECT d FROM Departamentos d WHERE d.cocta2 = :cocta2"),
    @NamedQuery(name = "Departamentos.findByCocta3", query = "SELECT d FROM Departamentos d WHERE d.cocta3 = :cocta3"),
    @NamedQuery(name = "Departamentos.findByCocta4", query = "SELECT d FROM Departamentos d WHERE d.cocta4 = :cocta4"),
    @NamedQuery(name = "Departamentos.findByCocta5", query = "SELECT d FROM Departamentos d WHERE d.cocta5 = :cocta5"),
    @NamedQuery(name = "Departamentos.findByCocta6", query = "SELECT d FROM Departamentos d WHERE d.cocta6 = :cocta6"),
    @NamedQuery(name = "Departamentos.findByCocta7", query = "SELECT d FROM Departamentos d WHERE d.cocta7 = :cocta7"),
    @NamedQuery(name = "Departamentos.findByCocta8", query = "SELECT d FROM Departamentos d WHERE d.cocta8 = :cocta8"),
    @NamedQuery(name = "Departamentos.findByVicta1", query = "SELECT d FROM Departamentos d WHERE d.victa1 = :victa1"),
    @NamedQuery(name = "Departamentos.findByVicta2", query = "SELECT d FROM Departamentos d WHERE d.victa2 = :victa2"),
    @NamedQuery(name = "Departamentos.findByVicta3", query = "SELECT d FROM Departamentos d WHERE d.victa3 = :victa3"),
    @NamedQuery(name = "Departamentos.findByVicta4", query = "SELECT d FROM Departamentos d WHERE d.victa4 = :victa4"),
    @NamedQuery(name = "Departamentos.findByVicta5", query = "SELECT d FROM Departamentos d WHERE d.victa5 = :victa5"),
    @NamedQuery(name = "Departamentos.findByVicta6", query = "SELECT d FROM Departamentos d WHERE d.victa6 = :victa6"),
    @NamedQuery(name = "Departamentos.findByVicta7", query = "SELECT d FROM Departamentos d WHERE d.victa7 = :victa7"),
    @NamedQuery(name = "Departamentos.findByVicta8", query = "SELECT d FROM Departamentos d WHERE d.victa8 = :victa8"),
    @NamedQuery(name = "Departamentos.findByDescDepto", query = "SELECT d FROM Departamentos d WHERE d.descDepto = :descDepto"),
    @NamedQuery(name = "Departamentos.findByStaff", query = "SELECT d FROM Departamentos d WHERE d.staff = :staff"),
    @NamedQuery(name = "Departamentos.findByProyecto", query = "SELECT d FROM Departamentos d WHERE d.proyecto = :proyecto"),
    @NamedQuery(name = "Departamentos.findByContable", query = "SELECT d FROM Departamentos d WHERE d.contable = :contable"),
    @NamedQuery(name = "Departamentos.findByPlanilla", query = "SELECT d FROM Departamentos d WHERE d.planilla = :planilla"),
    @NamedQuery(name = "Departamentos.findByMontoCaja", query = "SELECT d FROM Departamentos d WHERE d.montoCaja = :montoCaja"),
    @NamedQuery(name = "Departamentos.findByCodCuenta", query = "SELECT d FROM Departamentos d WHERE d.codCuenta = :codCuenta")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartamentosPK departamentosPK;
    @Column(name = "NOM_DEPTO", length = 100)
    private String nomDepto;
    @Column(name = "EMPLEADOS")
    private Integer empleados;
    @Column(name = "BCTA_1", length = 2)
    private String bcta1;
    @Column(name = "BCTA_2", length = 3)
    private String bcta2;
    @Column(name = "BCTA_3", length = 4)
    private String bcta3;
    @Column(name = "BCTA_4", length = 4)
    private String bcta4;
    @Column(name = "BCTA_5", length = 5)
    private String bcta5;
    @Column(name = "BCTA_6", length = 5)
    private String bcta6;
    @Column(name = "BCTA_7", length = 5)
    private String bcta7;
    @Column(name = "BCTA_8", length = 5)
    private String bcta8;
    @Column(name = "ECTA_1", length = 2)
    private String ecta1;
    @Column(name = "ECTA_2", length = 3)
    private String ecta2;
    @Column(name = "ECTA_3", length = 4)
    private String ecta3;
    @Column(name = "ECTA_4", length = 4)
    private String ecta4;
    @Column(name = "ECTA_5", length = 5)
    private String ecta5;
    @Column(name = "ECTA_6", length = 5)
    private String ecta6;
    @Column(name = "ECTA_7", length = 5)
    private String ecta7;
    @Column(name = "ECTA_8", length = 5)
    private String ecta8;
    @Column(name = "CTA_1", length = 2)
    private String cta1;
    @Column(name = "CTA_2", length = 3)
    private String cta2;
    @Column(name = "CTA_3", length = 4)
    private String cta3;
    @Column(name = "CTA_4", length = 4)
    private String cta4;
    @Column(name = "CTA_5", length = 5)
    private String cta5;
    @Column(name = "CTA_6", length = 5)
    private String cta6;
    @Column(name = "CTA_7", length = 5)
    private String cta7;
    @Column(name = "CTA_8", length = 5)
    private String cta8;
    @Column(name = "ACTA_1", length = 2)
    private String acta1;
    @Column(name = "ACTA_2", length = 3)
    private String acta2;
    @Column(name = "ACTA_3", length = 4)
    private String acta3;
    @Column(name = "ACTA_4", length = 4)
    private String acta4;
    @Column(name = "ACTA_5", length = 5)
    private String acta5;
    @Column(name = "ACTA_6", length = 5)
    private String acta6;
    @Column(name = "ACTA_7", length = 5)
    private String acta7;
    @Column(name = "ACTA_8", length = 5)
    private String acta8;
    @Column(name = "VCTA_1", length = 2)
    private String vcta1;
    @Column(name = "VCTA_2", length = 3)
    private String vcta2;
    @Column(name = "VCTA_3", length = 4)
    private String vcta3;
    @Column(name = "VCTA_4", length = 4)
    private String vcta4;
    @Column(name = "VCTA_5", length = 5)
    private String vcta5;
    @Column(name = "VCTA_6", length = 5)
    private String vcta6;
    @Column(name = "VCTA_7", length = 5)
    private String vcta7;
    @Column(name = "VCTA_8", length = 5)
    private String vcta8;
    @Column(name = "DEP_1", length = 2)
    private String dep1;
    @Column(name = "DEP_2", length = 3)
    private String dep2;
    @Column(name = "DEP_3", length = 4)
    private String dep3;
    @Column(name = "DEP_4", length = 4)
    private String dep4;
    @Column(name = "DEP_5", length = 5)
    private String dep5;
    @Column(name = "DEP_6", length = 5)
    private String dep6;
    @Column(name = "DEP_7", length = 5)
    private String dep7;
    @Column(name = "DEP_8", length = 5)
    private String dep8;
    @Column(name = "SXPCTA_1", length = 2)
    private String sxpcta1;
    @Column(name = "SXPCTA_2", length = 3)
    private String sxpcta2;
    @Column(name = "SXPCTA_3", length = 4)
    private String sxpcta3;
    @Column(name = "SXPCTA_4", length = 4)
    private String sxpcta4;
    @Column(name = "SXPCTA_5", length = 5)
    private String sxpcta5;
    @Column(name = "SXPCTA_6", length = 5)
    private String sxpcta6;
    @Column(name = "SXPCTA_7", length = 5)
    private String sxpcta7;
    @Column(name = "SXPCTA_8", length = 5)
    private String sxpcta8;
    @Column(name = "DEPACUM_1", length = 2)
    private String depacum1;
    @Column(name = "DEPACUM_2", length = 3)
    private String depacum2;
    @Column(name = "DEPACUM_3", length = 4)
    private String depacum3;
    @Column(name = "DEPACUM_4", length = 4)
    private String depacum4;
    @Column(name = "DEPACUM_5", length = 5)
    private String depacum5;
    @Column(name = "DEPACUM_6", length = 5)
    private String depacum6;
    @Column(name = "DEPACUM_7", length = 5)
    private String depacum7;
    @Column(name = "DEPACUM_8", length = 5)
    private String depacum8;
    @Column(name = "ICTA_1", length = 2)
    private String icta1;
    @Column(name = "ICTA_2", length = 3)
    private String icta2;
    @Column(name = "ICTA_3", length = 4)
    private String icta3;
    @Column(name = "ICTA_4", length = 4)
    private String icta4;
    @Column(name = "ICTA_5", length = 5)
    private String icta5;
    @Column(name = "ICTA_6", length = 5)
    private String icta6;
    @Column(name = "ICTA_7", length = 5)
    private String icta7;
    @Column(name = "ICTA_8", length = 5)
    private String icta8;
    @Column(name = "COPCTA_1", length = 2)
    private String copcta1;
    @Column(name = "COPCTA_2", length = 3)
    private String copcta2;
    @Column(name = "COPCTA_3", length = 4)
    private String copcta3;
    @Column(name = "COPCTA_4", length = 4)
    private String copcta4;
    @Column(name = "COPCTA_5", length = 5)
    private String copcta5;
    @Column(name = "COPCTA_6", length = 5)
    private String copcta6;
    @Column(name = "COPCTA_7", length = 5)
    private String copcta7;
    @Column(name = "COPCTA_8", length = 5)
    private String copcta8;
    @Column(name = "COCTA_1", length = 2)
    private String cocta1;
    @Column(name = "COCTA_2", length = 3)
    private String cocta2;
    @Column(name = "COCTA_3", length = 4)
    private String cocta3;
    @Column(name = "COCTA_4", length = 4)
    private String cocta4;
    @Column(name = "COCTA_5", length = 5)
    private String cocta5;
    @Column(name = "COCTA_6", length = 5)
    private String cocta6;
    @Column(name = "COCTA_7", length = 5)
    private String cocta7;
    @Column(name = "COCTA_8", length = 5)
    private String cocta8;
    @Column(name = "VICTA_1", length = 2)
    private String victa1;
    @Column(name = "VICTA_2", length = 3)
    private String victa2;
    @Column(name = "VICTA_3", length = 4)
    private String victa3;
    @Column(name = "VICTA_4", length = 4)
    private String victa4;
    @Column(name = "VICTA_5", length = 5)
    private String victa5;
    @Column(name = "VICTA_6", length = 5)
    private String victa6;
    @Column(name = "VICTA_7", length = 5)
    private String victa7;
    @Column(name = "VICTA_8", length = 5)
    private String victa8;
    @Column(name = "DESC_DEPTO", length = 200)
    private String descDepto;
    @Column(name = "STAFF", length = 1)
    private String staff;
    @Column(name = "PROYECTO", length = 20)
    private String proyecto;
    @Column(name = "CONTABLE", length = 1)
    private String contable;
    @Column(name = "PLANILLA", length = 5)
    private String planilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_CAJA", precision = 16, scale = 2)
    private BigDecimal montoCaja;
    @Column(name = "COD_CUENTA", length = 30)
    private String codCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<Empleados> empleadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<Secciones> seccionesList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_TIPOPLA", referencedColumnName = "COD_TIPOPLA")})
    @ManyToOne(optional = false)
    private TiposPlanilla tiposPlanilla;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_GERENCIA", referencedColumnName = "COD_GERENCIA")})
    @ManyToOne(optional = false)
    private Gerencia gerencia;
    @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA")
    @ManyToOne
    private AreasStaff codArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos")
    private List<InstitucionDepto> institucionDeptoList;

    public Departamentos() {
    }

    public Departamentos(DepartamentosPK departamentosPK) {
        this.departamentosPK = departamentosPK;
    }

    public Departamentos(short codCia, short codDepto) {
        this.departamentosPK = new DepartamentosPK(codCia, codDepto);
    }

    public DepartamentosPK getDepartamentosPK() {
        return departamentosPK;
    }

    public void setDepartamentosPK(DepartamentosPK departamentosPK) {
        this.departamentosPK = departamentosPK;
    }

    public String getNomDepto() {
        return nomDepto;
    }

    public void setNomDepto(String nomDepto) {
        this.nomDepto = nomDepto;
    }

    public Integer getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Integer empleados) {
        this.empleados = empleados;
    }

    public String getBcta1() {
        return bcta1;
    }

    public void setBcta1(String bcta1) {
        this.bcta1 = bcta1;
    }

    public String getBcta2() {
        return bcta2;
    }

    public void setBcta2(String bcta2) {
        this.bcta2 = bcta2;
    }

    public String getBcta3() {
        return bcta3;
    }

    public void setBcta3(String bcta3) {
        this.bcta3 = bcta3;
    }

    public String getBcta4() {
        return bcta4;
    }

    public void setBcta4(String bcta4) {
        this.bcta4 = bcta4;
    }

    public String getBcta5() {
        return bcta5;
    }

    public void setBcta5(String bcta5) {
        this.bcta5 = bcta5;
    }

    public String getBcta6() {
        return bcta6;
    }

    public void setBcta6(String bcta6) {
        this.bcta6 = bcta6;
    }

    public String getBcta7() {
        return bcta7;
    }

    public void setBcta7(String bcta7) {
        this.bcta7 = bcta7;
    }

    public String getBcta8() {
        return bcta8;
    }

    public void setBcta8(String bcta8) {
        this.bcta8 = bcta8;
    }

    public String getEcta1() {
        return ecta1;
    }

    public void setEcta1(String ecta1) {
        this.ecta1 = ecta1;
    }

    public String getEcta2() {
        return ecta2;
    }

    public void setEcta2(String ecta2) {
        this.ecta2 = ecta2;
    }

    public String getEcta3() {
        return ecta3;
    }

    public void setEcta3(String ecta3) {
        this.ecta3 = ecta3;
    }

    public String getEcta4() {
        return ecta4;
    }

    public void setEcta4(String ecta4) {
        this.ecta4 = ecta4;
    }

    public String getEcta5() {
        return ecta5;
    }

    public void setEcta5(String ecta5) {
        this.ecta5 = ecta5;
    }

    public String getEcta6() {
        return ecta6;
    }

    public void setEcta6(String ecta6) {
        this.ecta6 = ecta6;
    }

    public String getEcta7() {
        return ecta7;
    }

    public void setEcta7(String ecta7) {
        this.ecta7 = ecta7;
    }

    public String getEcta8() {
        return ecta8;
    }

    public void setEcta8(String ecta8) {
        this.ecta8 = ecta8;
    }

    public String getCta1() {
        return cta1;
    }

    public void setCta1(String cta1) {
        this.cta1 = cta1;
    }

    public String getCta2() {
        return cta2;
    }

    public void setCta2(String cta2) {
        this.cta2 = cta2;
    }

    public String getCta3() {
        return cta3;
    }

    public void setCta3(String cta3) {
        this.cta3 = cta3;
    }

    public String getCta4() {
        return cta4;
    }

    public void setCta4(String cta4) {
        this.cta4 = cta4;
    }

    public String getCta5() {
        return cta5;
    }

    public void setCta5(String cta5) {
        this.cta5 = cta5;
    }

    public String getCta6() {
        return cta6;
    }

    public void setCta6(String cta6) {
        this.cta6 = cta6;
    }

    public String getCta7() {
        return cta7;
    }

    public void setCta7(String cta7) {
        this.cta7 = cta7;
    }

    public String getCta8() {
        return cta8;
    }

    public void setCta8(String cta8) {
        this.cta8 = cta8;
    }

    public String getActa1() {
        return acta1;
    }

    public void setActa1(String acta1) {
        this.acta1 = acta1;
    }

    public String getActa2() {
        return acta2;
    }

    public void setActa2(String acta2) {
        this.acta2 = acta2;
    }

    public String getActa3() {
        return acta3;
    }

    public void setActa3(String acta3) {
        this.acta3 = acta3;
    }

    public String getActa4() {
        return acta4;
    }

    public void setActa4(String acta4) {
        this.acta4 = acta4;
    }

    public String getActa5() {
        return acta5;
    }

    public void setActa5(String acta5) {
        this.acta5 = acta5;
    }

    public String getActa6() {
        return acta6;
    }

    public void setActa6(String acta6) {
        this.acta6 = acta6;
    }

    public String getActa7() {
        return acta7;
    }

    public void setActa7(String acta7) {
        this.acta7 = acta7;
    }

    public String getActa8() {
        return acta8;
    }

    public void setActa8(String acta8) {
        this.acta8 = acta8;
    }

    public String getVcta1() {
        return vcta1;
    }

    public void setVcta1(String vcta1) {
        this.vcta1 = vcta1;
    }

    public String getVcta2() {
        return vcta2;
    }

    public void setVcta2(String vcta2) {
        this.vcta2 = vcta2;
    }

    public String getVcta3() {
        return vcta3;
    }

    public void setVcta3(String vcta3) {
        this.vcta3 = vcta3;
    }

    public String getVcta4() {
        return vcta4;
    }

    public void setVcta4(String vcta4) {
        this.vcta4 = vcta4;
    }

    public String getVcta5() {
        return vcta5;
    }

    public void setVcta5(String vcta5) {
        this.vcta5 = vcta5;
    }

    public String getVcta6() {
        return vcta6;
    }

    public void setVcta6(String vcta6) {
        this.vcta6 = vcta6;
    }

    public String getVcta7() {
        return vcta7;
    }

    public void setVcta7(String vcta7) {
        this.vcta7 = vcta7;
    }

    public String getVcta8() {
        return vcta8;
    }

    public void setVcta8(String vcta8) {
        this.vcta8 = vcta8;
    }

    public String getDep1() {
        return dep1;
    }

    public void setDep1(String dep1) {
        this.dep1 = dep1;
    }

    public String getDep2() {
        return dep2;
    }

    public void setDep2(String dep2) {
        this.dep2 = dep2;
    }

    public String getDep3() {
        return dep3;
    }

    public void setDep3(String dep3) {
        this.dep3 = dep3;
    }

    public String getDep4() {
        return dep4;
    }

    public void setDep4(String dep4) {
        this.dep4 = dep4;
    }

    public String getDep5() {
        return dep5;
    }

    public void setDep5(String dep5) {
        this.dep5 = dep5;
    }

    public String getDep6() {
        return dep6;
    }

    public void setDep6(String dep6) {
        this.dep6 = dep6;
    }

    public String getDep7() {
        return dep7;
    }

    public void setDep7(String dep7) {
        this.dep7 = dep7;
    }

    public String getDep8() {
        return dep8;
    }

    public void setDep8(String dep8) {
        this.dep8 = dep8;
    }

    public String getSxpcta1() {
        return sxpcta1;
    }

    public void setSxpcta1(String sxpcta1) {
        this.sxpcta1 = sxpcta1;
    }

    public String getSxpcta2() {
        return sxpcta2;
    }

    public void setSxpcta2(String sxpcta2) {
        this.sxpcta2 = sxpcta2;
    }

    public String getSxpcta3() {
        return sxpcta3;
    }

    public void setSxpcta3(String sxpcta3) {
        this.sxpcta3 = sxpcta3;
    }

    public String getSxpcta4() {
        return sxpcta4;
    }

    public void setSxpcta4(String sxpcta4) {
        this.sxpcta4 = sxpcta4;
    }

    public String getSxpcta5() {
        return sxpcta5;
    }

    public void setSxpcta5(String sxpcta5) {
        this.sxpcta5 = sxpcta5;
    }

    public String getSxpcta6() {
        return sxpcta6;
    }

    public void setSxpcta6(String sxpcta6) {
        this.sxpcta6 = sxpcta6;
    }

    public String getSxpcta7() {
        return sxpcta7;
    }

    public void setSxpcta7(String sxpcta7) {
        this.sxpcta7 = sxpcta7;
    }

    public String getSxpcta8() {
        return sxpcta8;
    }

    public void setSxpcta8(String sxpcta8) {
        this.sxpcta8 = sxpcta8;
    }

    public String getDepacum1() {
        return depacum1;
    }

    public void setDepacum1(String depacum1) {
        this.depacum1 = depacum1;
    }

    public String getDepacum2() {
        return depacum2;
    }

    public void setDepacum2(String depacum2) {
        this.depacum2 = depacum2;
    }

    public String getDepacum3() {
        return depacum3;
    }

    public void setDepacum3(String depacum3) {
        this.depacum3 = depacum3;
    }

    public String getDepacum4() {
        return depacum4;
    }

    public void setDepacum4(String depacum4) {
        this.depacum4 = depacum4;
    }

    public String getDepacum5() {
        return depacum5;
    }

    public void setDepacum5(String depacum5) {
        this.depacum5 = depacum5;
    }

    public String getDepacum6() {
        return depacum6;
    }

    public void setDepacum6(String depacum6) {
        this.depacum6 = depacum6;
    }

    public String getDepacum7() {
        return depacum7;
    }

    public void setDepacum7(String depacum7) {
        this.depacum7 = depacum7;
    }

    public String getDepacum8() {
        return depacum8;
    }

    public void setDepacum8(String depacum8) {
        this.depacum8 = depacum8;
    }

    public String getIcta1() {
        return icta1;
    }

    public void setIcta1(String icta1) {
        this.icta1 = icta1;
    }

    public String getIcta2() {
        return icta2;
    }

    public void setIcta2(String icta2) {
        this.icta2 = icta2;
    }

    public String getIcta3() {
        return icta3;
    }

    public void setIcta3(String icta3) {
        this.icta3 = icta3;
    }

    public String getIcta4() {
        return icta4;
    }

    public void setIcta4(String icta4) {
        this.icta4 = icta4;
    }

    public String getIcta5() {
        return icta5;
    }

    public void setIcta5(String icta5) {
        this.icta5 = icta5;
    }

    public String getIcta6() {
        return icta6;
    }

    public void setIcta6(String icta6) {
        this.icta6 = icta6;
    }

    public String getIcta7() {
        return icta7;
    }

    public void setIcta7(String icta7) {
        this.icta7 = icta7;
    }

    public String getIcta8() {
        return icta8;
    }

    public void setIcta8(String icta8) {
        this.icta8 = icta8;
    }

    public String getCopcta1() {
        return copcta1;
    }

    public void setCopcta1(String copcta1) {
        this.copcta1 = copcta1;
    }

    public String getCopcta2() {
        return copcta2;
    }

    public void setCopcta2(String copcta2) {
        this.copcta2 = copcta2;
    }

    public String getCopcta3() {
        return copcta3;
    }

    public void setCopcta3(String copcta3) {
        this.copcta3 = copcta3;
    }

    public String getCopcta4() {
        return copcta4;
    }

    public void setCopcta4(String copcta4) {
        this.copcta4 = copcta4;
    }

    public String getCopcta5() {
        return copcta5;
    }

    public void setCopcta5(String copcta5) {
        this.copcta5 = copcta5;
    }

    public String getCopcta6() {
        return copcta6;
    }

    public void setCopcta6(String copcta6) {
        this.copcta6 = copcta6;
    }

    public String getCopcta7() {
        return copcta7;
    }

    public void setCopcta7(String copcta7) {
        this.copcta7 = copcta7;
    }

    public String getCopcta8() {
        return copcta8;
    }

    public void setCopcta8(String copcta8) {
        this.copcta8 = copcta8;
    }

    public String getCocta1() {
        return cocta1;
    }

    public void setCocta1(String cocta1) {
        this.cocta1 = cocta1;
    }

    public String getCocta2() {
        return cocta2;
    }

    public void setCocta2(String cocta2) {
        this.cocta2 = cocta2;
    }

    public String getCocta3() {
        return cocta3;
    }

    public void setCocta3(String cocta3) {
        this.cocta3 = cocta3;
    }

    public String getCocta4() {
        return cocta4;
    }

    public void setCocta4(String cocta4) {
        this.cocta4 = cocta4;
    }

    public String getCocta5() {
        return cocta5;
    }

    public void setCocta5(String cocta5) {
        this.cocta5 = cocta5;
    }

    public String getCocta6() {
        return cocta6;
    }

    public void setCocta6(String cocta6) {
        this.cocta6 = cocta6;
    }

    public String getCocta7() {
        return cocta7;
    }

    public void setCocta7(String cocta7) {
        this.cocta7 = cocta7;
    }

    public String getCocta8() {
        return cocta8;
    }

    public void setCocta8(String cocta8) {
        this.cocta8 = cocta8;
    }

    public String getVicta1() {
        return victa1;
    }

    public void setVicta1(String victa1) {
        this.victa1 = victa1;
    }

    public String getVicta2() {
        return victa2;
    }

    public void setVicta2(String victa2) {
        this.victa2 = victa2;
    }

    public String getVicta3() {
        return victa3;
    }

    public void setVicta3(String victa3) {
        this.victa3 = victa3;
    }

    public String getVicta4() {
        return victa4;
    }

    public void setVicta4(String victa4) {
        this.victa4 = victa4;
    }

    public String getVicta5() {
        return victa5;
    }

    public void setVicta5(String victa5) {
        this.victa5 = victa5;
    }

    public String getVicta6() {
        return victa6;
    }

    public void setVicta6(String victa6) {
        this.victa6 = victa6;
    }

    public String getVicta7() {
        return victa7;
    }

    public void setVicta7(String victa7) {
        this.victa7 = victa7;
    }

    public String getVicta8() {
        return victa8;
    }

    public void setVicta8(String victa8) {
        this.victa8 = victa8;
    }

    public String getDescDepto() {
        return descDepto;
    }

    public void setDescDepto(String descDepto) {
        this.descDepto = descDepto;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getContable() {
        return contable;
    }

    public void setContable(String contable) {
        this.contable = contable;
    }

    public String getPlanilla() {
        return planilla;
    }

    public void setPlanilla(String planilla) {
        this.planilla = planilla;
    }

    public BigDecimal getMontoCaja() {
        return montoCaja;
    }

    public void setMontoCaja(BigDecimal montoCaja) {
        this.montoCaja = montoCaja;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Secciones> getSeccionesList() {
        return seccionesList;
    }

    public void setSeccionesList(List<Secciones> seccionesList) {
        this.seccionesList = seccionesList;
    }

    public TiposPlanilla getTiposPlanilla() {
        return tiposPlanilla;
    }

    public void setTiposPlanilla(TiposPlanilla tiposPlanilla) {
        this.tiposPlanilla = tiposPlanilla;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    public AreasStaff getCodArea() {
        return codArea;
    }

    public void setCodArea(AreasStaff codArea) {
        this.codArea = codArea;
    }

    @XmlTransient
    public List<InstitucionDepto> getInstitucionDeptoList() {
        return institucionDeptoList;
    }

    public void setInstitucionDeptoList(List<InstitucionDepto> institucionDeptoList) {
        this.institucionDeptoList = institucionDeptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentosPK != null ? departamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.departamentosPK == null && other.departamentosPK != null) || (this.departamentosPK != null && !this.departamentosPK.equals(other.departamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Departamentos[ departamentosPK=" + departamentosPK + " ]";
    }
    
}
