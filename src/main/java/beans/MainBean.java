
package beans;

import tools.Point;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private LocalDateTime dateTime;

    public MainBean(){
        dateTime = LocalDateTime.now();
        points = new ArrayList<>();
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        return LocalDateTime.now().format(formatter).toString();
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

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public void validateNumber(String value) {
        System.out.println(value);
    }

    public void clearPoints() {
        points.clear();
        showClearMessage();
    }

    public void addPoint() {
        Point point = new Point(x, y ,r);
        points.add(point);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Проверка точки. "+
                        "X: " + point.getX() + " Y: " + point.getY() + " R: " + point.getR() +
                        " " + point.getHit()));
    }

    public void showClearMessage() {
    }
}