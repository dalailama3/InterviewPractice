//Output:
//Return a list of strings of the most popular N toys in order of most to least frequently mentioned
//
//Note:
//The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys,
// return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.
import java.util.*;
public class TopNBuzzwords {
    public static ArrayList<String> topNToys(int topToys, String[] toys, String[] quotes) {
        if (topToys > toys.length) topToys = toys.length;
        HashMap<String,int[]> toyFrequencies = new HashMap<>();
        // map entry will be string mapping to an int array, [frequency,quoteFrequency]
        for (String toy : toys) {
            toyFrequencies.put(toy.toLowerCase(),new int[]{0,0});
        }

        // pq represent a Min Heap in which strings at the head occur least frequently, then sort on how many different quotes string appears in,
        // then order on string comparison
        PriorityQueue<String> pq = new PriorityQueue<>(topToys,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //compare word frequency
                if (Integer.compare(toyFrequencies.get(s1)[0],toyFrequencies.get(s2)[0]) != 0) {
                    return Integer.compare(toyFrequencies.get(s1)[0],toyFrequencies.get(s2)[0]);
                }
                //compare quote appearance frequency
                if (Integer.compare(toyFrequencies.get(s1)[1],toyFrequencies.get(s2)[1]) != 0) {
                    return Integer.compare(toyFrequencies.get(s1)[1],toyFrequencies.get(s2)[1]);
                }
                //compare words lexicographically when word freq and quote freq are the same
                return s2.compareTo(s1);

            }
        });
        // iterate through quotes, for each quote iterate through words
        // if word is in list of toys, then update frequency array of toy
        // have a priority queue (min heap) of wordFreq objects

        HashSet<String> seenInQuote = new HashSet<>();

        for (String quote : quotes) {
            seenInQuote.clear();
            // reset Set for each quote, keep track of toys seen in each quote
            // split each quote into words, split on space or comma or exclamation
            String [] words = quote.toLowerCase().split("[\\s,!;]+");
            for (String word : words) {

                // update frequency of toy
                if (toyFrequencies.containsKey(word)) {

                    int[] count = toyFrequencies.get(word);
                    count[0]++;
                    if (!seenInQuote.contains(word)) {
                        count[1]++;
                        seenInQuote.add(word);
                    }
                    toyFrequencies.put(word, count);
                }
            }
        }
        for (String toy : toyFrequencies.keySet()) {
            pq.offer(toy);
            if (pq.size() > topToys) {
                pq.poll();
            }
        }

        ArrayList<String> result = new ArrayList<>();
        System.out.println(pq);
        for (Map.Entry<String,int[]> entry : toyFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue()));
        }
        while (!pq.isEmpty()) {

            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
}

//    public static class WordWithFrequency {
//        String word;
//        Integer count;
//
//        WordWithFrequency(String word,Integer count) {
//            this.word = word;
//            this.count = count;
//        }
//
//        public String toString() {
//            return word + ": " + count;
//        }
//    }

//    public static class WordWithFrequencyComparator implements Comparator<WordWithFrequency> {
//        public int compare(WordWithFrequency w1, WordWithFrequency w2) {
//            System.out.println("comparing " + w1.toString() + " to " + w2.toString());
//            if (w1.count == w2.count) {
//                // if equal counts then compare strings
//                return w1.word.compareTo(w2.word);
//            } else {
//                //sort descending order
//                return w2.count - w1.count;
//            }
//        }
//    }



    public static void main (String[] args) {
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] quotes = {"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season",
                "warcraft tablet tablet tablet tablet tablet elsa, elmo   ,"
        };

        ArrayList<String> result = TopNBuzzwords.topNToys(20, toys, quotes);
        System.out.println(result);
        //Output:
        //["elmo", "elsa"]

    }
}