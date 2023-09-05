/*
 * Copyright 2023 The original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.jikkou.extension.aiven.change.handler;

import io.streamthoughts.jikkou.api.control.ChangeDescription;
import io.streamthoughts.jikkou.api.control.ChangeResponse;
import io.streamthoughts.jikkou.api.control.ChangeType;
import io.streamthoughts.jikkou.api.control.ValueChange;
import io.streamthoughts.jikkou.extension.aiven.api.AivenApiClient;
import io.streamthoughts.jikkou.extension.aiven.api.data.KafkaQuotaEntry;
import io.streamthoughts.jikkou.extension.aiven.change.KafkaChangeDescriptions;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class DeleteKafkaQuotaChangeHandler extends AbstractChangeHandler<KafkaQuotaEntry> {

    /**
     * Creates a new {@link DeleteKafkaQuotaChangeHandler} instance.
     *
     * @param api the {@link AivenApiClient} instance.
     */
    public DeleteKafkaQuotaChangeHandler(@NotNull final AivenApiClient api) {
        super(api, ChangeType.DELETE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChangeResponse<ValueChange<KafkaQuotaEntry>>> apply(@NotNull List<ValueChange<KafkaQuotaEntry>> changes) {
        return changes.stream()
                .map(change -> executeAsync(change, () -> api.deleteKafkaQuota(change.getBefore())))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChangeDescription getDescriptionFor(@NotNull ValueChange<KafkaQuotaEntry> change) {
        return KafkaChangeDescriptions.of(change.getChangeType(), change.getBefore());
    }
}
