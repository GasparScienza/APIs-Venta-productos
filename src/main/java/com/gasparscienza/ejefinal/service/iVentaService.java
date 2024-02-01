package com.gasparscienza.ejefinal.service;
import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.model.venta;
import java.time.LocalDate;
import java.util.List;

public interface iVentaService {
    public void addVenta(venta vent);
    public List<venta> getVentas();
    public void deleteVenta(Long id);
    public venta findVenta(Long id);
    public void editVenta(Long id, LocalDate fecha, Double total, List<producto> listaProductos, cliente unCliente);
    public void calTotVent(venta vent);
    public List<producto> findVentaProd(Long id);
    public String findVentaFecha(LocalDate fecha);
}
