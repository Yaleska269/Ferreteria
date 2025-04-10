/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
import java.util.List;
/**
 *
 * @author dell
 */
public class Venta {
        private int IdVenta;
        private int Idcliente; // Relación con Cliente
        private int Idempleado; // Relación con Empleado
        private Date fechaVenta;
        private float totalVenta;
        private List<DetallesVentas> detalles; // Relación con DetalleVenta

    public Venta() {
    }

    public Venta(int IdVenta, int Idcliente, int Idempleado, Date fechaVenta, float totalVenta, List<DetallesVentas> detalles) {
        this.IdVenta = IdVenta;
        this.Idcliente = Idcliente;
        this.Idempleado = Idempleado;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.detalles = detalles;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdcliente() {
        return Idcliente;
    }

    public void setIdcliente(int Idcliente) {
        this.Idcliente = Idcliente;
    }

    public int getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(int Idempleado) {
        this.Idempleado = Idempleado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public List<DetallesVentas> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesVentas> detalles) {
        this.detalles = detalles;
    }

    
        
}