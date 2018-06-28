package com.swpu.third_websocket_demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SwpuController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public SwpuResponse say(SwpuMessage swpuMessage) throws InterruptedException {
        Thread.sleep(3000);
        return new SwpuResponse(swpuMessage.getMessage()+"!");
    }
}
