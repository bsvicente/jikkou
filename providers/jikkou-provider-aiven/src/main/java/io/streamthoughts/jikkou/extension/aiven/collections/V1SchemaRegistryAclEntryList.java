/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) The original authors
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.streamthoughts.jikkou.extension.aiven.collections;

import io.streamthoughts.jikkou.core.annotation.ApiVersion;
import io.streamthoughts.jikkou.core.annotation.Kind;
import io.streamthoughts.jikkou.core.models.DefaultResourceListObject;
import io.streamthoughts.jikkou.core.models.ObjectMeta;
import io.streamthoughts.jikkou.extension.aiven.models.V1KafkaQuota;
import io.streamthoughts.jikkou.extension.aiven.models.V1SchemaRegistryAclEntry;
import java.beans.ConstructorProperties;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ApiVersion("kafka.aiven.io/v1beta1")
@Kind("SchemaRegistryAclEntryList")
public class V1SchemaRegistryAclEntryList extends DefaultResourceListObject<V1SchemaRegistryAclEntry> {


    /**
     * Creates a new {@link V1SchemaRegistryAclEntryList} instance.
     *
     * @param kind       The resource Kind.
     * @param apiVersion The resource API Version.
     * @param metadata   The resource metadata.
     * @param items      The items.
     */
    @ConstructorProperties({
            "apiVersion",
            "kind",
            "metadata",
            "items"
    })
    public V1SchemaRegistryAclEntryList(@Nullable String kind,
                                        @Nullable String apiVersion,
                                        @Nullable ObjectMeta metadata,
                                        @NotNull List<? extends V1SchemaRegistryAclEntry> items) {
        super(kind, apiVersion, metadata, items);
    }

    /**
     * Creates a new {@link V1KafkaQuota} instance.
     *
     * @param items The items.
     */
    public V1SchemaRegistryAclEntryList(List<? extends V1SchemaRegistryAclEntry> items) {
        super(items);
    }
}
