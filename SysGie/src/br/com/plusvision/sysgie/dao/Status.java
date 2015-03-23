package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="status")
	private List<Curso> cursos;

	//bi-directional many-to-one association to Disciplina
	@OneToMany(mappedBy="status")
	private List<Disciplina> disciplinas;

	//bi-directional many-to-one association to Mensagen
	@OneToMany(mappedBy="status")
	private List<Mensagen> mensagens;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="status")
	private List<Turma> turmas;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="status")
	private List<User> users;

	public Status() {
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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso addCurso(Curso curso) {
		getCursos().add(curso);
		curso.setStatus(this);

		return curso;
	}

	public Curso removeCurso(Curso curso) {
		getCursos().remove(curso);
		curso.setStatus(null);

		return curso;
	}

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Disciplina addDisciplina(Disciplina disciplina) {
		getDisciplinas().add(disciplina);
		disciplina.setStatus(this);

		return disciplina;
	}

	public Disciplina removeDisciplina(Disciplina disciplina) {
		getDisciplinas().remove(disciplina);
		disciplina.setStatus(null);

		return disciplina;
	}

	public List<Mensagen> getMensagens() {
		return this.mensagens;
	}

	public void setMensagens(List<Mensagen> mensagens) {
		this.mensagens = mensagens;
	}

	public Mensagen addMensagen(Mensagen mensagen) {
		getMensagens().add(mensagen);
		mensagen.setStatus(this);

		return mensagen;
	}

	public Mensagen removeMensagen(Mensagen mensagen) {
		getMensagens().remove(mensagen);
		mensagen.setStatus(null);

		return mensagen;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setStatus(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setStatus(null);

		return turma;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setStatus(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setStatus(null);

		return user;
	}

}