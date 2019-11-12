
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @BeforeEach
    void setUp() {
    }



    @Test
    void checkRightTr(){
        boolean act = Triangle.cheackTr(2,2,3);
        assertTrue(act);
    }

    @Test
    void checkSum2SidesLess3(){
        boolean act = Triangle.cheackTr(1,1,3);
        assertFalse(act);
    }

    @Test
    void checkSum2SidesEq3(){
        boolean act = Triangle.cheackTr(1,2,3);
        assertFalse(act);
    }

    @Test
    void checkSidesLess0(){
        boolean act = Triangle.cheackTr(-2,2,3);
        assertFalse(act);
    }

    @Test
    void checkSidesEq0(){
        boolean act = Triangle.cheackTr(0,2,3);
        assertFalse(act);
    }

    @Test
    void checkSideMaxDouble(){
        boolean act = Triangle.cheackTr(Double.POSITIVE_INFINITY,2,3);
        assertFalse(act);
    }

    @Test
    void checkSidesForNaN(){
        boolean act = Triangle.cheackTr(Double.NaN,2,3);
        assertFalse(act);
    }

    @Test
    void checkSideMinDouble(){
        boolean act = Triangle.cheackTr(Double.NEGATIVE_INFINITY,2,3);
        assertFalse(act);
    }

    @Test
    void checkSideWrongInteger(){
        Integer a = 2;
        boolean act = Triangle.cheackTr(a,2,3);
        assertTrue(act);
    }

    @Test
    void checkSideWrongLong(){
        long a = 2;
        boolean act = Triangle.cheackTr(a,2,3);
        assertTrue(act);
    }


}