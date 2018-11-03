package heb.candidate;

public class Testing {
    private final long id;
    private final String content;

    public Testing (long id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }
}