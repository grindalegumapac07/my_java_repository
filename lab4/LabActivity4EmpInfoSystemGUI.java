import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI {
    public static void main(String[] args) {
        Frame frame = new Frame("Laboratory Activity 4");
        frame.setSize(425, 525);
        frame.setResizable(false);

        // Main panel
        Panel pnlMain = new Panel(new GridLayout(3,1));

        // Panel for form fields (labels and textfields)
        Panel pnlForm = new Panel(new GridLayout(5,2));

        // First name
        pnlForm.add(new Label("First Name"));
        TextField tfFirstName = new TextField();
        pnlForm.add(tfFirstName);

        // Last name
        pnlForm.add(new Label("Last Name"));
        TextField tfLastName = new TextField();
        pnlForm.add(tfLastName);

        // Age
        pnlForm.add(new Label("Age"));
        TextField tfAge = new TextField();
        pnlForm.add(tfAge);

        // Hours Worked
        pnlForm.add(new Label("Hours Worked"));
        TextField tfHoursWork = new TextField();
        pnlForm.add(tfHoursWork);

        // Hourly Rate
        pnlForm.add(new Label("Hourly Rate"));
        TextField tfHourlyRate = new TextField();
        pnlForm.add(tfHourlyRate);

        // Panel for the submit button (button)
        Panel pnlButton = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnSubmit = new Button("Submit");
        pnlButton.add(btnSubmit);

        // Panel for the output (text area)
        Panel pnlOutput = new Panel(new GridLayout(2, 1));
        pnlOutput.add(new Label("Output:"));
        TextArea taOutput = new TextArea(3,1);
        taOutput.setEditable(false);
        pnlOutput.add(taOutput);

        // Add the three minor panels to main panel
        pnlMain.add(pnlForm);
        pnlMain.add(pnlButton);
        pnlMain.add(pnlOutput);

        // Add main panel to frame
        frame.add(pnlMain);

        // Give button's functionality
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actEvent) {
                String firstName = tfFirstName.getText().trim();
                String lastName = tfLastName.getText().trim();
                String ageText = tfAge.getText().trim();
                String hoursText = tfHoursWork.getText().trim();
                String rateText = tfHourlyRate.getText().trim();
        
                // Text fields validation
                if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() ||
                    hoursText.isEmpty() || rateText.isEmpty()) {
                    taOutput.setText("Error: All fields must be filled out.");
                    return;
                }
        
                int age;
                double hours, rate;
        
                // Validate age
                try {
                    age = Integer.parseInt(ageText);
                } catch (NumberFormatException error) {
                    taOutput.setText("Error: Age must be a valid integer.");
                    return;
                }
        
                // Validate hours worked and hourly rate
                try {
                    hours = Double.parseDouble(hoursText);
                    rate = Double.parseDouble(rateText);
                } catch (NumberFormatException error) {
                    taOutput.setText("Error: Hours worked and hourly rate must be valid numbers.");
                    return;
                }
        
                // Do calculation and output
                double salary = hours * rate;
                String output = "Full Name: " + firstName + " " + lastName +
                                "\nAge: " + age + " years old" +
                                String.format("\nDaily Salary: PHP %.2f", salary);
                taOutput.setText(output);
            }
        });

        // Exit window/frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent winEvent) {
                frame.dispose();
            }
        });

        // Set frame's visibility to true
        frame.setVisible(true);  
    }
}
