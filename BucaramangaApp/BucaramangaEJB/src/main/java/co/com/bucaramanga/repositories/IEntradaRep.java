package co.com.bucaramanga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.bucaramanga.entities.Entrada;

public interface IEntradaRep extends JpaRepository<Entrada, Long>{

}
