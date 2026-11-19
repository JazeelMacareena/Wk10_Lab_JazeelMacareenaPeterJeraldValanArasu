package com.jmpjva.appllication;

/**
 * @author jazeel
 * @since 2026-11-19
 * What this code does: 
 * Stores the personal information and employment details entered by an applicant in the employment application form.
 */

public class EmploymentApplication {
    private int id;
    private String fullName;
    private String currentAddress;
    private String contactNumber;
    private String emailAddress;
    private String education;
    private String gender;
    private String dateAvailable;
    private String desiredPosition;
    private String desiredSalary;
    private boolean legallyAuthorized;
    private boolean hasRelatives;
    private String relativesExplanation;
    private String applicantSignature;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getCurrentAddress() {
        return currentAddress;
    }
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDateAvailable() {
        return dateAvailable;
    }
    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }
    public String getDesiredPosition() {
        return desiredPosition;
    }
    public void setDesiredPosition(String desiredPosition) {
        this.desiredPosition = desiredPosition;
    }
    public String getDesiredSalary() {
        return desiredSalary;
    }
    public void setDesiredSalary(String desiredSalary) {
        this.desiredSalary = desiredSalary;
    }
    public boolean isLegallyAuthorized() {
        return legallyAuthorized;
    }
    public void setLegallyAuthorized(boolean legallyAuthorized) {
        this.legallyAuthorized = legallyAuthorized;
    }
    public boolean isHasRelatives() {
        return hasRelatives;
    }
    public void setHasRelatives(boolean hasRelatives) {
        this.hasRelatives = hasRelatives;
    }
    public String getRelativesExplanation() {
        return relativesExplanation;
    }
    public void setRelativesExplanation(String relativesExplanation) {
        this.relativesExplanation = relativesExplanation;
    }
    public String getApplicantSignature() {
        return applicantSignature;
    }
    public void setApplicantSignature(String applicantSignature) {
        this.applicantSignature = applicantSignature;
    }
}
