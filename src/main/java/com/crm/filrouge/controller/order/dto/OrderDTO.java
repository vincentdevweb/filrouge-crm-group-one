package com.crm.filrouge.controller.order.dto;

import com.crm.filrouge.controller.client.dto.ClientPostDTO;
import com.crm.filrouge.enumeration.OrderEnum;

import java.util.Objects;

public class OrderDTO {
    private String typePresta;
    private String designation;
    private Integer nbDays;
    private Double unitPrice;
    private OrderEnum state;
    private ClientPostDTO client;     // POST TDO


    public OrderDTO() {
    }

    public OrderDTO(String typePresta, String designation, Integer nbDays, Double unitPrice, OrderEnum state, ClientPostDTO client) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
        this.client = client;
    }

    public String getTypePresta() {
        return this.typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return this.nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Double getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderEnum getState() {
        return this.state;
    }

    public void setState(OrderEnum state) {
        this.state = state;
    }

    public ClientPostDTO getClient() {
        return this.client;
    }

    public void setClient(ClientPostDTO client) {
        this.client = client;
    }

    public OrderDTO typePresta(String typePresta) {
        setTypePresta(typePresta);
        return this;
    }

    public OrderDTO designation(String designation) {
        setDesignation(designation);
        return this;
    }

    public OrderDTO nbDays(Integer nbDays) {
        setNbDays(nbDays);
        return this;
    }

    public OrderDTO unitPrice(Double unitPrice) {
        setUnitPrice(unitPrice);
        return this;
    }

    public OrderDTO state(OrderEnum state) {
        setState(state);
        return this;
    }

    public OrderDTO client(ClientPostDTO client) {
        setClient(client);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderDTO)) {
            return false;
        }
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(typePresta, orderDTO.typePresta) && Objects.equals(designation, orderDTO.designation) && Objects.equals(nbDays, orderDTO.nbDays) && Objects.equals(unitPrice, orderDTO.unitPrice) && Objects.equals(state, orderDTO.state) && Objects.equals(client, orderDTO.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typePresta, designation, nbDays, unitPrice, state, client);
    }

    @Override
    public String toString() {
        return "{" +
            " typePresta='" + getTypePresta() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", nbDays='" + getNbDays() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", state='" + getState() + "'" +
            ", client='" + getClient() + "'" +
            "}";
    }


}
