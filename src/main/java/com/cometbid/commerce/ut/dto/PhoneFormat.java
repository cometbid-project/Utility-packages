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
@XmlRootElement(name = "PhoneFormat")
public class PhoneFormat extends DomainObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose(serialize = true, deserialize = false)
    private Integer phoneFormat;

    @Expose(serialize = true, deserialize = false)
    private Integer countryId;

    public PhoneFormat() {
        this(0, null);
    }

    public PhoneFormat(Integer countryId) {
        this(0, countryId);
    }

    public PhoneFormat(Integer phoneFormat, Integer countryId) {
        if (phoneFormat == null) {
            phoneFormat = 0;
        }
        this.phoneFormat = phoneFormat;
        this.countryId = countryId;
    }

    public Integer getPhoneFormat() {
        return phoneFormat;
    }

    public void setPhoneFormat(Integer phoneFormat) {
        this.phoneFormat = phoneFormat;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.phoneFormat);
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
        final PhoneFormat other = (PhoneFormat) obj;
        if (!Objects.equals(this.phoneFormat, other.phoneFormat)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PhoneFormat{"
                + "phoneFormat=" + phoneFormat
                + ", countryId=" + countryId
                + '}';
    }

}
