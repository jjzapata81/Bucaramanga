package co.com.bucaramanga.bean;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.bucaramanga.entities.Usuario;
import co.com.bucaramanga.enums.EstadoEnum;
import co.com.bucaramanga.request.LoginRequest;
import co.com.bucaramanga.response.MensajeResponse;
import co.com.bucaramanga.utils.Constantes;
import co.com.bucaramanga.utils.Utilidades;

@Stateless
public class LoginBean {
	
	@Inject
	private UsuarioBean usuarioBean;

	public MensajeResponse autenticar(LoginRequest request) {
		Usuario usuario = usuarioBean.consultarNombre(request.getUsuario());
		if(usuario != null){
			if(!usuario.isActivo()) {
				return new MensajeResponse(EstadoEnum.ERROR, Constantes.ERR_USUARIO_INACTIVO);
			}else if(Utilidades.validar(request.getPass(), usuario.getPass())) {
				return new MensajeResponse(Constantes.getMensaje(Constantes.LOGIN_OK, usuario.getNombreCompleto()));
			}
		}
		return new MensajeResponse(EstadoEnum.ERROR, Constantes.ERR_LOGIN_INCORRECTO);
	}
	
}
