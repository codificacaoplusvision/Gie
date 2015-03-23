package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the turma database table.
 * 
 */
@Entity
@Table(name="turma")
@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(nullable=false, length=45)
	private String descricao;

	@Column(nullable=false, length=2)
	private String turno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Disciplina
	@OneToMany(mappedBy="turma")
	private List<Disciplina> disciplinas;

	//bi-directional many-to-one association to Curso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCurso", nullable=false)
	private Curso curso;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStatus", nullable=false)
	private Status status;

	public Turma() {
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

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Disciplina addDisciplina(Disciplina disciplina) {
		getDisciplinas().add(disciplina);
		disciplina.setTurma(this);

		return disciplina;
	}

	public Disciplina removeDisciplina(Disciplina disciplina) {
		getDisciplinas().remove(disciplina);
		disciplina.setTurma(null);

		return disciplina;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}