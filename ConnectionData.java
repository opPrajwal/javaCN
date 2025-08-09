import java.io.Serializable;

public class ConnectionData implements Serializable{
    String message;
    String cmd;
    public ConnectionData(String message,String cmd){
        this.message=message;
        this.cmd=cmd;
    }

}
