package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;


import modelo.Tienda;
import utils.Conexion;

public class TiendaDao {

	private Conexion conexion;
	
	public static final String INSERT_USUARIO_SQL= "INSERT INTO tienda (nombre, lema, telefono) VALUES (?, ?, ?);";
	public static final String SELECT_ALL_USUARIO= "SELECT * FROM tienda;";
	
	public TiendaDao() {
		this.conexion=Conexion.getConexion();
	}
	
	public void insert(Tienda tienda) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, tienda.getNombre());
			preparedStatement.setString(2, tienda.getLema());
			preparedStatement.setString(3, tienda.getTelefono());
			conexion.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List <Tienda> selectAll(){
		
		List <Tienda> tienda = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_USUARIO);
			ResultSet rs= conexion.query();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				String nombre = rs.getString("nombre");
				String lema = rs.getString("lema");
				String telefono = rs.getString("telefono");
				tienda.add(new Tienda(id, nombre,lema, telefono));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tienda;
	}
}
