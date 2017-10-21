/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.entities;

import com.cometbid.commerce.ut.common.DomainObject;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ACCOUNT_TYPES")
// @Table(name = "ACCOUNT_TYPES", catalog = "", schema = "USR")
@XmlRootElement(name = "Subscription")
@NamedQueries({
    @NamedQuery(name = "AccountTypeEO.findAll", query = "SELECT a FROM AccountTypeEO a")
    , @NamedQuery(name = "AccountTypeEO.findByAcctTypeId",
            query = "SELECT a FROM AccountTypeEO a WHERE a.acctTypeId = :acctTypeId")
    , @NamedQuery(name = "AccountTypeEO.findByAccountType",
            query = "SELECT a FROM AccountTypeEO a WHERE a.accountType = :accountType")
    , @NamedQuery(name = "AccountTypeEO.findBySpaceQuota",
            query = "SELECT a FROM AccountTypeEO a WHERE a.spaceQuota = :spaceQuota")
    , @NamedQuery(name = "AccountTypeEO.findByPercTranFee",
            query = "SELECT a FROM AccountTypeEO a WHERE a.percTranFee = :percTranFee")
    , @NamedQuery(name = "AccountTypeEO.findByDescription",
            query = "SELECT a FROM AccountTypeEO a WHERE a.description = :description")
})
@Cacheable(true)
public class AccountTypeEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    @GenericGenerator(
    name = "AccountType_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "AccountType_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")
    }
    )
     */
    @Id
    @TableGenerator(
            name = "AccountType_gen",
            table = "DB_PK_table",
            pkColumnValue = "AccountType_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AccountType_gen")
  //  @Expose(serialize = true, deserialize = false)
    @Column(name = "ACCT_TYPE_ID")
    private Integer acctTypeId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "ACCT_TYPE_ID", nullable = false)
    @Type(type = "objectid")
    private String acctTypeId;
     */
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "ACCOUNT_TYPE", nullable = false, length = 50, unique = true)
    private String accountType;

    // @Max(value=?)  @Min(value=?)
    // if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "SPACE_QUOTA", nullable = false, precision = 20, scale = 2)
    private Double spaceQuota;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "PERC_TRAN_FEE", nullable = false, precision = 8, scale = 2)
    private Double percTranFee;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "DESCRIPTION", nullable = false, length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public AccountTypeEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        acctTypeId = null;
    }

    public Integer getAcctTypeId() {
        return acctTypeId;
    }

    /*
    public void setAcctTypeId(int acctTypeId) {
    this.acctTypeId = acctTypeId;
    }
     */
    public String getAccountType() {
        return accountType;
    }

    /*
    public void setAccountType(String accountType) {
    this.accountType = accountType;
    }
     */
    public Double getSpaceQuota() {
        return spaceQuota;
    }

    /*
    public void setSpaceQuota(double spaceQuota) {
    this.spaceQuota = spaceQuota;
    }
     */
    public Double getPercTranFee() {
        return percTranFee;
    }

    /*
    public void setPercTranFee(double percTranFee) {
    this.percTranFee = percTranFee;
    }
     */
    public String getDescription() {
        return description;
    }

    /*
    public void setDescription(String description) {
    this.description = description;
    }
     */
    public long getVersion() {
        return version;
    }

    protected void setVersion(long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.acctTypeId);
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
        final AccountTypeEO other = (AccountTypeEO) obj;
        if (!Objects.equals(this.acctTypeId, other.acctTypeId)) {
            return false;
        }
        return true;
    }

}
