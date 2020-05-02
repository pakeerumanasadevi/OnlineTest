package com.capgemini.onlinetest.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetest.entity.Userdata;
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Userdata addUser(Userdata u) {
		Userdata e=em.merge(u);
		return e;
	}
	
	
	@Override
	public List<Userdata> getAllUsers() {
		Query q=em.createQuery("select m from Userdata m");
		List<Userdata> userlist=q.getResultList();
		return userlist;
	}
	
	
	
	@Override
	public Userdata updateUser(Userdata u) {
		Userdata ud=em.find(Userdata.class,u.getUserid());
		if(ud!=null)
		{

			ud.setUsername(u.getUsername());
			ud.setUsertest(u.getUsertest());
			ud.setUserPassword(u.getUserPassword());
			ud.setUserPhoneno(u.getUserPhoneno());
			ud.setUserEmail(u.getUserEmail());
		}
		return ud;
			
	}
	@Override	
	public Userdata deleteUser(int userId) {
		Userdata ud=em.find(Userdata.class,userId);
		if(ud!=null)
			{em.remove(ud);
			}
        return ud;
	}
	
	
	@Override
	public String loginUser(Userdata u) {
		String type = null;
		String flag = null;
	Query q=em.createQuery("select m.userType from Userdata m where m.username=?1 and m.userPassword=?2");
	String a=u.getUsername();
	String b=u.getUserPassword();
	q.setParameter(1,a);
	q.setParameter(2,b);
	try
	{
		type=(String) q.getSingleResult();
		if(type.equalsIgnoreCase("admin") && type!=null) {
			 flag="admin";
		 }
		 else if(!type.equalsIgnoreCase("admin") && type!=null)
			 flag="student";
		return flag;
	}catch(javax.persistence.NoResultException e)
    {
        e.printStackTrace();
    }
	return "no";
	}

	@Override
	public Userdata getById(int uid) {
		// TODO Auto-generated method stub
		Userdata u=em.find(Userdata.class,uid);
		return u;
	}
	//changed on 28-04-2020 dont know if it will work
	@Override
	public List<Userdata> getUserTest() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select u.userid,t.testId,q.questionId from Userdata u,Questions q,Test t where u.testid=q.test");
		List<Userdata> userlist=q.getResultList();
		return userlist;
	}
	
	
	
}
