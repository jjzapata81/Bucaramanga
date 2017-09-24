package co.com.bucaramanga.bean;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.bucaramanga.entities.Producto;
import co.com.bucaramanga.enums.EstadoEnum;
import co.com.bucaramanga.repositories.IProductoRep;
import co.com.bucaramanga.request.ProductoRequest;
import co.com.bucaramanga.response.MensajeResponse;
import co.com.bucaramanga.utils.Constantes;

@Stateless
public class ProductoBean {
	
	@Inject
	private IProductoRep productoRep;

	public MensajeResponse crear(ProductoRequest request) {
		if(productoRep.exists(request.getCodProducto())) {
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.ERR_PRODUCTO_EXISTE);
		}
		try{
			Producto producto = new Producto();
			producto.setCodProducto(request.getCodProducto());
			producto.setNombre(request.getNombre());
			producto.setObservacion(request.getObservacion());
			producto.setPorcentajeIva(request.getPorcentajeIva());
			producto.setTieneIva(request.isTieneIva());
			productoRep.save(producto);
			return new MensajeResponse(Constantes.ACTUALIZACION_EXITO);
		}catch(Exception e){
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.ACTUALIZACION_FALLO);
		}
	}

	public List<Producto> consultar() {
		return productoRep.findAll();
	}

	public List<String> consultarNombres() {
		return productoRep.findAll().stream().map(Producto::getNombre).collect(Collectors.toList());
	}

	public MensajeResponse actualizar(ProductoRequest request) {
		Producto producto = productoRep.findOne(request.getCodProducto());
		if(producto == null) {
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.ERR_PRODUCTO_NO_EXISTE);
		}
		try{
			producto.setNombre(request.getNombre());
			producto.setObservacion(request.getObservacion());
			producto.setPorcentajeIva(request.getPorcentajeIva());
			producto.setTieneIva(request.isTieneIva());
			productoRep.save(producto);
			return new MensajeResponse(Constantes.ACTUALIZACION_EXITO);
		}catch(Exception e){
			return new MensajeResponse(EstadoEnum.ERROR, Constantes.ACTUALIZACION_FALLO);
		}
	}
}
