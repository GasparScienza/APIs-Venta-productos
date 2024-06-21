package com.gasparscienza.ejefinal.service;

import com.gasparscienza.ejefinal.model.producto;
import java.util.List;


public interface iProductService {
    public void addProduct(producto produc);
    public List<producto> getProduct();
    public void deleteProduct(Long id);
    public producto findProduct(Long id);
    public void editProduct(Long id, producto prod);
    public List<producto> getProdStock();
}
