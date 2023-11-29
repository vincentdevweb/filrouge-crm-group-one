package com.crm.filrouge.controller.client.dto;

import java.util.Objects;

import com.crm.filrouge.enumeration.ClientEnum;

public class ClientPostDTO {
    private String cname;
    private String fname;
    private String lname;
    private String tel;
    private String add;
    private String zCode;
    private String city;
    private String country;
    private String email;
    private ClientEnum state;

    public ClientPostDTO() {
    }

    public ClientPostDTO(String cname, String fname, String lname, String tel, String add, String zCode, String city, String country, String email, ClientEnum state) {
        this.cname = cname;
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.add = add;
        this.zCode = zCode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.state = state;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdd() {
        return this.add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getZCode() {
        return this.zCode;
    }

    public void setZCode(String zCode) {
        this.zCode = zCode;
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

    public ClientPostDTO cname(String cname) {
        setCname(cname);
        return this;
    }

    public ClientPostDTO fname(String fname) {
        setFname(fname);
        return this;
    }

    public ClientPostDTO lname(String lname) {
        setLname(lname);
        return this;
    }

    public ClientPostDTO tel(String tel) {
        setTel(tel);
        return this;
    }

    public ClientPostDTO add(String add) {
        setAdd(add);
        return this;
    }

    public ClientPostDTO zCode(String zCode) {
        setZCode(zCode);
        return this;
    }

    public ClientPostDTO city(String city) {
        setCity(city);
        return this;
    }

    public ClientPostDTO country(String country) {
        setCountry(country);
        return this;
    }

    public ClientPostDTO email(String email) {
        setEmail(email);
        return this;
    }

    public ClientPostDTO state(ClientEnum state) {
        setState(state);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClientPostDTO)) {
            return false;
        }
        ClientPostDTO clientPostDTO = (ClientPostDTO) o;
        return Objects.equals(cname, clientPostDTO.cname) && Objects.equals(fname, clientPostDTO.fname) && Objects.equals(lname, clientPostDTO.lname) && Objects.equals(tel, clientPostDTO.tel) && Objects.equals(add, clientPostDTO.add) && Objects.equals(zCode, clientPostDTO.zCode) && Objects.equals(city, clientPostDTO.city) && Objects.equals(country, clientPostDTO.country) && Objects.equals(email, clientPostDTO.email) && Objects.equals(state, clientPostDTO.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cname, fname, lname, tel, add, zCode, city, country, email, state);
    }

    @Override
    public String toString() {
        return "{" +
            " cname='" + getCname() + "'" +
            ", fname='" + getFname() + "'" +
            ", lname='" + getLname() + "'" +
            ", tel='" + getTel() + "'" +
            ", add='" + getAdd() + "'" +
            ", zCode='" + getZCode() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", email='" + getEmail() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
    
}
