package movie.task;

import functionalinterface.example.Randomable;

public class Movie {
    private String name;
    private MovieCategory genre;
    private int price;

    public Movie(String name, MovieCategory genre, int price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Movie() {
        setRandomValues();
    }

    private void setRandomValues() {
        Randomable rand = (from, to) -> (int) (Math.random() * (to - from)) + from;
        String uniqueName = "Movie number" + rand.getRandomInteger(1, 120);
        ;
        MovieCategory genre = null;
        int price = 0;

        switch (rand.getRandomInteger(0, 4)) {
            case 0:
                genre = MovieCategory.HORROR;
                price = rand.getRandomInteger(40, 120);
                break;
            case 1:
                genre = MovieCategory.COMEDY;
                price = rand.getRandomInteger(50, 110);
                break;
            case 2:
                genre = MovieCategory.ACTION;
                price = rand.getRandomInteger(50, 200);
                break;
            case 3:
                genre = MovieCategory.DRAMA;
                price = rand.getRandomInteger(20, 100);
                break;
        }
        this.name = uniqueName;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getGenre() {
        return genre;
    }

    public void setGenre(MovieCategory genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
