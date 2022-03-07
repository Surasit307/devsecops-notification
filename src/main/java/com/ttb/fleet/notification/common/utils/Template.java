package com.ttb.fleet.notification.common.utils;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

import java.io.StringWriter;
import java.util.Map;

public class Template {

    // Initialize the engine.
    private VelocityEngine engine = new VelocityEngine();

    public String stringTemplate(String templateString, Map<String, String> values) {
//        engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
//        engine.setProperty("runtime.log.logsystem.log4j.logger", LOGGER.getName());
//        engine.addProperty("string.resource.loader.modificationCheckInterval", "1");
        engine.setProperty(Velocity.RESOURCE_LOADER, "string");
        engine.addProperty("string.resource.loader.class", StringResourceLoader.class.getName());
        engine.addProperty("string.resource.loader.repository.static", "false");
        engine.init();
        StringResourceRepository repo = (StringResourceRepository) engine.getApplicationAttribute(StringResourceLoader.REPOSITORY_NAME_DEFAULT);
        repo.putStringResource("notification", templateString);

        // Set parameters for my template.
        VelocityContext context = new VelocityContext();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            context.put(entry.getKey(), entry.getValue());
        }

        org.apache.velocity.Template template = engine.getTemplate("notification");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        // Show the result.
        System.out.println(writer.toString());

        return writer.toString();
    }
}
