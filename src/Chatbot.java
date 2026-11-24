
import java.util.Scanner;

public class Chatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to AI Chatbot!");
        System.out.println("Type bye to exit.");

        while (true) {

            System.out.print("You: ");

            String message = sc.nextLine().toLowerCase().trim();

            if (message.contains("hello") || message.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            }
            else if (message.contains("how are you")) {
                System.out.println("Bot: I am fine! Thanks for asking.");
            }
            else if (message.contains("your name")) {
                System.out.println("Bot: I am Java AI Chatbot.");
            }
            else if (message.contains("java")) {
                System.out.println("Bot: Java is an object-oriented programming language.");
            }
            else if (message.equals("bye")) {
                System.out.println("Bot: Goodbye!");
                break;
            }
            else if (message.contains("what is ai")) {
                System.out.println("Bot: AI stands for Artificial Intelligence.");
            }
            else if (message.contains("what is python")) {
                System.out.println("Bot: Python is a popular programming language.");
            }
            else if (message.contains("college")) {
                 System.out.println("Bot: College is a place for higher education.");
            }
            else if (message.contains("thank")) {
                 System.out.println("Bot: You're welcome!");
            }
            else if (message.contains("help")) {
                 System.out.println("Bot: Sure! What do you want to know?");
            }
            else {
                System.out.println("Bot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}
