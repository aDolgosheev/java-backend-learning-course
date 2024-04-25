import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameProcess {

    static Scanner scanner = new Scanner(System.in);

    public static void action() {
        Random random = new Random();
        String hiddenWord = HangmanWordBank.WORDBANK.get(random.nextInt(HangmanWordBank.WORDBANK.size()));

        System.out.println("Отлично! Давай начнем.");
        System.out.println("Введите символ: ");

    }
}
