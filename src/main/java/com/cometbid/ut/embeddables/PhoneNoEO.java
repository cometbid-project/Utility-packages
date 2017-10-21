/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import com.cometbid.ut.entities.CountryEO;
import com.cometbid.ut.enums.PhoneNoType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.search.annotations.NumericField;

/**
 *
 * @author Gbenga
 */
//@Entity
@Embeddable
// @Table(name = "CUST_PHONE_NO_VIEW", catalog = "", schema = "USR")
// @XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "CustPhoneNoView.findAll", 
            query = "SELECT c FROM CustPhoneNoView c")
    , @NamedQuery(name = "CustPhoneNoView.findByCustomerId", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustPhoneNoView.findByPhoneNoId", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.phoneNoId = :phoneNoId")
    , @NamedQuery(name = "CustPhoneNoView.findByPhoneNo", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.phoneNo = :phoneNo")
    , @NamedQuery(name = "CustPhoneNoView.findByPhoneNoType", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.phoneNoType = :phoneNoType")
    , @NamedQuery(name = "CustPhoneNoView.findByCountryId", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "CustPhoneNoView.findByPriority", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.priority = :priority")
    , @NamedQuery(name = "CustPhoneNoView.findByStatus", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.status = :status")
    , @NamedQuery(name = "CustPhoneNoView.findByDateStored", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.dateStored = :dateStored")
    , @NamedQuery(name = "CustPhoneNoView.findByDateUpdated",
            query = "SELECT c FROM CustPhoneNoView c WHERE c.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "CustPhoneNoView.findByDescription", 
            query = "SELECT c FROM CustPhoneNoView c WHERE c.description = :description")}
)
 */
public class PhoneNoEO implements Serializable {

    // private static final long serialVersionUID = 785695069456905645L;
    @Column(name = "PHONE_NO_ID", nullable = false)
    private String phoneNoId;

    @Column(name = "PHONE_NO", length = 25, nullable = false)
    private String phoneNo;

    @Column(name = "PHONE_NO_TYPE", length = 30)
    @Enumerated(EnumType.STRING)
    private PhoneNoType phoneNoType;

    @OneToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private CountryEO countryId;

    @NumericField
    @Column(name = "PHONE_PRIORITY", nullable = false)
    private int priority;

    @Column(name = "PHONE_STATUS", nullable = false, length = 30)
    private String status;

    @Column(name = "PHONE_DATE_STORED")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateStored;

    @Column(name = "PHONE_DATE_UPDATED")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateUpdated;

    @Column(length = 200)
    private String description;

    public PhoneNoEO() {
    }

    public String getPhoneNoId() {
        return phoneNoId;
    }

    public void setPhoneNoId(String phoneNoId) {
        this.phoneNoId = phoneNoId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public PhoneNoType getPhoneNoType() {
        return phoneNoType;
    }

    public void setPhoneNoType(PhoneNoType phoneNoType) {
        this.phoneNoType = phoneNoType;
    }

    public CountryEO getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryEO countryId) {
        this.countryId = countryId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getPhoneNoId());
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
        final PhoneNoEO other = (PhoneNoEO) obj;
        if (!Objects.equals(this.getPhoneNoId(), other.getPhoneNoId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhoneNoEO{"
                + "phoneNoId=" + this.getPhoneNoId()
                + ", phoneNo=" + this.getPhoneNo()
                + ", phoneNoType=" + this.getPhoneNoType()
                + ", countryId=" + this.getCountryId()
                + ", priority=" + this.getPriority()
                + ", status=" + this.getStatus()
                + ", dateStored=" + this.getDateStored()
                + ", dateUpdated=" + this.getDateUpdated()
                + ", description=" + this.getDescription()
                + '}';
    }

}
