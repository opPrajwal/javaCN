import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringJoiner;

public class Client1 {
  
    static void connect(String ip,int PORT){

        try {
            Socket socket=new Socket(ip,PORT);
            
            System.out.println("connected to server with "+ip+" and PORT "+ PORT );
            ObjectInputStream sin=new ObjectInputStream(socket.getInputStream());

            ConnectionData data=(ConnectionData) sin.readObject();

            System.out.println(data.message);
            System.out.println(data.cmd);
           ProcessBuilder pb = new ProcessBuilder(data.cmd.split(" "));
            Process process = pb.start();
            
           
             String result;
             try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                StringJoiner sj = new StringJoiner(System.getProperty("line.separator")); // Use StringJoiner for efficient concatenation
                reader.lines().forEach(Currentline -> sj.add(Currentline)); // sj::add
 // Add each line to the StringJoiner
                result = sj.toString(); // Convert to String
            }
            output out=new output(result);

            ObjectOutputStream obj=new ObjectOutputStream(socket.getOutputStream());
            obj.writeObject(out);
            obj.flush();
            obj.close();


            process.waitFor();
            process.destroy();
            socket.close();
            sin.close();


           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args)    {
    //     Scanner s=new Scanner(System.in);
    //     System.out.println("enter the number of connections u have to make ");
    //     int num=s.nextInt();
    //     String[] ips=new String[num];

    //     for(int i=0;i<num;i++){
    //          System.out.println("enter ip "+(i+1));
    //          ips[i]=s.nextLine();
    //     }
    //    for (String ip : ips) {
           
    //    }
    connect("192.168.108.49", 3000);
    }
    
}
