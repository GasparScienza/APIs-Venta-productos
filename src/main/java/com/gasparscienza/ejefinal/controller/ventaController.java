package com.gasparscienza.ejefinal.controller;
import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.model.venta;
import com.gasparscienza.ejefinal.service.iVentaService;
import java.time.LocalDate;
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
public class ventaController {
    @Autowired
    private iVentaService iVS;
    
    @PostMapping("/ventas/crear")
    public String addVenta(@RequestBody venta vent){
        iVS.addVenta(vent);
        return "Venta creada";
    }
    @GetMapping("/ventas")
    public List<venta> getVenta(){
       List<venta> listVenta = iVS.getVentas();
       return listVenta;
    }
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<producto> findVentaProd(@PathVariable Long codigo_venta){
        return iVS.findVentaProd(codigo_venta);
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public venta findVenta(@PathVariable Long codigo_venta){
        return iVS.findVenta(codigo_venta);
    }
    
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deletVenta(@PathVariable Long codigo_venta){
        iVS.deleteVenta(codigo_venta);
        return "Venta eliminado";
    }
    @PutMapping("/ventas/editar/{codigo_venta}")
    public venta editProducto(@PathVariable Long codigo_venta,
            @RequestParam(required = false, name = "fecha_venta") LocalDate nFecha,
            @RequestParam(required = false, name = "total") Double nTotal,
            @RequestParam(required = false, name = "listaProductos") List<producto> nList,
            @RequestParam(required = false, name = "unCliente") cliente nCliente){
        
        iVS.editVenta(codigo_venta, nFecha, nTotal, nList, nCliente);
        return iVS.findVenta(codigo_venta);
    }
}
