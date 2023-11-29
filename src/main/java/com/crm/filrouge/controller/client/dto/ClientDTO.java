package com.crm.filrouge.controller.client.dto;

import java.util.List;

import com.crm.filrouge.dao.Order.Order;
import com.crm.filrouge.enumeration.ClientEnum;

import java.util.Objects;

public class ClientDTO {
    private String name;
    private String email;
    private ClientEnum state;
    private List<Order> orders;


    public ClientDTO() {
    }

    public ClientDTO(String name, String email, ClientEnum state, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.state = state;
        this.orders = orders;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientEnum getState() {
        return this.state;
    }

    public void setState(ClientEnum state) {
        this.state = state;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ClientDTO name(String name) {
        setName(name);
        return this;
    }

    public ClientDTO email(String email) {
        setEmail(email);
        return this;
    }

    public ClientDTO state(ClientEnum state) {
        setState(state);
        return this;
    }

    public ClientDTO orders(List<Order> orders) {
        setOrders(orders);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientDTO)) {
            return false;
        }
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(name, clientDTO.name) && Objects.equals(email, clientDTO.email) && Objects.equals(state, clientDTO.state) && Objects.equals(orders, clientDTO.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, state, orders);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", state='" + getState() + "'" +
            ", orders='" + getOrders() + "'" +
            "}";
    }
 

}