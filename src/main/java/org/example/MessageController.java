package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("api/message")
    public ResponseEntity<String> read(@RequestBody final String message) {
        final var uppercaseMessage = String.join(" ", Arrays.asList(this.messageService.transform(message), this.messageService.transform(message), this.messageService.transform(message)));

        return ResponseEntity.ok(uppercaseMessage);
    }
}