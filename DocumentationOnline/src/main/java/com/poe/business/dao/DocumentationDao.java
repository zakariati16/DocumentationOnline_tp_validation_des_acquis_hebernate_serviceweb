package com.poe.business.dao;



import com.poe.business.entity.Documentation;
import com.poe.business.jpa.EntityManagerSingleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class DocumentationDao {

    public static void create(Documentation documentation) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(documentation);
        tx.commit();

    }

    public static Documentation findById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Documentation documentation = entityManager.find(Documentation.class, id);

        return documentation;
    }

    public static List<Documentation> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select p from Documentation p");
        return findAllQuery.getResultList();
    }

    public static void delete(Documentation documentation) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(documentation);
        tx.commit();
    }



    public static void deleteDocumentationById(Long id) {
        Documentation documentationToDelete = findById(id);
        delete(documentationToDelete);
    }

    public static void update(Long id, Documentation data) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Documentation documentationToUpdate = entityManager.find(Documentation.class, id);
        documentationToUpdate.setNotNullData(data);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(documentationToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
