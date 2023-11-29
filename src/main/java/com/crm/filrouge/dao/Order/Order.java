package com.crm.filrouge.dao.Order;

import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.enumeration.OrderEnum;
import com.crm.filrouge.enumeration.OrderEnumConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String typePresta;

    @Column(nullable = false, length = 100)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Column(nullable = false)
    private Integer nbDays;

    @Column(nullable = false, columnDefinition = "NUMERIC")
    private Double unitPrice;

    @Column(nullable = false, columnDefinition = "NUMERIC", insertable = false, updatable = false)
    private Double totalExcludeTaxe;

    @Column(nullable = false, columnDefinition = "NUMERIC", insertable = false, updatable = false)
    private Double totalWithTaxe;

    @Column(nullable = false)
    @Convert(converter = OrderEnumConverter.class)
    private OrderEnum state;

    public Order() {
    }

    public Order(Integer id, String typePresta, String designation, Client client, Integer nbDays, Double unitPrice,
            Double totalExcludeTaxe, Double totalWithTaxe, OrderEnum state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.state = state;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Double getTotalExcludeTaxe() {
        return this.totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return this.totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderEnum getState() {
        return this.state;
    }

    public void setState(OrderEnum state) {
        this.state = state;
    }

    public Order id(Integer id) {
        setId(id);
        return this;
    }

    public Order typePresta(String typePresta) {
        setTypePresta(typePresta);
        return this;
    }

    public Order designation(String designation) {
        setDesignation(designation);
        return this;
    }

    public Order client(Client client) {
        setClient(client);
        return this;
    }

    public Order nbDays(Integer nbDays) {
        setNbDays(nbDays);
        return this;
    }

    public Order unitPrice(Double unitPrice) {
        setUnitPrice(unitPrice);
        return this;
    }

    public Order totalExcludeTaxe(Double totalExcludeTaxe) {
        setTotalExcludeTaxe(totalExcludeTaxe);
        return this;
    }

    public Order totalWithTaxe(Double totalWithTaxe) {
        setTotalWithTaxe(totalWithTaxe);
        return this;
    }

    public Order state(OrderEnum state) {
        setState(state);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(typePresta, order.typePresta)
                && Objects.equals(designation, order.designation) && Objects.equals(client, order.client)
                && Objects.equals(nbDays, order.nbDays) && Objects.equals(unitPrice, order.unitPrice)
                && Objects.equals(totalExcludeTaxe, order.totalExcludeTaxe)
                && Objects.equals(totalWithTaxe, order.totalWithTaxe) && Objects.equals(state, order.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typePresta, designation, client, nbDays, unitPrice, totalExcludeTaxe, totalWithTaxe,
                state);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", typePresta='" + getTypePresta() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", client='" + getClient() + "'" +
            ", nbDays='" + getNbDays() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", totalExcludeTaxe='" + getTotalExcludeTaxe() + "'" +
            ", totalWithTaxe='" + getTotalWithTaxe() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }


}
