package com.fastcampus.websocket.hellowebsocket

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class HelloWebSocketHandler: TextWebSocketHandler() {

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println(">>> Connection Closed: ${session.id}")
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(">>> Receive Message : $message")
        session.sendMessage(TextMessage("I got your message, $message"))
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(">>> Client Connectd: ${session.id}")
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println(">>> Error: ${session.id}, ${exception.message}")
    }
}