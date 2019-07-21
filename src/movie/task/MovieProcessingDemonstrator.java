package movie.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieProcessingDemonstrator {

    private static double getAveragePriceOfCategory(Map<String, List<Movie>> groupedMovies, String category) {
        return groupedMovies.get(category).stream()
                .mapToInt(Movie::getPrice)
                .average()
                .getAsDouble();
    }

    public static void demonstrateMovieProcessing() {
        List<Movie> moviesFirstList = generateMovies(25);
        List<Movie> moviesSecondList = generateMovies(25);
        moviesFirstList.addAll(moviesSecondList);

        Map<String, List<Movie>> groupedMovies = moviesFirstList.stream()
                .peek(System.out::println)
                .collect(Collectors.groupingBy(m -> m.getGenre().getNameOfCategorie()));

        double horrorAveragePrice = getAveragePriceOfCategory(groupedMovies, "Horror");
        double comedyAveragePrice = getAveragePriceOfCategory(groupedMovies, "Comedy");
        double actionAveragePrice = getAveragePriceOfCategory(groupedMovies, "Action");
        double dramaAveragePrice = getAveragePriceOfCategory(groupedMovies, "Drama");

        System.out.println("Horror average price: " + horrorAveragePrice + " films count:" + groupedMovies.get("Horror").size());
        System.out.println("Comedy average price: " + comedyAveragePrice + " films count:" + groupedMovies.get("Comedy").size());
        System.out.println("Action average price: " + actionAveragePrice + " films count:" + groupedMovies.get("Action").size());
        System.out.println("Drama average price: " + dramaAveragePrice + " films count:" + groupedMovies.get("Drama").size());
    }

    private static List<Movie> generateMovies(int amount) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            movies.add(new Movie());
        }

        return movies;
    }
}
