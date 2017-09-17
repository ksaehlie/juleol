package no.juleol.core;

import java.util.ArrayList;

public class Register {

	public ArrayList<Juleol> hentAlleRegistrerteJuleol() {
		ArrayList<Juleol> register = new ArrayList<Juleol> (); 

		register.add(new Juleol(1, "Hansa Vellagret", new Bryggeri (1, "Hansa", "Tromsø")));
		register.add(new Juleol(2, "Rignes Sterk", new Bryggeri (2, "Rignes", "Oslo")));
		register.add(new Juleol(3, "Aas Vellagret", new Bryggeri (3, "Aas Bryggeri", "Drammen")));
		register.add(new Juleol(4, "Aas Juleøl", new Bryggeri (4, "Aas Bryggeri", "Drammen")));
		
		return register;
	}

}
