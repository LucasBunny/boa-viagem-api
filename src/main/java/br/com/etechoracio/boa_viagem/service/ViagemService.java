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
	public Optional<Viagem> buscarPorId(Long id) {
		return	repository.findById(id);
	
	}

	// Deletar
	public boolean deletarPorId(Long id) {
		boolean existe = repository.existsById(id);

		if (existe) {
			repository.deleteById(id);
		}
		return existe;
	}

	// Inserir
	public Viagem inserir(Viagem obj) {
		return repository.save(obj);
	}

	// Atualizar Update
	public Optional<Viagem> atualizar(Long id, Viagem Viagem) {
		boolean existe = repository.existsById(id);

		if (!existe) {
			return Optional.empty();
		}

		return Optional.of(repository.save(Viagem));
	}
}
