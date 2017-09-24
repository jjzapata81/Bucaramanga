package co.com.bucaramanga.rest.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.bucaramanga.bean.ProductoBean;
import co.com.bucaramanga.entities.Producto;
import co.com.bucaramanga.request.ProductoRequest;
import co.com.bucaramanga.response.MensajeResponse;

@RequestScoped
@Path("productos/")
public class ProductosServices {
	
	@Inject
	private ProductoBean bean;
	
	@POST
	@Path("crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse crear(ProductoRequest request){
		return bean.crear(request);
	}
	
	@POST
	@Path("actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MensajeResponse actualizar(ProductoRequest request){
		return bean.actualizar(request);
	}
	
	@GET
	@Path("consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> consultar(){
		return bean.consultar();
	}
	
	@GET
	@Path("consultar/nombres")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getNombres(){
		return bean.consultarNombres();
	}
	
}
