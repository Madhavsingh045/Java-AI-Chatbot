
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;


public class ChatbotGUI extends JFrame {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;
    JButton clearButton;

    public ChatbotGUI() {

        setTitle("AI Chatbot Assistant");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JLabel title = new JLabel("AI CHATBOT ASSISTANT", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setBackground(new Color(30, 70, 130));
        title.setOpaque(true);
        title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        add(title, BorderLayout.NORTH);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setBackground(new Color(240, 245, 250));
        chatArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        sendButton = new JButton("Send");
        sendButton.setBackground(new Color(30, 100, 200));
        sendButton.setForeground(Color.WHITE);

        clearButton = new JButton("Clear Chat");

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        bottomPanel.add(clearButton, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("Bot: Welcome! I am your AI Assistant.\n");
        chatArea.append("Bot: Ask me about Java, AI, NLP or Python.\n\n");

        // Button actions
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        clearButton.addActionListener(e -> {
            chatArea.setText("");
            chatArea.append("Bot: Chat cleared! How can I help you?\n\n");
        });

        setVisible(true);
    }

    private void sendMessage() {

        String message = inputField.getText().trim().toLowerCase();

        if (message.isEmpty()) {
            return;
        }

        chatArea.append("You: " + message + "\n");

        String response = getResponse(message);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");

        saveChat("You: " + message);
        saveChat("Bot: " + response);
    }
    private void saveChat(String chat) {
    try (FileWriter writer = new FileWriter("chat_history.txt", true)){
        writer.write(chat + "\n");
    }  
    catch (IOException e) {
        System.out.println("Error saving chat:" + e.getMessage());
        }
    } 

    private String getResponse(String message) {

        message = message.toLowerCase().trim();
        message = message.replaceAll("[^a-z0-9 ]", "");
        message = message.replace("learing", "learning");
        message = message.replace("npl", "nlp");

        if (message.contains("machine learning") || message.equals("ml")) {
            return "Machine Learning is a branch of AI that allows computers to learn from data and make predictions.";
        }

        else if (message.contains("nlp") || message.contains("natural language processing")) {
            return "NLP stands for Natural Language Processing. It helps computers understand human language.";
        }

        else if (message.equals("hello") || message.equals("hi") || message.equals("hey")) {
            return "Hello! Welcome to Java AI Chatbot.";
        }

        else if (message.contains("how are you")) {
            return "I am doing great! How can I help you?";
        }

        else if (message.contains("your name") || message.contains("who are you")) {
            return "I am your Java AI Assistant.";
        }

        else if (message.contains("artificial intelligence") || message.contains("what is ai") || message.contains("explain ai")) {
            return "AI enables machines to perform tasks that normally require human intelligence.";
        }

        else if (message.contains("java")) {
            return "Java is a popular object-oriented programming language.";
        }

        else if (message.contains("python")) {
            return "Python is a simple and powerful programming language.";
        }

        else if (message.contains("thank")) {
            return "You're welcome! Happy to help.";
        }

        else if (message.contains("help")) {
            return "You can ask me about Java, Python, AI, NLP and Machine Learning.";
        }

        else if (message.equals("bye")) {
            return "Goodbye! Have a wonderful day.";
        }

        else {
            return "Sorry, I don't understand. Please ask another question.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatbotGUI());
    }
}
