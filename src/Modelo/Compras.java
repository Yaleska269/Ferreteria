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
public class Compras {

    private int IdCompra;
    private int Empleado; // Relación con Empleado
    private Date fechaCompra;
    private float totalCompra;
    private List<DetallesCompras> detalles; // Relación con DetalleCompra

    public Compras() {
    }

    public Compras(int IdCompra, int empleado, Date fechaCompra, float totalCompra, List<DetallesCompras> detalles) {
        this.IdCompra = IdCompra;
        this.Empleado = empleado;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
        this.detalles = detalles;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(int empleado) {
        this.Empleado = empleado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<DetallesCompras> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesCompras> detalles) {
        this.detalles = detalles;
    }

    
    
}
