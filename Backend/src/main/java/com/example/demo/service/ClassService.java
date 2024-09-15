package com.example.demo.service;


import com.example.demo.integrator.bularioapi.BularioFeignClientIntegrator;
import com.example.demo.model.Reminder;
import com.example.demo.model.bularioapi.Content;
import com.example.demo.model.bularioapi.SearchMedResponse;
import com.example.demo.repository.ReminderRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class ClassService {

    @Autowired
    BularioFeignClientIntegrator bularioFeignClientIntegrator;

    @Autowired
    ReminderRepository reminderRepository;

    // Get Bula from Medication Name
    public byte[] getBula(String medicationName/*,String labName*/) {
        SearchMedResponse response = bularioFeignClientIntegrator.searchMedication(medicationName);
        List<Content> contentList = response.getContent();
        String id = contentList.get(0).getIdBulaPacienteProtegido();

        /*for (Content content : contentList) {
            if (content.getRazaoSocial().contains(labName.toUpperCase())){
                id = content.getIdBulaPacienteProtegido();
                System.out.println(id);
                break;
            }
        }*/
        try {
            return bularioFeignClientIntegrator.getBula(id);
        } catch (FeignException e) {
            throw new RuntimeException("Unabled to process request to BularioAPI: " + e.getMessage());
        }
    }

    // Create/Save a Reminder
    public void saveReminder(Reminder reminder) {
        try {
            reminderRepository.save(reminder);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save product: " + e.getMessage());
        }
    }

    // Get all Reminders
    public List<Reminder> fetchAllReminders() {
        try {
            return reminderRepository.findAll();
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to fetch all products: " + e.getMessage());
        }
    }

    // Get a Reminder by ID
    public Optional<Reminder> fetchReminderById(Long id) {
        try {
            return reminderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch product by ID: " + e.getMessage());
        }
    }

    // Update a Reminder by Id
    public Optional<Reminder> updateReminder(Long id, Reminder updatedReminder) {
        try {
            Optional<Reminder> existingReminderOptional = reminderRepository.findById(id);
            if (existingReminderOptional.isPresent()) {
                Reminder existingProduct = existingReminderOptional.get();
                existingProduct.setMedicationName(updatedReminder.getMedicationName());
                existingProduct.setDate(updatedReminder.getDate());
                existingProduct.setTime(updatedReminder.getTime());
                Reminder savedEntity = reminderRepository.save(existingProduct);
                return Optional.of(savedEntity);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product: " + e.getMessage());
        }
    }

    //Delete a Reminder by Id
    public boolean deleteReminder(Long id) {
        try {
            reminderRepository.deleteById(id);
            return true; // Deletion successful
        } catch (Exception e) {
            // Handle exception or log the error
            throw new RuntimeException("Failed to delete product: " + e.getMessage());
        }
    }

}

