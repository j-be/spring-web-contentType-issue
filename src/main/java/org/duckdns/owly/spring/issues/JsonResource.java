package org.duckdns.owly.spring.issues;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Map;

@Controller
@ApplicationScope
public class JsonResource {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> greet() {
        return ResponseEntity.ok(Map.of("hello", "world"));
    }
}
