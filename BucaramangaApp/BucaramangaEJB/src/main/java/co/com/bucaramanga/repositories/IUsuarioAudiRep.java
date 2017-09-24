package co.com.bucaramanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bucaramanga.entities.auditoria.UsuarioAudi;

public interface IUsuarioAudiRep extends JpaRepository<UsuarioAudi, Long>{

}
