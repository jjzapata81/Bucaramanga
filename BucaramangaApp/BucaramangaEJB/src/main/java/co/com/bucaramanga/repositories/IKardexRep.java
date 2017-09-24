package co.com.bucaramanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bucaramanga.entities.Kardex;

public interface IKardexRep extends JpaRepository<Kardex, Long>{

}
