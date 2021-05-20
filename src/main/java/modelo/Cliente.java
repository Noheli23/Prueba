package modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

	private Integer id;
	private String nombre;
	private String email;
	private String clave;
	
	public Cliente(String nombre, String email, String clave) {
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
	}
}
