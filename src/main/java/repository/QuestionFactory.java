package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Question;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionFactory {

    // Сам метод-фабрика, который собирает карту вопросов
    public static Map<Integer, Question> loadQuestions() {
        Map<Integer, Question> questionMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        // Читаем файл quest.json из папки ресурсов
        try (InputStream is = QuestionFactory.class.getClassLoader().getResourceAsStream("quest.json")) {
            if (is == null) {
                throw new RuntimeException("Файл конфигурации квеста quest.json не найден!");
            }

            // Парсим массив JSON в список объектов Java
            List<Question> questions = mapper.readValue(is, new TypeReference<List<Question>>() {});

            // Наполняем карту для быстрого доступа по ID
            for (Question q : questions) {
                questionMap.put(q.getId(), q);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return questionMap;
    }
}