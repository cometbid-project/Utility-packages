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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
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
@Table(name = "COUNTRY_TAB")
@XmlRootElement(name = "Country")
@NamedQueries({
    @NamedQuery(name = "CountryEO.findAll",
            query = "SELECT c FROM CountryEO c ORDER BY c.country ASC")
    , @NamedQuery(name = "CountryEO.findByCountryId",
            query = "SELECT c FROM CountryEO c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "CountryEO.findByCountryCode",
            query = "SELECT c FROM CountryEO c WHERE c.countryCode = :countryCode")
    , @NamedQuery(name = "CountryEO.findByCountry",
            query = "SELECT c FROM CountryEO c WHERE c.country = :country")
    , @NamedQuery(name = "CountryEO.findByAlpha2Code",
            query = "SELECT c FROM CountryEO c WHERE c.alpha2Code = :alpha2Code")
    , @NamedQuery(name = "CountryEO.findByAlpha3Code",
            query = "SELECT c FROM CountryEO c WHERE c.alpha3Code = :alpha3Code")
    , @NamedQuery(name = "CountryEO.findByCapitalCity",
            query = "SELECT c FROM CountryEO c WHERE c.capitalCity = :capitalCity")
    , @NamedQuery(name = "CountryEO.findByPopulation",
            query = "SELECT c FROM CountryEO c WHERE c.population = :population")
    , @NamedQuery(name = "CountryEO.findByRegionId",
            query = "SELECT c FROM CountryEO c WHERE c.region = :region")
    , @NamedQuery(name = "CountryEO.findByDescription",
            query = "SELECT c FROM CountryEO c WHERE c.description = :description")}
)
@Cacheable(true)
public class CountryEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = 740806805960607980L;

    /*
    @GenericGenerator(
    name = "CountryEO_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "CountryEO_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")}
    )*/
    @Id
    @TableGenerator(
            name = "CountryEO_gen",
            table = "DB_PK_table",
            pkColumnValue = "Countries_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CountryEO_gen")
    @Expose(serialize = true, deserialize = false)
    @Column(name = "COUNTRY_ID")
    private Integer countryId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "COUNTRY_ID")
    @Type(type = "objectid")
    private String countryId;
     */
    @Column(name = "COUNTRY_CODE", nullable = false)
    @Expose(serialize = true, deserialize = false)
    private Integer countryCode;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(nullable = false, length = 100, unique = true)
    private String country;

    @Column(name = "ALPHA2_CODE", length = 2)
    private String alpha2Code;

    @Column(name = "ALPHA3_CODE", length = 3)
    private String alpha3Code;

    @Column(name = "CAPITAL_CITY", length = 50)
    private String capitalCity;

    @Column(name = "POPULATION")
    @ColumnDefault("0")
    private Long population;

    @JoinColumn(name = "STANDARD_CURRENCY_ID")
    @ManyToOne
    private CurrencyEO standardCurrency;

    @Expose(serialize = true, deserialize = false)
    @JoinColumn(name = "REGION_ID", nullable = false)
    @ManyToOne(optional = false)
    private RegionEO region;

    // @Expose(serialize = true, deserialize = false)
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "CALLING_CODES",
            joinColumns = @JoinColumn(name = "Country_ID"))
    @Column(name = "CALLING_CODE", nullable = false)
    private Set<String> callingCodes;

    // @Expose(serialize = true, deserialize = false)
    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "DIALLING_CODES",
            joinColumns = @JoinColumn(name = "Country_ID"))
    @Column(name = "DIALLING_CODE", nullable = true)
    private Set<String> diallingCodes;

    // @Expose(serialize = true, deserialize = false)
    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "PHONE_FORMATS",
            joinColumns = @JoinColumn(name = "Country_ID"))
    @Column(name = "PHONE_FORMAT", nullable = true)
    private Set<Integer> phoneFormats;

    @Column(name = "STATE_PROVINCES", nullable = false)
    @OneToMany(mappedBy = "countryOb", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @OrderBy("stateProvince ASC")
    private List<StateProvEO> stateProvList;

    @Column(length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public CountryEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        countryId = null;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public CurrencyEO getStandardCurrency() {
        return standardCurrency;
    }

    public void setStandardCurrency(CurrencyEO standardCurrency) {
        this.standardCurrency = standardCurrency;
    }

    public RegionEO getRegion() {
        return region;
    }

    public void setRegion(RegionEO region) {
        this.region = region;
    }

    public Set<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(Set<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public void addCallingCode(String callingCode) {
        if (this.callingCodes == null) {
            this.callingCodes = new HashSet<>();
        }
        this.callingCodes.add(callingCode);
    }

    public void removeCallingCode(String callingCode) {
        this.callingCodes.remove(callingCode);
    }

    public Set<String> getDiallingCodes() {
        return diallingCodes;
    }

    public void setDiallingCodes(Set<String> diallingCodes) {
        this.diallingCodes = diallingCodes;
    }

    public void addDiallingCode(String diallingCode) {
        if (this.diallingCodes == null) {
            this.diallingCodes = new HashSet<>();
        }
        this.diallingCodes.add(diallingCode);
    }

    public void removeDiallingCode(String diallingCode) {
        this.diallingCodes.remove(diallingCode);
    }

    public Set<Integer> getPhoneFormats() {
        return phoneFormats;
    }

    public void setPhoneFormats(Set<Integer> phoneFormats) {
        this.phoneFormats = phoneFormats;
    }

    public void addPhoneFormat(Integer phoneFormat) {
        if (this.phoneFormats == null) {
            this.phoneFormats = new HashSet<>();
        }
        this.phoneFormats.add(phoneFormat);
    }

    public void removePhoneFormat(Integer phoneFormat) {
        this.phoneFormats.remove(phoneFormat);
    }

    public List<StateProvEO> getStateProvList() {
        return stateProvList;
    }

    public void setStateProvList(List<StateProvEO> stateProvList) {
        this.stateProvList = stateProvList;
    }

    public void addStateProvToList(StateProvEO stateProv) {
        if (this.stateProvList == null) {
            this.stateProvList = new ArrayList<>();
        }
        this.stateProvList.add(stateProv);
    }

    public void removeStateProvFromList(StateProvEO stateProv) {
        this.stateProvList.remove(stateProv);
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getCountryId());
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
        final CountryEO other = (CountryEO) obj;
        if (!Objects.equals(this.getCountryId(), other.getCountryId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CountryEO{"
                + "countryId=" + this.getCountryId()
                + ", countryCode=" + this.getCountryCode()
                + ", country=" + this.getCountry()
                + ", alpha2Code=" + this.getAlpha2Code()
                + ", alpha3Code=" + this.getAlpha3Code()
                + ", capitalCity=" + this.getCapitalCity()
                + ", population=" + this.getPopulation()
                + ", standardCurrencyId=" + this.getStandardCurrency()
                + ", regionId=" + this.getRegion()
                + ", description=" + this.getDescription()
                + '}';
    }

}
