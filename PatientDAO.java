package com.hospital.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.models.*;

public class PatientDAO {
    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients (name, age, gender, diseases, allergies, attending_doctor, bed_number, room_number, floor_number, contact, emergency_contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getDiseases());
            stmt.setString(5, patient.getAllergies());
            stmt.setString(6, patient.getAttendingDoctor());
            stmt.setString(7, patient.getBedNumber());
            stmt.setString(8, patient.getRoomNumber());
            stmt.setString(9, patient.getFloorNumber());
            stmt.setString(10, patient.getContact());
            stmt.setString(11, patient.getEmergencyContact());
            stmt.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        String query = "SELECT * FROM patients";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setDiseases(rs.getString("diseases"));
                patient.setAllergies(rs.getString("allergies"));
                patient.setAttendingDoctor(rs.getString("attending_doctor"));
                patient.setBedNumber(rs.getString("bed_number"));
                patient.setRoomNumber(rs.getString("room_number"));
                patient.setFloorNumber(rs.getString("floor_number"));
                patient.setContact(rs.getString("contact"));
                patient.setEmergencyContact(rs.getString("emergency_contact"));
                patients.add(patient);
            }
        }
        return patients;
    }

    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patients SET name = ?, age = ?, gender = ?, diseases = ?, allergies = ?, attending_doctor = ?, bed_number = ?, room_number = ?, floor_number = ?, contact = ?, emergency_contact = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getDiseases());
            stmt.setString(5, patient.getAllergies());
            stmt.setString(6, patient.getAttendingDoctor());
            stmt.setString(7, patient.getBedNumber());
            stmt.setString(8, patient.getRoomNumber());
            stmt.setString(9, patient.getFloorNumber());
            stmt.setString(10, patient.getContact());
            stmt.setString(11, patient.getEmergencyContact());
            stmt.setInt(12, patient.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePatient(int id) throws SQLException {
        String query = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

