package ru.geekbrains.seminar6.notes.presentation.queries.controllers;

import ru.geekbrains.seminar6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.seminar6.notes.core.domain.Note;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(){
        this.notesEditor.add();
    }

    public void routeRemoveNote(Note note){
        this.notesEditor.remove(note);
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

}
