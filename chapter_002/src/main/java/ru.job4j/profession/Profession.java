package ru.job4j.profession;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Profession {
    private String name;
    private String profession;

    Profession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }
}
