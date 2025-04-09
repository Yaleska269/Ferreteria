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

    public static void main(String[] args) {
        try {
            DetallesComprasDAO dao = new DetallesComprasDAO();
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



