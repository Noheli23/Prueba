package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.Cliente;
import utils.Conexion;

public class ClienteDao {
	
	private Conexion conexion;
	
	public static final String INSERT_USUARIO_SQL= "INSERT INTO cliente (nombre, email, clave) VALUES (?, ?, ?);";
	public static final String SELECT_ALL_USUARIO= "SELECT * FROM cliente;";
	public ClienteDao() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Cliente cliente) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, cliente.getNombre());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getClave());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List <Cliente> selectAll(){
		
		List <Cliente> cliente = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_USUARIO);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String clave = rs.getString("clave");
				cliente.add(new Cliente(id, nombre, email, clave));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cliente;
	}
}
