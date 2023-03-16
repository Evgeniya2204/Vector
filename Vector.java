package OOP.Part1.Vector;

import java.util.Arrays;

public class Vector {
    //ПОЛЯ:
    private int n;
    private double[] components;

    //КОНСТРУКТОРЫ:
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность n должна быть больше 0");
        } else {
            this.n = n;
            this.components = new double[n];
            for (int i = 0; i < n; i++) {
                this.components[i] = 0.0;
            }
        }
    }

    public Vector(Vector other) {
        if (other != null) {//сравнение с null правильное
            this.n = other.n;
            this.components = other.components;
        }
    }

    public Vector(double[] components) {
        this.components = components;
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность n должна быть больше 0");
        } else {
            this.n = n;
        }
        if (components.length < n) {
            for (int i = 0; i < components.length; i++) {
                this.components[i] = components[i];
            }
            for (int i = components.length; i < n; i++) {
                this.components[i] = 0;
            }
        } else {
            this.components = components;
        }
    }

    //МЕТОДЫ:
    public int getSize() {
        if (n > 0) {
            return n;
        } else {
            return this.components.length;
        }
    }

    public double getComponent(int index) {
        return this.components[index];
    }

    public void setComponent(int index, double component) {
        this.components[index] = component;
    }

    //ПЕРЕОПРЕДЕЛЕНИЕ СТАНДАРТНЫХ МЕТОДОВ:
    @Override
    public String toString() {
        return Arrays.toString(components);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector v1 = (Vector) o;
        int size = v1.getSize();
        for (int i = 0; i < size; i++) {
            if (v1.getComponent(i) != this.getComponent(i)) {
                return false;
            }
        }
        if (n != v1.n) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    public static Vector getAdditionOfVectors(Vector v1, Vector v2) {//Получить сумму двух переданных векторов
        if (v1 != null && v2 != null) {
            Vector result = null;
            if (v1.getSize() == v2.getSize()) {
                int size = v1.getSize();
                double resultComponent;
                result = new Vector(size);
                for (int i = 0; i < size; i++) {
                    resultComponent = v1.getComponent(i) + v2.getComponent(i);
                    result.setComponent(i, resultComponent);
                }
            }
            return result;
        } else {
            throw new NullPointerException("В аргументах функции не может быть null");
        }
    }


    public double[] getSum(double[] components) {//к вектору прибавить вектор в виде массива
        double[] sumOfComponents;
        if (this.components.length == components.length) {
            sumOfComponents = new double[components.length];
            for (int i = 0; i < components.length; i++) {
                sumOfComponents[i] = this.components[i] + components[i];
            }
        } else if (this.components.length > components.length) {
            sumOfComponents = new double[this.components.length];
            for (int i = 0; i < components.length; i++) {
                sumOfComponents[i] = this.components[i] + components[i];
            }
            for (int i = components.length; i < this.components.length; i++) {
                sumOfComponents[i] = this.components[i];
            }
        } else {
            sumOfComponents = new double[components.length];
            for (int i = 0; i < this.components.length; i++) {
                sumOfComponents[i] = this.components[i] + components[i];
            }
            for (int i = this.components.length; i < components.length; i++) {
                sumOfComponents[i] = components[i];
            }
        }
        return sumOfComponents;
    }


    public static Vector getSubtractionOfVectors(Vector v1, Vector v2) {///Получить разность двух переданных векторов
        Vector result = null;
        if (v1.getSize() == v2.getSize()) {
            int size = v1.getSize();
            double resultComponent;
            result = new Vector(size);
            for (int i = 0; i < size; i++) {
                resultComponent = v1.getComponent(i) - v2.getComponent(i);
                result.setComponent(i, resultComponent);
            }
        }
        return result;
    }

    public double[] getDifference(double[] components) {//от вектора отнять переданные компоненты другого вектора
        double[] difOfComponents;
        if (this.components.length == components.length) {
            difOfComponents = new double[components.length];
            for (int i = 0; i < components.length; i++) {
                difOfComponents[i] = this.components[i] - components[i];
            }
        } else if (this.components.length > components.length) {
            difOfComponents = new double[this.components.length];
            for (int i = 0; i < components.length; i++) {
                difOfComponents[i] = this.components[i] - components[i];
            }
            for (int i = components.length; i < this.components.length; i++) {
                difOfComponents[i] = this.components[i];
            }
        } else {
            difOfComponents = new double[components.length];
            for (int i = 0; i < this.components.length; i++) {
                difOfComponents[i] = this.components[i] - components[i];
            }
            for (int i = this.components.length; i < components.length; i++) {
                difOfComponents[i] = 0 - components[i];
            }
        }
        return difOfComponents;
    }


    public static Vector getScalarMultiplication(Vector v1, int scalar) {
        int size = v1.getSize();
        double resultComponent;
        Vector result = new Vector(size);
        for (int i = 0; i < size; i++) {
            resultComponent = v1.getComponent(i) * scalar;
            result.setComponent(i, resultComponent);
        }
        return result;
    }

    public double[] getOnScalarMultiplication(int scalar) {
        double[] resultComponent = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            resultComponent[i] = components[i] * scalar;
        }
        return resultComponent;
    }

    public double[] getVectorReversal() {//разворот вектора
        double[] resultComponent = new double[components.length];
        for (int i = 0; i < components.length; i++) {
            resultComponent[i] = 0- components[i];
        }
        return resultComponent;
    }

    public Vector getVectorReverse() {
        double[] array = new double[components.length];
        Vector v6 = new Vector(array);
        for (int i = 0; i<array.length;i++){
            array[i]=components[i]*(-1);
        }
    return v6;
    }

    public double getLength() {// геометрическая длина вектора
        int size = this.getSize();
        double squareOfComponent;
        double sumOfSquares = 0;
        for (int i = 0; i < size; i++) {
            squareOfComponent = Math.pow(this.getComponent(i), 2.0);
            sumOfSquares += squareOfComponent;
        }
        double length = Math.sqrt(sumOfSquares);
        return length;
    }
}
