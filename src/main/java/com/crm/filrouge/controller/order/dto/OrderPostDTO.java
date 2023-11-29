package com.crm.filrouge.controller.order.dto;

import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.enumeration.OrderEnum;

import java.util.Objects;

public class OrderPostDTO {
    private String typePresta;
    private String designation;
    private Integer nbDays;
    private Double unitPrice;
    private OrderEnum state;
    private Client client;     // private Long clientId;


    public OrderPostDTO() {
    }

    public OrderPostDTO(String typePresta, String designation, Integer nbDays, Double unitPrice, OrderEnum state, Client client) {
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

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderPostDTO typePresta(String typePresta) {
        setTypePresta(typePresta);
        return this;
    }

    public OrderPostDTO designation(String designation) {
        setDesignation(designation);
        return this;
    }

    public OrderPostDTO nbDays(Integer nbDays) {
        setNbDays(nbDays);
        return this;
    }

    public OrderPostDTO unitPrice(Double unitPrice) {
        setUnitPrice(unitPrice);
        return this;
    }

    public OrderPostDTO state(OrderEnum state) {
        setState(state);
        return this;
    }

    public OrderPostDTO client(Client client) {
        setClient(client);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderPostDTO)) {
            return false;
        }
        OrderPostDTO orderPostDTO = (OrderPostDTO) o;
        return Objects.equals(typePresta, orderPostDTO.typePresta) && Objects.equals(designation, orderPostDTO.designation) && Objects.equals(nbDays, orderPostDTO.nbDays) && Objects.equals(unitPrice, orderPostDTO.unitPrice) && Objects.equals(state, orderPostDTO.state) && Objects.equals(client, orderPostDTO.client);
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
