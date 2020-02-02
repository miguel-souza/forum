package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.repository.UsuarioRepository;

public class TopicoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	public String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	public String mensagem;
	
	@NotNull @NotEmpty
	public String nomeCurso;
	
	@NotNull @NotEmpty
	public String nomeAutor;
	
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico converter(CursoRepository cursoRepository, UsuarioRepository autorRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Usuario autor = autorRepository.findByNome(nomeAutor);
		return new Topico(titulo, mensagem, curso, autor);
	}
	
	
}
