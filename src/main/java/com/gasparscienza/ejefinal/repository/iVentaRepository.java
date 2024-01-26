package com.gasparscienza.ejefinal.repository;
import com.gasparscienza.ejefinal.model.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iVentaRepository extends JpaRepository<venta, Long>{
    
}
