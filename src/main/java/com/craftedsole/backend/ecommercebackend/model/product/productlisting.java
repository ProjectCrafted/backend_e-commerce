package com.craftedsole.backend.ecommercebackend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class productlisting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true,updatable = false)
    private Long id;
    private String name;
    private String imageurl;
    private String color;
    private String price;
    private String quantity;
    @Column(nullable = false,updatable = false)
    private String productcode;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        quantity = quantity;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    @Override
    public String toString() {
        return "productlisting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", productcode='" + productcode + '\'' +
                '}';
    }
}
