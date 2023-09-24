package ru.geekbrains.seminar6.notes.core.application.interfaces;

import ru.geekbrains.seminar6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    public String inputTitle();
    public String inputDetails();

    void printAll(Collection<Note> notes);
}
