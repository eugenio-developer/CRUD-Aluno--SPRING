package br.com.eugenio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eugenio.models.Computador;

@Repository
public interface RepositoryComputador extends JpaRepository<Computador, Integer> {
	
}
