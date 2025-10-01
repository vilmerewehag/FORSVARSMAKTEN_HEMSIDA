package com.fm.demo.api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequestMapping("/api/chat")
public class ChatController {
  @PostMapping
  public ResponseEntity<?> chat(@RequestBody Map<String, String> body) {
    String prompt = body.getOrDefault("prompt", "");
    String reply = "Generellt råd: följ officiella kanaler (t.ex. Krisinformation.se).\nDin fråga: \"" + prompt + "\"";
    return ResponseEntity.ok(Map.of("reply", reply));
  }
}
