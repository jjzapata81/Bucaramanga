package co.com.bucaramanga.configuration;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public final class ConfiguracionCDI {
		 
    @Produces
    @Dependent
    @PersistenceContext
    public static EntityManager entityManager;
    
    private ConfiguracionCDI() {
	}
}
