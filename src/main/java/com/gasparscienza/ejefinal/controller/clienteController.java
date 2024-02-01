package com.gasparscienza.ejefinal.controller;
import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.model.producto;
import com.gasparscienza.ejefinal.model.venta;
import com.gasparscienza.ejefinal.service.iClienteService;
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
public class clienteController {
    @Autowired
    private iClienteService iCS;
    
    @PostMapping("/clientes/crear")
    public String addCliente(@RequestBody cliente client){
        iCS.addCliente(client);
        return "cliente creado";
    }
    @GetMapping("/clientes")
    public List<cliente> getClientes(){
       List<cliente> listClient = iCS.getCliente();
       return listClient;
    }
    @GetMapping("/clientes/{id_cliente}")
    public cliente findCliente(@PathVariable Long id_cliente){
        return iCS.findCliente(id_cliente);
    }
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deletProduct(@PathVariable Long id_cliente){
        iCS.deleteCliente(id_cliente);
        return "cliente eliminado";
    }
    @PutMapping("/clientes/editar/{id_cliente}")
    public cliente editProducto(@PathVariable Long id_cliente,
            @RequestParam(required = false, name = "nombre") String nNombre,
            @RequestParam(required = false, name = "apellido") String nApellido,
            @RequestParam(required = false, name = "dni") String nDni){
        iCS.editCliente(id_cliente, nNombre, nApellido, nDni);
        return iCS.findCliente(id_cliente);
    }
    @GetMapping("/clientes/ventas/{id_cliente}")
    public List<venta> findVentas(@PathVariable Long id_cliente){
        return iCS.findVentasByCliente(id_cliente);
    }
    
}
