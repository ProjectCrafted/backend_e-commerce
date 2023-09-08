package com.craftedsole.backend.ecommercebackend.Service;

import com.craftedsole.backend.ecommercebackend.Repository.ProductlistRepo;
import com.craftedsole.backend.ecommercebackend.imageutil.ImageUtility;
import com.craftedsole.backend.ecommercebackend.model.product.productlisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductlistService {

    private final ProductlistRepo productlistRepo;

    @Autowired
    public ProductlistService(ProductlistRepo productlistRepo) {
        this.productlistRepo = productlistRepo;
    }


    public List<productlisting> getAllproducts() {
        return productlistRepo.findAll();
    }


    public Optional<productlisting> getProductsById(Long id) {
        return productlistRepo.findById(id);
    }

    public productlisting uploadProduct(
            MultipartFile file,
            String name,
            String color,
            String price,
            String quantity) throws IOException {

        byte[] imageBytes = ImageUtility.compressImage(file.getBytes());
        String productcode = UUID.randomUUID().toString();

        productlisting productWithImage = new productlisting(name, imageBytes, color, price, quantity, productcode);
        return productlistRepo.save(productWithImage);
    }

    public ResponseEntity<productlisting> updateProduct(productlisting updatedProductWithImage) {

        Optional<productlisting> existingProductWithImage = productlistRepo.findById(updatedProductWithImage.getId());

        if (existingProductWithImage.isPresent()) {
            productlisting existingProduct = existingProductWithImage.get();
            existingProduct.setName(updatedProductWithImage.getName());
            existingProduct.setImage(updatedProductWithImage.getImage());
            existingProduct.setColor(updatedProductWithImage.getColor());
            existingProduct.setPrice(updatedProductWithImage.getPrice());
            existingProduct.setQuantity(updatedProductWithImage.getQuantity());
            existingProduct.setProductcode(updatedProductWithImage.getProductcode());

            productlisting updatedProduct = productlistRepo.save(existingProduct);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    public ResponseEntity<?> deleteProduct(Long id) {
        if (productlistRepo.existsById(id)) {
            productlistRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
