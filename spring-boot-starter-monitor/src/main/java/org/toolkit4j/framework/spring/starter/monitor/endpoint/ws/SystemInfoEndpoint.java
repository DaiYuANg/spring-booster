package org.toolkit4j.framework.spring.starter.monitor.endpoint.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.toolkit4j.framework.spring.starter.monitor.endpoint.services.ISystemInfoService;
import org.toolkit4j.libs.thready.async.AsyncWorker;

@ServerEndpoint("/dev/admin/system/info")
@Component
@Slf4j
public class SystemInfoEndpoint {

	private Session session;

	private static final CopyOnWriteArrayList<SystemInfoEndpoint> endpoints = new CopyOnWriteArrayList<>();

	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

	private static ISystemInfoService systemInfoService;

	private static ObjectMapper objectMapper;

	private static AsyncWorker asyncWorker;

	@Autowired
	public void setupSystemInfoService(ISystemInfoService systemInfoService) {
		SystemInfoEndpoint.systemInfoService = systemInfoService;
	}

	@Autowired
	public void setupObjectMapper(ObjectMapper gson) {
		SystemInfoEndpoint.objectMapper = gson;
	}

	@Autowired
	public void setupAsyncWorker(AsyncWorker asyncWorker) {
		SystemInfoEndpoint.asyncWorker = asyncWorker;
	}

	@PostConstruct
	public void init() {
		log.info("System info init");
		// var si = new SystemInfo();
		// MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		// MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
		// long max = heapMemoryUsage.getMax();
		// long used = heapMemoryUsage.getUsed();
		//
		// ThreadMXBean t = ManagementFactory.getThreadMXBean();
		// Arrays.stream(t.getAllThreadIds()).mapToObj(t::getThreadInfo).forEach(r -> {
		// System.err.println(r.getThreadName());
		// System.err.println(r.getThreadState());
		// });
		// List<GarbageCollectorMXBean> gcMXBeans =
		// ManagementFactory.getGarbageCollectorMXBeans();
		// String gcNames = gcMXBeans.stream()
		// .map(GarbageCollectorMXBean::getName)
		// .collect(Collectors.joining(","));
		// System.out.println("垃圾收集器：" + gcNames);
	}

	@OnOpen
	public void onOpen(@NotNull Session session) {
		this.session = session;
		endpoints.add(this);
		log.info("system info has connect:{}", endpoints.size());
	}

	@OnMessage
	public void onMessage(String message) {
		//		asyncWorker
		//				.supply(() -> new HashMap<String, Object>() {
		//					{
		//						put("now", DateUtil.date().toString());
		//						put("list", systemInfoService.getAllThreadOfCurrentJVM());
		//					}
		//				})
		//				.thenApply(r -> gson.toJson(r, new TypeToken<Map<String, Object>>() {}.getType()))
		//				.thenAccept(this::send);
	}

	@OnClose
	public void onClose(Session session) {
		endpoints.remove(this);
	}

	@SneakyThrows
	@OnError
	public void OnError(Session session, @NotNull Throwable throwable) {
		endpoints.remove(this);
		throw throwable;
	}

	private void send(String text) {
		session.getAsyncRemote().sendText(text);
	}
}
