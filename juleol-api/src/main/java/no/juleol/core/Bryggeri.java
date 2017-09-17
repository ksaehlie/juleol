package no.juleol.core;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bryggeri {
	
	private long id;

    @Length(max = 100)
    private String navn;
    
    @Length(max = 100)
    private String sted;
    
    public Bryggeri() {
        // Jackson deserialization
    }

    public Bryggeri(long id, String navn, String sted) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
    }

    @JsonProperty
	public String getNavn() {
		return navn;
	}

    @JsonProperty
	public long getId() {
		return id;
	}

    @JsonProperty
	public String getSted() {
		return sted;
	}

}
