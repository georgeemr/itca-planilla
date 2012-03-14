/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MENU", catalog = "", schema = "PLANILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByCodCia", query = "SELECT m FROM Menu m WHERE m.menuPK.codCia = :codCia"),
    @NamedQuery(name = "Menu.findByCodModulo", query = "SELECT m FROM Menu m WHERE m.menuPK.codModulo = :codModulo"),
    @NamedQuery(name = "Menu.findByCodMenu", query = "SELECT m FROM Menu m WHERE m.menuPK.codMenu = :codMenu"),
    @NamedQuery(name = "Menu.findByTitulo", query = "SELECT m FROM Menu m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Menu.findByNivel", query = "SELECT m FROM Menu m WHERE m.nivel = :nivel"),
    @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado"),
    @NamedQuery(name = "Menu.findByRuta", query = "SELECT m FROM Menu m WHERE m.ruta = :ruta")})
public class Menu implements Serializable, Comparable<Menu> {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuPK menuPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TITULO", nullable = false, length = 200)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIVEL", nullable = false)
    private long nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO", nullable = false)
    private long estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "RUTA", nullable = false, length = 500)
    private String ruta;
    @JoinTable(name = "MENU_ROL", joinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", nullable = false),
        @JoinColumn(name = "COD_MENU", referencedColumnName = "COD_MENU", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false),
        @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL", nullable = false)})
    @ManyToMany
    private List<Rol> rolList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Modulo modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Menu> menuList;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "COD_MENU_PADRE", referencedColumnName = "COD_MENU")})
    @ManyToOne(optional = false)
    private Menu menu;

    public Menu() {
    }

    public Menu(MenuPK menuPK) {
        this.menuPK = menuPK;
    }

    public Menu(MenuPK menuPK, String titulo, long nivel, long estado, String ruta) {
        this.menuPK = menuPK;
        this.titulo = titulo;
        this.nivel = nivel;
        this.estado = estado;
        this.ruta = ruta;
    }

    public Menu(short codCia, long codModulo, long codMenu) {
        this.menuPK = new MenuPK(codCia, codModulo, codMenu);
    }

    public MenuPK getMenuPK() {
        return menuPK;
    }

    public void setMenuPK(MenuPK menuPK) {
        this.menuPK = menuPK;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuPK != null ? menuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuPK == null && other.menuPK != null) || (this.menuPK != null && !this.menuPK.equals(other.menuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.Menu[ menuPK=" + menuPK + " ]";
    }

    @Override
    public int compareTo(Menu t) {
        return (this.menuPK.getCodMenu().compareTo(t.menuPK.getCodMenu()));
    }
    
}
