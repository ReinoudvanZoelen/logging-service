package models;

public class Log {
    private int id;
    private String message;
    private String source;

    public Log() {
    }

    public Log(int id, String message, String source) {
        this.id = id;
        this.message = message;
        this.source = source;
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
}