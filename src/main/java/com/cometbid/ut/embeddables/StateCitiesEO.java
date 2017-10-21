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
// @Table(name = "STATE_CITIES_VIEW")
// @XmlRootElement
/*
@NamedQueries({
      @NamedQuery(name = "StateCitiesEO.findAll", query = "SELECT s FROM StateCitiesEO s")
    , @NamedQuery(name = "StateCitiesEO.findByStateId", 
                query = "SELECT s FROM StateCitiesEO s WHERE s.stateId = :stateId")
    , @NamedQuery(name = "StateCitiesEO.findByCityCode", 
                query = "SELECT s FROM StateCitiesEO s WHERE s.cityCode = :cityCode")
    , @NamedQuery(name = "StateCitiesEO.findByCityName", 
                query = "SELECT s FROM StateCitiesEO s WHERE s.cityName = :cityName")
    , @NamedQuery(name = "StateCitiesEO.findByCityLongitude", 
                query = "SELECT s FROM StateCitiesEO s WHERE s.cityLongitude = :cityLongitude")
    , @NamedQuery(name = "StateCitiesEO.findByCityLatitude", 
                query = "SELECT s FROM StateCitiesEO s WHERE s.cityLatitude = :cityLatitude")})
 */
public class StateCitiesEO implements Serializable {

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "CITY_NAME", length = 200, nullable = false)
    private String cityName;

    // @Max(value=?)  @Min(value=?)
    //if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CITY_LONGITUDE", precision = 8, scale = 2)
    private double cityLongitude;

    @Column(name = "CITY_LATITUDE", precision = 8, scale = 2)
    private double cityLatitude;

    public StateCitiesEO() {
    }

    public StateCitiesEO(String cityCode, String cityName, double cityLongitude, double cityLatitude) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.cityLongitude = cityLongitude;
        this.cityLatitude = cityLatitude;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(double cityLongitude) {
        this.cityLongitude = cityLongitude;
    }

    public double getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(double cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.getCityCode());
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
        final StateCitiesEO other = (StateCitiesEO) obj;
        if (!Objects.equals(this.getCityCode(), other.getCityCode())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StateCitiesEO{"
                + "cityCode=" + this.getCityCode()
                + ", cityName=" + this.getCityName()
                + ", cityLongitude=" + this.getCityLongitude()
                + ", cityLatitude=" + this.getCityLatitude()
                + '}';
    }

}
