package models;

import java.time.LocalDate;

public class LogEntity {
    private static int id_counter;
    private int id;
    private String message;
    private String source;
    private LocalDate dateOfEntry;

    public LogEntity() {
    }

    public LogEntity(String message, String source) {
        this.id = id_counter++;
        this.message = message;
        this.source = source;
        this.dateOfEntry = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getDateOfEntry() {
        return this.dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }
}