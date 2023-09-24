package ru.geekbrains.seminar6.notes.presentation.queries.controllers;

import ru.geekbrains.seminar6.notes.presentation.queries.views.Presenter;

public abstract class Controller {

    public <T extends Presenter> void view(T presenter){
    }

}
