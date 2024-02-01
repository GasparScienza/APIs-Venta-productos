package com.gasparscienza.ejefinal.service;

import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.model.venta;
import java.util.List;

public interface iClienteService {
    
    public void addCliente(cliente client);
    public List<cliente> getCliente();
    public void deleteCliente(Long id);
    public cliente findCliente(Long id);
    public void editCliente(Long id, String nombre, String apellido, String dni);
    public List<venta> findVentasByCliente(Long id);
}
