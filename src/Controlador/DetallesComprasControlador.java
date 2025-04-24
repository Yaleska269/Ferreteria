/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.DetallesComprasDAO;
import Modelo.DetallesCompras;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class DetallesComprasControlador {
    
    private final DetallesComprasDAO detalleCompraDAO;

    public DetallesComprasControlador() {
        this.detalleCompraDAO = new DetallesComprasDAO();
    }

    // Método para crear un nuevo detalle de compra
    public void crearDetallesCompras(int idCompras, int idProducto, int cantidad, float precioUnitario) {
        try {
            DetallesCompras detalle = new DetallesCompras();
            detalle.setIdCompras(idCompras);
            detalle.setIdProducto(idProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalleCompraDAO.crearDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obtener todos los detalles de compra
    public List<DetallesCompras> obtenerTodosDetallesCompra() {
        try {
            return detalleCompraDAO.leerTodosDetallesCompra();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los detalles de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para actualizar un detalle de compra existente
    public void actualizarDetalleCompra(int idDetalleCompra, int idCompra, int idProducto, int cantidad, float precioUnitario) {
        try {
            DetallesCompras detalle = new DetallesCompras();
            detalle.setIdDetallesCompras(idDetalleCompra);
            detalle.setIdCompras(idCompra);
            detalle.setIdProducto(idProducto);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalleCompraDAO.actualizarDetalleCompra(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de compra actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para eliminar un detalle de compra
    public void eliminarDetallesCompras(int idDetallesCompras) {
        try {
            detalleCompraDAO.eliminarDetalleCompra(idDetallesCompras);
            JOptionPane.showMessageDialog(null, "Detalle de compra eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle de compra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        DetallesComprasControlador controlador = new DetallesComprasControlador();

        // Crear un detalle de compra
        controlador.crearDetallesCompras(1, 4, 11, 51.51f);

        // Leer todos los detalles de compra
        List<DetallesCompras> detalles = controlador.obtenerTodosDetallesCompra();
        if (detalles != null) {
            System.out.println("Lista de detalles de compra:");
            for (DetallesCompras d : detalles) {
                System.out.println("ID: " + d.getIdDetallesCompras()
                        + ", Compra: " + d.getIdCompras()
                        + ", Producto: " + d.getIdProducto()
                        + ", Cantidad: " + d.getCantidad());
            }
        }

        // Actualizar un detalle de compra (suponiendo que ID 1 existe)
        controlador.actualizarDetalleCompra(1, 1, 4, 15, 55.75f);

        // Eliminar un detalle de compra
        controlador.eliminarDetallesCompras(1);
    }
}


