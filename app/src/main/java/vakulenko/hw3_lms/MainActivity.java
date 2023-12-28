package vakulenko.hw3_lms;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Исходная строка стихотворения
        String poem = "У Лукоморья дуб зелёный";

        // Строка для хранения результатов анализа
        StringBuilder result = new StringBuilder();

        // Анализ строки и формирование результата
        result.append("У Лукоморья дуб зелёный\n");
        result.append("\n");
        result.append("Количество символов: ").append(countCharacters(poem)).append("\n");
        result.append("Количество слов: ").append(countWords(poem)).append("\n");
        result.append("Количество букв 'л': ").append(countSpecificLetter(poem, 'л')).append("\n");
        result.append("Слова из 5 букв: ").append(findWordsOfLength(poem, 5)).append("\n");
        result.append("Слова на 'а': ").append(findWordsStartingWith(poem, 'а'));

        // Вывод результатов на экран
        resultTextView.setText(result.toString());
    }

    // Метод для подсчета количества символов в строке
    private int countCharacters(String text) {
        return text.length();
    }

    // Метод для подсчета количества слов в строке
    private int countWords(String text) {
        return text.split("\\s+").length;
    }

    // Метод для подсчета количества конкретной буквы в строке
    private int countSpecificLetter(String text, char letter) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.toLowerCase(c) == letter) {
                count++;
            }
        }
        return count;
    }

    // Метод для поиска слов заданной длины в строке
    private String findWordsOfLength(String text, int length) {
        StringBuilder words = new StringBuilder();
        boolean found = false;
        for (String word : text.split("\\s+")) {
            if (word.length() == length) {
                words.append(word).append(" ");
                found = true;
            }
        }
        return found ? words.toString().trim() : "0";  // Возвращаем "0", если слов на заданной длины не найдено
    }

    // Метод для поиска слов, начинающихся с заданной буквы, в строке
    private String findWordsStartingWith(String text, char startLetter) {
        StringBuilder words = new StringBuilder();
        boolean found = false;  // Флаг, указывающий, были ли найдены слова на 'а'
        for (String word : text.split("\\s+")) {
            if (Character.toLowerCase(word.charAt(0)) == startLetter) {
                words.append(word).append(" ");
                found = true;
            }
        }
        return found ? words.toString().trim() : "0";  // Возвращаем "0", если слов на нужную букву не найдено
    }
}