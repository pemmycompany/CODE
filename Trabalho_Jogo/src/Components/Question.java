package Components;

import java.util.ArrayList;

public class Question {

    String text;
    ArrayList<Option> options;

    public Question(String text, ArrayList<Option> options) {
        this.text = text;
        this.options = options;
    }

    public String getText(){return text;}
    public ArrayList<Option> getOptions(){return options;}
}
