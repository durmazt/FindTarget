import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CensorMain {

    public static void main(String[] args)  {




      try(ServerSocket serverSocket = new ServerSocket(8080)) {
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Socket  centralSocket= new Socket("localhost", 8081);
        DataOutputStream out = new DataOutputStream(centralSocket.getOutputStream());

          while(true)
            {
            int x = in.readInt();
            int y = in.readInt();
            Censor censor1 = new Censor(Coordinate.generateRandomCoordinate());
            Censor censor2 = new Censor(Coordinate.generateRandomCoordinate());

            censor1.bearing=censor1.findBearing(new Coordinate(x, y));
            censor2.bearing=censor2.findBearing(new Coordinate(x, y));

            out.writeInt(censor1.coordinate.x);
            out.writeInt(censor1.coordinate.y);
            out.writeDouble(censor1.bearing);

            out.writeInt(censor2.coordinate.x);
            out.writeInt(censor2.coordinate.y);
            out.writeDouble(censor2.bearing);




            System.out.printf("Target is at (%d, %d)%n", x, y);
            System.out.printf("Censor 1 is at (%d, %d) and is facing %.2f degrees%n", censor1.coordinate.x, censor1.coordinate.y, censor1.bearing);
            System.out.printf("Censor 2 is at (%d, %d) and is facing %.2f degrees%n", censor2.coordinate.x, censor2.coordinate.y, censor2.bearing);

            }



      } catch(IOException e)
      {
        e.printStackTrace();
      }
    }
}
