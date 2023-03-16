package OOP.Part1.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(new double[]{3.0, 4.0, 5.0});
        Vector v2 = new Vector(3, new double[]{10.0, 9.0, 2.0});
        Vector v3 = new Vector(4);
        Vector v4 = new Vector(v1);
        Vector v5 = new Vector(new double[]{5.0, 7.0, 4.5});

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        int size1 = v1.getSize();
        int size2 = v2.getSize();
        int size3 = v3.getSize();
        int size4 = v4.getSize();

        double element1 = v1.getComponent(2);
        double element2 = v2.getComponent(1);
        double element3 = v3.getComponent(0);
        double element4 = v4.getComponent(2);

        v1.setComponent(2, 15.0);
        v2.setComponent(2, 20.0);
        v3.setComponent(0, 25.0);
        v4.setComponent(1, 30.0);

        Vector resultVector1 = Vector.getAdditionOfVectors(v1, v2);
        Vector resultVector2 = Vector.getAdditionOfVectors(v3, v4);

        double[] sum1 = v1.getSum(new double[]{8.0, 9.0});
        double[] sum2 = v2.getSum(new double[]{1.0, 8.0, 2.0, 4.0});
        double[] sum3 = v3.getSum(new double[]{3.5, 4.0});
        double[] sum4 = v4.getSum(new double[]{8.9, 7.5, 6.5, 7.9, 8.0});

        Vector resultVector3 = Vector.getSubtractionOfVectors(v1, v2);
        Vector resultVector4 = Vector.getSubtractionOfVectors(v4, v3);

        double[] dif1 = v2.getDifference(new double[]{8.0, 9.0});
        double[] dif2 = v4.getDifference(new double[]{7.9, 6.0, 4.6, 3.5, 2.0});

        Vector scalarVector = Vector.getScalarMultiplication(v1, 5);
        double[] result = v3.getOnScalarMultiplication(5);

        Vector v6 = new Vector(v5.getVectorReversal());
        Vector v7 = v5.getVectorReverse();
        System.out.println(v6);
        System.out.println(v7);

        v1.getLength();
        v5.getLength();
        System.out.println(v5.getLength());

        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(dif1));
        System.out.println(Arrays.toString(result));

    }
}
