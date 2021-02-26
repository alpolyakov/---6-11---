package var1.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Quadratic {
    private double a;
    private double b;
    private double c;

    public Quadratic(double a, double b, double c) {
        //checkQuadratic(a);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double[] getX() {
        double d = getDiscriminant();
        double[] x;

        if (d > 0) {
            x = new double[2];
            x[0] = (-b + Math.sqrt(d)) / (2 * a);
            x[1] = (-b - Math.sqrt(d)) / (2 * a);
            return x;
        } else if (d == 0) {
            x = new double[1];
            x[0] = -b / (2 * a);
            return x;
        } else {
            x = new double[0];
        }

        return x;
    }

    public double getExtremum() {
        return -b / (2 * a);
    }

    public double[] getDecreasingInterval() {
        double[] interval = new double[2];

        if (a > 0) {
            interval[0] = Double.NEGATIVE_INFINITY;
            interval[1] = getExtremum();
        } else {
            interval[0] = getExtremum();
            interval[1] = Double.POSITIVE_INFINITY;
        }

        return interval;
    }

    public double[] getIncreasingInterval() {
        double[] interval = new double[2];

        if (a > 0) {
            interval[0] = getExtremum();
            interval[1] = Double.POSITIVE_INFINITY;
        } else {
            interval[0] = Double.NEGATIVE_INFINITY;
            interval[1] = getExtremum();
        }

        return interval;
    }

    public double getMaxRoot(double[] roots) throws Exception {
        if (roots.length == 2) {
            double maxroot = roots[0];
            if (roots[1] > maxroot)
                maxroot = roots[1];
            return maxroot;
        }
        else if (roots.length == 1)
            return roots[0];
        else
            throw new Exception("Корней нет");

    }

    public double getMinRoot(double[] roots) throws Exception {
        if (roots.length == 2) {
            double minroot = roots[0];
            if (roots[1] < minroot)
                minroot = roots[1];
            return minroot;
        }
        else if (roots.length == 1)
            return roots[0];
        else
            throw new Exception("Корней нет");

    }

}

public class Main {
    public static void main(String[] args) {
        List<Quadratic> quadratics = new ArrayList<>();
        List<Double> maxroots = new ArrayList<>();
        List<Double> minroots = new ArrayList<>();
        //double maxx = first.getMaxRoot(first.getX());

        quadratics.add(new Quadratic(2., 1., 5.));
        quadratics.add(new Quadratic(1., 10.5, 3.));
        quadratics.add(new Quadratic(2.5, 20., 3.));
        quadratics.add(new Quadratic(1., 0, 0));
        quadratics.add(new Quadratic(1., 0, -5.));

        //double maxx = quadratics.get(0).getMaxRoot(quadratics.get(0).getX);
        int narr = 0;
        for (Quadratic quadratic : quadratics) {
            System.out.println("y = " + quadratic.getA() + "x^2 + (" + quadratic.getB() + ")x + (" + quadratic.getC() + ")");

            System.out.print("Discriminant = ");
            System.out.println(quadratic.getDiscriminant());

            double[] roots = new double[2];
            roots = quadratic.getX();
            System.out.print("Root(s) = ");
            System.out.println(Arrays.toString(roots));

            try {
                double max = quadratic.getMaxRoot(roots);
                double min = quadratic.getMinRoot(roots);
                narr += 1;
                maxroots.add(max);
                minroots.add(min);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //double max = quadratic.getMaxRoot(roots);
            //System.out.println(max);

            System.out.print("Decreasing interval = ");
            System.out.println(Arrays.toString(quadratic.getDecreasingInterval()));

            System.out.print("Increasing interval = ");
            System.out.println(Arrays.toString(quadratic.getIncreasingInterval()));

            System.out.println();
        }
        System.out.println(narr);
        System.out.println(maxroots);
        System.out.println(minroots);

        if (maxroots.isEmpty()) {
            System.out.println("Max root = None");
        }
        else {
            double mx = maxroots.get(0);
            for (int i = 0; i<narr; i++) {
                if (maxroots.get(i) > mx)
                    mx = maxroots.get(i);
            }
            System.out.println("Max root = " + mx);
        }

        if (minroots.isEmpty()) {
            System.out.println("Min root = None");
        }
        else {
            double mn = minroots.get(0);
            for (int i = 0; i<narr; i++) {
                if (minroots.get(i) < mn)
                    mn = minroots.get(i);
            }
            System.out.println("Min root = " + mn);
        }

    }

    //System.out.print("Max root = ");
    //System.out.println(getMaxX(quadratics));

    //System.out.print("Min root = ");
    //System.out.println(getMinX(quadratics));
}