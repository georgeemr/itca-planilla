/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class DmgcuentasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CIA", nullable = false)
    private short codCia;
    @Basic(optional = false)
    @Column(name = "CTA_1", nullable = false, length = 2)
    private String cta1;
    @Basic(optional = false)
    @Column(name = "CTA_2", nullable = false, length = 3)
    private String cta2;
    @Basic(optional = false)
    @Column(name = "CTA_3", nullable = false, length = 4)
    private String cta3;
    @Basic(optional = false)
    @Column(name = "CTA_4", nullable = false, length = 4)
    private String cta4;
    @Basic(optional = false)
    @Column(name = "CTA_5", nullable = false, length = 5)
    private String cta5;
    @Basic(optional = false)
    @Column(name = "CTA_6", nullable = false, length = 5)
    private String cta6;
    @Basic(optional = false)
    @Column(name = "CTA_7", nullable = false, length = 5)
    private String cta7;
    @Basic(optional = false)
    @Column(name = "CTA_8", nullable = false, length = 5)
    private String cta8;

    public DmgcuentasPK() {
    }

    public DmgcuentasPK(short codCia, String cta1, String cta2, String cta3, String cta4, String cta5, String cta6, String cta7, String cta8) {
        this.codCia = codCia;
        this.cta1 = cta1;
        this.cta2 = cta2;
        this.cta3 = cta3;
        this.cta4 = cta4;
        this.cta5 = cta5;
        this.cta6 = cta6;
        this.cta7 = cta7;
        this.cta8 = cta8;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (cta1 != null ? cta1.hashCode() : 0);
        hash += (cta2 != null ? cta2.hashCode() : 0);
        hash += (cta3 != null ? cta3.hashCode() : 0);
        hash += (cta4 != null ? cta4.hashCode() : 0);
        hash += (cta5 != null ? cta5.hashCode() : 0);
        hash += (cta6 != null ? cta6.hashCode() : 0);
        hash += (cta7 != null ? cta7.hashCode() : 0);
        hash += (cta8 != null ? cta8.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DmgcuentasPK)) {
            return false;
        }
        DmgcuentasPK other = (DmgcuentasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.cta1 == null && other.cta1 != null) || (this.cta1 != null && !this.cta1.equals(other.cta1))) {
            return false;
        }
        if ((this.cta2 == null && other.cta2 != null) || (this.cta2 != null && !this.cta2.equals(other.cta2))) {
            return false;
        }
        if ((this.cta3 == null && other.cta3 != null) || (this.cta3 != null && !this.cta3.equals(other.cta3))) {
            return false;
        }
        if ((this.cta4 == null && other.cta4 != null) || (this.cta4 != null && !this.cta4.equals(other.cta4))) {
            return false;
        }
        if ((this.cta5 == null && other.cta5 != null) || (this.cta5 != null && !this.cta5.equals(other.cta5))) {
            return false;
        }
        if ((this.cta6 == null && other.cta6 != null) || (this.cta6 != null && !this.cta6.equals(other.cta6))) {
            return false;
        }
        if ((this.cta7 == null && other.cta7 != null) || (this.cta7 != null && !this.cta7.equals(other.cta7))) {
            return false;
        }
        if ((this.cta8 == null && other.cta8 != null) || (this.cta8 != null && !this.cta8.equals(other.cta8))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.planilla.modelo.entidades.DmgcuentasPK[ codCia=" + codCia + ", cta1=" + cta1 + ", cta2=" + cta2 + ", cta3=" + cta3 + ", cta4=" + cta4 + ", cta5=" + cta5 + ", cta6=" + cta6 + ", cta7=" + cta7 + ", cta8=" + cta8 + " ]";
    }
    
}
