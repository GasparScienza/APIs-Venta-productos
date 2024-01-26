package com.gasparscienza.ejefinal.repository;
import com.gasparscienza.ejefinal.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iClienteRepository extends JpaRepository<cliente, Long>{
    
}
