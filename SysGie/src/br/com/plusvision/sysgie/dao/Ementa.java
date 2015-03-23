package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ementa database table.
 * 
 */
@Entity
@Table(name="ementa")
@NamedQuery(name="Ementa.findAll", query="SELECT e FROM Ementa e")
public class Ementa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private int descricao;

	@Temporal(TemporalType.DATE)
	private Date periodo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDisciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idResponsavel")
	private User user;

	public Ementa() {
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

	public int getDescricao() {
		return this.descricao;
	}

	public void setDescricao(int descricao) {
		this.descricao = descricao;
	}

	public Date getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}