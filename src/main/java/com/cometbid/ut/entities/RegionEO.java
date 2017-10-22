/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.entities;

import com.cometbid.commerce.ut.common.DomainObject;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author Gbenga
 */
@Entity
@Table(name = "REGION_TAB")
@XmlRootElement(name = "Region")
@NamedQueries({
    @NamedQuery(name = "RegionEO.findAll", query = "SELECT r FROM RegionEO r")
    , @NamedQuery(name = "RegionEO.findByContinentId",
            query = "SELECT r FROM RegionEO r WHERE r.regionId = :regionId")
    , @NamedQuery(name = "RegionEO.findByContinent",
            query = "SELECT r FROM RegionEO r WHERE r.region = :region")
    , @NamedQuery(name = "RegionEO.findByContinentCode",
            query = "SELECT r FROM RegionEO r WHERE r.regionCode = :regionCode")
    , @NamedQuery(name = "RegionEO.findByDescription",
            query = "SELECT r FROM RegionEO r WHERE r.description = :description")}
)
@Cacheable(true)
public class RegionEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = 58905659767750776L;

    /*@GenericGenerator(
    name = "RegionEO_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "RegionEO_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")
    }
    )*/
    @Id
    @TableGenerator(
            name = "RegionEO_gen",
            table = "DB_PK_table",
            pkColumnValue = "Regions_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegionEO_gen")
    @Expose(serialize = true, deserialize = false)
    @Column(name = "REGION_ID")
    private Integer regionId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "REGION_ID", nullable = false)
    @Type(type = "objectid")
    private String regionId;
     */
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "REGION_NAME", nullable = false, length = 35, unique = true)
    private String region;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "REGION_CODE", nullable = false, length = 2)
    private String regionCode;

    @Column(name = "COUNTRY_ID")
    @OneToMany(mappedBy = "region", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("country ASC")
    private List<CountryEO> countryList;

    @Column(length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public RegionEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        regionId = null;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CountryEO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryEO> countryList) {
        this.countryList = countryList;
    }

    public boolean addCountryToList(CountryEO country) {
        if (this.countryList == null) {
            this.countryList = new ArrayList<>();
        }
        if (!countryList.contains(country)) {
            RegionEO oldRegion = country.getRegion();
            if (oldRegion != null) {
                removeCountryFromList(country);
            }
            this.countryList.add(country);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeCountryFromList(CountryEO country) {
        if (countryList == null) {
            return false;
        }
        if (countryList.contains(country)) {
            this.countryList.remove(country);
            country.setRegion(null);
            return true;
        } else {
            return false;
        }
    }

    public long getVersion() {
        return version;
    }

    protected void setVersion(long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getRegionId());
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
        final RegionEO other = (RegionEO) obj;
        if (!Objects.equals(this.getRegionId(), other.getRegionId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegionEO{"
                + "regionId=" + this.getRegionId()
                + ", region=" + this.getRegion()
                + ", regionCode=" + this.getRegionCode()
                + '}';
    }
}
