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
    public Administrator(String name, String phone, String venueAddress, String cnpj) {
        if (!setName(name) || !setPhone(phone) || !setVenueAddress(venueAddress) || !setCnpj(cnpj)) {
            throw new IllegalArgumentException("Invalid arguments for creating Administrator");
        }
    }

    /**
     * Sets the name of the Administrator.
     *
     * @param name the name to be set
     * @return true if the name is valid and was set, false otherwise
     */
    public boolean setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * Sets the phone number of the Administrator.
     *
     * @param phone the phone number to be set
     * @return true if the phone number is valid and was set, false otherwise
     */
    public boolean setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
            return true;
        }
        return false;
    }

    /**
     * Sets the address of the venue managed by the Administrator.
     *
     * @param venueAddress the address to be set
     * @return true if the address is valid and was set, false otherwise
     */
    public boolean setVenueAddress(String venueAddress) {
        if (venueAddress != null && !venueAddress.isEmpty()) {
            this.venueAddress = venueAddress;
            return true;
        }
        return false;
    }

    /**
     * Sets the CNPJ of the Administrator.
     *
     * @param cnpj the CNPJ to be set
     * @return true if the CNPJ is valid and was set, false otherwise
     */
    public boolean setCnpj(String cnpj) {
        if (cnpj != null && !cnpj.isEmpty() && cnpj.length() >= 14 && cnpj.length() <= 18) {
            this.cnpj = cnpj;
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
