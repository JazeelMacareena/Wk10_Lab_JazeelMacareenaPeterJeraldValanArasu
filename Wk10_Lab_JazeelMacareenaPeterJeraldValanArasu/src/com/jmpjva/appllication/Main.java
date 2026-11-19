package com.jmpjva.appllication;

import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author jazeel
 * @since 2026-11-19
 * What this code does: 
 * Displays an employment application form and submits applicant information to the MySQL database.
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        EmploymentApplicationDatabase applicationDatabase = new EmploymentApplicationDatabase();
        primaryStage.setTitle("Employment Application");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 25, 20, 25));
        Text sceneTitle = new Text("Employment Application");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        Text personalTitle = new Text("Personal Information");
        personalTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(personalTitle, 0, 1, 2, 1);
        Label fullNameLabel = new Label("Full Name:");
        grid.add(fullNameLabel, 0, 2);
        TextField fullNameTextField = new TextField();
        grid.add(fullNameTextField, 1, 2);
        Label addressLabel = new Label("Current Address:");
        grid.add(addressLabel, 0, 3);
        TextField addressTextField = new TextField();
        grid.add(addressTextField, 1, 3);
        Label contactLabel = new Label("Contact Number:");
        grid.add(contactLabel, 0, 4);
        TextField contactTextField = new TextField();
        grid.add(contactTextField, 1, 4);
        Label emailLabel = new Label("Email Address:");
        grid.add(emailLabel, 0, 5);
        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 5);
        Label educationLabel = new Label("Highest Educational Attainment:");
        grid.add(educationLabel, 0, 6);
        TextField educationTextField = new TextField();
        grid.add(educationTextField, 1, 6);
        Label genderLabel = new Label("Gender:");
        grid.add(genderLabel, 0, 7);
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        RadioButton otherRadioButton = new RadioButton("Other");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);
        otherRadioButton.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(12, maleRadioButton, femaleRadioButton, otherRadioButton);
        grid.add(genderBox, 1, 7);
        Text employmentTitle = new Text("Employment Eligibility");
        employmentTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid.add(employmentTitle, 0, 8, 2, 1);
        Label dateLabel = new Label("Date Available:");
        grid.add(dateLabel, 0, 9);
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        grid.add(datePicker, 1, 9);
        Label positionLabel = new Label("Desired Position:");
        grid.add(positionLabel, 0, 10);
        TextField positionTextField = new TextField();
        grid.add(positionTextField, 1, 10);
        Label salaryLabel = new Label("Desired Salary:");
        grid.add(salaryLabel, 0, 11);
        TextField salaryTextField = new TextField();
        grid.add(salaryTextField, 1, 11);
        Label authorizedLabel = new Label("Legally authorized to work in the country?");
        grid.add(authorizedLabel, 0, 12, 2, 1);
        RadioButton authorizedYes = new RadioButton("Yes");
        RadioButton authorizedNo = new RadioButton("No");
        ToggleGroup authorizedGroup = new ToggleGroup();
        authorizedYes.setToggleGroup(authorizedGroup);
        authorizedNo.setToggleGroup(authorizedGroup);
        HBox authorizedBox = new HBox(12, authorizedYes, authorizedNo);
        grid.add(authorizedBox, 1, 13);
        Label relativesLabel = new Label("Do you have relatives working for our company?");
        grid.add(relativesLabel, 0, 14, 2, 1);
        RadioButton relativesYes = new RadioButton("Yes");
        RadioButton relativesNo = new RadioButton("No");
        ToggleGroup relativesGroup = new ToggleGroup();
        relativesYes.setToggleGroup(relativesGroup);
        relativesNo.setToggleGroup(relativesGroup);
        HBox relativesBox = new HBox(12, relativesYes, relativesNo);
        grid.add(relativesBox, 1, 15);
        Label explanationLabel = new Label("If yes, please explain:");
        grid.add(explanationLabel, 0, 16);
        TextArea explanationTextArea = new TextArea();
        explanationTextArea.setPrefRowCount(2);
        explanationTextArea.setWrapText(true);
        grid.add(explanationTextArea, 1, 16);
        Label signatureLabel = new Label("Applicant's Signature:");
        grid.add(signatureLabel, 0, 17);
        TextField signatureTextField = new TextField();
        grid.add(signatureTextField, 1, 17);
        Button submitButton = new Button("Submit");
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(submitButton);
        grid.add(buttonBox, 1, 18);
        submitButton.setOnAction(actionEvent -> {
            String fullName = fullNameTextField.getText().trim();
            String address = addressTextField.getText().trim();
            String contact = contactTextField.getText().trim();
            String email = emailTextField.getText().trim();
            String education = educationTextField.getText().trim();
            String position = positionTextField.getText().trim();
            String salary = salaryTextField.getText().trim();
            String signature = signatureTextField.getText().trim();
            if (fullName.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty() || education.isEmpty() || position.isEmpty() || salary.isEmpty() || signature.isEmpty() || genderGroup.getSelectedToggle() == null || authorizedGroup.getSelectedToggle() == null || relativesGroup.getSelectedToggle() == null || datePicker.getValue() == null) {
                this.alert("Error", "Please complete all required fields!", AlertType.ERROR);
            } 
            else {
                String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
                EmploymentApplication application = this.createApplicationObject(fullName, address, contact, email, education, gender, datePicker.getValue().toString(), position, salary, authorizedYes.isSelected(), relativesYes.isSelected(), explanationTextArea.getText().trim(), signature);
                try {
                    int result = applicationDatabase.saveApplication(application);
                    if (result > 0) {
                        this.alert("Submit", "Application submitted successfully!", AlertType.INFORMATION);
                        fullNameTextField.clear();
                        addressTextField.clear();
                        contactTextField.clear();
                        emailTextField.clear();
                        educationTextField.clear();
                        genderGroup.selectToggle(null);
                        datePicker.setValue(LocalDate.now());
                        positionTextField.clear();
                        salaryTextField.clear();
                        authorizedGroup.selectToggle(null);
                        relativesGroup.selectToggle(null);
                        explanationTextArea.clear();
                        signatureTextField.clear();
                    } else {
                        this.alert("Error", "Application was not saved!", AlertType.ERROR);
                    }
                } catch (SQLException ex) {
                    System.out.println("Exception occurred");
                    System.out.println(ex.getMessage());
                    this.alert("Database Error", ex.getMessage(), AlertType.ERROR);
                }
            }
        });
        Scene scene = new Scene(grid, 750, 780);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void alert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public EmploymentApplication createApplicationObject(
            String fullName,
            String currentAddress,
            String contactNumber,
            String emailAddress,
            String education,
            String gender,
            String dateAvailable,
            String desiredPosition,
            String desiredSalary,
            boolean legallyAuthorized,
            boolean hasRelatives,
            String relativesExplanation,
            String applicantSignature) {
        EmploymentApplication application = new EmploymentApplication();
        application.setFullName(fullName);
        application.setCurrentAddress(currentAddress);
        application.setContactNumber(contactNumber);
        application.setEmailAddress(emailAddress);
        application.setEducation(education);
        application.setGender(gender);
        application.setDateAvailable(dateAvailable);
        application.setDesiredPosition(desiredPosition);
        application.setDesiredSalary(desiredSalary);
        application.setLegallyAuthorized(legallyAuthorized);
        application.setHasRelatives(hasRelatives);
        application.setRelativesExplanation(relativesExplanation);
        application.setApplicantSignature(applicantSignature);
        return application;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
