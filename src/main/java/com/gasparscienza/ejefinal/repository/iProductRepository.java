package com.gasparscienza.ejefinal.repository;
import com.gasparscienza.ejefinal.model.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iProductRepository extends JpaRepository<producto, Long>{
    
}
