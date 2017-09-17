package no.juleol.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Juleol {
	private long id;

    @Length(max = 100)
    private String navn;
    
    @Length(max = 100)
    private Bryggeri bryggeri;

    public Juleol() {
        // Jackson deserialization
    }

    public Juleol(long id, String navn, Bryggeri bryggeri) {
        this.id = id;
        this.navn = navn;
        this.bryggeri = bryggeri;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return navn;
    }
    
    @JsonProperty
    public Bryggeri getBryggeri() {
        return bryggeri;
    }

}
