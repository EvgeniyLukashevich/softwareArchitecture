package ru.geekbrains.seminar6.notes.infrastructure.persistance.configurations;

import ru.geekbrains.seminar6.database.NotesRecord;
import ru.geekbrains.seminar6.notes.core.domain.Note;
import ru.geekbrains.seminar6.notes.infrastructure.persistance.ModelConfiguration;

public class NoteConfiguration implements ModelConfiguration<NotesRecord, Note> {

    //TODO: Описываем конкретный маппинг типа Note к объекту БД

    public NotesRecord noteMapping(Note note){
        return new NotesRecord(note.getTitle(),note.getDetails());
    }

}
