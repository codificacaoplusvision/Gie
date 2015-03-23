package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@Table(name="disciplina")
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(nullable=false, length=255)
	private String descricao;

	@Column(nullable=false, length=45)
	private String sigla;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to CadProva
	@OneToMany(mappedBy="disciplina")
	private List<CadProva> cadProvas;

	//bi-directional many-to-one association to Chamada
	@OneToMany(mappedBy="disciplina")
	private List<Chamada> chamadas;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStatus", nullable=false)
	private Status status;

	//bi-directional many-to-one association to Turma
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTurma")
	private Turma turma;

	//bi-directional many-to-one association to Ementa
	@OneToMany(mappedBy="disciplina")
	private List<Ementa> ementas;

	//bi-directional many-to-one association to FinalizarNota
	@OneToMany(mappedBy="disciplina")
	private List<FinalizarNota> finalizarNotas;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="disciplina")
	private List<Nota> notas;

	//bi-directional many-to-one association to Observacoe
	@OneToMany(mappedBy="disciplina")
	private List<Observacoe> observacoes;

	//bi-directional many-to-one association to Disciplinaprofessor
	@OneToMany(mappedBy="disciplina")
	private List<Disciplinaprofessor> disciplinaprofessors;

	public Disciplina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<CadProva> getCadProvas() {
		return this.cadProvas;
	}

	public void setCadProvas(List<CadProva> cadProvas) {
		this.cadProvas = cadProvas;
	}

	public CadProva addCadProva(CadProva cadProva) {
		getCadProvas().add(cadProva);
		cadProva.setDisciplina(this);

		return cadProva;
	}

	public CadProva removeCadProva(CadProva cadProva) {
		getCadProvas().remove(cadProva);
		cadProva.setDisciplina(null);

		return cadProva;
	}

	public List<Chamada> getChamadas() {
		return this.chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}

	public Chamada addChamada(Chamada chamada) {
		getChamadas().add(chamada);
		chamada.setDisciplina(this);

		return chamada;
	}

	public Chamada removeChamada(Chamada chamada) {
		getChamadas().remove(chamada);
		chamada.setDisciplina(null);

		return chamada;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Ementa> getEmentas() {
		return this.ementas;
	}

	public void setEmentas(List<Ementa> ementas) {
		this.ementas = ementas;
	}

	public Ementa addEmenta(Ementa ementa) {
		getEmentas().add(ementa);
		ementa.setDisciplina(this);

		return ementa;
	}

	public Ementa removeEmenta(Ementa ementa) {
		getEmentas().remove(ementa);
		ementa.setDisciplina(null);

		return ementa;
	}

	public List<FinalizarNota> getFinalizarNotas() {
		return this.finalizarNotas;
	}

	public void setFinalizarNotas(List<FinalizarNota> finalizarNotas) {
		this.finalizarNotas = finalizarNotas;
	}

	public FinalizarNota addFinalizarNota(FinalizarNota finalizarNota) {
		getFinalizarNotas().add(finalizarNota);
		finalizarNota.setDisciplina(this);

		return finalizarNota;
	}

	public FinalizarNota removeFinalizarNota(FinalizarNota finalizarNota) {
		getFinalizarNotas().remove(finalizarNota);
		finalizarNota.setDisciplina(null);

		return finalizarNota;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setDisciplina(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setDisciplina(null);

		return nota;
	}

	public List<Observacoe> getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(List<Observacoe> observacoes) {
		this.observacoes = observacoes;
	}

	public Observacoe addObservacoe(Observacoe observacoe) {
		getObservacoes().add(observacoe);
		observacoe.setDisciplina(this);

		return observacoe;
	}

	public Observacoe removeObservacoe(Observacoe observacoe) {
		getObservacoes().remove(observacoe);
		observacoe.setDisciplina(null);

		return observacoe;
	}

	public List<Disciplinaprofessor> getDisciplinaprofessors() {
		return this.disciplinaprofessors;
	}

	public void setDisciplinaprofessors(List<Disciplinaprofessor> disciplinaprofessors) {
		this.disciplinaprofessors = disciplinaprofessors;
	}

	public Disciplinaprofessor addDisciplinaprofessor(Disciplinaprofessor disciplinaprofessor) {
		getDisciplinaprofessors().add(disciplinaprofessor);
		disciplinaprofessor.setDisciplina(this);

		return disciplinaprofessor;
	}

	public Disciplinaprofessor removeDisciplinaprofessor(Disciplinaprofessor disciplinaprofessor) {
		getDisciplinaprofessors().remove(disciplinaprofessor);
		disciplinaprofessor.setDisciplina(null);

		return disciplinaprofessor;
	}

}