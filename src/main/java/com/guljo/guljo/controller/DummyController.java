package com.guljo.guljo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DummyController {
    @GetMapping("/track")
    public ResponseEntity<Void> track() {
        return ResponseEntity.ok().build(); // Just to avoid 404
    }
}