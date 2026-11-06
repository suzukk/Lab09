package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void letterGrade_returnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGrade_returnsB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void letterGrade_returnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void gpa_calculatesAverage() {
        double[] scores = {95, 85};
        assertEquals(3.5, calculator.gpa(scores));
    }

    @Test
    void scholarship_awards100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }
}

