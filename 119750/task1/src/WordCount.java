import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Filename: ");
        File file = new File(scanner.nextLine());
        scanner.close();
        Scanner sc = new Scanner(new FileReader(file));
        sc.useDelimiter("[^a-zA-Z0-9\\-\']+");
        ArrayList<Word> words = new ArrayList<>();
        String word;
        while (sc.hasNext()){
            word = sc.next();
            words.add(new Word(word));
        }
        sc.close();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (words.get(i).getWord().equals(words.get(j).getWord()))
                    words.get(i).setCount(words.get(i).getCount() + 1);
            }
        }
        words = Sort(words);
        print(words);
    }


    public static ArrayList<Word> Sort(ArrayList<Word> words){
        Word[] w = new Word[words.size()];
        for (int i = 0; i < w.length; i++) {
            w[i] = words.get(i);
        }
        for(int i = w.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( w[j].getCount() > w[j+1].getCount() ){
                    Word tmp = w[j];
                    w[j] = w[j+1];
                    w[j+1] = tmp;
                }
            }
        }
        ArrayList<Word> sortedWords= new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            sortedWords.add(0, w[i]);
        }
        return sortedWords;
    }

public static void print(ArrayList<Word> prWords){
    int n = 1;
    Word s = prWords.get(0);
    System.out.println("Most Frequent Words:");
    System.out.println("word           frequency");
    System.out.print(String.format("%-15s", s.getWord()));
    System.out.println(s.getCount());
    for (int i = 0; i < prWords.size(); i++) {
        if (!(s.getWord().equals(prWords.get(i).getWord()))){
            System.out.print(String.format("%-15s",prWords.get(i).getWord()));
            System.out.println(prWords.get(i).getCount());
            s = prWords.get(i);
            n++;
            if (n == 5)
                i = prWords.size();
        }
    }
}














}
