package com.observability.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/observability")
public class ObservabilityController {

    @PostMapping("/log")
    public ResponseEntity<?> receiveLog(@RequestBody Map<String, Object> logEvent) {

        // Simulação de processamento de log
        System.out.println("📥 LOG RECEBIDO: " + logEvent);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Log received successfully");
        response.put("received", logEvent);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/metric")
    public ResponseEntity<?> receiveMetric(@RequestBody Map<String, Object> metricEvent) {

        // Simulação de processamento de métrica
        System.out.println("📊 MÉTRICA RECEBIDA: " + metricEvent);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Metric received successfully");
        response.put("received", metricEvent);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<?> healthCheck() {

        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "observability-api");

        return ResponseEntity.ok(response);
    }
}
