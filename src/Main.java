import java.util.Random;
import java.util.InputMismatchException; // Для обработки нечислового ввода
import java.util.Scanner;

public class Main {
    // Глобальные переменные для настроек игры
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int maxNumber = 10;
    private static int attempts = 3;

    public static void main(String[] args) {
        startGame();
    }

    static void startGame() {
        boolean quit = false;

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        while (!quit) {
            System.out.println("\n0 - Выйти из игры");
            System.out.println("1 - Начать игру");
            System.out.println("2 - Настройки");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Спасибо за игру!");
                        quit = true;
                        break;
                    case 1:
                        playGame();
                        break;
                    case 2:
                        showOptions();
                        break;
                    default:
                        System.out.println("Ошибка! Введите 0, 1 или 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите число, а не текст.");
                scanner.next(); // Очистка неправильного ввода
            }
        }
        scanner.close();
    }

    static void playGame() {
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(maxNumber + 1);
            boolean guessed = false;

            System.out.println("\nУгадайте число от 0 до " + maxNumber);
            System.out.println("У вас " + attempts + " попыток");

            for (int i = 0; i < attempts && !guessed; i++) {
                System.out.print("Попытка " + (i + 1) + "/" + attempts + ": ");

                try {
                    int guess = scanner.nextInt();

                    if (guess == secretNumber) {
                        System.out.println("Поздравляем! Вы угадали!");
                        guessed = true;
                    } else if (guess > secretNumber) {
                        System.out.println("Слишком много!");
                    } else {
                        System.out.println("Слишком мало!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка! Введите число, а не текст.");
                    scanner.next(); // Очистка неправильного ввода
                    i--; // Не засчитываем эту попытку
                }
            }

            if (!guessed) {
                System.out.println("К сожалению, вы не угадали. Число было: " + secretNumber);
            }

            System.out.print("\nСыграем ещё раз? (1 - Да, 0 - Нет): ");
            try {
                int choice = scanner.nextInt();
                playAgain = (choice == 1);
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Игра завершена.");
                playAgain = false;
            }
        }
    }

    static void showOptions() {
        boolean exit = false;

        System.out.println("\n=== Настройки игры ===");
        while (!exit) {
            System.out.println("\n0 - Назад");
            System.out.println("1 - Изменить количество попыток (текущее: " + attempts + ")");
            System.out.println("2 - Изменить максимальное число (текущее: " + maxNumber + ")");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        System.out.print("Введите новое количество попыток: ");
                        attempts = scanner.nextInt();
                        break;
                    case 2:
                        System.out.print("Введите новое максимальное число: ");
                        maxNumber = scanner.nextInt();
                        break;
                    default:
                        System.out.println("Ошибка! Введите 0, 1 или 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите число, а не текст.");
                scanner.next();
            }
        }
    }
}