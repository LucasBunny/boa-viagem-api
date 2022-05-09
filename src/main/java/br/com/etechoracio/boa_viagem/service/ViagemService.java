package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

public class ViagemService {

	@Autowired
	private ViagemRepository repository;

	// Listar Todos
	public List<Viagem> listarTodos() {
		return repository.findAll();
	}

	// Buscar
	public Viagem buscarPorId(Long id) {
		Optional<Viagem> existe = repository.findById(id);
		if (existe.isPresent()) {
			return existe.get();
		}
		return null;
	}

	// Deletar
	public void deletarPorId(Long id) {
		boolean existe = repository.existsById(id);

		if (existe) {
			repository.deleteById(id);
		}
	}

	// Inserir
	public Viagem inserir(Viagem obj) {
		return repository.save(obj);
	}

	// Atualizar Update
	public Viagem atualizar(Long id, Viagem Viagem) {
		boolean existe = repository.existsById(id);

		if (!existe) {
			return null;
		}

		return repository.save(Viagem);
	}
}
