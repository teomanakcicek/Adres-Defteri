package com.teomanakcicek.springdemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teomanakcicek.springdemo.entity.Kisi;

@Repository
public class KisiDAOImpl implements KisiDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Kisi> getKisiler() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Kisi> query=session.createQuery("from Kisi order by ad",Kisi.class);
		
		List<Kisi> kisiler=query.getResultList();
		
		return kisiler;
	}

	@Override
	public void saveKisi(Kisi kisi) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(kisi);
		
	}

	@Override
	public Kisi getKisi(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Kisi kisi=session.get(Kisi.class, theId);
		
		return kisi;
	}

	@Override
	public void deleteKisi(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("delete from Kisi where id=:theKisi");
		query.setParameter("theKisi", theId);
		
		query.executeUpdate();
		
	}

}
