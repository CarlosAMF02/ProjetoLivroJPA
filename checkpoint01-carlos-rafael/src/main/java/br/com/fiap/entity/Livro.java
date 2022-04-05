package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro implements Serializable {

	private static final long serialVersionUID = -8267771391503503435L;
	
	public Livro() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Livro(String titulo, String autor, String edicao, int anoPublicacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	}
	
	@Id
	@GeneratedValue(generator = "livro", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "nm_livro", length = 50, nullable = false)
	private String titulo;
	@Column(name = "nm_autor", length = 40, nullable = false)
	private String autor;
	@Column(name = "ds_edicao", length = 30)
	private String edicao;
	@Column(name = "ds_ano_publicacao")
	private int anoPublicacao;
	@Column(name = "st_livro", nullable = false)
	private boolean ativo;
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	@Column(name = "dt_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@Override
	public String toString() {
		return "Titulo: "+this.getTitulo() + 
				"\nAutor: "+this.getAutor()+
				"\nEdição: "+this.getEdicao()+
				"\nAno de Publicação: "+this.getAnoPublicacao();
	}
}
