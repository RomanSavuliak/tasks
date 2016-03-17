
public class Word {
    private String word;
    private int count;

    public Word(String word) {
        this.word = word.toLowerCase();
        count = -1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
