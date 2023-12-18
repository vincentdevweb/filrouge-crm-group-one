package com.crm.filrouge.dao.Client;

import java.util.List;

import com.crm.filrouge.dao.Order.Order;
import com.crm.filrouge.enumeration.ClientEnum;
import com.crm.filrouge.enumeration.ClientEnumConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String companyName;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number",unique = true, length = 15)
    private String phone;

    @Column(nullable = false, columnDefinition = "text")
    private String address;

    @Column(nullable = false, length = 30)
    private String zipCode;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false)
    @Convert(converter = ClientEnumConverter.class)
    private ClientEnum state;

    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Client() {
    }

    public Client(Integer id, String companyName, String firstName, String lastName, String email, String phone,
            String address, String zipCode, String city, String country, ClientEnum state, List<Order> orders) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
        this.orders = orders;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Client id(Integer id) {
        setId(id);
        return this;
    }

    public Client companyName(String companyName) {
        setCompanyName(companyName);
        return this;
    }

    public Client firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Client lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Client email(String email) {
        setEmail(email);
        return this;
    }

    public Client phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Client address(String address) {
        setAddress(address);
        return this;
    }

    public Client zipCode(String zipCode) {
        setZipCode(zipCode);
        return this;
    }

    public Client city(String city) {
        setCity(city);
        return this;
    }

    public Client country(String country) {
        setCountry(country);
        return this;
    }

    public Client state(ClientEnum state) {
        setState(state);
        return this;
    }

    public Client orders(List<Order> orders) {
        setOrders(orders);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(companyName, client.companyName)
                && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email) && Objects.equals(phone, client.phone)
                && Objects.equals(address, client.address) && Objects.equals(zipCode, client.zipCode)
                && Objects.equals(city, client.city) && Objects.equals(country, client.country)
                && Objects.equals(state, client.state) && Objects.equals(orders, client.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, firstName, lastName, email, phone, address, zipCode, city, country, state,
                orders);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", companyName='" + getCompanyName() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", email='" + getEmail() + "'" +
                ", phone='" + getPhone() + "'" +
                ", address='" + getAddress() + "'" +
                ", zipCode='" + getZipCode() + "'" +
                ", city='" + getCity() + "'" +
                ", country='" + getCountry() + "'" +
                ", state='" + getState() + "'" +
                "}";
    }

}
