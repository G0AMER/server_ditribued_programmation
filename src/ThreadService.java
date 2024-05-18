import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ThreadService extends Thread {
    private Socket socket;
    private Map<String, String> map;
    private int clientCount;

    public ThreadService(Socket socket, Map<String, String> map, int clientCount) {
        this.socket = socket;
        this.map = map;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        try {
            // Récupérer log et password
            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader istream = new BufferedReader(reader);
            String log = istream.readLine();
            String pwd = istream.readLine();

            boolean b;
            if (map.containsKey(log) && map.get(log).equals(pwd)) {
                System.out.println(log + " vient se connecter");
                b = true;
            } else {
                System.out.println("Impossible connexion");
                b = false;
            }

            OutputStream out = socket.getOutputStream();
            PrintWriter str = new PrintWriter(out);
            str.println(b);
            str.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}