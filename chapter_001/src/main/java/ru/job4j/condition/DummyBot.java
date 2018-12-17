package ru.job4j.condition;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
        * @version $Id$
        * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) { // заменить ... на проверку, что этот вопрос известен боту и он знает как на него ответить.
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
