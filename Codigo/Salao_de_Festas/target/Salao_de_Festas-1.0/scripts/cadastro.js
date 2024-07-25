
document.addEventListener('DOMContentLoaded', function(){
    const cadastroForm = document.querySelector('#cadastroForm');

    if(cadastroForm){
        cadastroForm.addEventListener('submit', function(event){
            event.preventDefault();

            const nome = document.getElementById('name').value;
            const endereco = document.getElementById('endereco').value;
            const telefone = document.getElementById('telefone').value;
            const dataNascimento = document.getElementById('dataNascimento').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const cliente = {
                nome: nome,
                endereco: endereco,
                telefone: telefone,
                dataNascimento: dataNascimento,
                email: email,
                password: password
            };

            fetch('http://localhost:8080/Salao_de_Festas-1.0/api/clientes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(cliente)
            })
            .then(response => {
                if (response.status === 201) {
                    return response.json().then(data => {
                        alert('Cadastro realizado com sucesso!');
                        window.location.href = '../pages/login.html';
                    });
                } else if (response.status === 409) {
                    alert('Já existe um usuário cadastrado com esse email.');
                } else {
                    return response.json().then(data => {
                        alert('Erro ao cadastrar cliente: ' + data.message);
                    });
                }
            })
            .catch(error => console.error('Erro ao cadastrar cliente:', error));
        });
    }
});
function togglePassword() {
    var passwordField = document.getElementById("password");
    var checkbox = document.querySelector("input[type='checkbox']");
    if (checkbox.checked) {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}