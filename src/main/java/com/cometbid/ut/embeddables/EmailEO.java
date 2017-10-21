/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import com.cometbid.ut.enums.StatusType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.search.annotations.NumericField;

/**
 *
 * @author Gbenga
 */
//@Entity
@Embeddable
// @Table(name = "CUST_EMAIL_VIEW", catalog = "", schema = "USR")
// @XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "EmailEO.findAll", query = "SELECT c FROM EmailEO c")
    , @NamedQuery(name = "EmailEO.findByCustomerId",
            query = "SELECT c FROM EmailEO c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "EmailEO.findByEmailId",
            query = "SELECT c FROM EmailEO c WHERE c.emailId = :emailId")
    , @NamedQuery(name = "EmailEO.findByEmail",
            query = "SELECT c FROM EmailEO c WHERE c.email = :email")
    , @NamedQuery(name = "EmailEO.findByPriority",
            query = "SELECT c FROM EmailEO c WHERE c.priority = :priority")
    , @NamedQuery(name = "EmailEO.findByStatus",
            query = "SELECT c FROM EmailEO c WHERE c.status = :status")
    , @NamedQuery(name = "EmailEO.findByDateStored",
            query = "SELECT c FROM EmailEO c WHERE c.dateStored = :dateStored")
    , @NamedQuery(name = "EmailEO.findByDateUpdated",
            query = "SELECT c FROM EmailEO c WHERE c.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "EmailEO.findByDescription",
            query = "SELECT c FROM EmailEO c WHERE c.description = :description")}
)
 */
public class EmailEO implements Serializable {

    // private static final long serialVersionUID = 578774629894279585L;

    @Column(name = "EMAIL_ID", nullable = false)
    private String emailId;

    @Column(length = 100, nullable = false)
    private String email;

    @NumericField
    @Column(name = "EMAIL_PRIORITY", nullable = false)
    private int priority;

    @Column(name = "EMAIL_STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "EMAIL_DATE_STORED")
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateStored;

    @Column(name = "EMAIL_DATE_UPDATED")
   // @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateUpdated;

    @Column(length = 200)
    private String description;

    public EmailEO() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash = 97 * hash + Objects.hashCode(this.getEmailId());
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
        final EmailEO other = (EmailEO) obj;
        if (!Objects.equals(this.getEmailId(), other.getEmailId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmailEO{"
                + "emailId=" + this.getEmailId()
                + ", email=" + this.getEmail()
                + ", priority=" + this.getPriority()
                + ", status=" + this.getStatus()
                + ", dateStored=" + this.getDateStored()
                + ", dateUpdated=" + this.getDateUpdated()
                + ", description=" + this.getDescription()
                + '}';
    }

}
