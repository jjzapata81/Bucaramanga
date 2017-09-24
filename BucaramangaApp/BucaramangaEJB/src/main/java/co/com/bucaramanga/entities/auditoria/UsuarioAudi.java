package co.com.bucaramanga.entities.auditoria;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.bucaramanga.entities.converter.BooleanConverter;

@Entity
@Table(name="ta_usuario_audi")
public class UsuarioAudi implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String NOMBRE_SECUENCIA = "UsuarioAudi.id";

	@Id
	@SequenceGenerator(name = UsuarioAudi.NOMBRE_SECUENCIA, sequenceName = "sq_ta_usuario_audi", allocationSize=1)
	@GeneratedValue(generator = UsuarioAudi.NOMBRE_SECUENCIA, strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="nmusuario")
	private Long  usuario;
	
	private String accion;
	
	private Date fecha;
	
	@Column(name="snactivo")
	@Convert(converter = BooleanConverter.class)
	private boolean activo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@PrePersist
	private void onPrepersist() {
		fecha = new Date();
	}

}
