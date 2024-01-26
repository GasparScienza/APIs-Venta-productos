package com.gasparscienza.ejefinal.service;
import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.model.venta;
import com.gasparscienza.ejefinal.repository.iVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ventaService implements iVentaService{
    
    @Autowired
    private iVentaRepository iVR;

    @Override
    public void addVenta(venta vent) {
        iVR.save(vent);
    }

    @Override
    public List<venta> getVentas() {
        return iVR.findAll();
    }

    @Override
    public void deleteVenta(Long id) {
        iVR.deleteById(id);
    }

    @Override
    public venta findVenta(Long id) {
        return iVR.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Long id, LocalDate fecha, Double total, List<producto> listaProductos, cliente unCliente) {        
        venta vent = this.findVenta(id);
        
        if (fecha != null) {
            vent.setFecha_venta(fecha);
        }
        if (listaProductos != null) {
            vent.setListaProductos(listaProductos);
        }
        if (unCliente != null) {
           vent.setUnCliente(unCliente);
        }
        if (total != null) {
          vent.setTotal(total);
        }
        this.addVenta(vent);
    }

    @Override
    public double calTotVent(venta vent) {
        Double tot = 0.0;
        List<producto> listProd = vent.getListaProductos();
        if(listProd != null){
            for(producto prod : listProd){
                if(prod != null && prod.getCosto() != null){
                    tot += prod.getCosto();
                }
            
            }
        }
        
        return tot;
    }

    @Override
    public List<producto> findVentaProd(Long id) {
        venta ven = iVR.findById(id).orElse(null);
        return ven.getListaProductos();
    }
}