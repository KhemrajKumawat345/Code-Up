import java.util.ArrayList;
import java.util.List;
public class MostFrequentPath{

    public static String mostFrequent2PagePath(String[] logs) {
        List<String> user = new ArrayList<>();
        List<List<String>> destination = new ArrayList<>();

        for (String entry : logs) {
            String[] parts = entry.split(",");
            String user1 = parts[0].trim();
            String page = parts[1].trim();
            int index = user.indexOf(user1);
            if (index == -1) {
                user.add(user1);
                List<String> pages = new ArrayList<>();
                pages.add(page);
                destination.add(pages);
            } 
            else{
                destination.get(index).add(page);
            }
        }
        //store 2 page paths and frequency
        List<String> paths = new ArrayList<>();
        List<Integer> freq = new ArrayList<>();

        //2 page paths for each user
        for (List<String> pages : destination) {
            if (pages.size() < 2) continue;
            for (int i = 0; i + 1 < pages.size(); i++) {
                String path = pages.get(i) + " -> " + pages.get(i + 1);
                int idx = paths.indexOf(path);
                if (idx == -1) {
                    paths.add(path);
                    freq.add(1);
                } else {
                    freq.set(idx, freq.get(idx) + 1);
                }
            }
        }
        // find highest frequency
        int max = 0;
        String best = "";
        for (int i = 0; i < paths.size(); i++) {
            if (freq.get(i) > max) {
                max = freq.get(i);
                best = paths.get(i);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] logs = {"u1, Home","u1, Search","u1, Cart","u2, Search","u2, cart","u2, Home","u2, Search"};
        System.out.println("Most Frequent Path : " + mostFrequent2PagePath(logs));
    }
}
