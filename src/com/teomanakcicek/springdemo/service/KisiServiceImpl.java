package com.teomanakcicek.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teomanakcicek.springdemo.DAO.KisiDAO;
import com.teomanakcicek.springdemo.entity.Kisi;

@Service
public class KisiServiceImpl implements KisiService {

	@Autowired
	private KisiDAO kisidao;
	
	@Override
	@Transactional
	public List<Kisi> getKisiler() {
		
		return kisidao.getKisiler();
		
	}

	@Override
	@Transactional
	public void saveKisi(Kisi kisi) {
		
		kisidao.saveKisi(kisi);
		
	}

	@Override
	@Transactional
	public Kisi getKisi(int theId) {
		
		return kisidao.getKisi(theId);
	}

	@Override
	@Transactional
	public void deleteKisi(int theId) {
		
		kisidao.deleteKisi(theId);
	}

}
