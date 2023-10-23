package br.com.eugenio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eugenio.models.Computador;
import br.com.eugenio.repository.RepositoryComputador;

@Service
public class ServiceComputador {
	
	@Autowired
	private RepositoryComputador repositoryComputador;
	
	public void save(Computador computador) {
		repositoryComputador.save(computador);
	}
	
	public void delete(Computador computador) {
		repositoryComputador.delete(computador);
	}
	
	public java.util.List<Computador> findAll(){
		return repositoryComputador.findAll();
	}
	
	public Optional<Computador> getComputador(int id) {
		return repositoryComputador.findById(id);
	}

}

