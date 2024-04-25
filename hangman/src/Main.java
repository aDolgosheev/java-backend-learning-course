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
            System.out.println("Хотите сыграть? ([Д]а, [Н]ет): ");
            char answer = Character.toLowerCase(scanner.next().charAt(0));
            if (answer == 'д') {
                GameProcess gameProcess = new GameProcess();
                gameProcess.action();
            } else if (answer == 'н') {
                System.out.println("До свидания");
                correctAnswer = false;
            } else {
                System.out.println("Некорректный ответ. Попробуйте еще раз.");
            }
        }
    }
}