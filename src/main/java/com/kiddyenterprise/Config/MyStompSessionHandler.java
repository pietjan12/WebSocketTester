package com.kiddyenterprise.Config;

import com.kiddyenterprise.Domain.Item;
import com.kiddyenterprise.Domain.WonItemMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {
    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/4/items", this);
        logger.info("Subscribed to /topic/4/items");
        session.send("/app/4/items", getTestItem());
        logger.info("Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return WonItemMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        WonItemMessage receivedItem = (WonItemMessage) payload;
        logger.info("Received : " + receivedItem.getCaseID());
        logger.info("Received item : " + receivedItem.getItem().getName());
    }

    private Item getTestItem() {
        Item myItem = new Item(1, "mooi itempje", 10.00f);
        return myItem;
    }
}
