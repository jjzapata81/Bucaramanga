package co.com.bucaramanga.rest.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.bucaramanga.bean.UsuarioBean;
import co.com.bucaramanga.entities.Usuario;
import co.com.bucaramanga.request.UsuarioRequest;
import co.com.bucaramanga.response.MensajeResponse;

@RequestScoped
@Path("usuario/")
public class UsuariosServices {
	
	@Inject
	private UsuarioBean bean;
	
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse crear(UsuarioRequest request){
		return bean.crear(request);
	}
	
	@POST
	@Path("actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse actualizar(UsuarioRequest request){
		return bean.actualizar(request);
	}
	
	@GET
	@Path("consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> consultar(){
		return bean.consultar();
	}
	
	@POST
	@Path("cambiar/password")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse cambiarPassword(UsuarioRequest request){
		return bean.cambiarPassword(request);
	}
	
	@PUT
	@Path("cambiar/estado")
	@Consumes(MediaType.APPLICATION_JSON)
	public void cambiarEstado(UsuarioRequest request) {
		bean.cambiarEstado(request);
	}
	
}
