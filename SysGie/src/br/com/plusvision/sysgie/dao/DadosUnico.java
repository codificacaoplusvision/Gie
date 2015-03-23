package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dados_unicos database table.
 * 
 */
@Entity
@Table(name="dados_unicos")
@NamedQuery(name="DadosUnico.findAll", query="SELECT d FROM DadosUnico d")
public class DadosUnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String bairro;

	@Column(length=9)
	private String cep;

	@Column(length=255)
	private String cidade;

	@Column(length=255)
	private String complemento;

	@Column(length=14)
	private String cpf;

	@Column(name="cpf_responsavel", length=45)
	private String cpfResponsavel;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="data_expedicao", length=45)
	private String dataExpedicao;

	@Column(length=255)
	private String email;

	@Column(length=3)
	private String estado;

	@Column(name="fone_celular", length=45)
	private String foneCelular;

	@Column(name="fone_residencial", length=45)
	private String foneResidencial;

	@Column(length=1000)
	private String logradouro;

	@Column(length=10)
	private String nascimento;

	@Column(nullable=false, length=255)
	private String nome;

	@Column(name="nome_mae", length=255)
	private String nomeMae;

	@Column(name="nome_pai", length=255)
	private String nomePai;

	@Column(name="org_expedicao", length=45)
	private String orgExpedicao;

	@Column(length=255)
	private String responsavel;

	@Column(length=10)
	private String rg;

	@Column(length=2)
	private String sexo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Escolaridade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEscolaridade")
	private Escolaridade escolaridade;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="dadosUnico")
	private List<User> users;

	public DadosUnico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpfResponsavel() {
		return this.cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDataExpedicao() {
		return this.dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoneCelular() {
		return this.foneCelular;
	}

	public void setFoneCelular(String foneCelular) {
		this.foneCelular = foneCelular;
	}

	public String getFoneResidencial() {
		return this.foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getOrgExpedicao() {
		return this.orgExpedicao;
	}

	public void setOrgExpedicao(String orgExpedicao) {
		this.orgExpedicao = orgExpedicao;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Escolaridade getEscolaridade() {
		return this.escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setDadosUnico(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setDadosUnico(null);

		return user;
	}

}