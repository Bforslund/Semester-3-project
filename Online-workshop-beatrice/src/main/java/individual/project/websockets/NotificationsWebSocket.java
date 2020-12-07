package individual.project.websockets;

import org.glassfish.grizzly.websockets.WebSocket;
import org.glassfish.grizzly.websockets.WebSocketApplication;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NotificationsWebSocket extends WebSocketApplication {
    private static final Set<WebSocket> sockets = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void onConnect(WebSocket socket) {
        sockets.add(socket);
        System.out.println("onConnect");
        super.onConnect(socket);
    }

    @Override
    public void onMessage(WebSocket current, String text) {
        System.out.println("onMessage");

        synchronized (sockets) {
            sockets.forEach(socket -> {
                if (socket.isConnected()) {
                    socket.send(text);
                }
            });
        }
    }

    @Override
    public void onMessage(WebSocket socket, byte[] bytes) {
        socket.send(bytes);
    }


}
