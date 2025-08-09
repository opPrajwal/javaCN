import java.io.Serializable;

public class output implements Serializable{
    private static final long serialVersionUID = 1L;
    String result;
    public output(String result){
        this.result=result;

    }
    public String toString(){
        return result;
    }
}
