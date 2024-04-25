import java.util.*;

public class GameProcess {

    static Scanner scanner = new Scanner(System.in);

    public void action() {
        Random random = new Random();
        String word = HangmanWordBank.WORDBANK.get(random.nextInt(HangmanWordBank.WORDBANK.size())).toUpperCase();
        char[] hiddenWord = new char[word.length()];
        Arrays.fill(hiddenWord, '_' );

        System.out.println("Отлично! Давайте начнем.");

        Set<Character> lettersUsed = new HashSet<>();
        int lives = 7;
        while (lives > 0) {
            System.out.println("Осталось попыток: " + lives);
            System.out.println("\n" + printHiddenWord(hiddenWord) + "                  " + word); // слово указано справа в явном виде для проверки
            System.out.println("\nВведите символ: ");
            char letter = Character.toUpperCase(scanner.next().charAt(0));
            if (!lettersUsed.add(letter)) {
                System.out.println("Вы уже предлагали эту букву, выберите другую.");
            } else if (word.contains(String.valueOf(letter))) {
                lettersUsed.add(letter);
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        hiddenWord[i] = letter;
                    }
                }
                if (!String.valueOf(hiddenWord).contains("_")) {
                    System.out.println("Победа!");
                    System.out.println("Загаданное слово: \n" + printHiddenWord(hiddenWord));
                    return;
                }
            } else {
                lettersUsed.add(letter);
                System.out.println(HangmanWordBank.HANGMANPICS.get(lives - 1));
                System.out.println("Такой буквы нет в слове.");
                lives--;
            }
            System.out.println("Вы использовали следующие буквы:\n" +
                    lettersUsed.toString());
        }
        System.out.println("Вы проиграли!\n" +
                "Загаданное слово было: " + word);
    }

    public String printHiddenWord(char[] hiddenWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : hiddenWord) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }
}