/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salao_de_festas.resources;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import jakarta.ws.rs.core.Response;
import salao_de_festas.dao.FuncionarioDAO;
import salao_de_festas.entity.Funcionario;
/**
 *
 * @author Víctor
 */
@Path("/funconarios")

public class FuncionarioResorce {
    @Inject
    private FuncionarioDAO funcionarioDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFuncionario(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
        return Response.ok(funcionario).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioDAO.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFuncionarioById(@PathParam("id") int id) {
        Funcionario funcionario = funcionarioDAO.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(funcionario).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFuncionario(@PathParam("id") int id, Funcionario funcionario) {
        Funcionario existingFuncionario = funcionarioDAO.findById(id);
        if (existingFuncionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        funcionario.setCodigo(id);
        funcionarioDAO.update(funcionario);
        return Response.ok(funcionario).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFuncionario(@PathParam("id") int id) {
        Funcionario funcionario = funcionarioDAO.findById(id);
        if (funcionario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        funcionarioDAO.delete(id);
        return Response.noContent().build();
    }
}
