package org.spring.boost.channel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Channel<T> {
    private final BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    // 发送消息到Channel
    public void send(T message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 从Channel接收消息
    public T receive() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
