import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(2009);
            Socket socket = serverSocket.accept();
            while (true) {


                InputStream input = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(input);
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                int res = Integer.parseInt(line);
                res = res * res;
                OutputStream output = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(output);
                pw.println(res);
                pw.flush();
                System.out.println(res);
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
