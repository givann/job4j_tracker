package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }


    public boolean exist(double ab, double ac, double bc) {
        double per = period(ab, ac, bc);
        if (per > 0)
            return true;
        else
            return false;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double per = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = per * (per - ab) * (per - ac) * (per - bc);
        }
        return rsl;
    }
}

