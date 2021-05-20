package modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tienda implements Serializable {

	private Integer id;
	private String nombre;
	private String lema;
	private String telefono;
	
	public Tienda(String nombre, String lema, String telefono) {
	
		this.nombre = nombre;
		this.lema = lema;
		this.telefono = telefono;
	}
	

}