package com.yy.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // register a websocket endpoint that the clients will use to connect to our websocket server.
        registry.addEndpoint("/ws").withSockJS(); // SockJS is used to enable fallback options for browsers that don’t support websocket.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // message broker is used to route messages from one client to another.
        // messages whose destination starts with “/app” should be routed to message-handling methods.
        registry.setApplicationDestinationPrefixes("/app");
        // messages whose destination starts with “/topic” should be routed to the message broker.
        // Message broker broadcasts messages to all the connected clients who are subscribed to a particular topic.
        registry.enableSimpleBroker("/topic");
    }

}
