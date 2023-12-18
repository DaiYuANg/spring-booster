/* (C)2023*/
package org.toolkit.spring.boot.web.core.conditions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.toolkit.spring.boot.web.annotation.Version;

@Slf4j
@Getter
@RequiredArgsConstructor
public class VersioningCondition implements RequestCondition<VersioningCondition> {

	private final Version version;

	@Override
	public @NotNull VersioningCondition combine(@NotNull VersioningCondition other) {
		return new VersioningCondition(other.version);
	}

	@Override
	public VersioningCondition getMatchingCondition(@NotNull HttpServletRequest request) {
		return null;
	}

	@Override
	public int compareTo(@NotNull VersioningCondition other, @NotNull HttpServletRequest request) {
		return 0;
	}
}
