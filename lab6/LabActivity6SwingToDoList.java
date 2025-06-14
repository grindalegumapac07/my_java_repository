import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class LabActivity6SwingToDoList {

    // Declare main frames and components for viewer and form
    static JFrame frameViewer, frameForm;
    static JTable table;
    static DefaultTableModel tableModel;

    // Define column names for the table and status options for dropdown
    static final String[] columnNames = {"Task Name", "Task Description", "Status"};
    static final String[] statusOptions = {"Not Started", "Ongoing", "Completed"};

    public LabActivity6SwingToDoList() {
        frameViewer = new JFrame("To-Do List Viewer"); // Main window
        frameViewer.setLayout(new BorderLayout()); // Use BorderLayout
        frameViewer.setSize(600, 400); // Set window size
        frameViewer.setLocationRelativeTo(null); // Center on screen
        frameViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close

        // Button to open the task form
        JButton btnAdd = new JButton("Add Task");

        // When the button is clicked, show the form window
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frameForm == null || !frameForm.isVisible()) {
                    showTaskForm(); // Open the form window
                }
            }
        });

        // Panel to hold the "Add Task" button at the top
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(btnAdd);
        frameViewer.add(topPanel, BorderLayout.NORTH); // Add to top

        // Set up the table to display tasks
        tableModel = new DefaultTableModel(columnNames, 0); // No rows yet
        table = new JTable(tableModel);
        JScrollPane spTable = new JScrollPane(table); // Scrollable table
        frameViewer.add(spTable, BorderLayout.CENTER); // Add to center

        // Make the main window visible
        frameViewer.setVisible(true);
    }

    // Method to create and display the task input form
    static void showTaskForm() {
        frameForm = new JFrame("Add New Task"); // Form window
        frameForm.setLayout(new BorderLayout(10, 10)); // Add spacing
        frameForm.setSize(400, 300); // Set size
        frameForm.setLocationRelativeTo(frameViewer); // Position near viewer
        frameForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this form

        // Labels and input fields
        JLabel lblTaskName = new JLabel("Task Name:");
        JTextField tfTaskName = new JTextField();

        JLabel lblTaskDescription = new JLabel("Task Description:");
        JTextArea taTaskDescription = new JTextArea(2, 1); // Multi-line text area
        taTaskDescription.setLineWrap(true);
        taTaskDescription.setWrapStyleWord(true);
        JScrollPane spTaskDescription = new JScrollPane(taTaskDescription); // Scrollable

        JLabel lblStatus = new JLabel("Status:");
        JComboBox<String> comboBox = new JComboBox<>(statusOptions); // Dropdown

        // Organize form components using GridLayout
        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 51, 10)); // Padding
        formPanel.add(lblTaskName);
        formPanel.add(tfTaskName);
        formPanel.add(lblTaskDescription);
        formPanel.add(spTaskDescription);
        formPanel.add(lblStatus);
        formPanel.add(comboBox);

        // Save button to add task to the table
        JButton btnSave = new JButton("Save Task");

        // Save button action listener
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user inputs
                String taskName = tfTaskName.getText().trim();
                String taskDescription = taTaskDescription.getText().trim();
                String status = comboBox.getSelectedItem().toString();

                // Validate input: Task name and description cannot be empty
                if (taskName.isEmpty() || taskDescription.isEmpty()) {
                    JOptionPane.showMessageDialog(frameForm,
                            "Please fill in Task Name and Status.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    tfTaskName.requestFocus(); // Focus back to Task Name
                    return;
                }

                // Add the task to the table
                String[] data = {taskName, taskDescription, status};
                tableModel.addRow(data); // Append row
                frameForm.dispose(); // Close the form window
            }
        });

        // Bottom panel to hold the Save button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnSave);

        // Add panels to the form window
        frameForm.add(formPanel, BorderLayout.CENTER);
        frameForm.add(bottomPanel, BorderLayout.SOUTH);

        // Show the form
        frameForm.setVisible(true);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new LabActivity6SwingToDoList();
    }
}