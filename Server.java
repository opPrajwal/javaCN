import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
        public static void main(String[] args) throws Exception {
            
            connect();
        }

        static void connect() throws Exception{
            try (ServerSocket serversocket = new ServerSocket(3000)) {
                System.out.println("waiting for clients ");
                
                Socket socket=serversocket.accept();
                System.out.println("inet address is "+socket.getInetAddress());
                ConnectionData data=new ConnectionData("hello ", "mkdir file1");

                ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

                out.writeObject(data);
                ObjectInputStream obj=new ObjectInputStream(socket.getInputStream());
                output finalAns=(output) obj.readObject();
                System.out.println(finalAns.result);
                obj.close();
                out.flush();
                out.close();
                socket.close();
            }


        }
}
