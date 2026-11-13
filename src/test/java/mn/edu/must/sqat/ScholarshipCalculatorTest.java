package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calculator = new ScholarshipCalculator();

    // A хэсгийн happy-path тестүүд

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

    // letterGrade() нэмэлт тестүүд

    @Test
    void letterGrade_returnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void letterGrade_returnsF() {
        assertEquals("F", calculator.letterGrade(55));
    }

    @Test
    void letterGrade_rejectsBelowZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    @Test
    void letterGrade_rejectsAbove100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    // gpa() тестүүд

    @Test
    void gpa_calculatesAverage() {
        double[] scores = {95, 85};
        assertEquals(3.5, calculator.gpa(scores));
    }

    @Test
    void gpa_coversAllGradeMappings() {
        double[] scores = {95, 85, 75, 65, 55};
        assertEquals(2.0, calculator.gpa(scores));
    }

    @Test
    void gpa_rejectsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    @Test
    void gpa_rejectsEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    // scholarship() тестүүд

    @Test
    void scholarship_awards100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_rejectsViolation() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void scholarship_awards70WhenGpaBelow38() {
        assertEquals(70, calculator.scholarship(3.7, 16, false));
    }

    @Test
    void scholarship_awards70WhenCreditsBelow15() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void scholarship_awards50WhenGpaBelow34() {
        assertEquals(50, calculator.scholarship(3.2, 15, false));
    }

    @Test
    void scholarship_awards50WhenCreditsBelow12() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    @Test
    void scholarship_awardsZeroWhenGpaBelow3() {
        assertEquals(0, calculator.scholarship(2.9, 15, false));
    }

    @Test
    void scholarship_rejectsNegativeGpa() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-1, 15, false));
    }

    @Test
    void scholarship_rejectsGpaAbove4() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(5, 15, false));
    }

    @Test
    void scholarship_rejectsNegativeCredits() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.5, -1, false));
    }

    @Test
    void gpa_handlesOneElement() {
        double[] scores = {95};
        assertEquals(4.0, calculator.gpa(scores));
    }

    @Test
    void gpa_handlesMultipleElements() {
        double[] scores = {95, 85, 75, 65};
        assertEquals(2.5, calculator.gpa(scores));
    }
    @Test
    void letterGrade_60ShouldBeD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void letterGrade_59_99ShouldBeF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void letterGrade_69_99ShouldBeD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void letterGrade_0ShouldBeF() {
        assertEquals("F", calculator.letterGrade(0));
    }

    @Test
    void letterGrade_100ShouldBeA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void letterGrade_89_99ShouldBeB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void letterGrade_90ShouldBeA() {
        assertEquals("A", calculator.letterGrade(90));
    }
}
