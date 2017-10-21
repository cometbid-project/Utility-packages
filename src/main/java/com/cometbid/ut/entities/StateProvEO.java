/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.entities;

import com.cometbid.commerce.ut.common.DomainObject;
import com.cometbid.ut.embeddables.StateLgaEO;
import com.cometbid.ut.embeddables.StateCitiesEO;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author Gbenga
 */
@Entity
@Table(name = "STATE_PROV_TAB" /*,
       uniqueConstraints = {
        @UniqueConstraint(columnNames = {"STATE_PROVINCE", "COUNTRY_ID"})
        }*/
)
@XmlRootElement(name = "State/Province")
@NamedQueries({
    @NamedQuery(name = "StateProvEO.findAll",
            query = "SELECT s FROM StateProvEO s ORDER BY s.stateProvince")
    , @NamedQuery(name = "StateProvEO.findByStateId",
            query = "SELECT s FROM StateProvEO s WHERE s.stateId = :stateId ORDER BY s.stateProvince")
    , @NamedQuery(name = "StateProvEO.findByStateProvince",
            query = "SELECT s FROM StateProvEO s WHERE s.stateProvince = :stateProvince")
    , @NamedQuery(name = "StateProvEO.findByStateCode",
            query = "SELECT s FROM StateProvEO s WHERE s.stateCode = :stateCode")
    , @NamedQuery(name = "StateProvEO.findByStateNumCode",
            query = "SELECT s FROM StateProvEO s WHERE s.stateNumCode = :stateNumCode")
    , @NamedQuery(name = "StateProvEO.findByCountryName",
            query = "SELECT s FROM StateProvEO s WHERE UPPER(s.countryOb.country) = UPPER(:countryName)"
            + " ORDER BY s.stateProvince")
    , @NamedQuery(name = "StateProvEO.findByCountryId",
            query = "SELECT s FROM StateProvEO s WHERE s.countryOb.countryId = :countryId"
            + " ORDER BY s.stateProvince")
    , @NamedQuery(name = "StateProvEO.findByDescription",
            query = "SELECT s FROM StateProvEO s WHERE s.description = :description")
})
@Cacheable(true)
public class StateProvEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = 6899875986095095054L;

    /*
    @GenericGenerator(
    name = "StateProvEO_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "StateProvEO_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")
    }
    )*/
    @Id
    @Expose(serialize = true, deserialize = false)
    @TableGenerator(
            name = "StateProvEO_gen",
            table = "DB_PK_table",
            pkColumnValue = "StatesProv_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StateProvEO_gen")
    @Column(name = "STATE_ID")
    private Integer stateId;

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "STATE_ID", nullable = false)
    @Type(type = "objectid")
    private String stateId;
     */
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "STATE_PROVINCE", nullable = false, length = 100)
    private String stateProvince;

    @Column(name = "STATE_CODE", length = 3)
    private String stateCode;

    @Column(name = "STATE_NUM_CODE")
    @Expose(serialize = true, deserialize = false)
    private Integer stateNumCode;

    @Expose(serialize = true, deserialize = false)
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    @ManyToOne(optional = false)
    private CountryEO countryOb;

    @ElementCollection(targetClass = StateCitiesEO.class)
    @CollectionTable(name = "STATE_CITIES",
            joinColumns = @JoinColumn(name = "State_Prov_id"))
    private Set<StateCitiesEO> cities;

    @ElementCollection(targetClass = StateLgaEO.class)
    @CollectionTable(name = "STATE_COUNCILS",
            joinColumns = @JoinColumn(name = "State_Prov_id"))
    private Set<StateLgaEO> lgas;

    @Column(length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public StateProvEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        stateId = null;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Integer getStateNumCode() {
        return stateNumCode;
    }

    public void setStateNumCode(Integer stateNumCode) {
        this.stateNumCode = stateNumCode;
    }

    public CountryEO getCountryOb() {
        return countryOb;
    }

    public void setCountryOb(CountryEO countryOb) {
        this.countryOb = countryOb;
    }

    public Set<StateCitiesEO> getCities() {
        return cities;
    }

    public void setCities(Set<StateCitiesEO> cities) {
        this.cities = cities;
    }

    public Set<StateLgaEO> getLgas() {
        return lgas;
    }

    public void setLgas(Set<StateLgaEO> councils) {
        this.lgas = councils;
    }

    public void addStateCity(StateCitiesEO city) {
        if (this.cities == null) {
            this.cities = new HashSet<>();
        }
        this.cities.add(city);
    }

    public void removeStateCity(StateCitiesEO city) {
        this.cities.remove(city);
    }

    public void addStateCouncil(StateLgaEO council) {
        if (this.lgas == null) {
            this.lgas = new HashSet<>();
        }
        this.lgas.add(council);
    }

    public void removeStateCouncil(StateLgaEO council) {
        this.lgas.remove(council);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getVersion() {
        return version;
    }

    protected void setVersion(long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.getStateId());
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
        final StateProvEO other = (StateProvEO) obj;
        if (!Objects.equals(this.getStateId(), other.getStateId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StateProvEO{"
                + "stateId=" + this.getStateId()
                + ", stateProvince=" + this.getStateProvince()
                + ", stateCode=" + this.getStateCode()
                + ", stateNumCode=" + this.getStateNumCode()
                + ", country=" + this.getCountryOb()
                + '}';
    }

}
