package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final InfoService infoService;

    public InfoController(final InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("api/info")
    public ResponseEntity<Info> read() {
        final var startTime = this.infoService.getStartTime();
        final var uptime = this.infoService.getUptime();
        final var info = new Info(startTime, uptime);

        return ResponseEntity.ok(info);
    }
}