package ru.geekbrains.seminar6.notes.core.domain;

import java.util.Date;

public class Note {

    private int counter = 0;

    private int id = counter;

    {
        ++counter;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    //region Constructors

    public Note(int id, String title, String details, Date creationDate) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.creationDate = creationDate;
    }

    public Note(String title, String details){
        this.title = title;
        this.details = details;
        this.creationDate = new Date();
    }

    //endregion

    //region Public Getters And Setters (Properties)

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    //endregion

    //region Private Fields



    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    //endregion

}
