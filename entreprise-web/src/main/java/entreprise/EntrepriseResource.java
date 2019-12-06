/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import services.ServiceEntrepriseLocal;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("entreprise")
@RequestScoped
public class EntrepriseResource {

    ServiceEntrepriseLocal serviceEntreprise = lookupServiceEntrepriseLocal();

    @Context
    private UriInfo context;
    
    private Gson gson;

    /**
     * Creates a new instance of EntrepriseResource
     */
    public EntrepriseResource() {
        serviceEntreprise = lookupServiceEntrepriseLocal();
        this.gson = new Gson();
    }

   
    @Path("afficherCR")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherCR() {
        return this.gson.toJson(this.serviceEntreprise.afficherCR());
    }

    private ServiceEntrepriseLocal lookupServiceEntrepriseLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceEntrepriseLocal) c.lookup("java:global/entreprise-ear/entreprise-ejb-1.0-SNAPSHOT/ServiceEntreprise!services.ServiceEntrepriseLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
}
