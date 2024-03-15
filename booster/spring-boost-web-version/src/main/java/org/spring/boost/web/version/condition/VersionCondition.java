/* (C)2023*/
package org.spring.boost.web.version.condition;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

@Slf4j
public record VersionCondition(String version) implements RequestCondition<VersionCondition> {

    @Override
    public @NotNull VersionCondition combine(@NotNull VersionCondition other) {
        return new VersionCondition(other.version);
    }

    @Contract(pure = true)
    @Override
    public @Nullable VersionCondition getMatchingCondition(@NotNull HttpServletRequest request) {
        return null;
    }

    @Override
    public int compareTo(@NotNull VersionCondition other, @NotNull HttpServletRequest request) {
        return 0;
    }
}
