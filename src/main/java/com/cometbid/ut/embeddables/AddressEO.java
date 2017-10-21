/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import com.cometbid.ut.entities.CountryEO;
import com.cometbid.ut.entities.StateProvEO;
import com.cometbid.ut.enums.StatusType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Gbenga
 */
// @Entity
@Embeddable //(name = "CUST_ADDRESS_VIEW", catalog = "", schema = "USR")
// @XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "CustAddressEO.findAll", query = "SELECT c FROM CustAddressEO c")
    , @NamedQuery(name = "CustAddressEO.findByCustomerId", 
            query = "SELECT c FROM CustAddressEO c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustAddressEO.findByAddrId",
            query = "SELECT c FROM CustAddressEO c WHERE c.addrId = :addrId")
    , @NamedQuery(name = "CustAddressEO.findByStreetAddr1", 
            query = "SELECT c FROM CustAddressEO c WHERE c.streetAddr1 = :streetAddr1")
    , @NamedQuery(name = "CustAddressEO.findByStreetAddr2", 
            query = "SELECT c FROM CustAddressEO c WHERE c.streetAddr2 = :streetAddr2")
    , @NamedQuery(name = "CustAddressEO.findByPostalCode", 
            query = "SELECT c FROM CustAddressEO c WHERE c.postalCode = :postalCode")
    , @NamedQuery(name = "CustAddressEO.findByZipCode", 
            query = "SELECT c FROM CustAddressEO c WHERE c.zipCode = :zipCode")
    , @NamedQuery(name = "CustAddressEO.findByCountryRef", 
            query = "SELECT c FROM CustAddressEO c WHERE c.countryRef = :countryRef")
    , @NamedQuery(name = "CustAddressEO.findByStateProRef", 
            query = "SELECT c FROM CustAddressEO c WHERE c.stateProRef = :stateProRef")
    , @NamedQuery(name = "CustAddressEO.findByPostalCity",
            query = "SELECT c FROM CustAddressEO c WHERE c.postalCity = :postalCity")
    , @NamedQuery(name = "CustAddressEO.findByPriority", 
            query = "SELECT c FROM CustAddressEO c WHERE c.priority = :priority")
    , @NamedQuery(name = "CustAddressEO.findByStatus", 
            query = "SELECT c FROM CustAddressEO c WHERE c.status = :status")
    , @NamedQuery(name = "CustAddressEO.findByDateStored", 
            query = "SELECT c FROM CustAddressEO c WHERE c.dateStored = :dateStored")
    , @NamedQuery(name = "CustAddressEO.findByDateUpdated", 
            query = "SELECT c FROM CustAddressEO c WHERE c.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "CustAddressEO.findByDescription", 
            query = "SELECT c FROM CustAddressEO c WHERE c.description = :description")}
)
 */
public class AddressEO implements Serializable {

    @Column(name = "ADDR_ID", nullable = false)
    private String addrId;

    @Column(name = "STREET_ADDR1", length = 100)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String streetAddr1;

    @Column(name = "STREET_ADDR2", length = 100)
    private String streetAddr2;

    @Column(name = "POSTAL_CODE", length = 15)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String postalCode;

    /* 
    @Column(name = "ZIP_CODE", length = 20)
    private String zipCode;
     */
    @JoinColumn(name = "COUNTRY_REF", nullable = false)
    @IndexedEmbedded
    @OneToOne
    private CountryEO countryRef;

    @JoinColumn(name = "STATE_PROV_REF", nullable = false)
    @IndexedEmbedded
    @OneToOne
    private StateProvEO stateProRef;

    @Column(name = "POSTAL_CITY", length = 100)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String postalCity;

    @NumericField
    @Column(name = "ADDR_PRIORITY", nullable = false)
    private int priority;

    @Column(name = "ADDR_STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "DATE_ADDR_STORED")
    // @Temporal(TemporalType.TIMESTAMP)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private LocalDateTime dateStored;

    @Column(name = "DATE_ADDR_UPDATED")
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateUpdated;

    @Column(length = 200)
    private String description;

    public AddressEO() {
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public String getStreetAddr1() {
        return streetAddr1;
    }

    public void setStreetAddr1(String streetAddr1) {
        this.streetAddr1 = streetAddr1;
    }

    public String getStreetAddr2() {
        return streetAddr2;
    }

    public void setStreetAddr2(String streetAddr2) {
        this.streetAddr2 = streetAddr2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /*
    public String getZipCode() {
    return zipCode;
    }
    
    public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
    }
     */
    public CountryEO getCountryRef() {
        return countryRef;
    }

    public void setCountryRef(CountryEO countryRef) {
        this.countryRef = countryRef;
    }

    public StateProvEO getStateProRef() {
        return stateProRef;
    }

    public void setStateProRef(StateProvEO stateProRef) {
        this.stateProRef = stateProRef;
    }

    public String getPostalCity() {
        return postalCity;
    }

    public void setPostalCity(String postalCity) {
        this.postalCity = postalCity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public LocalDateTime getDateStored() {
        return dateStored;
    }

    public void setDateStored(LocalDateTime dateStored) {
        this.dateStored = dateStored;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.getAddrId());
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
        final AddressEO other = (AddressEO) obj;
        if (!Objects.equals(this.getAddrId(), other.getAddrId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AddressEO{"
                + "addrId=" + this.getAddrId()
                + ", streetAddr1=" + this.getStreetAddr1()
                + ", streetAddr2=" + this.getStreetAddr2()
                + ", postalCode=" + this.getPostalCode()
                //  + ", zipCode=" + this.getZipCode()
                + ", countryRef=" + this.getCountryRef()
                + ", stateProRef=" + this.getStateProRef()
                + ", postalCity=" + this.getPostalCity()
                + ", priority=" + this.getPriority()
                + ", status=" + this.getStatus()
                + ", dateStored=" + this.getDateStored()
                + ", dateUpdated=" + this.getDateUpdated()
                + ", description=" + this.getDescription()
                + '}';
    }

}
