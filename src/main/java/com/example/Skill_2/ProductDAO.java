package com.example.Skill_2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ProductDAO {
	
	  private static final Session session = null;
	  public void saveProduct(Product p) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();

	        session.save(p);

	        tx.commit();
	        session.close();
	    }

	    // UPDATE
	    public void updateProduct(Product p) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();

	        session.update(p);

	        tx.commit();
	        session.close();
	    }

	    // DELETE
	    public void deleteProduct(int id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();

	        Product p = session.get(Product.class, id);
	        if (p != null) {
	            session.delete(p);
	        }

	        tx.commit();
	        session.close();
	    }

	    // READ (LIST)
	    public List<Product> getAllProducts() {
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        List<Product> list =
	                session.createQuery("from Product", Product.class).list();

	        session.close();
       return list;
	    }

	    public List<Product> getProductsSortedByPriceAsc() {

	        // 1️⃣ Open session
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        // 2️⃣ Write HQL query (YOUR CODE GOES HERE)
	        String hql = "FROM Product p ORDER BY p.price ASC";
	        Query<Product> query = session.createQuery(hql, Product.class);

	        // 3️⃣ Execute query
	        List<Product> list = query.list();

	        // 4️⃣ Close session
	        session.close();

	        // 5️⃣ Return result
	        return list;
	    }
	    
	    public List<Product> getProductsSortedByPriceDesc() {

	        // 1️⃣ Open session
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        // 2️⃣ Write HQL query (THIS IS YOUR LINE)
	        String hql = "FROM Product p ORDER BY p.price DESC";

	        // 3️⃣ Create query object
	        Query<Product> query = session.createQuery(hql, Product.class);

	        // 4️⃣ Execute query
	        List<Product> productList = query.list();

	        // 5️⃣ Close session
	        session.close();

	        // 6️⃣ Return result
	        return productList;
	    }

	    public List<Product> getProductsSortedByQuantityDesc() {

	        // 1️⃣ Open Hibernate session
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        // 2️⃣ HQL query (THIS IS THE LINE YOU ASKED ABOUT)
	        String hql = "FROM Product p ORDER BY p.quantity DESC";

	        // 3️⃣ Create query
	        Query<Product> query = session.createQuery(hql, Product.class);

	        // 4️⃣ Execute query
	        List<Product> productList = query.list();

	        // 5️⃣ Close session
	        session.close();

	        // 6️⃣ Return result
	        return productList;
	    }

	}
	