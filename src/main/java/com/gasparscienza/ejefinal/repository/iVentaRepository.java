package com.gasparscienza.ejefinal.repository;
import com.gasparscienza.ejefinal.model.venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface iVentaRepository extends JpaRepository<venta, Long>{
    @Query("SELECT p.costo FROM producto p WHERE p.codigo_producto = :productId")
    Double findProductCostByProductId(@Param("productId") Long productId);
}
