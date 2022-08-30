package gor.websocket_spring_example.contoller;

import com.google.gson.Gson;
import gor.websocket_spring_example.model.Message;
import gor.websocket_spring_example.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    private Gson gson = new Gson();

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom().toUpperCase(), "pong", time);
    }

//    @MessageMapping("/chat")
//    @SendToUser("/topic/messages")
//    public String send(
//        @Payload String message,
//        Principal principal) throws Exception {
//            return gson
//                    .fromJson(message, Map.class)
//                    .get("name").toString();
//    }

}
