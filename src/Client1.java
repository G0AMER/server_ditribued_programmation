import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException {
        //connexion
        InetAddress addr = InetAddress.getByName("192.168.0.9");
        Socket s = new Socket(addr, 2009);
        //envoie d'adresse et de mot de passe
        OutputStream out = s.getOutputStream();
        PrintWriter str = new PrintWriter(out);
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le login : ");
        String log = sc.nextLine();
        System.out.println("Entrez le mot de passe : ");
        String pwd = sc.nextLine();
        str.println(log);
        str.println(pwd);
        str.flush();
        //reçoit du b
        InputStream in = s.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader istream = new BufferedReader(reader);
        boolean b = Boolean.parseBoolean(istream.readLine());
        if (b) {
            System.out.println("Client connecté");
        } else {
            System.out.println("Client non connecté");

        }
    }


}
