package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNome(String nomeAutor);
}
