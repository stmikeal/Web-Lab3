
package beans;

import tools.DatabaseHandler;
import tools.Point;
import tools.PointDB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "mainBean")
@SessionScoped
public class MainBean {

    private String x = "0";
    private String y = "0";
    private String r = "1";
    private List<Point> points;
    private final PointDB pointHandler;
    private final String sessionID;
    private final DatabaseHandler dbHandler = new DatabaseHandler();

    public MainBean(){
        points = new ArrayList<>();
        pointHandler = new PointDB();
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
        this.sessionID = session.getId();
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
        Point point = new Point(x, y ,r);
        points.add(point);
        pointHandler.add(point);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Проверка точки. "+
                        "X: " + point.getX() + " Y: " + point.getY() + " R: " + point.getR() +
                        " " + point.getHit()));
    }

    public void showClearMessage() {
    }
}