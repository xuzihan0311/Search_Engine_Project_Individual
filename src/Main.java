import java.io.File;
import java.util.HashMap;

public class Main {

    private static HashMap<String, HashMap<String, Integer>> tfMap;
    private static HashMap<String, Integer[]> dfMaxTF;
    private static int N;

    public static void main(String[] args) {
        File pagesDir = new File("/Users/Alex/Downloads/School/HKUST/Spring 2017/COMP 4321/Search_Engine_Project_Individual/pages");
        File[] pages = pagesDir.listFiles();
        N = pages.length;

        Indexer indexer = new Indexer();
        tfMap = new HashMap<>();
        for (File page : pages) {
            tfMap.put(page.getName(), new HashMap<>());
            indexer.index(page);
        }
        System.out.println(tfMap.get(pages[2].getName()));
    }

    public static HashMap<String, HashMap<String, Integer>> getTFMap() {
        return tfMap;
    }

    public static HashMap<String, Integer[]> getDfMaxTF() {
        return dfMaxTF;
    }
}
