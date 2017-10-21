/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.embeddables;

import com.cometbid.ut.enums.PreferenceOptionType;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gbenga
 */
@Embeddable
// @Table(name = "USER_PREFERENCE_VIEW", catalog = "", schema = "USR")
// @Table(name = "USER_PREFERENCES")
// @XmlRootElement
/*
@NamedQueries({
    @NamedQuery(name = "PreferencesEO.findAll",
            query = "SELECT u FROM PreferencesEO u")
    , @NamedQuery(name = "PreferencesEO.findByPrefId",
            query = "SELECT u FROM PreferencesEO u WHERE u.prefId = :prefId")
    , @NamedQuery(name = "PreferencesEO.findByPrefOptionTyp",
            query = "SELECT u FROM PreferencesEO u WHERE u.prefOptionTyp = :prefOptionTyp")
    , @NamedQuery(name = "PreferencesEO.findByPrefName",
            query = "SELECT u FROM PreferencesEO u WHERE u.prefName = :prefName")
    , @NamedQuery(name = "PreferencesEO.findByDescription",
            query = "SELECT u FROM PreferencesEO u WHERE u.description = :description")}
)
 */
public class PreferencesEO implements Serializable {

    // private static final long serialVersionUID = 93739559059695670L;

    @Basic(optional = false)
    @Column(name = "OPTION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PreferenceOptionType prefOptionTyp;

    @Basic(optional = false)
    @Column(name = "PREF_NAME", nullable = false, length = 50)
    private String prefName;

    @Column(length = 500)
    private String description;

    public PreferencesEO() {
    }

    public PreferenceOptionType getPrefOptionTyp() {
        return prefOptionTyp;
    }

    public void setPrefOptionTyp(PreferenceOptionType prefOptionTyp) {
        this.prefOptionTyp = prefOptionTyp;
    }

    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PreferenceEO{"
                + ", prefOptionTyp=" + this.getPrefOptionTyp()
                + ", prefName=" + this.getPrefName()
                + ", description=" + this.getDescription()
                + '}';
    }

}
