package com.trabalhobd.backend.controller;

import com.trabalhobd.backend.model.BluePill;
import com.trabalhobd.backend.service.BluePillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class BluePillController {
    private final BluePillService bluePillService;

    public BluePillController(final BluePillService bluePillService) {
        this.bluePillService = bluePillService;
    }

    @PostMapping("/bluepill")
    BluePill createBluePill(@RequestBody BluePill bluePill) {
        return bluePillService.createBluePill(bluePill);
    }

    @GetMapping("/bluepills")
    List<BluePill> getAllBluePills() {
        return bluePillService.getAllBluePills();
    }

    @GetMapping("/bluepill/{bluePillId}")
    BluePill getBluePillById(@PathVariable Long bluePillId) {
        return bluePillService.getBluePillById(bluePillId);
    }

    @PutMapping("/bluepill/{bluePillId}")
    BluePill updateBluePill(@RequestBody BluePill bluePillPutRequest, @PathVariable Long bluePillId) {
        return bluePillService.updateBluePill(bluePillPutRequest, bluePillId);
    }

    @DeleteMapping("/bluepill/{bluePillId}")
    String deleteBluePill(@PathVariable Long bluePillId) {
        return bluePillService.deleteBluePill(bluePillId);
    }
}
