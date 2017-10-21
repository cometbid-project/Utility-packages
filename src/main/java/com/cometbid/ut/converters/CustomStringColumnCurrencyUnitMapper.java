/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.converters;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import org.jadira.usertype.spi.shared.AbstractStringColumnMapper;

/**
 *
 * @author Gbenga
 */
public class CustomStringColumnCurrencyUnitMapper extends AbstractStringColumnMapper<CurrencyUnit> {

    private static final long serialVersionUID = -9337890199015880L;

    public CustomStringColumnCurrencyUnitMapper() {
    }

    @Override
    public CurrencyUnit fromNonNullValue(String value) {
        return Monetary.getCurrency(value);
    }

    @Override
    public String toNonNullValue(CurrencyUnit value) {
        return value.getCurrencyCode();
    }

}
