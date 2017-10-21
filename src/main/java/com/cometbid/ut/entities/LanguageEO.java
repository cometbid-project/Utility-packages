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
@Table(name = "LANGUAGE_TAB")
@XmlRootElement(name = "Language")
@NamedQueries({
    @NamedQuery(name = "LanguageEO.findAll",
            query = "SELECT l FROM LanguageEO l WHERE l.langSupported = true ORDER BY l.langName")
    , @NamedQuery(name = "LanguageEO.findByLangId",
            query = "SELECT l FROM LanguageEO l WHERE l.langId = :langId")
    , @NamedQuery(name = "LanguageEO.findByLangCode",
            query = "SELECT l FROM LanguageEO l WHERE l.langCode = :langCode")
    , @NamedQuery(name = "LanguageEO.findByLangName",
            query = "SELECT l FROM LanguageEO l WHERE l.langName = :langName")
    , @NamedQuery(name = "LanguageEO.findByDescription",
            query = "SELECT l FROM LanguageEO l WHERE l.description = :description")}
)
@Cacheable(true)
public class LanguageEO extends DomainObject implements Serializable {

    private static final long serialVersionUID = 87747856636386585L;

    /*@GenericGenerator(
    name = "LanguageEO_gen",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
    @Parameter(name = "sequence_name", value = "LanguageEO_seq")
    ,
    @Parameter(name = "initial_value", value = "1")
    ,
    @Parameter(name = "increment_size", value = "1")
    }
    )*/
    @Id
    @TableGenerator(
            name = "LanguageEO_gen",
            table = "DB_PK_table",
            pkColumnValue = "Languages_seq",
            valueColumnName = "SEQ_TYPE"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LanguageEO_gen")
    @Expose(serialize = true, deserialize = false)
    @Column(name = "LANG_ID", nullable = false)
    private Integer langId;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "LANG_ID", nullable = false)
    @Type(type = "objectid")
    private String langId;
     */
    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "LANG_CODE", nullable = false, length = 2)
    private String langCode;

    @Basic(optional = false)
    @Expose(serialize = true, deserialize = false)
    @Column(name = "LANG_NAME", nullable = false, length = 35, unique = true)
    private String langName;

    @Column(name = "LANG_SUPPORTED")
    @ColumnDefault("1")
    private Boolean langSupported = true;

    @Column(length = 500)
    private String description;

    @Version
    @ColumnDefault("1")
    private long version;

    public LanguageEO() {
    }

    @PrePersist
    protected void doBeforePersist() {
        langId = null;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public boolean isLangSupported() {
        return langSupported;
    }

    public void setLangSupported(Boolean langSupported) {
        this.langSupported = langSupported;
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.getLangId());
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
        final LanguageEO other = (LanguageEO) obj;
        if (!Objects.equals(this.getLangId(), other.getLangId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LanguageEO{" + "langId=" + this.getLangId()
                + ", langCode=" + this.getLangCode()
                + ", langName=" + this.getLangName()
                + ", langSupported=" + this.isLangSupported()
                + '}';
    }

}
