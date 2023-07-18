package org.toolkit4J.tools.designer.events;

import javafx.event.EventHandler;
import javafx.scene.input.ZoomEvent;

public class ZoomEventHandler implements EventHandler<ZoomEvent> {
    @Override
    public void handle(ZoomEvent event) {
        System.err.println(event);
    }
}
