package com.crm.filrouge.enumeration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ClientEnumConverter implements AttributeConverter<ClientEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ClientEnum attribute) {
        if (attribute == null) {
            return null;
        }

        switch (attribute) {
            case ACTIVE:
                return 1;
            case INACTIVE:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown value: " + attribute);
        }
    }

    @Override
    public ClientEnum convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        switch (dbData) {
            case 1:
                return ClientEnum.ACTIVE;
            case 0:
                return ClientEnum.INACTIVE;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }
}
