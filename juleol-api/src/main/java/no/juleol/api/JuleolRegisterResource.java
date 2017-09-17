package no.juleol.api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import no.juleol.core.Juleol;
import no.juleol.core.Register;

@Path("/juleol-register")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/juleol-register", produces = "Holder orden på uleøl")
public class JuleolRegisterResource {

	@GET
	@Timed
	@Path("/hentAlle")
	@ApiOperation(value = "Returnerer alle registrerte juleøl ", notes = "Her kan vi utdype")
	public ArrayList<Juleol> hentAlleRegistrerteJuleol() {
		
		return new Register().hentAlleRegistrerteJuleol();
	}

}
