package br.com.eugenio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eugenio.models.Computador;
import br.com.eugenio.service.ServiceComputador;

@Controller
@RequestMapping("/computadores")
public class ControllerComputador {
	
	@Autowired
	private ServiceComputador serviceComputador;
	
	@GetMapping(value = "")
	public String listAll(Model model) {
		model.addAttribute("computadores", serviceComputador.findAll());
		return "listarcomputadores";
	}
	
	@GetMapping(value = "/novocomputador")
	public String novoComputador(Model model) {
		model.addAttribute("computador", new Computador());
		return  "novocomputador";
	}
	
	@PostMapping(value = "/salvar")
	public String salvarComputador(@ModelAttribute Computador computador) {
		serviceComputador.save(computador);
		return "redirect:/computadores";
	}

	@GetMapping (value = "/excluir/{id}")
	public String excluirComputador(@PathVariable("id") int id) {
		
		java.util.Optional<Computador> computador = serviceComputador.getComputador(id);
			if(computador.isPresent()) {
				serviceComputador.delete(computador.get());
			}
		
		return"redirect:/computadores";
	}
	
	@GetMapping(value="/editar/{id}")
	public String editarComputador(@PathVariable("id") int id, Model model) {
		
		java.util.Optional<Computador> computador = serviceComputador.getComputador(id);
		model.addAttribute("computador", computador.get());
		
		return "novocomputador";
	}
	
	
}
