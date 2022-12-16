package com.Dilum.springBootTutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint
public class featureMap {

    private final Map<String, Feature> FM =
            new ConcurrentHashMap<>();


    public featureMap()
    {
        FM.put("Department", new Feature(true));
        FM.put("Code", new Feature(true));
        FM.put("Name", new Feature(false));

    }

    @ReadOnlyProperty
    public Map<String, Feature> features()
    {
        return FM;
    }

    @ReadOnlyProperty
    public Feature feature(@Selector String featureName)
    {
        return FM.get(featureName);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature
    {
        private boolean isEnabled;
    }
}
