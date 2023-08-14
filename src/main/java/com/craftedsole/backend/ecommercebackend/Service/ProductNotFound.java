package com.craftedsole.backend.ecommercebackend.Service;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
}
