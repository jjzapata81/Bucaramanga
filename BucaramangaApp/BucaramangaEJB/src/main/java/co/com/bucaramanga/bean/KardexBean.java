package co.com.bucaramanga.bean;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.com.bucaramanga.repositories.IKardexRep;

@Stateless
public class KardexBean {
	
	@Inject
	private IKardexRep kardexRep;
	
}
