package com.ayty.fintech.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Integer phone;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Consummer consumer;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Seller seller;
	
	public User() {}
	
	public User(long id, String cpf, String fullName, String email, String password, Integer phone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullName;
	}

	public void setFullname(String fullname) {
		this.fullName = fullname;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cPF) {
		cpf = cPF;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", cpf=" + cpf + ", fullName=" + fullName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", consumer=" + consumer.toString() + ", seller=" + seller + "]";
	}
	
}
