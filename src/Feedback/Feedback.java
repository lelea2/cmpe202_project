package Feedback;

import Base.DateFormat;

/**
 * Created by YuexingYin on 8/9/16.
 */
public abstract class Feedback {
    private String content, name;
    private int rating;

    public Feedback(String content, String name, int rating) {
        this.content = content;
        this.name = name;
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void provideFeedback(){
        setType();
        setContent(getContent());
        setFeedbacker(getName());
        setRating(getRating());
        setDate();
    }

    public void setContent(String content){
        System.out.println(content);
    }
    public void setFeedbacker(String name){
        System.out.println(name);
    }
    public void setType(){}
    public void setRating(int rating){
        System.out.println(rating);
    }
    public void setDate(){
        System.out.println(new DateFormat().getCurrentDate());
    }

}
