package Feedback;

import Base.DateFormat;

import java.time.LocalDateTime;

/**
 * Created by YuexingYin on 8/9/16.
 */
abstract public class Feedback {
    private String content;
    private String title;
    private int rating;
    protected LocalDateTime time;


    public Feedback(String title, String content, int rating) {
        this.content = content;
        this.title = title;
        this.rating = rating;
        this.time = LocalDateTime.now(); //Time stamp for feedback
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public LocalDateTime getTime() { return time;}

    public void provideFeedback() {
        setType();
        setContent(getContent());
        setFeedbacker(getTitle());
        setRating(getRating());
//        setDate();
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
//    public void setDate(){
//        System.out.println(new DateFormat().getCurrentDate());
//    }

    abstract public String getType();

}
