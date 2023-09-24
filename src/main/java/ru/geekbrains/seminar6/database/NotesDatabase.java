package ru.geekbrains.seminar6.database;

import ru.geekbrains.seminar6.notes.infrastructure.persistance.Database;

public class NotesDatabase implements Database {

    private NotesTable notesTable;

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }

    public NotesTable addNotesRecord(NotesRecord notesRecord) {
        if (notesTable == null)
            notesTable = new NotesTable();
        notesTable.addNotesRecord(notesRecord);
        return notesTable;
    }
}
