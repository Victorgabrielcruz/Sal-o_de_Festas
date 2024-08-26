package Salao_de_festas.Salao_de_festas.modells.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents an Administrator entity in the system. This class is mapped to the
 * "Administrador" table in the database.
 */
@Entity
@Table(name = "Administrador")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "venue_address", nullable = false)
    private String venueAddress;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    private String password;

    //Actions
    /**
     * Constructs a new Administrator instance with the specified details.
     *
     * @param name the name of the Administrator
     * @param phone the phone number of the Administrator
     * @param venueAddress the address of the venue managed by the Administrator
     * @param cnpj the CNPJ of the Administrator
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Administrator() {

    }

    public Administrator(String name, String phone, String venueAddress, String cnpj, String password) {
        validarDados(name, phone, venueAddress, cnpj, password);
        this.name = name;
        this.phone = phone;
        this.venueAddress = venueAddress;
        this.cnpj = removeSpecialCharacters(cnpj);
        this.password = password;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public String getCnpj() {
        return cnpj;
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
     * @param name the name of the Administrator
     * @param phone the phone number of the Administrator
     * @param venueAddress the address of the venue managed by the Administrator
     * @param cnpj the CNPJ of the Administrator
     * @throws IllegalArgumentException if any data is invalid
     */
    private void validarDados(String name, String phone, String venueAddress, String cnpj, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        if (venueAddress == null || venueAddress.isEmpty()) {
            throw new IllegalArgumentException("Venue address cannot be null or empty");
        }
        cnpj = removeSpecialCharacters(cnpj);
        if (cnpj == null || cnpj.isEmpty() || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ must be 14 digits");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
}
