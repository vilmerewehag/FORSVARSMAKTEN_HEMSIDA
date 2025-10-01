package com.fm.demo.api;
import com.fm.demo.model.Tip;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.*;

@RestController @RequestMapping("/api/tips")
public class TipController {

  private final List<Map<String,Object>> memory = new ArrayList<>();

  @PostMapping
  public ResponseEntity<?> postTip(@Valid @RequestBody Tip tip) {
    Map<String,Object> saved = new LinkedHashMap<>();
    saved.put("id", UUID.randomUUID().toString());
    saved.put("createdAt", Instant.now().toString());
    saved.put("category", tip.category);
    saved.put("message", tip.message);
    saved.put("location", tip.location);
    saved.put("contactEmail", tip.contactEmail);
    memory.add(saved);
    return ResponseEntity.status(201).body(Map.of("status","received","id",saved.get("id")));
  }

  @GetMapping   // enkel lista för test
  public List<Map<String,Object>> all() { return memory; }
}
