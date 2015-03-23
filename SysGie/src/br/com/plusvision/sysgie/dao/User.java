package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(nullable=false, length=20)
	private String login;

	@Column(nullable=false, length=100)
	private String password;

	@Column(name="remember_token", length=255)
	private String rememberToken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Chamada
	@OneToMany(mappedBy="user")
	private List<Chamada> chamadas;

	//bi-directional many-to-one association to Ementa
	@OneToMany(mappedBy="user")
	private List<Ementa> ementas;

	//bi-directional many-to-one association to FinalizarNota
	@OneToMany(mappedBy="user")
	private List<FinalizarNota> finalizarNotas;

	//bi-directional many-to-one association to Mensagen
	@OneToMany(mappedBy="user1")
	private List<Mensagen> mensagens1;

	//bi-directional many-to-one association to Mensagen
	@OneToMany(mappedBy="user2")
	private List<Mensagen> mensagens2;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="user")
	private List<Nota> notas;

	//bi-directional many-to-one association to Observacoe
	@OneToMany(mappedBy="user")
	private List<Observacoe> observacoes;

	//bi-directional many-to-one association to DadosUnico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPerfil", nullable=false)
	private DadosUnico dadosUnico;

	//bi-directional many-to-one association to Hierarquia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHierarquia", nullable=false)
	private Hierarquia hierarquia;

	//bi-directional many-to-one association to Status
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idStatus", nullable=false)
	private Status status;

	//bi-directional many-to-one association to Disciplinaprofessor
	@OneToMany(mappedBy="user")
	private List<Disciplinaprofessor> disciplinaprofessors;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberToken() {
		return this.rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Chamada> getChamadas() {
		return this.chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}

	public Chamada addChamada(Chamada chamada) {
		getChamadas().add(chamada);
		chamada.setUser(this);

		return chamada;
	}

	public Chamada removeChamada(Chamada chamada) {
		getChamadas().remove(chamada);
		chamada.setUser(null);

		return chamada;
	}

	public List<Ementa> getEmentas() {
		return this.ementas;
	}

	public void setEmentas(List<Ementa> ementas) {
		this.ementas = ementas;
	}

	public Ementa addEmenta(Ementa ementa) {
		getEmentas().add(ementa);
		ementa.setUser(this);

		return ementa;
	}

	public Ementa removeEmenta(Ementa ementa) {
		getEmentas().remove(ementa);
		ementa.setUser(null);

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
		finalizarNota.setUser(this);

		return finalizarNota;
	}

	public FinalizarNota removeFinalizarNota(FinalizarNota finalizarNota) {
		getFinalizarNotas().remove(finalizarNota);
		finalizarNota.setUser(null);

		return finalizarNota;
	}

	public List<Mensagen> getMensagens1() {
		return this.mensagens1;
	}

	public void setMensagens1(List<Mensagen> mensagens1) {
		this.mensagens1 = mensagens1;
	}

	public Mensagen addMensagens1(Mensagen mensagens1) {
		getMensagens1().add(mensagens1);
		mensagens1.setUser1(this);

		return mensagens1;
	}

	public Mensagen removeMensagens1(Mensagen mensagens1) {
		getMensagens1().remove(mensagens1);
		mensagens1.setUser1(null);

		return mensagens1;
	}

	public List<Mensagen> getMensagens2() {
		return this.mensagens2;
	}

	public void setMensagens2(List<Mensagen> mensagens2) {
		this.mensagens2 = mensagens2;
	}

	public Mensagen addMensagens2(Mensagen mensagens2) {
		getMensagens2().add(mensagens2);
		mensagens2.setUser2(this);

		return mensagens2;
	}

	public Mensagen removeMensagens2(Mensagen mensagens2) {
		getMensagens2().remove(mensagens2);
		mensagens2.setUser2(null);

		return mensagens2;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setUser(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setUser(null);

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
		observacoe.setUser(this);

		return observacoe;
	}

	public Observacoe removeObservacoe(Observacoe observacoe) {
		getObservacoes().remove(observacoe);
		observacoe.setUser(null);

		return observacoe;
	}

	public DadosUnico getDadosUnico() {
		return this.dadosUnico;
	}

	public void setDadosUnico(DadosUnico dadosUnico) {
		this.dadosUnico = dadosUnico;
	}

	public Hierarquia getHierarquia() {
		return this.hierarquia;
	}

	public void setHierarquia(Hierarquia hierarquia) {
		this.hierarquia = hierarquia;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Disciplinaprofessor> getDisciplinaprofessors() {
		return this.disciplinaprofessors;
	}

	public void setDisciplinaprofessors(List<Disciplinaprofessor> disciplinaprofessors) {
		this.disciplinaprofessors = disciplinaprofessors;
	}

	public Disciplinaprofessor addDisciplinaprofessor(Disciplinaprofessor disciplinaprofessor) {
		getDisciplinaprofessors().add(disciplinaprofessor);
		disciplinaprofessor.setUser(this);

		return disciplinaprofessor;
	}

	public Disciplinaprofessor removeDisciplinaprofessor(Disciplinaprofessor disciplinaprofessor) {
		getDisciplinaprofessors().remove(disciplinaprofessor);
		disciplinaprofessor.setUser(null);

		return disciplinaprofessor;
	}

}