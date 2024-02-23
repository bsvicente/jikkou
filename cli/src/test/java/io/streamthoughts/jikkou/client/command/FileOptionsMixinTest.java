package io.streamthoughts.jikkou.client.command;

import io.streamthoughts.jikkou.api.template.JinjaResourceTemplateRenderer;
import io.streamthoughts.jikkou.core.io.Jackson;
import io.streamthoughts.jikkou.core.io.ResourceLoaderFacade;
import io.streamthoughts.jikkou.core.template.ResourceTemplateRenderer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOptionsMixinTest {

    private final FileOptionsMixin fileOptionsMixin = FileOptionsMixin.createFileOptionsMixin(List.of("file:///C:/Users/Brendon/workspace/jikkou"), "**/*.{yaml,yml}");

    @Test
    void getResourceFileLocations() {

        ResourceTemplateRenderer renderer = new JinjaResourceTemplateRenderer()
                .withPreserveRawTags(false)
                .withFailOnUnknownTokens(false);
        var resourceLoaderFacade = new ResourceLoaderFacade(renderer, Jackson.YAML_OBJECT_MAPPER);

        assertFalse(resourceLoaderFacade.load(fileOptionsMixin).getItems().isEmpty());

    }
}