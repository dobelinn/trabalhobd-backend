package com.trabalhobd.backend.controller;

import com.trabalhobd.backend.model.RedPill;
import com.trabalhobd.backend.service.RedPillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class RedPillController {
    private final RedPillService redPillService;

    public RedPillController(final RedPillService redPillService) {
        this.redPillService = redPillService;
    }

    @PostMapping("/redpill")
    RedPill createRedPill(@RequestBody RedPill redPill) {
        return redPillService.createRedPill(redPill);
    }

    @GetMapping("/redpills")
    List<RedPill> getAllRedPills() {
        return redPillService.getAllRedPills();
    }

    @GetMapping("/redpill/{redpillId}")
    RedPill getRedPillById(@PathVariable Long redpillId) {
        return redPillService.getRedPillById(redpillId);
    }

    @PutMapping("/redpill/{redpillId}")
    RedPill updateRedPill(@RequestBody RedPill redPillPutRequest, @PathVariable Long redpillId) {
        return redPillService.updateRedPill(redPillPutRequest, redpillId);
    }

    @DeleteMapping("/redpill/{redpillId}")
    String deleteRedPill(@PathVariable Long redpillId) {
        return redPillService.deleteRedPill(redpillId);
    }
}
