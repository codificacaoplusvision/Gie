package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hierarquia database table.
 * 
 */
@Entity
@Table(name="hierarquia")
@NamedQuery(name="Hierarquia.findAll", query="SELECT h FROM Hierarquia h")
public class Hierarquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=45)
	private String descricao;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="hierarquia")
	private List<User> users;

	public Hierarquia() {
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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setHierarquia(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setHierarquia(null);

		return user;
	}

}