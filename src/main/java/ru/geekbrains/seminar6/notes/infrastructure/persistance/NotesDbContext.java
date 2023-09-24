package ru.geekbrains.seminar6.notes.infrastructure.persistance;

import ru.geekbrains.seminar6.database.NotesDatabase;
import ru.geekbrains.seminar6.database.NotesRecord;
import ru.geekbrains.seminar6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.seminar6.notes.core.domain.Note;
import ru.geekbrains.seminar6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {
    NoteConfiguration config = new NoteConfiguration();

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase) database).getNotesTable().getRecords()) {
            notesList.add(new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    @Override
    public void addNote(Note note) {
        ((NotesDatabase) database).addNotesRecord(config.noteMapping(note));
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
