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
@Table(name = "enemy_team")
@NamedQueries({
    @NamedQuery(name = "EnemyTeam.findAll", query = "SELECT e FROM EnemyTeam e")})
public class EnemyTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "szint")
    private int szint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "probalkozas")
    private int probalkozas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kapus")
    private String kapus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vedo_egy")
    private String vedoEgy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vedo_ketto")
    private String vedoKetto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vedo_harom")
    private String vedoHarom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vedo_negy")
    private String vedoNegy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kozep_egy")
    private String kozepEgy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kozep_ketto")
    private String kozepKetto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kozep_harom")
    private String kozepHarom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kozep_negy")
    private String kozepNegy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tamado_egy")
    private String tamadoEgy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tamado_ketto")
    private String tamadoKetto;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public EnemyTeam() {
    }

    public EnemyTeam(Integer id) {
        this.id = id;
    }

    public EnemyTeam(Integer id, int szint, int probalkozas, String kapus, String vedoEgy, String vedoKetto, String vedoHarom, String vedoNegy, String kozepEgy, String kozepKetto, String kozepHarom, String kozepNegy, String tamadoEgy, String tamadoKetto) {
        this.id = id;
        this.szint = szint;
        this.probalkozas = probalkozas;
        this.kapus = kapus;
        this.vedoEgy = vedoEgy;
        this.vedoKetto = vedoKetto;
        this.vedoHarom = vedoHarom;
        this.vedoNegy = vedoNegy;
        this.kozepEgy = kozepEgy;
        this.kozepKetto = kozepKetto;
        this.kozepHarom = kozepHarom;
        this.kozepNegy = kozepNegy;
        this.tamadoEgy = tamadoEgy;
        this.tamadoKetto = tamadoKetto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public int getProbalkozas() {
        return probalkozas;
    }

    public void setProbalkozas(int probalkozas) {
        this.probalkozas = probalkozas;
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
        if (!(object instanceof EnemyTeam)) {
            return false;
        }
        EnemyTeam other = (EnemyTeam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.inf.unideb.test.entity.EnemyTeam[ id=" + id + " ]";
    }
    
}
