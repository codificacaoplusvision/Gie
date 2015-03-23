package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="curso")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(nullable=false, length=255)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStatus", nullable=false)
	private Status status;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="curso")
	private List<Turma> turmas;

	public Curso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

}