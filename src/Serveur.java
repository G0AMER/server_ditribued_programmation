import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Serveur {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("Sami", "123");
        map.put("Ali", "azerty");
        int clientCount = 0;

        try {
            ServerSocket svs = new ServerSocket(2009);
            System.out.println("Serveur lancé");

            while (true) {
                Socket s = svs.accept();
                clientCount++;
                System.out.println("Client " + clientCount + " accepté");

                // Déléguer la connexion à un nouveau thread
                ThreadService ts = new ThreadService(s, map, clientCount);
                ts.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}