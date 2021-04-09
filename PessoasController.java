package br.net.evne.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoasController {

	@Autowired
	private PessoaRepository repository;

	@GetMapping("/pessoas")
	public List<Pessoa> list() {
		return repository.list();
	}
}
