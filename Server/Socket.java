package Server;
import java.io.*;

public class Socket {

    public static java.net.Socket socket;
    public static ObjectInputStream inputStream;
    public static ObjectOutputStream outputStream;

    public static void connectToServer(){
        try {
            socket = new java.net.Socket("127.0.0.1", 8888);
            //inputStream = socket.getInputStream();
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            InputStream in = socket.getInputStream();
            inputStream = new ObjectInputStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
