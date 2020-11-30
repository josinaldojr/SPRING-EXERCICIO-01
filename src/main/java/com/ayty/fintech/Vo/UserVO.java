package com.ayty.fintech.Vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.ayty.fintech.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "CPF", "phone", "email", "password"})
public class UserVO implements Serializable{
	
	private static final long serialVersionUID = 2938272643682548375L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("fullname")
	private String fullname;
	
	@JsonProperty("CPF")
	private String CPF;
	
	@JsonProperty("phone")
	private Integer phone;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;
	
	public static UserVO create(User user) {
		return new ModelMapper().map(user, UserVO.class);
	}
	
	public static List<UserVO> createAllUsers(List<User> user) {
		List<UserVO> listVO = new ArrayList<UserVO>();
		for(int i = 0; i < user.size(); i++) {
			listVO.add(create(user.get(i)));
		}
		return listVO;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return fullname;
	}
	public void setName(String name) {
		this.fullname = name;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	
}
