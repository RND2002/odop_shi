package com.odopBackend.odopShi_RestApi.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<ProductOwnerShip> productOwnerShip = new ArrayList<>();


    public Users(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ProductOwnerShip> getProductOwnerShip() {
        return productOwnerShip;
    }

    public void setProductOwnerShip(List<ProductOwnerShip> productOwnerShip) {
        this.productOwnerShip = productOwnerShip;
    }

    public Users(long id, String username, String password, String email, String phone, List<ProductOwnerShip> productOwnerShip) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.productOwnerShip = productOwnerShip;
    }
}
