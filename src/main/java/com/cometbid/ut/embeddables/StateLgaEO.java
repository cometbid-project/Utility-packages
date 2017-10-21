/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gbenga
 */
@XmlRootElement
@Embeddable
// @Table(name = "STATE_LGA_VIEW")
// @XmlRootElement
/*
@NamedQueries({
      @NamedQuery(name = "StateLgaEO.findAll", query = "SELECT s FROM StateLgaEO s")
    , @NamedQuery(name = "StateLgaEO.findByStateId", query = "SELECT s FROM StateLgaEO s WHERE s.stateId = :stateId")
    , @NamedQuery(name = "StateLgaEO.findByLgaId", query = "SELECT s FROM StateLgaEO s WHERE s.lgaId = :lgaId")
    , @NamedQuery(name = "StateLgaEO.findByLgaName", query = "SELECT s FROM StateLgaEO s WHERE s.lgaName = :lgaName")
    , @NamedQuery(name = "StateLgaEO.findByLgaLongitude", query = "SELECT s FROM StateLgaEO s WHERE s.lgaLongitude = :lgaLongitude")
    , @NamedQuery(name = "StateLgaEO.findByLgaLatitude", query = "SELECT s FROM StateLgaEO s WHERE s.lgaLatitude = :lgaLatitude")})
 */
public class StateLgaEO implements Serializable {

   // private static final long serialVersionUID = 89054559798459436L;

    @Column(name = "LGA_ID", nullable = false)
    private String lgaId;

    @Column(name = "LGA_NAME", length = 200, nullable = false)
    private String lgaName;

    // @Max(value=?)  @Min(value=?)
    //if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LGA_LONGITUDE", precision = 10, scale = 2)
    private double lgaLongitude;

    @Column(name = "LGA_LATITUDE", precision = 10, scale = 2)
    private double lgaLatitude;

    public StateLgaEO() {
    }

    public String getLgaId() {
        return lgaId;
    }

    public void setLgaId(String lgaId) {
        this.lgaId = lgaId;
    }

    public String getLgaName() {
        return lgaName;
    }

    public void setLgaName(String lgaName) {
        this.lgaName = lgaName;
    }

    public double getLgaLongitude() {
        return lgaLongitude;
    }

    public void setLgaLongitude(double lgaLongitude) {
        this.lgaLongitude = lgaLongitude;
    }

    public double getLgaLatitude() {
        return lgaLatitude;
    }

    public void setLgaLatitude(double lgaLatitude) {
        this.lgaLatitude = lgaLatitude;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.getLgaId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StateLgaEO other = (StateLgaEO) obj;
        if (!Objects.equals(this.getLgaId(), other.getLgaId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StateLgaEO{"
                + "lgaId=" + this.getLgaId()
                + ", lgaName=" + this.getLgaName()
                + ", lgaLongitude=" + this.getLgaLongitude()
                + ", lgaLatitude=" + this.getLgaLatitude()
                + '}';
    }

}
