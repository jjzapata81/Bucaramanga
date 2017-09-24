package co.com.bucaramanga.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.bucaramanga.bean.auditoria.UsuarioLog;
import co.com.bucaramanga.entities.Usuario;
import co.com.bucaramanga.enums.EstadoEnum;
import co.com.bucaramanga.repositories.IUsuarioRep;
import co.com.bucaramanga.request.UsuarioRequest;
import co.com.bucaramanga.response.MensajeResponse;
import co.com.bucaramanga.utils.Constantes;
import co.com.bucaramanga.utils.Utilidades;

@Stateless
public class UsuarioBean {
	
	@Inject
	private IUsuarioRep usuarioRep;
	
	@Inject
	private UsuarioLog log;

	public MensajeResponse crear(UsuarioRequest request) {
		Usuario usuario = consultarId(request.getId());
		if(usuario == null){
			usuario = new Usuario();
			usuario.setId(request.getId());
			usuario.setNombre(request.getNombre());
			usuario.setApellido(request.getApellido());
			usuario.setPass(Utilidades.encriptar(request.getPass().trim()));
			usuario.setFeIngreso(request.getFeIngreso());
			usuarioRep.save(usuario);
			log.save(usuario, Constantes.ACCION_CREAR);
			return new MensajeResponse(Constantes.ACTUALIZACION_EXITO);
		}else{
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.getMensaje(Constantes.USUARIO_EXISTE, request.getId()));
		}
	}

	public MensajeResponse actualizar(UsuarioRequest request) {
		Usuario usuario = consultarId(request.getId());
		if(usuario!=null){
			usuario.setNombre(request.getNombre());
			usuario.setApellido(request.getApellido());
			usuarioRep.save(usuario);
			return new MensajeResponse(Constantes.ACTUALIZACION_EXITO);
		}else{
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.USUARIO_NO_EXISTE);
		}
	}
	
	public MensajeResponse cambiarPassword(UsuarioRequest request) {
		try {
			Usuario usuario = usuarioRep.findOne(request.getId());
			usuario.setPass(Utilidades.encriptar(request.getPass().trim()));
			usuarioRep.save(usuario);
			return new MensajeResponse(Constantes.ACTUALIZACION_EXITO);
		}catch (Exception e) {
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.ACTUALIZACION_FALLO);
		}
	}

	public List<Usuario> consultar() {
		return usuarioRep.findAll();
	}
	
	public void cambiarEstado(UsuarioRequest request) {
		Usuario usuario = consultarId(request.getId());
		usuario.setActivo(request.isActivo());
		String accion;
		if(request.isActivo()) {
			usuario.setFeIngreso(new Date());
			accion = Constantes.ACCION_ACTIVAR;
		}else {
			usuario.setFeBaja(new Date());
			accion = Constantes.ACCION_DESACTIVAR;
		}
		usuarioRep.save(usuario);
		log.save(usuario, accion);
	}
	
	public Usuario consultarNombre(String usuario){
		return usuarioRep.findByNombreUsuario(usuario);
	}
	
	private Usuario consultarId(Long id){
		return usuarioRep.findOne(id);
	}
	
}
