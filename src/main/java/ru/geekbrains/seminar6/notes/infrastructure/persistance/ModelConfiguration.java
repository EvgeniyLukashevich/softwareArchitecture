package ru.geekbrains.seminar6.notes.infrastructure.persistance;

import ru.geekbrains.seminar6.database.NotesRecord;
import ru.geekbrains.seminar6.notes.core.domain.Note;

import java.util.Optional;

public interface ModelConfiguration<T, TEntity> {
    T noteMapping(TEntity entity);
}
