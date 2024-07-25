/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salao_de_festas.resources;
import salao_de_festas.dao.FornecedorDAO;
import salao_de_festas.entity.Fornecedor;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import jakarta.ws.rs.core.Response;

/**
 *
 * @author Víctor
 * Controlador REST para a entidade Fornecedor.
 */
@Path("/fornecedores")

public class FornecedorResource {
    @Inject
    private FornecedorDAO fornecedorDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFornecedor(Fornecedor fornecedor) {
        fornecedorDAO.save(fornecedor);
        return Response.ok(fornecedor).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFornecedorById(@PathParam("id") int id) {
        Fornecedor fornecedor = fornecedorDAO.findById(id);
        if (fornecedor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(fornecedor).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFornecedor(@PathParam("id") int id, Fornecedor fornecedor) {
        Fornecedor existingFornecedor = fornecedorDAO.findById(id);
        if (existingFornecedor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        fornecedor.setCodigo(id);
        fornecedorDAO.update(fornecedor);
        return Response.ok(fornecedor).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFornecedor(@PathParam("id") int id) {
        Fornecedor fornecedor = fornecedorDAO.findById(id);
        if (fornecedor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        fornecedorDAO.delete(id);
        return Response.noContent().build();
    }
}
