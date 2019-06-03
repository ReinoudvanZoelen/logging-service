package models;

public class LogModel {
    private String message;
    private String source;

    public LogModel() {
    }

    public LogModel(String message, String source) {
        this.message = message;
        this.source = source;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}