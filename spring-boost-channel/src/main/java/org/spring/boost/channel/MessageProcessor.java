package org.spring.boost.channel;

import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Component
public class MessageProcessor {
    private final Channel<String> messageChannel = new Channel<>();

    @Resource
    private Executor executor;

    @Async
    public void sendMessage(String message) {
        messageChannel.send(message);
    }

    @Async
    public void processMessages() {
        CompletableFuture.runAsync(() -> {
            while (true) {
                String message = messageChannel.receive();
                if (message != null) {
                    System.out.println("Received message: " + message);
                }
            }
        }, executor);
    }
}