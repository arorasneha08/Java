import java.util.*;

public class DesignMovieRentalSystem {
    class Pair implements Comparable<Pair> {
    int shop;
    int movie;
    int price;

    Pair(int shop, int movie, int price) {
        this.shop = shop;
        this.movie = movie;
        this.price = price;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.price == other.price) {
            if (this.shop == other.shop) {
                return this.movie - other.movie;
            }
            return this.shop - other.shop;
        }
        return this.price - other.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shop, movie, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;
        Pair other = (Pair) obj;
        return this.shop == other.shop && this.movie == other.movie && this.price == other.price;
    }
}

class MovieRentingSystem {
    // For each movie, keep available copies sorted
    Map<Integer, TreeSet<Pair>> movieAvailable;
    // Map from "shop-movie" to Pair
    Map<String, Pair> pairMap;
    // Global rented set (sorted by price, shop, movie)
    TreeSet<Pair> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        movieAvailable = new HashMap<>();
        pairMap = new HashMap<>();
        rented = new TreeSet<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Pair p = new Pair(shop, movie, price);

            movieAvailable.putIfAbsent(movie, new TreeSet<>());
            movieAvailable.get(movie).add(p);

            pairMap.put(shop + "-" + movie, p);
        }
    }

    // Return up to 5 cheapest shops with this movie
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieAvailable.containsKey(movie)) return res;

        Iterator<Pair> it = movieAvailable.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            res.add(it.next().shop);
            count++;
        }
        return res;
    }

    // Rent a movie from a shop
    public void rent(int shop, int movie) {
        String key = shop + "-" + movie;
        Pair p = pairMap.get(key);

        movieAvailable.get(movie).remove(p);
        rented.add(p);
    }

    // Drop a rented movie back to available
    public void drop(int shop, int movie) {
        String key = shop + "-" + movie;
        Pair p = pairMap.get(key);

        rented.remove(p);
        movieAvailable.get(movie).add(p);
    }

    // Report up to 5 rented movies globally
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<Pair> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            Pair p = it.next();
            res.add(Arrays.asList(p.shop, p.movie));
            count++;
        }
        return res;
    }
}

}
