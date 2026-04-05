package com.devbhumi.backend.controller;
import com.devbhumi.backend.dto.DailySummaryResponseDto;
import com.devbhumi.backend.service.DailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/daily-summary/")
public class DailySummaryController {

    @Autowired
    private DailySummaryService dailySummaryService;

    @PostMapping("/generate")
    public ResponseEntity<DailySummaryResponseDto> generate(@RequestParam LocalDate date) {
        DailySummaryResponseDto response = dailySummaryService.generateSummary(date);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DailySummaryResponseDto>> getAll() {
        List<DailySummaryResponseDto> responses = dailySummaryService.getAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DailySummaryResponseDto> findById(@PathVariable Long id) {
        DailySummaryResponseDto response = dailySummaryService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByDate")
    public ResponseEntity<DailySummaryResponseDto> findByDate(@RequestParam LocalDate date) {
        DailySummaryResponseDto response = dailySummaryService.getByDate(date);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        dailySummaryService.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
