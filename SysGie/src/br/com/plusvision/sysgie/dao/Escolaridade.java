package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escolaridade database table.
 * 
 */
@Entity
@Table(name="escolaridade")
@NamedQuery(name="Escolaridade.findAll", query="SELECT e FROM Escolaridade e")
public class Escolaridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String descricao;

	//bi-directional many-to-one association to DadosUnico
	@OneToMany(mappedBy="escolaridade")
	private List<DadosUnico> dadosUnicos;

	public Escolaridade() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<DadosUnico> getDadosUnicos() {
		return this.dadosUnicos;
	}

	public void setDadosUnicos(List<DadosUnico> dadosUnicos) {
		this.dadosUnicos = dadosUnicos;
	}

	public DadosUnico addDadosUnico(DadosUnico dadosUnico) {
		getDadosUnicos().add(dadosUnico);
		dadosUnico.setEscolaridade(this);

		return dadosUnico;
	}

	public DadosUnico removeDadosUnico(DadosUnico dadosUnico) {
		getDadosUnicos().remove(dadosUnico);
		dadosUnico.setEscolaridade(null);

		return dadosUnico;
	}

}