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
}
