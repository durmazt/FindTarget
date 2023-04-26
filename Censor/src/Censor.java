public class Censor {

    Coordinate coordinate;

    double bearing;

    public Censor(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    public double findBearing(Coordinate target) {

        double angle = Math.atan2(target.y - coordinate.y, target.x - coordinate.x);
        double bearing = Math.toDegrees(angle);

        if (bearing < 0) {
            bearing = bearing + 360;
        }



        return bearing;
    }

}
