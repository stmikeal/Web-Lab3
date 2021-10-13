package tools;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Point implements Serializable {
    private double x;
    private double y;
    private double r;
    private long scriptTime;
    private String sendTime;
    private String hit;

    public Point(String xParam, String yParam, String rParam) {
        this.scriptTime = System.currentTimeMillis();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.sendTime = LocalDateTime.now().format(formatter);
        setFields(xParam, yParam, rParam);
        this.hit = checkHit() ? "Попадание" : "Промах";
        this.scriptTime = System.currentTimeMillis() - this.scriptTime;
        this.scriptTime = this.scriptTime > 0 ? this.scriptTime : 3;
    }

    private void setFields(String xParam, String yParam, String rParam) {
        try {
            this.x = Double.parseDouble(xParam);
        } catch (Exception e) {
            System.out.println("Not valid x-parameter. Setting default value.");
            this.x = 0D;
        }
        try {
            this.y = Double.parseDouble(yParam.replaceAll(",", "."));
        } catch (Exception e) {
            System.out.println("Not valid y-parameter. Setting default value.");
            this.y = 0D;
        }
        try {
            this.r = Double.parseDouble(rParam);
        } catch (Exception e) {
            System.out.println("Not valid r-parameter. Setting default value.");
            this.r = 1D;
        }
    }

    private boolean checkHit() {
        return checkCircle()||checkRectangle()||checkTriangle();
    }

    private boolean checkTriangle() {
        return y-2*x <= r && y >= 0 && x <= 0;
    }

    private boolean checkCircle() {
        return x*x + y*y <= r*r && x >= 0 && y <= 0;
    }

    private boolean checkRectangle() {
        return x >= 0 && y >= 0 && y <= r && 2*x < r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getScriptTime() {
        return scriptTime + " ms";
    }

    public String getSendTime() {
        return sendTime;
    }

    public String getHit() {
        return hit;
    }
}
