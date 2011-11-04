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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdCompania", query = "SELECT m FROM Menu m WHERE m.menuPK.idCompania = :idCompania"),
    @NamedQuery(name = "Menu.findByIdModulo", query = "SELECT m FROM Menu m WHERE m.menuPK.idModulo = :idModulo"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.menuPK.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByTitulo", query = "SELECT m FROM Menu m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Menu.findByNivel", query = "SELECT m FROM Menu m WHERE m.nivel = :nivel"),
    @NamedQuery(name = "Menu.findByEstado", query = "SELECT m FROM Menu m WHERE m.estado = :estado"),
    @NamedQuery(name = "Menu.findByRuta", query = "SELECT m FROM Menu m WHERE m.ruta = :ruta")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuPK menuPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ruta", nullable = false, length = 500)
    private String ruta;
    @JoinTable(name = "menu_rol", joinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo", nullable = false),
        @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false),
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)})
    @ManyToMany
    private List<Rol> rolList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Modulo modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Menu> menuList;
    @JoinColumns({
        @JoinColumn(name = "id_compania", referencedColumnName = "id_compania", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "id_menu_padre", referencedColumnName = "id_menu")})
    @ManyToOne(optional = false)
    private Menu menu;

    public Menu() {
    }

    public Menu(MenuPK menuPK) {
        this.menuPK = menuPK;
    }

    public Menu(MenuPK menuPK, String titulo, int nivel, int estado, String ruta) {
        this.menuPK = menuPK;
        this.titulo = titulo;
        this.nivel = nivel;
        this.estado = estado;
        this.ruta = ruta;
    }

    public Menu(int idCompania, int idModulo, int idMenu) {
        this.menuPK = new MenuPK(idCompania, idModulo, idMenu);
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
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
    
}
