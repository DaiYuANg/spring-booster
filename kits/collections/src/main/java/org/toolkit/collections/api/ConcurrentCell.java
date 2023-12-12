/* (C)2023*/
package org.toolkit.collections.api;

import javax.annotation.Nonnull;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

interface ConcurrentCell<R, C, V> {
	@Nonnull
	@NonNull @NotNull R getRowKey();

	@Nonnull
	@NonNull @NotNull C getColumnKey();

	@Nonnull
	@NonNull @NotNull V getValue();
}
