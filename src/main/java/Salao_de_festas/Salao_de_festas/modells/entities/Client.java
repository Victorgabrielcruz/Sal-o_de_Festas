package Salao_de_festas.Salao_de_festas.modells.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "cpf", length = 100, nullable = false)
    private String cpf;

    @Column(name = "rg", length = 100, nullable = false)
    private String rg;

    @Column(name = "phone", length = 100, nullable = false)
    private String phone;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    //builder
    /**
     * Constructs a new Client instance with the specified details.
     *
     * @param name the name of the Client
     * @param cpf the CPF of the Client
     * @param rg the RG of the Client
     * @param phone the phone number of the Client
     * @param address the address of the Client
     * @param password the password of the Client
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Client(String name, String cpf, String rg, String phone, String address, String password) {
        validarDados(name, cpf, rg, phone, address, password);
        this.name = name;
        this.cpf = removeSpecialCharacters(cpf);
        this.rg = removeSpecialCharacters(rg);
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    //auxiliary functions
    /**
     * Removes special characters from a string, keeping letters and digits.
     *
     * @param input the string from which special characters will be removed
     * @return a string containing only letters and digits
     */
    public String removeSpecialCharacters(String input) {
        if (input != null) {
            // Remove all non-alphanumeric characters (keeping letters and digits)
            return input.replaceAll("[^a-zA-Z0-9]", "");
        }
        return null;
    }

    /**
     * Validates the provided data.
     *
     * @param name the name of the Client
     * @param cpf the CPF of the Client
     * @param rg the RG of the Client
     * @param phone the phone number of the Client
     * @param address the address of the Client
     * @param password the password of the Client
     * @throws IllegalArgumentException if any data is invalid
     */
    private void validarDados(String name, String cpf, String rg, String phone, String address, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        cpf = removeSpecialCharacters(cpf);
        if (cpf == null || cpf.isEmpty() || cpf.length() != 11) { // CPF deve ter exatamente 11 dígitos
            throw new IllegalArgumentException("CPF must be 11 digits");
        }
        rg = removeSpecialCharacters(rg);
        if (rg == null || rg.isEmpty() || rg.length() < 7 || rg.length() > 14) {
            throw new IllegalArgumentException("RG must be between 7 and 14 digits");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }

}
