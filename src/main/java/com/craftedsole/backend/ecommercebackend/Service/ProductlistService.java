package com.craftedsole.backend.ecommercebackend.Service;

import com.craftedsole.backend.ecommercebackend.Repository.ProductlistRepo;
import com.craftedsole.backend.ecommercebackend.model.productlisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductlistService {
    private final ProductlistRepo productlistRepo;

    @Autowired
    public ProductlistService(ProductlistRepo productlistRepo)
    {
        this.productlistRepo=productlistRepo;
    }
    public productlisting addProductlisting(productlisting productlisting)
    {
        productlisting.setProductcode(UUID.randomUUID().toString());
        return productlistRepo.save(productlisting);
    }

    public List<productlisting> findallProductlisting()
    {
        return productlistRepo.findAll();
    }

    public productlisting updateProductlisting(productlisting productlisting)
    {
        return productlistRepo.save(productlisting);
    }

    public productlisting findProductlistingById(Long id)
    {
        return productlistRepo.findProductlistingById(id).orElseThrow(() -> new ProductNotFound ("Product "+id+"not found by Id" ));
    }

    public void deleteProductlisting(Long id) {
        productlistRepo.deleteProductlistingById(id);
    }
}
