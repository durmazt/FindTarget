import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TargetMain {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        socket.setSoTimeout(7000);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            Coordinate coordinate = Coordinate.generateRandomCoordinate();
            try {
                out.writeInt(coordinate.x);
                out.writeInt(coordinate.y);
                System.out.println("x: " + coordinate.x + " y: " + coordinate.y);
            } catch (IOException e) {
                e.printStackTrace();
                // handle the exception here, e.g. by breaking out of the loop or retrying
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
