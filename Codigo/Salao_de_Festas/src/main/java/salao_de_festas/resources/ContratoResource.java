/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salao_de_festas.resources;


import salao_de_festas.dao.ContratoDAO;
import salao_de_festas.entity.Contrato;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * Controlador REST para a entidade Contrato.
 */
@Path("/contratos")
public class ContratoResource {

    @Inject
    private ContratoDAO contratoDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createContrato(Contrato contrato) {
        contratoDAO.save(contrato);
        return Response.ok(contrato).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contrato> getAllContratos() {
        return contratoDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContratoById(@PathParam("id") int id) {
        Contrato contrato = contratoDAO.findById(id);
        if (contrato == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(contrato).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateContrato(@PathParam("id") int id, Contrato contrato) {
        Contrato existingContrato = contratoDAO.findById(id);
        if (existingContrato == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        contrato.setNumeroContrato(id);
        contratoDAO.update(contrato);
        return Response.ok(contrato).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteContrato(@PathParam("id") int id) {
        Contrato contrato = contratoDAO.findById(id);
        if (contrato == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        contratoDAO.delete(id);
        return Response.noContent().build();
    }
}
