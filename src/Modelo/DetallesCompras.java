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
        private int IdDetallesCompras;
        private int IdCompras; // Relación con Compras
        private int IdProducto; // Relación con Producto
        private int cantidad;
        private float precioUnitario;

    public DetallesCompras() {
    }

        
    public DetallesCompras(int IdDetallesCompras, int IdCompras, int IdProducto, int cantidad, float precioUnitario) {
        this.IdDetallesCompras = IdDetallesCompras;
        this.IdCompras = IdCompras;
        this.IdProducto = IdProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetallesCompras() {
        return IdDetallesCompras;
    }

    public void setIdDetallesCompras(int IdDetallesCompras) {
        this.IdDetallesCompras = IdDetallesCompras;
    }

    public int getIdCompras() {
        return IdCompras;
    }

    public void setIdCompras(int IdCompras) {
        this.IdCompras = IdCompras;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
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
