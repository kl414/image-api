package com.klin.imageapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Image {
    @Id
    @GeneratedValue()
    private long id;

    @NotEmpty
    private String label;

    private List<String> objects;

    @NotEmpty
    private String url;

    public Image(){}

    public Image(String label, List<String> objects, String url) {
        this.label = label;
        this.objects = objects;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getObjects() {
        return objects;
    }

    public void setObjects(List<String> objects) {
        this.objects = objects;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
