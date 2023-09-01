package ru.geekbrains.seminar1.store3D.models;

import java.nio.file.Path;

public class Texture {

    private static int counter = 0;
    private int id;

    private String name;

    private Path path;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public Texture(String name) {
        this.name = name;
        this.id = ++counter;
    }

    public Texture(Path path, String name) {
        this.path = path;
        this.name = name;
        this.id = ++counter;
    }


}
