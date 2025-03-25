/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author dell
 */
public class DetallesCompras {
        private int idDetallesCompras;
        private Compras compras; // Relación con Compras
        private Producto producto; // Relación con Producto
        private int cantidad;
        private float precioUnitario;

    public DetallesCompras(int idDetallesCompras, Compras compras, Producto producto, int cantidad, float precioUnitario) {
        this.idDetallesCompras = idDetallesCompras;
        this.compras = compras;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetallesCompras() {
        return idDetallesCompras;
    }

    public void setIdDetallesCompras(int idDetallesCompras) {
        this.idDetallesCompras = idDetallesCompras;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
        
        
}
