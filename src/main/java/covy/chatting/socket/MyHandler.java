package covy.chatting.socket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

  private final Map<String, WebSocketSession> sessions = new HashMap<>();

  /**
   * afterConnectionEstablished: 최초 연결시 call
   *
   * @param session
   * @throws Exception
   */
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    final String sessionId = session.getId();
    final String enteredMessage = sessionId + "님이 입장하셨습니다.";
    sessions.put(sessionId, session);

    sendMessage(sessionId, new TextMessage(enteredMessage));

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
    //do something
    final String sessionId = session.getId();

    sendMessage(sessionId, message);
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
    final String sessionId = session.getId();
    final String leaveMessage = sessionId + "님이 떠났습니다.";
    sessions.remove(sessionId); // 삭제

    //메시지 전송
    sendMessage(sessionId, new TextMessage(leaveMessage));
  }

  /**
   * handleTransportError: 통신 에러 발생시 call
   *
   * @param session
   * @param exception
   * @throws Exception
   */
  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {}

  private void sendMessage(String sessionId, WebSocketMessage<?> message) {
    sessions.values().forEach(s -> {
      if(!s.getId().equals(sessionId) && s.isOpen()) {
        try {
          s.sendMessage(message);
        } catch (IOException e) {}
      }
    });
  }
}
