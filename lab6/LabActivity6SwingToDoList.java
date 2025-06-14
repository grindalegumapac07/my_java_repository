import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class LabActivity6SwingToDoList {
    static JFrame frameViewer, frameForm;
    static JTable table;
    static DefaultTableModel tableModel;

    static final String[] columnNames = {"Task Name", "Task Description", "Status"};
    static final String[] statusOptions = {"Not Started", "Ongoing", "Completed"};

    public LabActivity6SwingToDoList() {
        frameViewer = new JFrame("To-Do List Viewer");
        frameViewer.setLayout(new BorderLayout());
        frameViewer.setSize(600, 400);
        frameViewer.setLocationRelativeTo(null);
        frameViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnAdd = new JButton("Add Task");

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frameForm == null || !frameForm.isVisible()) {
                    showTaskForm();
                }
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(btnAdd);
        frameViewer.add(topPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane spTable = new JScrollPane(table);
        frameViewer.add(spTable, BorderLayout.CENTER);

        frameViewer.setVisible(true);
    }

    static void showTaskForm() {
        frameForm = new JFrame("Add New Task");
        frameForm.setLayout(new BorderLayout(10, 10));
        frameForm.setSize(400, 300);
        frameForm.setLocationRelativeTo(frameViewer);
        frameForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTaskName = new JLabel("Task Name:");
        JTextField tfTaskName = new JTextField();

        JLabel lblTaskDescription = new JLabel("Task Description:");
        JTextArea taTaskDescription = new JTextArea(2, 1);
        taTaskDescription.setLineWrap(true);
        taTaskDescription.setWrapStyleWord(true);
        JScrollPane spTaskDescription = new JScrollPane(taTaskDescription);

        JLabel lblStatus = new JLabel("Status:");
        JComboBox<String> comboBox = new JComboBox<>(statusOptions);

        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 51, 10));
        formPanel.add(lblTaskName);
        formPanel.add(tfTaskName);
        formPanel.add(lblTaskDescription);
        formPanel.add(spTaskDescription);
        formPanel.add(lblStatus);
        formPanel.add(comboBox);

        JButton btnSave = new JButton("Save Task");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskName = tfTaskName.getText().trim();
                String taskDescription = taTaskDescription.getText().trim();
                String status = comboBox.getSelectedItem().toString();

                if (taskName.isEmpty() || taskDescription.isEmpty()) {
                    JOptionPane.showMessageDialog(frameForm,
                            "Please fill in Task Name and Status.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    tfTaskName.requestFocus();
                    return;
                }

                String[] data = {taskName, taskDescription, status};
                tableModel.addRow(data);
                frameForm.dispose();
            }
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnSave);

        frameForm.add(formPanel, BorderLayout.CENTER);
        frameForm.add(bottomPanel, BorderLayout.SOUTH);

        frameForm.setVisible(true);
    }

    public static void main(String[] args) {
        new LabActivity6SwingToDoList();
    }
}
