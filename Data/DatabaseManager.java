package Data;

import Data.Medicamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {
    private Connection conn;

    public DatabaseManager(String dbName) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            createTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS medicamentos (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nombre TEXT NOT NULL," +
                     "dosis TEXT NOT NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    public void insertarMedicamento(Medicamento m) {
        String sql = "INSERT INTO medicamentos(nombre, dosis) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, m.getNombre());
            pstmt.setString(2, m.getDosis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarMedicamentos() {
        String sql = "SELECT * FROM medicamentos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") +
                                   ", Dosis: " + rs.getString("dosis"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarMedicamento(Medicamento m) {
        String sql = "DELETE FROM medicamentos WHERE rowid = (" +
                 "SELECT rowid FROM medicamentos WHERE nombre = ? AND dosis = ? LIMIT 1)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, m.getNombre());
        pstmt.setString(2, m.getDosis());
        pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public StackMedicamento obtenerMedicamentosComoPila() {
        StackMedicamento pila = new StackMedicamento();
        String sql = "SELECT nombre, dosis FROM medicamentos ORDER BY rowid DESC"; 
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String dosis = rs.getString("dosis");
            Medicamento m = new Medicamento(nombre, dosis);
            pila.push(m);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pila;
}    public ArrayList<Medicamento> obtenerMedicamentosComoLista() {
        ArrayList<Medicamento> pila = new ArrayList<>();
        String sql = "SELECT nombre, dosis FROM medicamentos ORDER BY rowid ASC"; 
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String dosis = rs.getString("dosis");
            Medicamento m = new Medicamento(nombre, dosis);
            pila.add(m);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pila;
}



    public void cerrar() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
