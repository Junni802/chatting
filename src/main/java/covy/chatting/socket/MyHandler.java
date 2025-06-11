package covy.chatting.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

  /**
   * afterConnectionEstablished: 최초 연결시 call
   *
   * @param session
   * @throws Exception
   */
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {

  }

  /**
   * handleTextMessage: 연결 후 메세지를 주고 받을 때 call
   *
   * @param session
   * @param message
   * @throws Exception
   */
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

  }

  /**
   * afterConnectionClosed: 웹소켓이 끊키면 call
   *
   * @param session
   * @param status
   * @throws Exception
   */
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

  }

  /**
   * handleTransportError: 통신 에러 발생시 call
   *
   * @param session
   * @param exception
   * @throws Exception
   */
  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

  }
}
