package no.juleol.api;

import no.juleol.core.Juleol;
import no.juleol.core.Register;

import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Path("/juleol-api")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/juleol-api", description = "API for å stemme på juleøl")
public class JuleolResource {

    public JuleolResource() {
    }

    @GET
    @Timed
    @Path("/hent")
    @ApiOperation(
    		value = "Send inn navn ", 
    		notes = "Returnerer en hilsen",
    		response = Juleol.class)
    public Juleol sayHello(@QueryParam("name") Optional<String> name) {
        ArrayList<Juleol> alleJuleol = new Register().hentAlleRegistrerteJuleol();
        
        Random rn = new Random();
        int n = (alleJuleol.size() -1 ) - 0 + 1;
        int i = rn.nextInt() % n;
        int randomNum = 0 + i;
        
        return alleJuleol.get(randomNum);
    }
}
