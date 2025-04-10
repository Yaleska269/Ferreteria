/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.DetallesCompras;
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
 * @author dell
 */
public class DetallesComprasDAO {
    //DetalleCompraDAO
public void crearDetalleCompra(DetallesCompras detalle) throws SQLException {
    String sql = """
        INSERT INTO Detalles_Compras (
            Id_compra, 
            Id_producto, 
            cantidad, 
            precio_unitario
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdDetallesCompras());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.executeUpdate();
    }
}

public List<DetallesCompras> leerTodosDetallesCompra() throws SQLException {
        String sql = "SELECT * FROM Detalles_Compras";
        List<DetallesCompras> detalles = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetallesCompras detalle = new DetallesCompras();
                detalle.setIdDetallesCompras(rs.getInt("id_detalle_compra"));
                detalle.setIdCompras(rs.getInt("id_compra"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getFloat("precio_unitario"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }

    public void actualizarDetalleCompra(DetallesCompras detalle) throws SQLException {
    String sql = "UPDATE Detalles_Compras SET id_compra = ?, id_producto = ?, cantidad = ?, precio_unitario = ? WHERE id_detalle_compra = ?";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdCompras());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.setInt(5, detalle.getIdDetallesCompras());
        stmt.executeUpdate();
    }
}

// Método para eliminar un detalle de compra
public void eliminarDetalleCompra(int idDetalleCompra) throws SQLException {
    String sql = "DELETE FROM Detalles_Compras WHERE id_detalle_compra = ?";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, idDetalleCompra);
        stmt.executeUpdate();
    }
}



// Método Main
public static void main(String[] args) {
    try {
        DetallesComprasDAO dao = new DetallesComprasDAO();
        
        // Actualizar un detalle de compra
        DetallesCompras detalle = new DetallesCompras();
        detalle.setIdDetallesCompras(1); // ID existente
        detalle.setIdCompras(1);
        detalle.setIdProducto(2);
        detalle.setCantidad(5);
        detalle.setPrecioUnitario(100.0f);
        dao.actualizarDetalleCompra(detalle);
        System.out.println("Detalle de compra actualizado.");
        
        // Eliminar un detalle de compra
        dao.eliminarDetalleCompra(2); // ID a eliminar
        System.out.println("Detalle de compra eliminado.");
        
        // Leer y mostrar todos los detalles de compra para verificar
        List<DetallesCompras> detalles = dao.leerTodosDetallesCompra();
        System.out.println("Lista de detalles de compra:");
        for (DetallesCompras det : detalles) {
            System.out.println("ID: " + det.getIdDetallesCompras() + 
                               ", Compra ID: " + det.getIdCompras() + 
                               ", Producto ID: " + det.getIdProducto() + 
                               ", Cantidad: " + det.getCantidad() + 
                               ", Precio Unitario: " + det.getPrecioUnitario());
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}



