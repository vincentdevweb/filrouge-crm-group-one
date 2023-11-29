package com.crm.filrouge.controller.client.dto;

import java.util.ArrayList;
import java.util.List;

import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.dao.Order.Order;


public class ClientMapper {

        public static ClientPostDTO convertFromEntityToPostDto(Client entity) {
        ClientPostDTO postDTO = new ClientPostDTO();
        postDTO.setAdd(entity.getAddress());
        postDTO.setCity(entity.getCity());
        postDTO.setCname(entity.getCompanyName());
        postDTO.setCountry(entity.getCountry());
        postDTO.setEmail(entity.getEmail());
        postDTO.setFname(entity.getFirstName());
        postDTO.setLname(entity.getLastName());
        postDTO.setState(entity.getState());
        postDTO.setZCode(entity.getZipCode());
        postDTO.setTel(entity.getPhone());
        return postDTO;
    }

    public static ClientDTO convertFromEntityToDto(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getFirstName());
        dto.setState(entity.getState());
        List<Order> orders = new ArrayList<>();
        for (Order order : entity.getOrders()) {
            // Order newOrder = new Order();
            // newOrder.setId(order.getId());
            // newOrder.setTypePresta(order.getTypePresta());
            // newOrder.setNbDays(order.getNbDays());
            // newOrder.setTotalExcludeTaxe(order.getTotalExcludeTaxe());
            // newOrder.setUnitPrice(order.getUnitPrice());
            // newOrder.setDesignation(order.getDesignation());
            order.setClient(null);
            orders.add(order);
        }
        dto.setOrders(orders);
        return dto;
    }

    public static Client convertFromDtoToEntity(ClientPostDTO dto) {
    Client entity = new Client();
    entity.setAddress(dto.getAdd());
    entity.setCity(dto.getCity());
    entity.setCountry(dto.getCountry());;
    entity.setCompanyName(dto.getCname());
    entity.setEmail(dto.getEmail());
    entity.setFirstName(dto.getFname());
    entity.setLastName(dto.getLname());
    entity.setPhone(dto.getTel());
    entity.setState(dto.getState());
    entity.setZipCode(dto.getZCode());
    return entity;
    }
}
