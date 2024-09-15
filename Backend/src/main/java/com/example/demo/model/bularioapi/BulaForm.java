package com.example.demo.model.bularioapi;

public class BulaForm {
    private String medicationName;

    private String labName;

    public BulaForm() {
    }

    public BulaForm(String medicationName/*,String labName*/) {
        this.medicationName = medicationName;
        //this.labName = labName;
    }

    public String getMedicationName() { return medicationName;
    }

    /*public String getLabName() { return labName;
    }*/

    public void setMedicationName(String medicamentionName) {
        this.medicationName = medicamentionName;
    }

   /* public void setLabName(String labName) {
        this.labName = labName;
    }*/

}
