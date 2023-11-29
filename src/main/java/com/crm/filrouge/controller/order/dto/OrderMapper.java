package com.crm.filrouge.controller.order.dto;

import com.crm.filrouge.controller.client.dto.ClientMapper;
import com.crm.filrouge.dao.Order.Order;

public class OrderMapper {
    public static OrderDTO convertFromEntityToDto(Order entity) {
        OrderDTO dto = new OrderDTO();
        entity.getClient().setOrders(null);
        dto.setClient(ClientMapper.convertFromEntityToPostDto(entity.getClient())); //setClient est un ClientPostTDO
        dto.setDesignation(entity.getDesignation());
        dto.setNbDays(entity.getNbDays());

        dto.setState(entity.getState());
        dto.setTypePresta(entity.getTypePresta());
        dto.setUnitPrice(entity.getUnitPrice());

        // Client newClient = new Client();
        // newClient.setId(entity.getClient().getId());
        // dto.setClient(newClient);

        return dto;
    }

    public static Order convertFromDtoToEntity(OrderPostDTO dto) {
    Order entity = new Order();
    entity.setClient(dto.getClient());
    entity.setDesignation(dto.getDesignation());
    entity.setNbDays(dto.getNbDays());

    entity.setState(dto.getState());
    entity.setTypePresta(dto.getTypePresta());
    entity.setUnitPrice(dto.getUnitPrice());

    // Client newClient = new Client();
    // newClient.setId(entity.getClient().getId());
    // entity.setClient(newClient);

    return entity;
    }
}
