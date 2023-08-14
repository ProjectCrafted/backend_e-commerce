package com.craftedsole.backend.ecommercebackend.Repository;

import com.craftedsole.backend.ecommercebackend.model.productlisting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductlistRepo extends JpaRepository<productlisting, Long>
{
    void deleteProductlistingById(Long id);

    Optional<productlisting> findProductlistingById(Long id);
}
