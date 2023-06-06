import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testAnswerFalseWhenQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Молоко", "Яйца", "Хлеб"});
        String query = "Сыр";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerTrueWhenQueryInSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);
        String query = "Яйца";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить подруге");
        String query = "Позвонить";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить подруге");
        String query = "Посмотреть фильм";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Сделать домашнее задание в Нетологии", "Обучение QA engineer", "25.01.2023");
        String query = "домашнее задание";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Сделать домашнее задание в Нетологии", "Обучение QA engineer", "25.01.2023");
        String query = "Обучение QA engineer";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAnswerFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Сделать домашнее задание в Нетологии", "Обучение QA engineer", "25.01.2023");
        String query = "25.01.2023";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}
