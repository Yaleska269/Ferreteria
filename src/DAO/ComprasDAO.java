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
import java.sql.Statement;
/**
 *
 * @author YALESKA
 */
public class ComprasDAO {

    public int crearCompra(Compras compra) throws SQLException {
        String sql = """
        INSERT INTO Compras (
            id_empleado, 
            fecha_compra, 
            total_compra
        ) VALUES (?, ?, ?)""";
        int generatedId = -1;

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, compra.getEmpleado());
            stmt.setDate(2, new java.sql.Date(compra.getFechaCompra().getTime()));
            stmt.setFloat(3, compra.getTotalCompra());
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }
        }
        return generatedId;
    }
public List<Compras> leerTodasCompras() throws SQLException {
        String sql = "SELECT * FROM Compras";
        List<Compras> compras = new ArrayList<>();

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setEmpleado(rs.getInt("id_empleado"));
                compra.setFechaCompra(rs.getDate("fecha_compra"));
                compra.setTotalCompra(rs.getFloat("total_compra"));
                compras.add(compra);
            }
        }
        return compras;
    }

    public void actualizarCompra(Compras compra) throws SQLException {
        String sql = "UPDATE Compras SET id_empleado = ?, fecha_compra = ?, total_compra = ? WHERE id_compra = ?";

        try (Connection c = ConexionBD.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, compra.getEmpleado());
            stmt.setDate(2, new java.sql.Date(compra.getFechaCompra().getTime()));
            stmt.setFloat(3, compra.getTotalCompra());
            stmt.setInt(4, compra.getIdCompra());
            stmt.executeUpdate();
        }
    }
        // Método para eliminar una compra
    public void eliminarCompra(int idCompras) throws SQLException {
        String sql = "DELETE FROM Compras WHERE id_compra = ?";

        try (Connection c = ConexionBD.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCompras);
            stmt.executeUpdate();
        }
    }

    

// Método Main
    public static void main(String[] args) {
        try {
            ComprasDAO dao = new ComprasDAO();

            // Actualizar una compra
            Compras compra = new Compras();
            compra.setIdCompra(1); // ID existente
            compra.setEmpleado(2);
            compra.setFechaCompra(new java.util.Date());
            compra.setTotalCompra(1500.50f);
            dao.actualizarCompra(compra);
            System.out.println("Compra actualizada.");

            // Leer y mostrar todas las compras para verificar
            List<Compras> compras = dao.leerTodasCompras();
            System.out.println("Lista de compras:");
            for (Compras comp : compras) {
                System.out.println("ID: " + comp.getIdCompra()
                        + ", Empleado ID: " + comp.getEmpleado()
                        + ", Fecha: " + comp.getFechaCompra()
                        + ", Total: " + comp.getTotalCompra());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}



