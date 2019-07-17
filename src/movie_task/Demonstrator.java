package movie_task;

import functional_interface_example.Randomable;
import users_task.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demonstrator {
    public static void main(String[] args) {
        List<Movie> movies = generateMovies(99);

        Map<String, List<Movie>> gouredMovies = movies.stream()
                .peek(System.out::println)
                .collect(Collectors.groupingBy(Movie::getGenre));
        double horrorAveragePrice = gouredMovies.get("Horror").stream()
                .mapToInt(Movie::getPrice)
                .average()
                .getAsDouble();
        double comedyAveragePrice = gouredMovies.get("Comedy").stream()
                .mapToInt(Movie::getPrice)
                .average()
                .getAsDouble();
        double actionAveragePrice = gouredMovies.get("Action").stream()
                .mapToInt(Movie::getPrice)
                .average()
                .getAsDouble();
        double dramaAveragePrice = gouredMovies.get("Drama").stream()
                .mapToInt(Movie::getPrice)
                .average()
                .getAsDouble();

        System.out.println("Horror average price: "+horrorAveragePrice + " films count:"+gouredMovies.get("Horror").size());
        System.out.println("Comedy average price: "+comedyAveragePrice + " films count:"+gouredMovies.get("Comedy").size());
        System.out.println("Action average price: "+actionAveragePrice + " films count:"+gouredMovies.get("Action").size());
        System.out.println("Drama average price: "+dramaAveragePrice + " films count:"+gouredMovies.get("Drama").size());
    }

    private static List<Movie> generateMovies(int howMany) {
        Randomable rand = (from, to) -> from + (int) (Math.random() * (to - from));
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            String uniqueName = "Movie number" + i;
            String genre = null;
            int price = 0;
            switch (rand.getRandomInteger(0, 4)) {
                case 0:
                    genre = "Horror";
                    price=rand.getRandomInteger(40,120);
                    break;
                case 1:
                    genre = "Comedy";
                    price=rand.getRandomInteger(50,110);
                    break;
                case 2:
                    genre = "Action";
                    price=rand.getRandomInteger(50,200);
                    break;
                case 3:
                    genre = "Drama";
                    price=rand.getRandomInteger(20,100);
                    break;
            }
            movies.add(new Movie(uniqueName,genre,price));
        }
        return movies;
    }
}
