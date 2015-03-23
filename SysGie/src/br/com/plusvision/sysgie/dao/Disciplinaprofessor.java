package br.com.plusvision.sysgie.dao;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the disciplinaprofessor database table.
 * 
 */
@Entity
@Table(name="disciplinaprofessor")
@NamedQuery(name="Disciplinaprofessor.findAll", query="SELECT d FROM Disciplinaprofessor d")
public class Disciplinaprofessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDisciplina", nullable=false)
	private Disciplina disciplina;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProfessor")
	private User user;

	public Disciplinaprofessor() {
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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