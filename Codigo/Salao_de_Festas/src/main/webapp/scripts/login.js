document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.querySelector('#loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const login = {
                email: email,
                password: password
            };

            fetch('http://localhost:8080/Salao_de_Festas-1.0/api/clientes/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(login)
            })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Login failed: ' + response.statusText);
                }
            })
            .then(data => {
                console.log('Login successful:', data);
                // Armazenar as informações do cliente na sessão/localStorage
                sessionStorage.setItem('cliente', JSON.stringify(data.id));
                // Redirecionar para o painel do cliente
                window.location.href = "../pages/home.html";
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Falha no login. Por favor, verifique suas credenciais.');
            });
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
