import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8081)) {
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());

while (true) {
    int C1x = in.readInt();
    int C1y = in.readInt();
    double C1bearing = in.readDouble();

    Coordinate censor1 = new Coordinate(C1x, C1y);

    int C2x = in.readInt();
    int C2y = in.readInt();
    double C2bearing = in.readDouble();

    Coordinate censor2 = new Coordinate(C2x, C2y);



    Coordinate target = findTargetLocation(censor1, censor2,C1bearing, C2bearing);

    System.out.printf("Target is at (%d, %d)%n", target.x, target.y);
    System.out.printf("Censor 1 is at (%d, %d) and is facing %.2f degrees%n", C1x, C1y, C1bearing);
    System.out.printf("Censor 2 is at (%d, %d) and is facing %.2f degrees%n", C2x, C2y, C2bearing);



}

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Coordinate findTargetLocation(Coordinate sensor1, Coordinate sensor2, double bearing1, double bearing2) {

            double x1 = sensor1.x;
            double y1 = sensor1.y;
            double x2 = sensor2.x;
            double y2 = sensor2.y;

            double m1 = Math.tan(Math.toRadians(bearing1));
            double m2 = Math.tan(Math.toRadians(bearing2));

            double x = (m1 * x1 - m2 * x2 + y2 - y1) / (m1 - m2);
            x= Math.round(x);
            double y = m1 * (x - x1) + y1;
            y= Math.round(y);

            return new Coordinate((int) x, (int) y);
    }
    }
