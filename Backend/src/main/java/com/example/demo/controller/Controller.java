package com.example.demo.controller;


import com.example.demo.model.Reminder;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private ClassService classService;

    @GetMapping("/searchBula")
    public ResponseEntity<byte[]> pesquisarBula(@RequestParam String medName/*, @RequestParam String labName*/) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        var response = classService.getBula(medName/*,String labName*/);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/createReminder")
    public ResponseEntity<Void> createReminder(@RequestBody Reminder reminder) {
        classService.saveReminder(reminder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = classService.fetchAllReminders();
        return ResponseEntity.ok(reminders);
    }

    @GetMapping("/reminder/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable(value = "id") long id) {
        Optional<Reminder> reminder = classService.fetchReminderById(id);
        return reminder.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Optional<Reminder> updatedReminderOptional = classService.updateReminder(id, reminder);
        return updatedReminderOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean deletionStatus = classService.deleteReminder(id);
        if (deletionStatus) {
            return ResponseEntity.ok("Product with ID " + id + " has been deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product with ID " + id);
        }
    }
}
