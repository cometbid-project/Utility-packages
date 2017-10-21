/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cometbid.ut.converters;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Gbenga
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    /*
    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        if (date == null) {
            return null;
        }

        final Instant instant = date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        if (value == null) {
            return null;
        }

        final Instant instant = Instant.ofEpochMilli(value.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }
     */
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : java.sql.Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
