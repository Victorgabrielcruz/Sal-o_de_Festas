package salao_de_festas.resources;

import salao_de_festas.dao.ClienteDAO;
import salao_de_festas.entity.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import static salao_de_festas.PasswordUtils.hashPassword;

@Path("/clientes")
public class ClienteResource {

    @Inject
    private ClienteDAO clienteDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCliente(Cliente cliente) {
        try {
            Cliente clienteExistente = clienteDAO.findByEmail(cliente.getEmail());
            if (clienteExistente != null) {
                return Response.status(Response.Status.CONFLICT).entity("Email já cadastrado").build();
            }
        
            clienteDAO.save(cliente);
            return Response.status(Response.Status.CREATED).entity(cliente).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar cliente: " + e.getMessage()).build();
        }
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        Cliente cliente = clienteDAO.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (cliente != null) {
            return Response.ok(cliente.getCodigo()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciais inválidas").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = clienteDAO.findAll();
        int lenght = clientes.size();
        for(int i = 0; i < lenght ; i++){
            Cliente cliente = clientes.get(i);
            cliente.setPassword(hashPassword(cliente.getPassword()));
        }
        return clientes;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteById(@PathParam("id") int id) {
        Cliente cliente = clienteDAO.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cliente.setPassword(hashPassword(cliente.getPassword()));
        return Response.ok(cliente).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam("id") int id, Cliente cliente) {
        Cliente existingCliente = clienteDAO.findById(id);
        if (existingCliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cliente.setCodigo(id);
        clienteDAO.update(cliente);
        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCliente(@PathParam("id") int id) {
        Cliente cliente = clienteDAO.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteDAO.delete(id);
        return Response.noContent().build();
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isPasswordCorrect(String inputPassword) {
            return this.password != null && this.password.equals(inputPassword);
        }
    }
}