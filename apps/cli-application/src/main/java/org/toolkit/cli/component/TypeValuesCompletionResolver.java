package org.toolkit.cli.component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.completion.CompletionResolver;

public class TypeValuesCompletionResolver implements CompletionResolver {
	@Override
	public List<CompletionProposal> apply(CompletionContext t) {
		return Stream.of("val1", "val2").map(CompletionProposal::new).collect(Collectors.toList());
	}
}
