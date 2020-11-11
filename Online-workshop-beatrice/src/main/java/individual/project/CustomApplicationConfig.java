package individual.project;


import individual.project.resources.AuthenticationFilter;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomApplicationConfig extends ResourceConfig
{
	public CustomApplicationConfig()
	{
		packages("individual.project.resources"); // find all resource endpoint classes in this package
		// log exchanged http messages
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, LoggingFeature.DEFAULT_MAX_ENTITY_SIZE));

		//register(AuthenticationFilter.class);
	}
}
