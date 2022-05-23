package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.boa_viagem.entity.Gasto;
import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.GastoRepository;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

@Service
public class GastoService {

	@Autowired
	private GastoRepository repository;

	@Autowired
	private ViagemRepository ViagemRepository;

	// Listar Todos
	public List<Gasto> listarTodos() {
		return repository.findAll();
	}

	// Buscar
	public Optional<Gasto> buscarPorId(Long id) {
		return repository.findById(id);
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
	public Gasto inserir(Gasto obj) {
		Optional<Viagem> existe = ViagemRepository.findById(obj.getViagem().getId());
		if (!existe.isPresent()) {
			throw new RuntimeException("Viagem não encontrada!");
		}
		if (existe.get().getSaida() != null) {
			throw new RuntimeException("Viagem ainda em aberto");
		}
		return repository.save(obj);

	}

	// Atualizar Update
	public Optional<Gasto> atualizar(Long id, Gasto gasto) {
		boolean existe = repository.existsById(id);

		if (!existe) {
			return Optional.empty();
		}

		return Optional.of(repository.save(gasto));
	}
}
