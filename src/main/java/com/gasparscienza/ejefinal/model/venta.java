package com.gasparscienza.ejefinal.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @OneToMany
    private List<producto> listaProductos;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private cliente unCliente;
	public Long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public LocalDate getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public cliente getUnCliente() {
		return unCliente;
	}
	public void setUnCliente(cliente unCliente) {
		this.unCliente = unCliente;
	} 
    
    
}
