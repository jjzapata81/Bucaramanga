package co.com.bucaramanga.bean.auditoria;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.bucaramanga.entities.Usuario;
import co.com.bucaramanga.entities.auditoria.UsuarioAudi;
import co.com.bucaramanga.repositories.IUsuarioAudiRep;

@Stateless
public class UsuarioLog {
	
	@Inject
	private IUsuarioAudiRep audiRep;

	public void save(Usuario usuario, String accion) {
		UsuarioAudi audi = new UsuarioAudi();
		audi.setAccion(accion);
		audi.setActivo(usuario.isActivo());
		audi.setUsuario(usuario.getId());
		audiRep.save(audi);
	}

}
