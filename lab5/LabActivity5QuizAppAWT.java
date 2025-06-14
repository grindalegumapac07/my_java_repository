import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT {
    static String[] questions = {
        "What is also known as the \"brain\" of the computer?",
        "What is the binary number system made of?",
        "What does GUI stand for?"
    };

    static String[][] choices = {
        {"A. Monitor", "B. RAM", "C. CPU", "D. Hardware"},
        {"A. 0 and 1", "B. A to Z", "C. 1 to 9", "D. 0 to 10"},
        {"A. General User Interface", "B. Graphical User Interface", "C. Global Utility Integration", "D. Generated User Input"}
    };

    static String[] correctAnswers = {
        "C. CPU",
        "A. 0 and 1",
        "B. Graphical User Interface"
    };

    // Universal counter for current question and score
    static int currentQuestion = 0;
    static int score = 0;

    static Label lblQuestion;
    static Checkbox[] options = new Checkbox[4];
    static CheckboxGroup optionsGroup;
    static Button btnNext;
    static Label errorMessage;

    public LabActivity5QuizAppAWT() {
        Frame frame = new Frame("Quiz App");
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        lblQuestion = new Label("", Label.CENTER);
        customizedTextBold(lblQuestion);
        frame.add(lblQuestion, BorderLayout.NORTH);

        Panel pnlMiddle = new Panel(new GridLayout(2, 2));
        optionsGroup = new CheckboxGroup();

        // Display blank question choices
        for (int i = 0; i < 4; i++) {
            options[i] = new Checkbox("", optionsGroup, false);
            customizeCheckbox(options[i]);
            pnlMiddle.add(options[i]);
        }

        frame.add(pnlMiddle, BorderLayout.CENTER);

        Panel pnlBottom = new Panel(new GridLayout(2, 1));
        errorMessage = new Label("", Label.CENTER);
        pnlBottom.add(errorMessage);

        btnNext = new Button("Next");
        customizeButton(btnNext);
        pnlBottom.add(btnNext);

        frame.add(pnlBottom, BorderLayout.SOUTH);

        loadQuestion();

        // Button's functionality
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Checkbox selected = optionsGroup.getSelectedCheckbox();
                // If no selected answer
                if (selected == null) {
                    errorMessage.setText("Please select an answer.");
                    return;
                }

                // If answer is correct
                if (selected.getLabel().equals(correctAnswers[currentQuestion])) {
                    score++;
                }

                currentQuestion++;

                // If all questions answered or not
                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    showResult();
                }
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    static void loadQuestion() {
        lblQuestion.setText(questions[currentQuestion]);
        errorMessage.setText("");

        // Load and display question choices
        for (int i = 0; i < 4; i++) {
            options[i].setLabel(choices[currentQuestion][i]);
            options[i].setEnabled(true);
        }

        optionsGroup.setSelectedCheckbox(null);
    }

    static void showResult() {
        lblQuestion.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);

        // Disable answer choice selection
        for (Checkbox option : options) {
            option.setEnabled(false);
        }

        // Disable button, and remove selected choice and error message(if displayed)
        btnNext.setEnabled(false);
        optionsGroup.setSelectedCheckbox(null);
        errorMessage.setText("");
    }

    static void customizedTextBold(Component component) {
        component.setFont(new Font("Arial", Font.BOLD, 16));
    }

    static void customizeCheckbox(Checkbox checkbox) {
        checkbox.setForeground(Color.BLUE);
        checkbox.setFont(new Font("Arial", Font.PLAIN, 16));
    }

    static void customizeButton(Button button) {
        customizedTextBold(button);
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}