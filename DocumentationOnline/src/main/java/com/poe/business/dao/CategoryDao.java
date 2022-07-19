
package com.poe.business.dao;

import com.poe.business.entity.Category;
import com.poe.business.jpa.EntityManagerSingleton;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class CategoryDao {

    public static void create(Category c) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(c);
        tx.commit();
    }
    
    public static List<Category> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Category c");
        return findAllQuery.getResultList();
    }

    public static Category findById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Category category = entityManager.find(Category.class, id);
        return category;
    }

    public static void delete(Category category) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(category);
        tx.commit();
    }

    public static void deleteCategoryById(Long id) {
        Category categoryToDelete = findById(id);
        delete(categoryToDelete);
    }

   public static void update(Long id, Category  newCategoryData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Category categoryToUpdate = entityManager.find(Category .class,id);
        categoryToUpdate.setNotNullData(newCategoryData);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(categoryToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

   
}
