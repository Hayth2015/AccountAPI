package com.account.api.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalizedConfiguration {

    @Value("{application.description}")
    private String aPIDescription;

    @Value("{application.version}")
    private String aPIVersion;

    @Value("{application.title}")
    private String aPITitle;

    @Value("application.terms.of.service")
    private String aPITermsOfService;

    public ExternalizedConfiguration() {}

    public String getaPIDescription() {
        return aPIDescription;
    }

    public String getaPIVersion() {
        return aPIVersion;
    }

    public String getaPITitle() {
        return aPITitle;
    }

    public String getaPITermsOfService() {
        return aPITermsOfService;
    }
}
