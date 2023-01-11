import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll() { // !!! it is static method @BeforeAll
        System.out.println("BeforeAll is executed");
    }
            // These two methods are common, so we create them as static
    @AfterAll
    static void tearDownAll() { // !!! it is static method @AfterAll
        System.out.println("AfterAll is executed");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed");
    }

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5, actual, "Test failed.");
    }

    @Test
    void add2() {
        System.out.println("Add2 method");

        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3,2));   // pass
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2,3));
        // fail, expected illegal to be thrown, but nothing was thrown.
        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3,2));      // fail
    }

    @Test
    void testCase1() {
        System.out.println("Test Case 1");
        fail("Not implemented yet.");
    }

    @Test
    void testCase2() {
        System.out.println("Test Case 2");
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);
    }

    @Test
    void testCase3() {
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 2}, "Arrays are not same");
    }

    @Test
    void testCase4() {
        System.out.println("Test Case 4");

        String nullString = null;
        String notNullString = "icolak_test";

        assertNull(nullString);         // pass
        assertNotNull(notNullString);   // pass

        assertNull(notNullString);      // fail
        assertNotNull(nullString);      // fail
    }

    @Test
    void testCase5() {
        System.out.println("Test Case 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1,c2);
        assertNotSame(c1,c3);

    }
}