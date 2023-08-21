package org.toolkit.spring.boot.starter.dict.hub;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.dict.configuration.DictConfigurationProperties;
import org.toolkit.spring.boot.starter.dict.funcational.DictFunctional;
import org.toolkit.spring.boot.starter.dict.funcational.DictItem;
import org.toolkit.spring.boot.starter.dict.scanner.DictScanner;

@Slf4j
@Component
public class DefaultDictManagerImpl implements DictManager {

	@Resource
	private DictScanner dictScanner;

	@Resource
	private DictConfigurationProperties dictConfigurationProperties;

	//    @Resource
	//    private AsyncWorker asyncWorker;

	private final ConcurrentMap<String, AtomicInteger> hit = new ConcurrentSkipListMap<>();

	private final ConcurrentSkipListMap<String, DictFunctional> storage = new ConcurrentSkipListMap<>();

	//    @Resource
	//    private Cache<String, DictFunctional> cache;

	/**
	 * On bean initial do dict definition scan in class path
	 */
	@PostConstruct
	public void init() {
		if (!dictConfigurationProperties.isLoadDictMetadata()) return;
		// if (dictConfigurationProperties.isAsync()) {
		// asyncLoad();
		// return;
		// }
		syncLoad();
	}

	//    private void asyncLoad() {
	//        asyncWorker
	//                .supply(dictScanner::doScan)
	//                .thenAccept(storage::putAll)
	//                .thenApply(r -> "Dict Scanner scanned:{} finish")
	//                .thenAccept(r -> log.info(r, dictScanner.scannedClasspath.keySet()));
	//    }

	private void syncLoad() {
		storage.putAll(dictScanner.doScan());
	}

	public Optional<DictFunctional> get(String code) {
		return Optional.ofNullable(storage.get(code));
	}

	public Optional<DictItem> searchByValue(String value) {
		return storage.values().stream()
				.flatMap(d -> d.searchByValueOptional(value).stream())
				.findFirst();
	}
}