/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.inf.unideb.test.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gjula
 */
@Entity
@Table(name = "my_team", catalog = "sql7261965", schema = "")
@NamedQueries({
    @NamedQuery(name = "MyTeam.findAll", query = "SELECT m FROM MyTeam m")})
public class MyTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "kapus", length = 255)
    private String kapus;
    @Size(max = 255)
    @Column(name = "vedo_egy", length = 255)
    private String vedoEgy;
    @Size(max = 255)
    @Column(name = "vedo_ketto", length = 255)
    private String vedoKetto;
    @Size(max = 255)
    @Column(name = "vedo_harom", length = 255)
    private String vedoHarom;
    @Size(max = 255)
    @Column(name = "vedo_negy", length = 255)
    private String vedoNegy;
    @Size(max = 255)
    @Column(name = "kozep_egy", length = 255)
    private String kozepEgy;
    @Size(max = 255)
    @Column(name = "kozep_ketto", length = 255)
    private String kozepKetto;
    @Size(max = 255)
    @Column(name = "kozep_harom", length = 255)
    private String kozepHarom;
    @Size(max = 255)
    @Column(name = "kozep_negy", length = 255)
    private String kozepNegy;
    @Size(max = 255)
    @Column(name = "tamado_egy", length = 255)
    private String tamadoEgy;
    @Size(max = 255)
    @Column(name = "tamado_ketto", length = 255)
    private String tamadoKetto;
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public MyTeam() {
    }

    public MyTeam(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKapus() {
        return kapus;
    }

    public void setKapus(String kapus) {
        this.kapus = kapus;
    }

    public String getVedoEgy() {
        return vedoEgy;
    }

    public void setVedoEgy(String vedoEgy) {
        this.vedoEgy = vedoEgy;
    }

    public String getVedoKetto() {
        return vedoKetto;
    }

    public void setVedoKetto(String vedoKetto) {
        this.vedoKetto = vedoKetto;
    }

    public String getVedoHarom() {
        return vedoHarom;
    }

    public void setVedoHarom(String vedoHarom) {
        this.vedoHarom = vedoHarom;
    }

    public String getVedoNegy() {
        return vedoNegy;
    }

    public void setVedoNegy(String vedoNegy) {
        this.vedoNegy = vedoNegy;
    }

    public String getKozepEgy() {
        return kozepEgy;
    }

    public void setKozepEgy(String kozepEgy) {
        this.kozepEgy = kozepEgy;
    }

    public String getKozepKetto() {
        return kozepKetto;
    }

    public void setKozepKetto(String kozepKetto) {
        this.kozepKetto = kozepKetto;
    }

    public String getKozepHarom() {
        return kozepHarom;
    }

    public void setKozepHarom(String kozepHarom) {
        this.kozepHarom = kozepHarom;
    }

    public String getKozepNegy() {
        return kozepNegy;
    }

    public void setKozepNegy(String kozepNegy) {
        this.kozepNegy = kozepNegy;
    }

    public String getTamadoEgy() {
        return tamadoEgy;
    }

    public void setTamadoEgy(String tamadoEgy) {
        this.tamadoEgy = tamadoEgy;
    }

    public String getTamadoKetto() {
        return tamadoKetto;
    }

    public void setTamadoKetto(String tamadoKetto) {
        this.tamadoKetto = tamadoKetto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyTeam)) {
            return false;
        }
        MyTeam other = (MyTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.inf.unideb.test.entity.MyTeam[ id=" + id + " ]";
    }
    
}
