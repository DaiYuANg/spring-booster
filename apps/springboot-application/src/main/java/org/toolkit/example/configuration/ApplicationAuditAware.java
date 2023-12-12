/* (C)2023*/
package org.toolkit.example.configuration;

import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class ApplicationAuditAware implements AuditorAware<String> {
	@Override
	public @NotNull Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null
				|| !authentication.isAuthenticated()
				|| authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}
		User userPrincipal = (User) authentication.getPrincipal();
		return Optional.ofNullable(userPrincipal.getUsername());
	}
}
