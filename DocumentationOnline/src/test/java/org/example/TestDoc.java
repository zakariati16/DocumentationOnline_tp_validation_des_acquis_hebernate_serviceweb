
package org.example;

import com.poe.business.dao.CategoryDao;
import com.poe.business.entity.Category;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class TestDoc {
    
    @Test

    public void createCategory() {
        
    Category category=new Category();
    category.setName("Mansour");
    

    CategoryDao.create(category);
       

        assertTrue(true);
    }

   
    
}
