package com.gasparscienza.ejefinal.service;
import com.gasparscienza.ejefinal.model.cliente;
import com.gasparscienza.ejefinal.repository.iClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteService implements iClienteService{
    
    @Autowired
    private iClienteRepository iCR;

    @Override
    public void addCliente(cliente client) {
        iCR.save(client);
    }

    @Override
    public List<cliente> getCliente() {
        return iCR.findAll();
    }

    @Override
    public void deleteCliente(Long id) {
        iCR.deleteById(id);
    }

    @Override
    public cliente findCliente(Long id) {
        return iCR.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id, String nombre, String apellido, String dni) {
        cliente client = this.findCliente(id);
        client.setApellido(apellido);
        client.setDni(dni);
        client.setNombre(nombre);
        this.addCliente(client);
    }
    
    
}
