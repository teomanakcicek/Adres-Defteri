package com.teomanakcicek.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="kisi")
public class Kisi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="alan doldurulmalidir")
	@Column(name="ad")
	@Pattern(regexp="^[a-zA-Z]+$",message="sadece harf giriniz")
	private String ad;
	
	@NotNull(message="alan doldurulmalidir")
	@Pattern(regexp="^[a-zA-Z]+$",message="sadece harf giriniz")
	@Column(name="soyad")
	private String soyad;
	
	@NotNull(message="alan doldurulmalidir")
	@Pattern(regexp="[0-9]+",message="sadece rakam giriniz")
	@Column(name="tel")
	private String tel;
	
	@NotNull(message="alan doldurulmalidir")
	@Size(min=1,message="alan doldurulmalidir")
	@Column(name="eposta")
	private String eposta;
	
	@NotNull(message="alan doldurulmalidir")
	@Size(min=1,message="alan doldurulmalidir")
	@Column(name="adres")
	private String adres;
	
	public Kisi() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	
	
}
