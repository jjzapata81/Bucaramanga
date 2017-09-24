package co.com.bucaramanga.response;

import co.com.bucaramanga.enums.EstadoEnum;

public class MensajeResponse {
	
	protected String mensaje;
	protected EstadoEnum estado;
	
	public MensajeResponse(){
	}
	
	public MensajeResponse(String mensaje){
		this(EstadoEnum.OK, mensaje);
	}
	
	public MensajeResponse(EstadoEnum estado, String mensaje){
		this.mensaje = mensaje;
		this.estado = estado;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public EstadoEnum getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

}
