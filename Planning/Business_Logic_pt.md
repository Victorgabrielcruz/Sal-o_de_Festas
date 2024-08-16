### 1. **Cadastro e Autenticação de Usuários**

**Regra:**  
- Clientes e o administrador (Fernando) devem se cadastrar com informações detalhadas, como nome, e-mail, CPF/CNPJ, endereço, entre outros.
- O sistema deve verificar se o CPF/CNPJ já está registrado antes de permitir um novo cadastro.
- A autenticação deve ser realizada por e-mail e senha.

**Processo:**  
1. Cliente/Administrador acessa a tela de cadastro.
2. Preenche os dados necessários e os submete.
3. O sistema verifica a unicidade do CPF/CNPJ.
4. Se o CPF/CNPJ for único, o sistema cria o novo usuário e envia um e-mail de confirmação.
5. O usuário confirma seu e-mail e pode acessar o sistema usando e-mail e senha.

### 2. **Gerenciamento de Festas**

**Regra:**  
- Apenas o administrador pode criar e gerenciar festas no sistema.
- O cliente pode solicitar a criação de uma festa, mas esta deve ser aprovada pelo administrador.
- Cada festa deve ter um contrato associado, e este contrato deve conter todos os detalhes da festa e dos envolvidos (cliente, funcionários, etc.).

**Processo:**
1. Cliente faz a solicitação para uma nova festa, especificando data, hora e detalhes básicos.
2. O sistema notifica o administrador sobre a solicitação.
3. O administrador revisa a solicitação e pode aprová-la ou rejeitá-la.
   - Se aprovada, o administrador cria um contrato associado e define o status da festa como "Agendada".
   - Se rejeitada, o cliente é notificado e pode editar ou cancelar a solicitação.
4. O administrador pode posteriormente editar os detalhes da festa, como datas, horários, funcionários escalados, etc.
5. A qualquer momento, o administrador pode alterar o status da festa (e.g., em andamento, concluída, cancelada).

### 3. **Gerenciamento de Contratos**

**Regra:**  
- Cada festa deve ter um contrato formal, que inclui todos os detalhes do evento, os custos, e os termos de serviço.
- O contrato deve ser gerado automaticamente quando uma festa é aprovada pelo administrador.
- O contrato só pode ser editado pelo administrador.

**Processo:**
1. Após a aprovação da festa, o sistema gera automaticamente um contrato com base nos detalhes fornecidos.
2. O administrador revisa e, se necessário, edita o contrato.
3. O cliente é notificado para revisar o contrato.
4. O cliente aceita os termos do contrato, após o qual ele é finalizado e não pode mais ser editado.
5. O contrato permanece acessível tanto para o cliente quanto para o administrador até o término da festa.

### 4. **Escalação de Funcionários**

**Regra:**  
- Funcionários podem ser escalados para festas, desde que estejam disponíveis na data e hora solicitadas.
- O administrador tem a autoridade final para escalar ou substituir funcionários.

**Processo:**
1. Cliente seleciona os funcionários desejados ao solicitar a festa.
2. O sistema verifica a disponibilidade dos funcionários na data e horário escolhidos.
3. Se disponível, os funcionários são pré-escalados.
4. O administrador revisa a escalação dos funcionários e pode confirmar ou modificar a escalação.
5. Uma vez confirmada, a escalação é finalizada e os funcionários são notificados.

### 5. **Gerenciamento de Status da Festa e Contrato**

**Regra:**  
- O status da festa (e.g., agendada, em andamento, concluída, cancelada) deve refletir o estado atual do evento.
- O status do contrato (e.g., pendente, confirmado, cancelado) deve refletir o acordo entre o cliente e o administrador.

**Processo:**
1. O sistema atribui o status "Agendada" quando o administrador aprova a festa.
2. No dia da festa, o status muda automaticamente para "Em andamento" quando a festa começa.
3. Após o término da festa, o administrador marca manualmente a festa como "Concluída".
4. Se a festa for cancelada pelo cliente ou administrador, o status é alterado para "Cancelada", e os funcionários são desescalados.
5. O contrato segue um ciclo similar, iniciando como "Pendente" até que o cliente o confirme, momento em que o contrato é marcado como "Confirmado". Se cancelado, o contrato recebe o status de "Cancelado".

### 6. **Relatórios e Dashboards**

**Regra:**  
- O administrador deve ter acesso a relatórios sobre festas, contratos, e funcionários para ajudar na gestão do salão.
- Os clientes devem ter uma visão geral de suas festas e contratos em um painel simplificado.

**Processo:**
1. O sistema gera relatórios periódicos (diários, semanais, mensais) sobre o número de festas agendadas, status de contratos, e horas trabalhadas por funcionários.
2. O administrador pode acessar esses relatórios no painel de controle, onde ele pode filtrar dados e tomar decisões informadas.
3. Clientes têm um painel que mostra as festas agendadas, status de contratos, e histórico de festas passadas.