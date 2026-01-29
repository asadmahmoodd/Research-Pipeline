import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class compareBasesTest {

    private final compareBases baseComparer = new compareBases();

    // Test case for readbase == 61 (Branch 1: true)
    @Test
    void testReadBaseEquals61() {
        assertTrue(baseComparer.compareBases((byte)'A', (byte)61), "readbase 61 should always return true");
        assertTrue(baseComparer.compareBases((byte)'Z', (byte)61), "readbase 61 should always return true regardless of refbase");
    }

    // Test cases for refbase > 90 (Branch 2: true and false)
    @Test
    void testRefbaseLowercaseConversion() {
        // 'a' (97) > 90, converts to 'A' (65). 'C' (67) is uppercase. 'A' != 'C'.
        assertFalse(baseComparer.compareBases((byte)'a', (byte)'C'), "Lowercase refbase 'a' should convert to 'A' and not match 'C'");
    }

    @Test
    void testRefbaseUppercaseNoConversion() {
        // 'A' (65) !> 90, no conversion. 'C' (67) is uppercase. 'A' != 'C'.
        assertFalse(baseComparer.compareBases((byte)'A', (byte)'C'), "Uppercase refbase 'A' should not convert and not match 'C'");
    }

    // Test cases for readbase > 90 (Branch 3: true and false)
    @Test
    void testReadbaseLowercaseConversion() {
        // 'C' (67) is uppercase. 'a' (97) > 90, converts to 'A' (65). 'C' != 'A'.
        assertFalse(baseComparer.compareBases((byte)'C', (byte)'a'), "Lowercase readbase 'a' should convert to 'A' and not match 'C'");
    }

    @Test
    void testReadbaseUppercaseNoConversion() {
        // 'C' (67) is uppercase. 'A' (65) is uppercase. 'C' != 'A'.
        assertFalse(baseComparer.compareBases((byte)'C', (byte)'A'), "Uppercase readbase 'A' should not convert and not match 'C'");
    }

    // Test cases for refbase == readbase (Branch 4: true)
    @Test
    void testExactMatchUppercase() {
        assertTrue(baseComparer.compareBases((byte)'A', (byte)'A'), "Uppercase 'A' should match 'A'");
    }

    @Test
    void testExactMatchLowercase() {
        assertTrue(baseComparer.compareBases((byte)'a', (byte)'a'), "Both lowercase 'a' should convert to 'A' and match");
    }

    @Test
    void testExactMatchMixedCase() {
        assertTrue(baseComparer.compareBases((byte)'A', (byte)'a'), "Mixed case 'A' and 'a' should match after conversion");
        assertTrue(baseComparer.compareBases((byte)'a', (byte)'A'), "Mixed case 'a' and 'A' should match after conversion");
    }

    // Test cases for switch statement (Branch 4: false, proceed to switch)

    // Case 'N' (Branch 5)
    @Test
    void testNMatchesAny() {
        assertTrue(baseComparer.compareBases((byte)'N', (byte)'A'), "N should match A");
        assertTrue(baseComparer.compareBases((byte)'N', (byte)'C'), "N should match C");
        assertTrue(baseComparer.compareBases((byte)'n', (byte)'G'), "Lowercase n should convert to N and match G");
    }

    // Case 'U' (Branch 6)
    @Test
    void testUMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'U', (byte)'T'), "U should match T");
    }

    @Test
    void testUNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'U', (byte)'A'), "U should not match A");
    }

    // Case 'M' (Branch 7)
    @Test
    void testMMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'M', (byte)'A'), "M should match A");
    }

    @Test
    void testMMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'M', (byte)'C'), "M should match C");
    }

    @Test
    void testMNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'M', (byte)'G'), "M should not match G");
    }

    // Case 'R' (Branch 8)
    @Test
    void testRMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'R', (byte)'A'), "R should match A");
    }

    @Test
    void testRMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'R', (byte)'G'), "R should match G");
    }

    @Test
    void testRNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'R', (byte)'C'), "R should not match C");
    }

    // Case 'W' (Branch 9)
    @Test
    void testWMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'W', (byte)'A'), "W should match A");
    }

    @Test
    void testWMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'W', (byte)'T'), "W should match T");
    }

    @Test
    void testWNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'W', (byte)'C'), "W should not match C");
    }

    // Case 'S' (Branch 10)
    @Test
    void testSMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'S', (byte)'C'), "S should match C");
    }

    @Test
    void testSMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'S', (byte)'G'), "S should match G");
    }

    @Test
    void testSNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'S', (byte)'A'), "S should not match A");
    }

    // Case 'Y' (Branch 11)
    @Test
    void testYMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'Y', (byte)'C'), "Y should match C");
    }

    @Test
    void testYMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'Y', (byte)'T'), "Y should match T");
    }

    @Test
    void testYNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'Y', (byte)'A'), "Y should not match A");
    }

    // Case 'K' (Branch 12)
    @Test
    void testKMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'K', (byte)'G'), "K should match G");
    }

    @Test
    void testKMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'K', (byte)'T'), "K should match T");
    }

    @Test
    void testKNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'K', (byte)'A'), "K should not match A");
    }

    // Case 'V' (Branch 13)
    @Test
    void testVMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'V', (byte)'A'), "V should match A");
    }

    @Test
    void testVMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'V', (byte)'C'), "V should match C");
    }

    @Test
    void testVMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'V', (byte)'G'), "V should match G");
    }

    @Test
    void testVNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'V', (byte)'T'), "V should not match T");
    }

    // Case 'H' (Branch 14)
    @Test
    void testHMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'H', (byte)'A'), "H should match A");
    }

    @Test
    void testHMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'H', (byte)'C'), "H should match C");
    }

    @Test
    void testHMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'H', (byte)'T'), "H should match T");
    }

    @Test
    void testHNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'H', (byte)'G'), "H should not match G");
    }

    // Case 'D' (Branch 15)
    @Test
    void testDMatchesA() {
        assertTrue(baseComparer.compareBases((byte)'D', (byte)'A'), "D should match A");
    }

    @Test
    void testDMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'D', (byte)'G'), "D should match G");
    }

    @Test
    void testDMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'D', (byte)'T'), "D should match T");
    }

    @Test
    void testDNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'D', (byte)'C'), "D should not match C");
    }

    // Case 'B' (Branch 16)
    @Test
    void testBMatchesC() {
        assertTrue(baseComparer.compareBases((byte)'B', (byte)'C'), "B should match C");
    }

    @Test
    void testBMatchesG() {
        assertTrue(baseComparer.compareBases((byte)'B', (byte)'G'), "B should match G");
    }

    @Test
    void testBMatchesT() {
        assertTrue(baseComparer.compareBases((byte)'B', (byte)'T'), "B should match T");
    }

    @Test
    void testBNoMatch() {
        assertFalse(baseComparer.compareBases((byte)'B', (byte)'A'), "B should not match A");
    }

    // Default case (Branch 17)
    @Test
    void testDefaultNoMatch() {
        // 'X' is not a special base, and 'X' != 'Y'. This hits the default case and returns false.
        assertFalse(baseComparer.compareBases((byte)'X', (byte)'Y'), "Default case with non-matching bases should return false");
        // Test with lowercase to ensure conversion happens before default
        assertFalse(baseComparer.compareBases((byte)'x', (byte)'y'), "Lowercase non-matching bases should convert and then return false from default");
    }
}