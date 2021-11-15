package libraryTest;

import library.BoardLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class BoardLocationTest {
    @Test public void constructorTest() {
        BoardLocation boardLocationTest = new BoardLocation(0, 0);
        Assertions.assertEquals(0, boardLocationTest.getColumn());
        Assertions.assertEquals(0, boardLocationTest.getRow());
    }
}
