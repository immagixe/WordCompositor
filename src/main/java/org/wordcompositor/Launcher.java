package org.wordcompositor;

import org.wordcompositor.output.ConsoleDataPrinter;
import org.wordcompositor.workwithwords.RandomWord;
import org.wordcompositor.workwithwords.GetWordsListFromFile;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

/**
 * Hello world!
 */
public class Launcher {
    public static void main(String[] args) throws FileNotFoundException {

        final Game game = new Game(
                new GetWordsListFromFile(),
                new RandomWord(),
                new ConsoleDataPrinter(),
                new Player[]{new Player(), new Player()},
                new LinkedHashMap<String, Integer>(),
                new WinnerVerifier());
        game.play();
    }
}


/**
 * 1.Выбор случайного слова из списка, длина которого больше 7 букв.
 * <p>
 * 2.Отображение краткой инструкции по игре.
 * <p>
 * 3.Отображение на экране этого слова.
 * <p>
 * ----Бесконечный цикл----
 * 4.Тектовый запрос на ввод нового слова от 1-го игрока: "Make a new word from the letters of the original word: <original word>."
 * - если такое слово уже было использовано -> вывести сообщение "This word has already been used!" об этом и вернуться к началу шага 3;
 * - если такое слово существует -> вывести это слово в 1-ю колонку, добавить в список использованных слов, перейти к шагу 5;
 * - предусмотреть вывод сообщений на все неверные вводы запроса: несколько слов, ввод цифр и т.д.
 * - если такого слова не существует -> вывести текстовое сообщение "This word does not exist!" об этом и вернуться к началу шага 3;
 * - если введено слово в любом регистре "I give up" -> переход к шагу 6.
 * <p>
 * 5. Повторить Шаг №4 для 2-го игрока.
 * ----Выход из цикоа----
 * <p>
 * 6. Отображение результатов. Конец игры.
 * <p>
 * ----------------
 * Класс WordGeneration: выбор случайного слова из списка, длина которого больше 7 букв.
 * Класс DataPrinter: вывод на экран информации по игре.
 * Класс Player:
 * -содержит поле: количество составленных слов
 * -содержит метод: сделать ход (попытка составить слово)
 * Класс Game: весь процесс игры
 */
