package com.craftedsole.backend.ecommercebackend.Controller;

import com.craftedsole.backend.ecommercebackend.Service.ProductlistService;
import com.craftedsole.backend.ecommercebackend.model.product.productlisting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productlist")
@CrossOrigin(origins = "http://localhost:3004")

public class ProductResou {
    private final ProductlistService productlistService;

    public ProductResou(ProductlistService productlistService)
    {
        this.productlistService=productlistService;
    }
    @GetMapping("all")
    public ResponseEntity<List<productlisting>> getAllProductlistings()
    {
        List<productlisting> productlistings = productlistService.findallProductlisting();
        return new ResponseEntity<>(productlistings, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<productlisting> getProductlistingsById(@PathVariable("id")Long id)
    {
        productlisting productlisting=productlistService.findProductlistingById(id);
        return new ResponseEntity<>(productlisting, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<productlisting> addProductlisting( @RequestBody productlisting productlisting)
    {
        productlisting newProductlisting =productlistService.addProductlisting(productlisting);
        return new ResponseEntity<>(newProductlisting, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<productlisting> updateProductlisting(@RequestBody productlisting productlisting)
    {
        productlisting newProductlisting =productlistService.updateProductlisting(productlisting);
        return new ResponseEntity<>(newProductlisting, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductlisting(@PathVariable("id") Long id)
    {
        productlistService.deleteProductlisting(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
