package com.craftedsole.backend.ecommercebackend.Controller.product;


import com.craftedsole.backend.ecommercebackend.Service.ProductlistService;
import com.craftedsole.backend.ecommercebackend.model.product.productlisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productlist")
@CrossOrigin(origins = "http://localhost:3001/")
public class ProductResou {

    private final ProductlistService productlistService;

    @Autowired
    public ProductResou(ProductlistService productlistService) {
        this.productlistService = productlistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<productlisting>> getAllproducts() {
        List<productlisting> productWithImages = productlistService.getAllproducts();
        return ResponseEntity.status(HttpStatus.OK)
                .body(productWithImages);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<productlisting> getProductsById(@PathVariable("id") Long id) {
        Optional<productlisting> productWithImage = productlistService.getProductsById(id);
        return productWithImage.map(productlisting ->
                        ResponseEntity.status(HttpStatus.OK)
                                .body(productlisting))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @PostMapping("/upload")
    public ResponseEntity<productlisting> uploadProduct(
            @RequestParam("image") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("color") String color,
            @RequestParam("price") String price,
            @RequestParam("quantity") String quantity) throws IOException {

        productlisting savedProductWithImage = productlistService.uploadProduct(file, name, color, price, quantity);

        return ResponseEntity.status(HttpStatus.OK)
                .body(savedProductWithImage);
    }

    @PutMapping("/update")
    public ResponseEntity<productlisting> updateProduct(@RequestBody productlisting updatedProductWithImage) {
        return productlistService.updateProduct(updatedProductWithImage);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return productlistService.deleteProduct(id);
    }
}
