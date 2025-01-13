package com.hospital.services.impl;

import java.sql.SQLException;
import java.util.Scanner;

import com.hospital.dao.impl.PatientDAO;
import com.hospital.models.Patient;

public class MainApp {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hospital Food Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        Patient newPatient = new Patient();
                        System.out.print("Enter name: ");
                        newPatient.setName(scanner.nextLine());
                        System.out.print("Enter age: ");
                        newPatient.setAge(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter gender: ");
                        newPatient.setGender(scanner.nextLine());
                        System.out.print("Enter diseases: ");
                        newPatient.setDiseases(scanner.nextLine());
                        System.out.print("Enter allergies: ");
                        newPatient.setAllergies(scanner.nextLine());
                        System.out.print("Enter attending doctor: ");
                        newPatient.setAttendingDoctor(scanner.nextLine());
                        System.out.print("Enter bed number: ");
                        newPatient.setBedNumber(scanner.nextLine());
                        System.out.print("Enter room number: ");
                        newPatient.setRoomNumber(scanner.nextLine());
                        System.out.print("Enter floor number: ");
                        newPatient.setFloorNumber(scanner.nextLine());
                        System.out.print("Enter contact: ");
                        newPatient.setContact(scanner.nextLine());
                        System.out.print("Enter emergency contact: ");
                        newPatient.setEmergencyContact(scanner.nextLine());

                        patientDAO.addPatient(newPatient);
                        System.out.println("Patient added successfully.");
                        break;
                    case 2:
                        for (Patient patient : patientDAO.getAllPatients()) {
                            System.out.println(patient);
                        }
                        break;
                    case 3:
                        System.out.print("Enter patient ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Patient updatedPatient = new Patient();
                        updatedPatient.setId(updateId);
                        System.out.print("Enter new name: ");
                        updatedPatient.setName(scanner.nextLine());
                        System.out.print("Enter new age: ");
                        updatedPatient.setAge(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new gender: ");
                        updatedPatient.setGender(scanner.nextLine());
                        System.out.print("Enter new diseases: ");
                        updatedPatient.setDiseases(scanner.nextLine());
                        System.out.print("Enter new allergies: ");
                        updatedPatient.setAllergies(scanner.nextLine());
                        System.out.print("Enter new attending doctor: ");
                        updatedPatient.setAttendingDoctor(scanner.nextLine());
                        System.out.print("Enter new bed number: ");
                        updatedPatient.setBedNumber(scanner.nextLine());
                        System.out.print("Enter new room number: ");
                        updatedPatient.setRoomNumber(scanner.nextLine());
                        System.out.print("Enter new floor number: ");
                        updatedPatient.setFloorNumber(scanner.nextLine());
                        System.out.print("Enter new contact: ");
                        updatedPatient.setContact(scanner.nextLine());
                        System.out.print("Enter new emergency contact: ");
                        updatedPatient.setEmergencyContact(scanner.nextLine());

                        patientDAO.updatePatient(updatedPatient);
                        System.out.println("Patient updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter patient ID to delete: ");
                        int deleteId = scanner.nextInt();
                        patientDAO.deletePatient(deleteId);
                        System.out.println("Patient deleted successfully.");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        }
    }
}

