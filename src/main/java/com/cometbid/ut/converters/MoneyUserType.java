/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.converters;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.javamoney.moneta.Money;

/**
 *
 * @author Gbenga
 */
public class MoneyUserType implements CompositeUserType {

    private static final String[] PROPERTY_NAMES = {"amount", "currencyUnit"};
    private static final Type[] PROPERTY_TYPES = {StandardBasicTypes.BIG_DECIMAL, StandardBasicTypes.CURRENCY};

    public MoneyUserType() {
        super();
    }

    @Override
    public Object assemble(final Serializable cached, final SessionImplementor session, final Object owner)
            throws HibernateException {
        return cached;
    }

    @Override
    public Serializable disassemble(final Object value, final SessionImplementor session) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES.clone();
    }

    @Override
    public Type[] getPropertyTypes() {
        return PROPERTY_TYPES.clone();
    }

    @Override
    public Object getPropertyValue(final Object component, final int property) throws HibernateException {
        
        MonetaryAmount money = (MonetaryAmount) component;
        return (property == 0) ? BigDecimal.valueOf(money.getNumber().doubleValue()): money.getCurrency();
    }

    @Override
    public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session,
            final Object owner) throws HibernateException, SQLException {
        
        BigDecimal amount = StandardBasicTypes.BIG_DECIMAL.nullSafeGet(rs, names[0], session);
        Currency currency = StandardBasicTypes.CURRENCY.nullSafeGet(rs, names[1], session);
        return Money.of(amount, Monetary.getCurrency(currency.getCurrencyCode()));
    }

    @Override
    public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
            final SessionImplementor session) throws HibernateException, SQLException {
        
        MonetaryAmount money = (MonetaryAmount) value;
        BigDecimal amount = (money == null) ? null : BigDecimal.valueOf(money.getNumber().doubleValue());
        CurrencyUnit currency = (money == null) ? null : money.getCurrency();

        StandardBasicTypes.BIG_DECIMAL.nullSafeSet(st, amount, index, session);
        StandardBasicTypes.CURRENCY.nullSafeSet(st, currency, index + 1, session);
    }

    @Override
    public Object replace(final Object original, final Object target, final SessionImplementor session,
            final Object owner) throws HibernateException {
        return deepCopy(original);
    }

    @Override
    public void setPropertyValue(final Object component, final int property, final Object value)
            throws HibernateException {
        throw new HibernateException("Money is immutable.");
    }

    @Override
    public Object deepCopy(final Object value) throws HibernateException {
        NumberValue moneyValue = ((MonetaryAmount) value).getNumber();
        CurrencyUnit currency = ((MonetaryAmount) value).getCurrency();

        return (value != null) ? Money.of(BigDecimal.valueOf(moneyValue.doubleValue()), currency) : null;
    }

    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException {
        return ObjectUtils.equals(x, y);
    }

    @Override
    public int hashCode(final Object x) throws HibernateException {
        return ObjectUtils.hashCode(x);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Class<?> returnedClass() {
        return MonetaryAmount.class;
    }
}
