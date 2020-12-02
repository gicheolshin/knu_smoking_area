package com.example.knu_smoking_area;

public class InfoWindowData{
    private String score;
    private String image;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getImage()
    {
        return image;
    }

    public String getScore() {
        return score;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
