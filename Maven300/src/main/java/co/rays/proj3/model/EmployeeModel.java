package co.rays.proj3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import co.rays.proj3.dto.EmployeeDTO;

public class EmployeeModel {

	public void add(EmployeeDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();

	}

	public void update(EmployeeDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();

	}

	public void delete(EmployeeDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();

	}

	public List search(EmployeeDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(EmployeeDTO.class);
		if(dto!=null) {
			if(dto.getName() != null && dto.getName().length()>0) {
				c.add(Restrictions.ilike("name", dto.getName()+"%"));
			}
			if(dto.getId()!=0 && dto.getId()>0){
				c.add(Restrictions.eq("id", dto.getId()));
			}
		}
		List list = c.list();
		tx.commit();
		session.close();

		return list;

	}

	public EmployeeDTO findByPK(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		EmployeeDTO dto= (EmployeeDTO) session.get(EmployeeDTO.class,id);
		
		return dto;

	}
	
}
