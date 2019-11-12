

public class Triangle {
    public static boolean cheackTr(double a, double b, double c) {

        if(a <= 0 || b <= 0 || c <= 0
                    ||a == Double.NEGATIVE_INFINITY || b == Double.NEGATIVE_INFINITY || c == Double.NEGATIVE_INFINITY
                    ||a == Double.POSITIVE_INFINITY || b == Double.POSITIVE_INFINITY || c == Double.POSITIVE_INFINITY
                    || Double.compare(a, Double.NaN) * Double.compare(b, Double.NaN) * Double.compare(c, Double.NaN) == 0){
            return false; }

        return checkSides(a, b, c) && checkSides(a, c, b) && checkSides(b, c, a);
    }
    private static boolean checkSides(double a, double b, double c){
        return (a+b)>c;
    }
}
