import IRUtilities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class StopStem {

    private Porter porter;
    private HashSet<String> stopWords;

    public StopStem() {
        porter = new Porter();
        stopWords = new HashSet<>();
    }

    public void StopWordList() {
        try {
            FileReader fr = new FileReader("/Users/Alex/Downloads/School/HKUST/Spring 2017/COMP 4321/Search_Engine_Project_Individual/doc/stopwords.txt");
            BufferedReader br = new BufferedReader(fr);

            String nextWord = br.readLine();

            while (nextWord != null) {
                nextWord.replace("\n", "");
                stopWords.add(nextWord);
                nextWord = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isStopWord(String word) {
        return stopWords.contains(word);
    }

    public String stem(String word) {
        return porter.stripAffixes(word);
    }
}
