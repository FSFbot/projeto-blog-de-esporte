package com.blogesporte.esportes.DTO;

public class NotificationDTO {
    private Long id;
    private Long textTitle;
    private Boolean read;
    private String route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(Long textTitle) {
        this.textTitle = textTitle;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
