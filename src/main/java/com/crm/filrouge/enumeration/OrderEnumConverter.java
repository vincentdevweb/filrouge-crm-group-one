package com.crm.filrouge.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderEnumConverter implements AttributeConverter<OrderEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderEnum attribute) {
        if (attribute == null) {
            return null;
        }

        switch (attribute) {
            case CANCELED:
                return 0;
            case OPTION:
                return 1;
            case CONFIRMED:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown value: " + attribute);
        }
    }

    @Override
    public OrderEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        switch (dbData) {
            case 0:
                return OrderEnum.CANCELED;
            case 1:
                return OrderEnum.OPTION;
            case 2:
                return OrderEnum.CONFIRMED;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }
}