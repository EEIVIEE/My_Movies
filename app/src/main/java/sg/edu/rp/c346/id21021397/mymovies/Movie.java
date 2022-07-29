package sg.edu.rp.c346.id21021397.mymovies;

public class Movie {
    int id;
    String name;
    String genre;
    int yearReleased;
    String rating;

    public Movie(int id, String name, String genre, int yearReleased, String rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.yearReleased = yearReleased;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return yearReleased + " ";
    }

}
