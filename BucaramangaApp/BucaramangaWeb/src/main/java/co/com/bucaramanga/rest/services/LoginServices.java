package co.com.bucaramanga.rest.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.bucaramanga.bean.LoginBean;
import co.com.bucaramanga.request.LoginRequest;
import co.com.bucaramanga.response.MensajeResponse;

@RequestScoped
@Path("login/")
public class LoginServices {
	
	@Inject
	private LoginBean bean;
	
	@POST
	@Path("autenticar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse autenticar(LoginRequest request){
		return bean.autenticar(request);
	}


	
}
