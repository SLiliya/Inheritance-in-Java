package ru.netology.Diary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testSimpleTaskWhenMatches() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskWhenNotMatches() {
        SimpleTask simpleTask = new SimpleTask(12, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicWhenMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicWhenNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        boolean actual = epic.matches("Рыба");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingWhenNotMatches() {
        Meeting meeting = new Meeting(4, "Введение в Java", "Наследование", "В 18:00, суббота");

        boolean actual = meeting.matches("Пойти");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingWhenMatchesTopic() {
        Meeting meeting = new Meeting(5, "Введение в Java", "Наследование", "В 18:00, суббота");

        boolean actual = meeting.matches("Java");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingWhenMatchesProject() {
        Meeting meeting = new Meeting(6, "Введение в Java", "Наследование и расширяемость", "В 18:00, суббота");

        boolean actual = meeting.matches("Наследование");

        Assertions.assertTrue(actual);
    }


}
