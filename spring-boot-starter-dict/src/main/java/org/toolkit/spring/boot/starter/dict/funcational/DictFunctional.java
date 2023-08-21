package org.toolkit.spring.boot.starter.dict.funcational;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.starter.dict.exceiptions.DictNotFoundException;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class DictFunctional {
	String code;

	String description;

	ConcurrentMap<String, DictItem> items;

	public Optional<DictItem> getByCodeOptional(String code) {
		return Optional.ofNullable(items.get(code));
	}

	public DictItem getByCode(String code) {
		return getByCodeOptional(code).orElseThrow(DictNotFoundException::new);
	}

	public Map<String, DictItem> getAll() {
		return items;
	}

	public Optional<DictItem> searchByValueOptional(String value) {
		return items.values().stream().filter(v -> v.code().equals(value)).findFirst();
	}

	public DictItem searchByValue(String value) {
		return searchByValueOptional(value).orElseThrow(DictNotFoundException::new);
	}

	public Optional<DictItem> searchByTextOptional(String text) {
		return items.values().stream().filter(v -> v.text().equals(text)).findFirst();
	}

	public DictItem searchByText(String text) {
		return searchByTextOptional(text).orElseThrow(DictNotFoundException::new);
	}
}