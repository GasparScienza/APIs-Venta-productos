package com.gasparscienza.ejefinal.service;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.repository.iProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService implements iProductService{

    @Autowired
    private iProductRepository iPR;
    
    @Override
    public void addProduct(producto produc) {
        iPR.save(produc);
    }

    @Override
    public List<producto> getProduct() {
        return iPR.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        iPR.deleteById(id);
    }

    @Override
    public producto findProduct(Long id) {
        return iPR.findById(id).orElse(null);
    }

    @Override
    public void editProduct(Long id, String nombre, String marca, Double costo, Double cantDisp) {
        producto prod = this.findProduct(id);       
        prod.setCantidad_disponible(cantDisp);
        prod.setNombre(nombre);
        prod.setMarca(marca);
        prod.setCosto(costo);
        this.addProduct(prod);
    }

    @Override
    public List<producto> getProdStock() {
        List<producto> listProd = this.getProduct();
        List<producto> listPStock = new ArrayList<producto>();
        for(producto p : listProd){
            if(p.getCantidad_disponible() < 5.0){
                listPStock.add(p);
            }
        }
        return listPStock;
    }
    
}
