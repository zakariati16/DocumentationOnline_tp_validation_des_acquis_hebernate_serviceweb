package com.poe.api;



import com.poe.business.entity.Category;
import com.poe.business.dao.CategoryDao;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("categories")
public class CategoryApi {

   
        
	@GET()
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Category> getCategory(){

                
                return CategoryDao.findAll();
	}

        
        @POST()
        @Consumes({ MediaType.APPLICATION_JSON })
         public void postCategory(Category category){
          
        
            CategoryDao.create(category);
            
        }
     
      
        @Path("/{id}")
        @GET()
        @Produces({ MediaType.APPLICATION_JSON })
               public Category getById(@PathParam("id") Long categoryId){          
           
             return CategoryDao.findById(categoryId) ;
        }


    
        @Path("/{id}")
        @DELETE()
        @Produces({MediaType.APPLICATION_JSON})
        public void delete(@PathParam("id") Long categoryId){
           
            CategoryDao.deleteCategoryById(categoryId);
        }

      
       @Path("/{id}")
       @PUT()
       @Produces({MediaType.APPLICATION_JSON})
       public void update(@PathParam("id") Long categoryId, Category CategoryToUpdate) {

        CategoryDao.update(categoryId, CategoryToUpdate);
    }

}
