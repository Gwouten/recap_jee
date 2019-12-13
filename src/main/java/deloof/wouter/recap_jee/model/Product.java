package deloof.wouter.recap_jee.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="Naam moet ingevuld zijn.")
    @Size(min = 2, max = 50, message = "Naam moet tussen 2 en 50 tekens bevatten.")
    private String naam;
    @NotBlank(message = "Omschrijving moet ingevuld zijn.")
    @Column(columnDefinition = "text")
    private String omschrijving;
    @NotBlank(message = "Username moet ingevuld zijn.")
    @Size(min = 2, max = 20, message = "Username moet tussen 2 en 20 tekens bevatten.")
    private String username;
    @NotBlank(message = "Email adres is verplicht!")
    private String email;
    @NotNull(message = "Geef een startprijs in.")
    private BigDecimal startprijs;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getStartprijs() {
        return startprijs;
    }

    public void setStartprijs(BigDecimal startprijs) {
        this.startprijs = startprijs;
    }
}
