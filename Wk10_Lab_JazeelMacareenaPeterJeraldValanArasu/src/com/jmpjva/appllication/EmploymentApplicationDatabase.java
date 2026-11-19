package com.jmpjva.appllication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author jazeel
 * @since 2026-11-19
 * What this code does: 
 * Inserts employment application information into the MySQL database using JDBC PreparedStatement.
 */

public class EmploymentApplicationDatabase {
    public int saveApplication(EmploymentApplication application) throws SQLException {
        int result = 0;
        String query = "INSERT INTO employment_application " + "(full_name, current_address, contact_number, email_address, " + "education, gender, date_available, desired_position, " + "desired_salary, legally_authorized, has_relatives, " + "relatives_explanation, applicant_signature) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = Database.getDBConnection()) {
            if (connection == null) {
                throw new SQLException("Database connection failed!");
            }
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, application.getFullName());
                statement.setString(2, application.getCurrentAddress());
                statement.setString(3, application.getContactNumber());
                statement.setString(4, application.getEmailAddress());
                statement.setString(5, application.getEducation());
                statement.setString(6, application.getGender());
                if (application.getDateAvailable() == null || application.getDateAvailable().isBlank()) {
                    statement.setNull(7, Types.DATE);
                } 
                else {
                    statement.setDate(7, java.sql.Date.valueOf( application.getDateAvailable()));
                }
                statement.setString(8, application.getDesiredPosition());
                statement.setString(9, application.getDesiredSalary());
                statement.setBoolean(10, application.isLegallyAuthorized());
                statement.setBoolean(11, application.isHasRelatives());
                if (application.getRelativesExplanation() == null || application.getRelativesExplanation().isBlank()) {
                    statement.setNull(12, Types.VARCHAR);

                } 
                else {
                    statement.setString(12, application.getRelativesExplanation());
                }
                statement.setString(13, application.getApplicantSignature());
                result = statement.executeUpdate();
            }
        }
        return result;
    }
}
