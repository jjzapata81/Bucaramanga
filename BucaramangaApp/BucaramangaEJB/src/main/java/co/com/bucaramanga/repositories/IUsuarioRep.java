package co.com.bucaramanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bucaramanga.entities.Usuario;

public interface IUsuarioRep extends JpaRepository<Usuario, Long>{

	Usuario findByNombreUsuario(String usuario);

}
