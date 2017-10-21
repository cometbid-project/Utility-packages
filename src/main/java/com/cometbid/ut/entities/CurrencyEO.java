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
@Table(name = "CURRENCY_TAB")
@XmlRootElement(name = "Currency")
@NamedQueries({
    @NamedQuery(name = "CurrencyEO.findAll",
            query = "SELECT c FROM CurrencyEO c WHERE c.currencySupported = true ORDER BY c.currency")
    , @NamedQuery(name = "CurrencyEO.findByCurrencyId",
            query = "SELECT c FROM CurrencyEO c WHERE c.currencyId = :currencyId")
    , @NamedQuery(name = "CurrencyEO.findByCurrency",
            query = "SELECT c FROM CurrencyEO c WHERE c.currency = :currency")
    , @NamedQuery(name = "CurrencyEO.findByCurrCode",
            query = "SELECT c FROM CurrencyEO c WHERE c.currCode = :currCode")
    , @NamedQuery(name = "CurrencyEO.findByExRate",
            query = "SELECT c FROM CurrencyEO c WHERE c.exRate = :exRate")
    , @NamedQuery(name = "CurrencyEO.findByHtmlSymbol",
            query = "SELECT c FROM CurrencyEO c WHERE c.htmlSymbol = :htmlSymbol")
    , @NamedQuery(name = "CurrencyEO.findByDescription",
            query = "SELECT c FROM CurrencyEO c WHERE c.description = :description")}
)
@Cacheable(true)
public class CurrencyEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = -87757577765658565L;

    /*@GenericGenerator(
    name = "CurrencyEO_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "CurrencyEO_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")
    }
    )
     */
    @Id
    @TableGenerator(
            name = "CurrencyEO_gen",
            table = "DB_PK_table",
            pkColumnValue = "Currencies_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CurrencyEO_gen")
    @Expose(serialize = true, deserialize = false)
    @Column(name = "CURRENCY_ID")
    private Integer currencyId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "CURRENCY_ID", nullable = false)
    @Type(type = "objectid")
    private String currencyId;
     */
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(nullable = false, length = 100, unique = true)
    private String currency;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "CURR_CODE", nullable = false, length = 3, unique = true)
    private String currCode;

    @Column(name = "EX_RATE", precision = 8, scale = 2)
    private Double exRate;

    @Column(name = "HTML_SYMBOL", length = 70)
    @Expose(serialize = true, deserialize = false)
    private String htmlSymbol;

    @Column(name = "CURRENCY_SUPPORTED")
    @ColumnDefault("1")
    private Boolean currencySupported = true;

    @Column(length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public CurrencyEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        currencyId = null;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }

    public Double getExRate() {
        return exRate;
    }

    public void setExRate(Double exRate) {
        this.exRate = exRate;
    }

    public String getHtmlSymbol() {
        return htmlSymbol;
    }

    public void setHtmlSymbol(String htmlSymbol) {
        this.htmlSymbol = htmlSymbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCurrencySupported() {
        return currencySupported;
    }

    public void setCurrencySupported(Boolean currencySupported) {
        this.currencySupported = currencySupported;
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
        hash = 13 * hash + Objects.hashCode(this.currencyId);
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
        final CurrencyEO other = (CurrencyEO) obj;
        if (!Objects.equals(this.currencyId, other.currencyId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CurrencyEO{"
                + "currencyId=" + this.getCurrencyId()
                + ", currency=" + this.getCurrency()
                + ", currCode=" + this.getCurrCode()
                + ", exRate=" + this.getExRate()
                + ", htmlSymbol=" + this.getHtmlSymbol()
                + '}';
    }

}
