/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.VentaDAO;
import DAO.DetallesVentasDAO;
import Modelo.Venta;
import Modelo.DetallesVentas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class VentaControlador {
    
    private final VentaDAO ventaDAO;
    private final DetallesVentasDAO detalleVentaDAO;

    public VentaControlador() {
        this.ventaDAO = new VentaDAO();
        this.detalleVentaDAO = new DetallesVentasDAO();
    }

    // Método para crear una nueva venta con sus detalles
    public void crearVenta(int idCliente, int idEmpleado, Date fechaVenta, float totalVenta, List<DetallesVentas> detalles) {
        try {
            Venta venta = new Venta();
            venta.setIdcliente(idCliente);
            venta.setIdempleado(idEmpleado);
            venta.setFechaVenta(fechaVenta);
            venta.setTotalVenta(totalVenta);
            int idVenta = ventaDAO.crearVenta(venta);

            if (idVenta == -1) {
                throw new SQLException("No se pudo obtener el ID de la venta.");
            }

            // Asignar el id_venta a cada detalle y guardarlos
            for (DetallesVentas detalle : detalles) {
                detalle.setIdventa(idVenta);
                detalleVentaDAO.crearDetalleVenta(detalle);
            }

            JOptionPane.showMessageDialog(null, "Venta y detalles creados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todas las ventas
    public List<Venta> obtenerTodasVentas() {
        try {
            return ventaDAO.leerTodasVentas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer las ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar una venta existente
    public void actualizarVenta(int idVenta, int idCliente, int idEmpleado, Date fechaVenta, float totalVenta) {
        try {
            Venta venta = new Venta();
            venta.setIdVenta(idVenta);
            venta.setIdcliente(idCliente);
            venta.setIdempleado(idEmpleado);
            venta.setFechaVenta(fechaVenta);
            venta.setTotalVenta(totalVenta);
            ventaDAO.actualizarVenta(venta);
            JOptionPane.showMessageDialog(null, "Venta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar una venta
    public void eliminarVenta(int idVenta) {
        try {
            ventaDAO.eliminarVenta(idVenta);
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        VentaControlador controlador = new VentaControlador();

        // Crear una lista de detalles de venta
        List<DetallesVentas> detalles = new ArrayList<>();
        DetallesVentas detalle1 = new DetallesVentas();
        detalle1.setIdProducto(1);
        detalle1.setCantidad(11);
        detalle1.setPrecioUnitario(33.22f);
        detalles.add(detalle1);

        // Crear una venta con detalles
        controlador.crearVenta(1, 1, new Date(), 555.44f, detalles);

        // Leer todas las ventas
        List<Venta> ventas = controlador.obtenerTodasVentas();
        if (ventas != null) {
            System.out.println("Lista de ventas:");
            for (Venta v : ventas) {
                System.out.println("ID: " + v.getIdVenta()
                        + ", Cliente: " + v.getIdcliente()
                        + ", Total: " + v.getTotalVenta());
            }
        }
        
        // Actualizar una venta (suponiendo que ID 1 existe)
        controlador.actualizarVenta(1, 5, 4, new Date(), 600.75f);

        // Eliminar una venta
        controlador.eliminarVenta(1);
        
    }
}

