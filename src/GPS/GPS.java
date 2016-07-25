package GPS;

import java.awt.Point;
import java.util.Random;

/**
 * Created by kdao on 7/24/16.
 */

public class GPS {
    private Point location;

    /**
     * Constructor
     */
    public GPS() {
        location = new Point(getPosRange(0, 50), getPosRange(0, 50));
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point point) {
        location = point;
    }

    private int getPosRange(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
