package com.craftedsole.backend.ecommercebackend.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class productlisting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true,updatable = false)
    private Long id;
    private String name;
    @Column(name = "images",unique = false,nullable = false,length = 100000)
    private byte[] image;
    private String imageType;
    private String color;
    private String price;
    private String quantity;
    @Column(nullable = false,updatable = false)
    private String productcode;

    public productlisting(String name, byte[] imageBytes, String color, String price, String quantity, String productcode) {
        this.name = name;
        this.image = imageBytes;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.productcode = productcode;
    }


    @Override
    public String toString() {
        return "productlisting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", productcode='" + productcode + '\'' +
                '}';
    }
}
