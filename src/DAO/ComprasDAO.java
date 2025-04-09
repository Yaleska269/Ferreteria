/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Compras;
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
 * @author YALESKA
 */
public class ComprasDAO {
  
   public void crearCompras(Compras compras) throws SQLException {
    String sql = """
        INSERT INTO Compras (
            id_empleado, 
            fecha_compra, 
            total_compra
        ) VALUES (?, ?, ?)""";
    
    try (Connection c = ConexionBD.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, compras.getIdEmpleado());
        stmt.setDate(2, new java.sql.Date(compras.getFechaCompra().getTime()));
        stmt.setFloat(3, compras.getTotalCompra());
        stmt.executeUpdate();
    }
}
public List<Compras> leerTodasCompras() throws SQLException {
        String sql = "SELECT * FROM Compras";
        List<Compras> compras = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setIdEmpleado(rs.getInt("id_empleado"));
                compra.setFechaCompra(rs.getDate("fecha_compra"));
                compra.setTotalCompra(rs.getFloat("total_compra"));
                compras.add(compra);
            }
        }
        return compras;
    }

    public static void main(String[] args) {
        try {
            ComprasDAO dao = new ComprasDAO();
            List<Compras> compras = dao.leerTodasCompras();
            System.out.println("Lista de compras:");
            for (Compras comp : compras) {
                System.out.println("ID: " + comp.getIdCompra() + 
                                 ", Empleado ID: " + comp.getIdEmpleado() + 
                                 ", Fecha: " + comp.getFechaCompra() + 
                                 ", Total: " + comp.getTotalCompra());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}






