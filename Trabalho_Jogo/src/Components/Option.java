package Components;

public class Option {

    String text;
    boolean isAnswer;

    public Option(String text, boolean isAnswer) {
        this.text = text;
        this.isAnswer = isAnswer;
    }

    public String getText(){return text;}
    public boolean isAnswer(){return isAnswer;}
}
