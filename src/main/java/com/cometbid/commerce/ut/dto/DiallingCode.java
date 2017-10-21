/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.commerce.ut.dto;

import com.cometbid.commerce.ut.common.DomainObject;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gbenga
 */
@XmlRootElement(name = "DiallingCode")
public class DiallingCode extends DomainObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose(serialize = true, deserialize = false)
    private String diallingCode;

    @Expose(serialize = true, deserialize = false)
    private Integer countryId;

    public DiallingCode() {
        this("00", null);
    }

    public DiallingCode(Integer countryId) {
        this("00", countryId);
    }

    public DiallingCode(String diallingCode) {
        this(diallingCode, null);
    }

    public DiallingCode(String diallingCode, Integer countryId) {
        if (diallingCode == null) {
            diallingCode = "+00";
        }
        this.diallingCode = diallingCode;
        this.countryId = countryId;
    }

    public String getDiallingCode() {
        return diallingCode;
    }

    public void setDiallingCode(String diallingCode) {
        this.diallingCode = diallingCode;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.diallingCode);
        hash = 23 * hash + Objects.hashCode(this.countryId);
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
        final DiallingCode other = (DiallingCode) obj;
        if (!Objects.equals(this.diallingCode, other.diallingCode)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DiallingCode{"
                + "diallingCode=" + diallingCode
                + ", countryId=" + countryId
                + '}';
    }

}
