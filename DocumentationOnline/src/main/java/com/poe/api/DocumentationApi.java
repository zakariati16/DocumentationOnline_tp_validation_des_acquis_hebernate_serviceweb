
package com.poe.api;

import com.poe.business.dao.DocumentationDao;
import com.poe.business.entity.Documentation;
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

@Path("doc")
public class DocumentationApi {
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    
	public List<Documentation> getDocumentation(){

                return DocumentationDao.findAll();
	}

        
        @POST()
        @Consumes({ MediaType.APPLICATION_JSON })
         public void postDocumentation(Documentation documentation){

            DocumentationDao.create(documentation);  
        }
         
        @Path("/{id}")
        @GET()
        @Produces({ MediaType.APPLICATION_JSON })
             public Documentation getById(@PathParam("id") Long documentationId){           
             return DocumentationDao.findById(documentationId) ;
        }
    
        @Path("/{id}")
        @DELETE()
        @Produces({MediaType.APPLICATION_JSON})
        public void delete(@PathParam("id") Long documentationId){
           
            DocumentationDao.deleteDocumentationById(documentationId);
        }
      
       @Path("/{id}")
       @PUT()
       @Produces({MediaType.APPLICATION_JSON})
       public void update(@PathParam("id") Long documentationId, Documentation DocumentationToUpdate) {

        DocumentationDao.update(documentationId, DocumentationToUpdate);
    }
    
}
