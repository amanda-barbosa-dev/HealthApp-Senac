package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Reminder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String medicationName;

  @Column(nullable = false)
  private String date;

  @Column(nullable = false)
  private String time;



  public Reminder() {
  }
  public Reminder(Long id, String medicationName, String date, String time) {
    this.id = id;
    this.medicationName = medicationName;
    this.date = date;
    this.time = time;
  }

  public Long getId() {
    return id;
  }

  public String getMedicationName() {
    return medicationName;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public void setMedicationName(String medicationName) {
    this.medicationName = medicationName;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public void setId(Long id) {
    this.id = id;
  }
}


