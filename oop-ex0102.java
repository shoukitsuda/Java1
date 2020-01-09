class Point2D {
    double x, y;
    Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Point2D move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }
    double dist(Point2D v) { // implement this method
        double dx = this.x - v.getX();
        double dy = this.y - v.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }
    double dist() { // implement this method
      Point2D u = new Point2D(0,0);
      return dist(u);
    }
    double getX() { // implement this method
        return x;
    }
    double getY() { // implement this method
        return y;
    }
    Point2D rotate(double ang) { // implement this method
      ang = ang / 360. * 2 * Math.PI; // deg -> rad
      double r = this.dist();
      ang += Math.atan2(y,x);
      this.x = r * Math.cos(ang);
      this.y = r * Math.sin(ang);
      return this;
    }
    Point2D rotate(Point2D v, double ang) { // implement this method

      //Point2D d = new Point2D(  this.x - v.getX(), this.y - v.getY());
      //d.rotate(ang);
      //d.move( v.getX(), v.getY());

      //  return d;

      double r = this.dist(v);
      double dx = this.x-v.getX();
      double dy = this.y-v.getY();

      ang = ang / 360. * 2 * Math.PI; // deg -> rad
      //double r = this.dist();
      ang += Math.atan2(dy,dx);
      dx = r * Math.cos(ang);
      dy = r * Math.sin(ang);

      this.x = dx + v.getX();
      this.y = dy + v.getY();
      return this;
    }

    String show() {
        return "(" + x + ", " + y + ")";
    }
}
class Point2DMain {
    public static void main(String [] args) {
        Point2D u = new Point2D(8, 6);
        Point2D v = new Point2D(4, 3);
        Point2D w = new Point2D(15, 3);
        System.out.println("u = " + u.show());
        System.out.println("v = " + v.show());
        System.out.println("w = " + w.show());
        System.out.println("x of u = " + u.getX());
        System.out.println("y of v = " + v.getY());
        System.out.println("distance of w and u = " + w.dist(u));
        System.out.println("distance of w from O = " + w.dist());
        u.move(-1,-3);
        System.out.println("moved u = " + u.show());
        v.rotate(90);
        System.out.println("rotated v = " + v.show());
        v.rotate(90).move(4,5).rotate(-90); // chain!
        System.out.println("new v = " + v.show());
        w.rotate(u, -90);
        System.out.println("rotated w = " + w.show());
        v.rotate(v, -90); // this doesn't move, of course.
        System.out.println("rotated v = " + v.show());
    }
}
