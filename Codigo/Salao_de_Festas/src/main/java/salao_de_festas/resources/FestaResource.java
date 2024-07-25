/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salao_de_festas.resources;
import salao_de_festas.dao.FestaDAO;
import salao_de_festas.entity.Festa;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * Controlador REST para a entidade Festa.
 */
@Path("/festas")
public class FestaResource {

    @Inject
    private FestaDAO festaDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFesta(Festa festa) {
        festaDAO.save(festa);
        return Response.ok(festa).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Festa> getAllFestas() {
        return festaDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFestaById(@PathParam("id") int id) {
        Festa festa = festaDAO.findById(id);
        if (festa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(festa).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFesta(@PathParam("id") int id, Festa festa) {
        Festa existingFesta = festaDAO.findById(id);
        if (existingFesta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        festa.setCodigoFesta(id);
        festaDAO.update(festa);
        return Response.ok(festa).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFesta(@PathParam("id") int id) {
        Festa festa = festaDAO.findById(id);
        if (festa == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        festaDAO.delete(id);
        return Response.noContent().build();
    }   
}
