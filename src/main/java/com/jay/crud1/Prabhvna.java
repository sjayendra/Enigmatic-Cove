package com.jay.crud1;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import java.time.LocalDateTime;

import java.util.Set;

@Entity
@Table(name= "prabhavna")
@SecondaryTable(name = "aradhak", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ecn"))
public class Prabhvna {

    @Id
    private String ecn;
    private String centre;
    private int category;
    private String  karyakarta;
    private boolean pra_rbta;
    private boolean pra_comp;
    private boolean pra_gatha;
    private boolean pra_consolation;
    private java.time.LocalDateTime p_time;

    @Column(name = "name", table = "aradhak",updatable = false, insertable = false)
    private String name;

    @Column(name = "mobil", table = "aradhak",updatable = false, insertable = false)
    private String mobil;

    protected Prabhvna() {
    }

    public String getEcn() {
        return ecn;
    }

    public void setEcn(String ecn) {
        this.ecn = ecn;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }


    public String getCentre() {
        return centre;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getKaryakarta() {
        return karyakarta;
    }

    public void setKaryakarta(String karyakarta) {
        this.karyakarta = karyakarta;
    }

    public boolean isPra_rbta() {
       return pra_rbta;

    }

    public void setPra_rbta(boolean pra_rbta) {
        this.pra_rbta = pra_rbta;
    }

    public boolean isPra_comp() {
        return pra_comp;
    }

    public void setPra_comp(boolean pra_comp) {
        this.pra_comp = pra_comp;
    }

    public boolean isPra_gatha() {
        return pra_gatha;
    }

    public void setPra_gatha(boolean pra_gatha) {
        this.pra_gatha = pra_gatha;
    }

    public boolean isPra_consolation() {
        return pra_consolation;
    }

    public void setPra_consolation(boolean pra_consolation) {
        this.pra_consolation = pra_consolation;
    }

    public LocalDateTime getP_time() {
        return p_time;
    }

    public void setP_time(LocalDateTime p_time) {
        this.p_time = p_time;
    }

    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //    this.name = name;
    //}

    public String getMobil() {
        return mobil;
    }

    //public void setMobil(String mobil) {
    //    this.mobil = mobil;
    //}

}

