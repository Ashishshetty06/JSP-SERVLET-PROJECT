package com.alvas.proj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.alvas.proj.dto.Student;

public class StudentCrud {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ashish");

	public Student savestudent(Student s) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		return em.find(Student.class, s.getSid());
	}

	public String Update(Student s, int id) {
		EntityManager em = emf.createEntityManager();
		if (em.find(Student.class, id) != null) {
			Student student = new Student();
			student.setSid(s.getSid());
			student.setName(s.getName());
			student.setEmail((s.getEmail()));
			student.setPhone(s.getPhone());
			return "successfull";
		} else
			return "id not available ";

	}

	public List<Student> getAlldetails() {
		EntityManager eManager = emf.createEntityManager();
		String s = "select s from Student s";
		Query query = eManager.createQuery(s);
		return query.getResultList();
	}

	public boolean delete(int id) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction eTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			eTransaction.begin();
			entityManager.remove(student);
			eTransaction.commit();
			return true;
		} else {
			return false;
		}
	
	}
	public Student update(Student student,int id){
		EntityManager entityManager=emf.createEntityManager();
		EntityTransaction eTransaction=entityManager.getTransaction();
		Student student2=entityManager.find(Student.class, id);
		if(student2!=null){
			eTransaction.begin();
			entityManager.merge(student);
			eTransaction.commit();
			return entityManager.find(Student.class, id);
		}else
			return null;
		
	}
	public Student getbyid(int id){
		EntityManager entityManager=emf.createEntityManager();
		return entityManager.find(Student.class, id);
	}
}
