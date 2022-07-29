package sg.edu.rp.c346.id21021397.mymovies;

public class Movie {
    String name;
    String genre;
    int yearReleased;
    int rating;

    public Movie(String name, String genre, int yearReleased, int rating) {
        this.name = name;
        this.genre = genre;
        this.yearReleased = yearReleased;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", yearReleased=" + yearReleased +
                ", rating='" + rating + '\'' +
                '}';
    }

    private String getRating(int rating) {
        switch (rating) {
            case 1: return "*";

            case 2: return "* *";

            case 3: return "* * *";

            case 4: return "* * * *";

            case 5: return "* * * * *";

            default: return "";
        }
    }
}
