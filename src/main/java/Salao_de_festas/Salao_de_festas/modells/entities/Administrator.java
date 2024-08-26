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
 * <p>
 * An Administrator manages the venue's details, such as its address and CNPJ.
 * </p>
 */
@Entity
@Table(name = "Administrador")
public class Administrator {

    /**
     * The unique identifier for the Administrator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the Administrator.
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    /**
     * The phone number of the Administrator.
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * The address of the venue managed by the Administrator.
     */
    @Column(name = "venue_address", nullable = false)
    private String venueAddress;

    /**
     * The CNPJ of the Administrator, a unique identifier for businesses in
     * Brazil.
     */
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    /**
     * The password for the Administrator's account.
     */
    private String password;

    /**
     * Default constructor for JPA.
     */
    public Administrator() {
    }

    /**
     * Constructs a new Administrator instance with the specified details.
     *
     * @param name the name of the Administrator
     * @param phone the phone number of the Administrator
     * @param venueAddress the address of the venue managed by the Administrator
     * @param cnpj the CNPJ of the Administrator
     * @param password the password for the Administrator's account
     * @throws IllegalArgumentException if any of the provided arguments are
     * invalid
     */
    public Administrator(String name, String phone, String venueAddress, String cnpj, String password) {
        validarDados(name, phone, venueAddress, cnpj, password);
        this.name = name;
        this.phone = phone;
        this.venueAddress = venueAddress;
        this.cnpj = removeSpecialCharacters(cnpj);
        this.password = password;
    }

    /**
     * Returns the unique identifier for the Administrator.
     *
     * @return the id of the Administrator
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the Administrator.
     *
     * @return the name of the Administrator
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the phone number of the Administrator.
     *
     * @return the phone number of the Administrator
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the address of the venue managed by the Administrator.
     *
     * @return the venue address of the Administrator
     */
    public String getVenueAddress() {
        return venueAddress;
    }

    /**
     * Returns the CNPJ of the Administrator.
     *
     * @return the CNPJ of the Administrator
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Returns the password for the Administrator's account.
     *
     * @return the password of the Administrator
     */
    public String getPassword() {
        return password;
    }

    /**
     * Removes special characters from a string, keeping only letters and
     * digits.
     *
     * @param input the string from which special characters will be removed
     * @return a string containing only letters and digits, or null if the input
     * is null
     */
    public String removeSpecialCharacters(String input) {
        if (input != null) {
            // Remove all non-alphanumeric characters (keeping letters and digits)
            return input.replaceAll("[^a-zA-Z0-9]", "");
        }
        return null;
    }

    /**
     * Validates the provided data to ensure that all fields are correctly
     * populated.
     *
     * @param name the name of the Administrator
     * @param phone the phone number of the Administrator
     * @param venueAddress the address of the venue managed by the Administrator
     * @param cnpj the CNPJ of the Administrator
     * @param password the password for the Administrator's account
     * @throws IllegalArgumentException if any data is invalid, such as an empty
     * or null name, phone, venue address, password, or a CNPJ that does not
     * have exactly 14 digits after removing special characters
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
