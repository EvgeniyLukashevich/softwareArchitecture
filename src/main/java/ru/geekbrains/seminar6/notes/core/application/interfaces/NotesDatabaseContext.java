package ru.geekbrains.seminar6.notes.core.application.interfaces;

import ru.geekbrains.seminar6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    void addNote(Note note);

    boolean saveChanges();

}
