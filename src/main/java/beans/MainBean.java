
package beans;

import tools.Point;
import tools.PointDB;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mainBean")
@ApplicationScoped
public class MainBean implements Serializable {

    private String x = "0";
    private String y = "0";
    private String r = "1";
    private List<Point> points;
    private final PointDB pointHandler;
    private final String sessionID;

    public MainBean(){
        points = new ArrayList<>();
        pointHandler = new PointDB();
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        this.sessionID = session.getId();
        System.out.println("Bean init");
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
        pointHandler.clear(sessionID);
        points.clear();
        showClearMessage();
    }

    public void addPoint() {
        pointHandler.open();
        Point point = new Point(x, y ,r);
        points.add(point);
        //pointHandler.add(point);
    }

    public void showClearMessage() {
    }
}