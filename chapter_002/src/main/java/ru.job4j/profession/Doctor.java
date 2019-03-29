package ru.job4j.profession;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Doctor extends Profession {

    public Doctor() {
        super("Doctor");
    }

    Diagnose heal(Patient p) {
        return new Diagnose();
    }
}
