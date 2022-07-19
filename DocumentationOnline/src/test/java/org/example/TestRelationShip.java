
package org.example;

import com.poe.business.dao.CategoryDao;
import com.poe.business.dao.DocumentationDao;
import com.poe.business.entity.Category;
import com.poe.business.entity.Documentation;
import org.junit.Test;

public class TestRelationShip {
    
    @Test
    public void manyToOne()
    {

        Category category = new Category();
        category.setName("DEV");

        CategoryDao.create(category);


        Documentation  documentation1 = new Documentation();
        documentation1.setCategory(category);
        documentation1.setTitre("java");
        documentation1.setDate("1996");
        documentation1.setAuteur("Zakaria");
       

        
        DocumentationDao.create(documentation1);


        Documentation documentation2 = new  Documentation();
        documentation2.setCategory(category);

        documentation2.setTitre("java");
        documentation2.setDate("1998");
        documentation2.setAuteur("Mansour");

       
        DocumentationDao.create(documentation2);




    }
    
}
