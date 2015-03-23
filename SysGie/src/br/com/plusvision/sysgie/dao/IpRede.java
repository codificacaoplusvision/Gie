package br.com.plusvision.sysgie.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ip_rede database table.
 * 
 */
@Entity
@Table(name="ip_rede")
@NamedQuery(name="IpRede.findAll", query="SELECT i FROM IpRede i")
public class IpRede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="descricao_ip", length=45)
	private String descricaoIp;

	@Column(length=45)
	private String maskRede;

	@Column(length=45)
	private String subRede;

	public IpRede() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoIp() {
		return this.descricaoIp;
	}

	public void setDescricaoIp(String descricaoIp) {
		this.descricaoIp = descricaoIp;
	}

	public String getMaskRede() {
		return this.maskRede;
	}

	public void setMaskRede(String maskRede) {
		this.maskRede = maskRede;
	}

	public String getSubRede() {
		return this.subRede;
	}

	public void setSubRede(String subRede) {
		this.subRede = subRede;
	}

}