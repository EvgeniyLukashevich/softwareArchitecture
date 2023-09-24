package ru.geekbrains.seminar6.notes.presentation.queries.views;

import ru.geekbrains.seminar6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.seminar6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Scanner;

public class NotesConsolePresenter implements NotesPresenter {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    public String inputTitle() {
        System.out.println("Введите заголовок:");
        return scanner.nextLine();
    }

    public String inputDetails() {
        System.out.println("Введите текст заметки:");
        return scanner.nextLine();
    }
}
