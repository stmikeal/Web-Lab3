
package beans;

import tools.Point;
import tools.PointDB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Named("mainBean")
@SessionScoped
public class MainBean implements Serializable {

    @Inject
    private PointDB pointDB;

    private String x = "0";
    private String y = "0";
    private String r = "1";
    private List<Point> points;

    public MainBean() {
        points = new ArrayList<>();
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        return LocalDateTime.now().format(formatter);
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getR() {
        return r;
    }

    public List<Point> getPoints() {
        return points;
    }


    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public void setR(String r) {
        this.r = r;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void clearPoints() {
        points.clear();
        showClearMessage();
    }

    public void addPoint() {
        Point point = new Point(x, y, r);
        pointDB.add(point);
        points.add(point);
    }

    public void showClearMessage() {
    }
}