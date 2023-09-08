package com.craftedsole.backend.ecommercebackend.Repository;

import com.craftedsole.backend.ecommercebackend.model.product.productlisting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductlistRepo extends JpaRepository<productlisting, Long>
{
    void deleteAllById(Long id);
    Optional<productlisting> findProductlistingById(Long id);
}
