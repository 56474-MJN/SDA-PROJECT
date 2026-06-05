// Pattern: MVC Model
package com.sdapro.model;

public class Alert {

    private int id;
    private String source;
    private String severity;
    private String description;

    public Alert() {
    }

    public Alert(int id, String source, String severity, String description) {
        this.id = id;
        this.source = source;
        this.severity = severity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}