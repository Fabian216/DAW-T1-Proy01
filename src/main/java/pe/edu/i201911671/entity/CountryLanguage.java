package pe.edu.i201911671.entity;

import jakarta.persistence.*;

@Entity
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial")
    private IsOfficial isOfficial; // Enum

    private Double Percentage;

    // Relación con Country
    @ManyToOne
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguageId id, IsOfficial isOfficial, Double percentage, Country country) {
        this.id = id;
        this.isOfficial = isOfficial;
        Percentage = percentage;
        this.country = country;
    }

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public IsOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(IsOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "Percentage=" + Percentage +
                '}';
    }
}
