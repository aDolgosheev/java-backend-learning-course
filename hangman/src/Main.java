import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Здравствуйте!\nПеред вами игра \"Виселица\"!");
        toPlay();
    }

    public static void toPlay() {
        boolean correctAnswer = true;
        while (correctAnswer) {
            System.out.println("Хотите сыграть? ('Y' - да, 'N' - нет): ");
            String answer = scanner.next().toLowerCase();
            if (answer.equals("y")) {
                GameProcess.action();
            } else if (answer.equals("n")) {
                System.out.println("До свидания");
                correctAnswer = false;
            } else {
                System.out.println("Некорректный ответ. Попробуйте еще раз.");
            }
        }
    }
}