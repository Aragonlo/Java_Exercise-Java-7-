package com.example.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    /*  Both template and defaultName are annotated with @NotEmpty, 
     * so if the YAML configuration file has blank values for either 
     * or is missing template entirely an informative exception will 
     * be thrown, and your application won’t start.
     */
	@NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";
    /*
     Both the getters and setters for template and defaultName are annotated 
     with @JsonProperty, which allows Jackson to both deserialize 
     the properties from a YAML file but also to serialize it.
      */
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}