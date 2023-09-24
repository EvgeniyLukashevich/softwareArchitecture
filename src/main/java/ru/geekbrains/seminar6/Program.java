package ru.geekbrains.seminar6;


import ru.geekbrains.seminar6.database.NotesDatabase;
import ru.geekbrains.seminar6.notes.core.application.ConcreteNoteEditor;
import ru.geekbrains.seminar6.notes.infrastructure.persistance.NotesDbContext;
import ru.geekbrains.seminar6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.seminar6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        // Попробовал реализовать возможность добавить заметку не нарушая принципов чистой архитектуры
        boolean loop = true;
        while (loop) {
            System.out.println("" +
                    "\n### ### ###" +
                    "\n1 - Создать заметку" +
                    "\n2 - Показать заметки" +
                    "\n0 - Выйти\n### ### ###" +
                    "\n\nВыбирите пункт меню:");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                switch (no) {
                    case 0:
                        System.out.println("Завершение работы.");
                        loop = false;
                        break;
                    case 1:
                        controller.routeAddNote();
                        break;
                    case 2:
                        controller.routeGetAll();
                        break;
                    default:
                        System.out.println("Некорректный ввод.");
                }
            }
        }
    }
}
