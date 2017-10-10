package com.teomanakcicek.springdemo.DAO;

import java.util.List;

import com.teomanakcicek.springdemo.entity.Kisi;

public interface KisiDAO {
	public List<Kisi> getKisiler();

	public void saveKisi(Kisi kisi);

	public Kisi getKisi(int theId);

	public void deleteKisi(int theId);

}
