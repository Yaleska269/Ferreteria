/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.DetallesVentas;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author YALESKASEVILLA
 */
public class DetallesVentasDAO {
    //DetalleVentaDAO
public void crearDetalleVenta(DetallesVentas detalle) throws SQLException {
    String sql = """
        INSERT INTO Detalles_Ventas (
            Id_venta, 
            Id_producto, 
            cantidad, 
            precio_unitario
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdventa());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.executeUpdate();
    }
}

 public List<DetallesVentas> leerTodosDetallesVentas() throws SQLException {
        String sql = "SELECT * FROM Detalles_Ventas";
        List<DetallesVentas> detalles = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetallesVentas detalle = new DetallesVentas();
                detalle.setIdDetalleVenta(rs.getInt("Id_detalle_venta"));
                detalle.setIdventa(rs.getInt("Id_venta"));
                detalle.setIdProducto(rs.getInt("Id_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getFloat("precio_unitario"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }
 
    public void actualizarDetalleVenta(DetallesVentas detalle) throws SQLException {
    String sql = "UPDATE Detalles_Ventas SET id_venta = ?, id_producto = ?, cantidad = ?, precio_unitario = ? WHERE id_detalle_venta = ?";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdventa());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.setInt(5, detalle.getIdDetalleVenta());
        stmt.executeUpdate();
    }
}

// Método para eliminar un detalle de venta
public void eliminarDetalleVenta(int idDetalleVenta) throws SQLException {
    String sql = "DELETE FROM Detalles_Ventas WHERE id_detalle_venta = ?";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, idDetalleVenta);
        stmt.executeUpdate();
    }
}

// Método Main
public static void main(String[] args) {
    try {
        DetallesVentasDAO dao = new DetallesVentasDAO();
        
        // Actualizar un detalle de venta
        DetallesVentas detalle = new DetallesVentas();
        detalle.setIdDetalleVenta(1); // ID existente
        detalle.setIdventa(1);
        detalle.setIdProducto(3);
        detalle.setCantidad(2);
        detalle.setPrecioUnitario(200.0f);
        dao.actualizarDetalleVenta(detalle);
        System.out.println("Detalle de venta actualizado.");
        
        // Eliminar un detalle de venta
        dao.eliminarDetalleVenta(2); // ID a eliminar
        System.out.println("Detalle de venta eliminado.");
        
        // Leer y mostrar todos los detalles de venta para verificar
        List<DetallesVentas> detalles = dao.leerTodosDetallesVentas();
        System.out.println("Lista de detalles de venta:");
        for (DetallesVentas det : detalles) {
            System.out.println("ID: " + det.getIdDetalleVenta() + 
                               ", Venta ID: " + det.getIdventa() + 
                               ", Producto ID: " + det.getIdProducto() + 
                               ", Cantidad: " + det.getCantidad() + 
                               ", Precio Unitario: " + det.getPrecioUnitario());
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}

}
