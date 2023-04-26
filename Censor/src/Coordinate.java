import java.util.Random;

public class Coordinate {

    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate generateRandomCoordinate() {
        Random random = new Random();
        int x = random.nextInt(1001) - 500;
        int y = random.nextInt(1001) - 500;
        return new Coordinate(x, y);
    }

}
