package ca.uhn.fhir.jpa.starter.cr;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.cr.config.CrDstu3Config;
import ca.uhn.fhir.jpa.starter.annotations.OnDSTU3Condition;
import ca.uhn.fhir.rest.server.provider.ResourceProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Conditional({OnDSTU3Condition.class, CrConfigCondition.class})
@Import({CrDstu3Config.class})
public class StarterCrDstu3Config {
	@Bean
	CrOperationFactory crOperationFactory() {
		return new CrOperationFactory();
	}

	@Bean
	CrOperationLoader crOperationLoader(FhirContext theFhirContext, ResourceProviderFactory theResourceProviderFactory,
													CrOperationFactory theCrlProviderFactory) {
		return new CrOperationLoader(theFhirContext, theResourceProviderFactory, theCrlProviderFactory);
	}
}
