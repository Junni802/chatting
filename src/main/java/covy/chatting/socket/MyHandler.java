package covy.chatting.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {

  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

  }
}
