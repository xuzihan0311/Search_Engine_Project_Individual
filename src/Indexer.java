import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Indexer {

    private StopStem stopStem;

    public void index(File page) {
        stopStem = new StopStem();
        stopStem.StopWordList();

        try {
            FileReader fr = new FileReader(page);
            BufferedReader br = new BufferedReader(fr);

            String nextLine = br.readLine();

            while (nextLine != null) {
                String[] words = nextLine.split(" ");
                int length = words.length;
                if (length > 0) {
                    String lastWord = words[length - 1];
                    lastWord.replace("\n", "");
                }

                for (String word : words) {
                    word = word.toLowerCase();
                    if (!word.isEmpty() && !word.equals("\n") && !stopStem.isStopWord(word)) {
                        word = stopStem.stem(word);
                        HashMap<String, Integer> pageMap = Main.getTFMap().get(page.getName());
                        if (pageMap.containsKey(word)) {
                            int tf = pageMap.get(word);
                            pageMap.put(word, tf + 1);
                        } else {
                            pageMap.put(word, 1);
                        }
                    }
                }

                nextLine = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
