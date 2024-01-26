package com.gasparscienza.ejefinal.controller;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.service.iProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {
    @Autowired
    private iProductService iPS;
    
    @PostMapping("/productos/crear")
    public String addProduct(@RequestBody producto product){
        iPS.addProduct(product);
        return "Producto creado";
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
    public String deletProduct(@PathVariable Long codigo_producto){
        iPS.deleteProduct(codigo_producto);
        return "Producto eliminado";
    }
    @PutMapping("/productos/editar/{codigo_producto}")
    public producto editProducto(@PathVariable Long codigo_producto,
            @RequestParam(required = false, name = "nombre") String nNombre,
            @RequestParam(required = false, name = "marca") String nMarca,
            @RequestParam(required = false, name = "costo") Double nCosto,
            @RequestParam(required = false, name = "cantidad_disponible") Double nCantidad_disponible){
        
        iPS.editProduct(codigo_producto, nNombre, nMarca, nCosto, nCantidad_disponible);
        return iPS.findProduct(codigo_producto);
    }
    @GetMapping("/productos/falta_stock")
    public List<producto> getProdStock(){
       List<producto> listProducts = iPS.getProdStock();
       return listProducts;
    }
    
}
