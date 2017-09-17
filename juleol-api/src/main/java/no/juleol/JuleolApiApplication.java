package no.juleol;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import no.juleol.api.JuleolRegisterResource;
import no.juleol.api.JuleolResource;
import no.juleol.health.JuleolApiHelsesjekk;


public class JuleolApiApplication extends Application<JuleolApiConfiguration> {

    public JuleolApiApplication() {
    	BeanConfig config = new BeanConfig();
        config.setTitle("Juleøl smaking");
        config.setVersion("0.1.0");
        config.setSchemes(new String[]{"http"});
        config.setHost("localhost:8002");
        config.setResourcePackage("no.juleol.api");
        config.setScan(true);
        config.setBasePath("/api");
    }
	
	public static void main(final String[] args) throws Exception {
        new JuleolApiApplication().run(args);
    }
    

    @Override
    public String getName() {
        return "JuleolApi";
    }

    @Override
    public void initialize(final Bootstrap<JuleolApiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final JuleolApiConfiguration configuration,
                    final Environment environment) {
    	
    	final JuleolApiHelsesjekk healthCheck =
    	            new JuleolApiHelsesjekk(configuration.getTemplate());
    	
    	//Helsesjekk
    	environment.healthChecks().register("template", healthCheck);
     	//Swagger
     	environment.jersey().register(new ApiListingResource());
     	environment.jersey().register(new SwaggerSerializers());	
     	//Tjenester
    	environment.jersey().register(new JuleolResource());
    	environment.jersey().register(new JuleolRegisterResource());

     	Cors.insecure(environment);
    }

}
