package salao_de_festas.resources;

import salao_de_festas.dao.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;

/**
 *
 * @author 
 */
@Path("public")
public class PublicResource {
    
    @GET
    public Response ping() {
        Connection connection = null; // Declara a variável para a conexão
        
        try {
            String resultado = "Foi"; // Declara e inicializa a variável resultado
            
            // Obtém a conexão do banco de dados
            connection = DatabaseConnection.getConnection();
            
            // Lógica adicional pode ser adicionada aqui usando a conexão
            
            return Response
                .ok(resultado) // Usa o nome correto da variável
                .build();
        } catch (Exception e) { // Captura exceções gerais
            return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR) // Retorna status de erro interno
                .entity("Erro interno no servidor: " + e.getMessage()) // Mensagem do erro
                .build();
        } finally {
            // Fechamento da conexão, se necessário
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    // Ignora falhas ao fechar a conexão
                }
            }
        }
    }
}