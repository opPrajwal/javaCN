import java.io.Serializable;

public class ConnectionData implements Serializable{
    private static final long serialVersionUID = 1L;
    String message;
    String cmd;
    public ConnectionData(String message,String cmd){
        this.message=message;
        this.cmd=cmd;
    }

}
