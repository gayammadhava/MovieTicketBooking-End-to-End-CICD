
package com.movieticket.model;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private String language;
    private String imageUrl;
    private double price;

    public Movie(int id, String title, String genre,
                 String language, String imageUrl, double price) {

        this.id = id;
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }
}
