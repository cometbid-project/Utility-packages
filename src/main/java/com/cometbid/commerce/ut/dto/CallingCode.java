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
@XmlRootElement(name = "CallingCode")
public class CallingCode extends DomainObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose(serialize = true, deserialize = false)
    private String callingCode;

    @Expose(serialize = true, deserialize = false)
    private Integer countryId;

    public CallingCode() {
        this("00", null);
    }

    public CallingCode(Integer countryId) {
        this("00", countryId);
    }

    public CallingCode(String callingCode) {
        this(callingCode, null);
    }

    public CallingCode(String callingCode, Integer countryId) {
        if (callingCode == null) {
            callingCode = "00";
        }
        this.callingCode = callingCode;
        this.countryId = countryId;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String CallingCode) {
        this.callingCode = CallingCode;
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
        hash = 71 * hash + Objects.hashCode(this.callingCode);
        hash = 71 * hash + Objects.hashCode(this.countryId);
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
        final CallingCode other = (CallingCode) obj;
        if (!Objects.equals(this.callingCode, other.callingCode)) {
            return false;
        }
        if (!Objects.equals(this.countryId, other.countryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CallingCode{"
                + "callingCode=" + callingCode
                + ", countryId=" + countryId
                + '}';
    }

}
