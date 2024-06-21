package com.gasparscienza.ejefinal.controller;

import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.service.iProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class productController {
    @Autowired
    private iProductService iPS;
    
    @PostMapping("/productos/crear")
    public ResponseEntity<Map<String, Object>> addProduct(@RequestBody producto product){
    	Map<String, Object> response = new HashMap<>();
    	try {
            iPS.addProduct(product);
            response.put("success", true);
            response.put("message", "Producto creado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al crear el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/productos")
    public List<producto> getProductos(){
       List<producto> listProducts = iPS.getProduct();
       return listProducts;
    }
    @GetMapping("/productos/{codigo_producto}")
    public producto findProduct(@PathVariable Long codigo_producto){
        return iPS.findProduct(codigo_producto);
    }
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public ResponseEntity<Map<String, Object>> deletProduct(@PathVariable Long codigo_producto){
    	Map<String, Object> response = new HashMap<>();
    	try {
    		iPS.deleteProduct(codigo_producto);
            response.put("success", true);
            response.put("message", "Producto eliminado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al eliminar el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PutMapping("/productos/editar/{codigo_producto}")
    public ResponseEntity<Map<String, Object>> editProducto(@PathVariable Long codigo_producto,
    		@RequestBody producto prod){
    	Map<String, Object> response = new HashMap<>();
    	try {
    		iPS.editProduct(codigo_producto, prod);
            response.put("success", true);
            response.put("message", "Producto editado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al editar el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        
    }
    @GetMapping("/productos/falta_stock")
    public List<producto> getProdStock(){
       List<producto> listProducts = iPS.getProdStock();
       return listProducts;
    }
    
}
