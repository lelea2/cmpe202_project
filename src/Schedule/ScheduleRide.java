package Schedule;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import Request.*;
import Payment.*;

/**
 * Created by kdao on 8/15/16.
 */
public class ScheduleRide extends Schedule {
    public ScheduleRide(Request req, Payment pay) {
        super(req, pay);
        _distance = 0;
    }

    @Override
    public void setDistance() {
        if (_endPoint != null && _startPoint != null) {
            _distance = (int) (Math.abs(_endPoint.getX() - _startPoint.getX()) + Math.abs(_endPoint.getY() - _startPoint.getY()));
        }
    }
    @Override
    public long getDistance() {
        return _distance;
    }

    @Override
    public void set_startPoint(Point start) {
        _startPoint = start ;
    }

    @Override
    public void set_endPoint(Point end) {
        _endPoint = end ;
    }

    @Override
    public long getTotalTime() {
        Instant startI = _startTime.toInstant(ZoneOffset.UTC);
        Instant endI = _finishTime.toInstant(ZoneOffset.UTC);
        return Duration.between(startI, endI).toMinutes();
    }
}
