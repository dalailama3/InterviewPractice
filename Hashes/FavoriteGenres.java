import java.util.*;
public class FavoriteGenres {

    public static Map<String,List<String>> favoriteGenres(Map<String, List<String>> userSongs,Map<String, List<String>> songGenres) {
        // create a map that has songs as keys and genres as values
        Map<String, List<String>> favorites = new HashMap<>();
        Map<String, String> songToGenres = new HashMap<>();
        for (String key : songGenres.keySet()) {
            for (String song : songGenres.get(key)) {
                songToGenres.put(song, key);
            }
        }
        Map<String, Integer> genreFrequencies = new HashMap<>();

        for (String user : userSongs.keySet()) {
            int highestCount = 0;

            for (String song : userSongs.get(user)) {
                // look up song to get genre
                if (songToGenres.containsKey(song)) {
                    String genre = songToGenres.get(song);
                    int count = genreFrequencies.getOrDefault(genre,0) + 1;
                    genreFrequencies.put(genre,count);
                    highestCount = Math.max(highestCount,count);

                }
            }
            List<String> genres = new ArrayList<>();
            for (String genre : genreFrequencies.keySet()) {
                if (genreFrequencies.get(genre) == highestCount) {
                    genres.add(genre);
                }
            }
            favorites.put(user, genres);
            //clear genreFrequencies after each user
            genreFrequencies.clear();
        }
        for (String user : favorites.keySet()) {
            System.out.println(user + ": " + favorites.get(user));
        }
        return favorites;

    }

    public static void main(String[] args) {
        //Input:
        //userSongs = {
        //   "David": ["song1", "song2", "song3", "song4", "song8"],
        //   "Emma":  ["song5", "song6", "song7"]
        //},
        //songGenres = {
        //   "Rock":    ["song1", "song3"],
        //   "Dubstep": ["song7"],
        //   "Techno":  ["song2", "song4"],
        //   "Pop":     ["song5", "song6"],
        //   "Jazz":    ["song8", "song9"]
        //}
        Map<String,List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
        Map<String,List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2","song4"));
        songGenres.put("Pop", Arrays.asList("song5","song6"));
        songGenres.put("Jazz", Arrays.asList("song8","song9"));

        //songGenres.clear();

        favoriteGenres(userSongs,songGenres);

    }

}