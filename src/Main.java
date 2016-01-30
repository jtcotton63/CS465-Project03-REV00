/**
 * Created by josepher on 1/29/16.
 */
public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        // Test case 1
        String expected = "a9993e364706816aba3e25717850c26c9cd0d89d";
        String result = sha1Impl.getHashDigest("abc".getBytes(), null);
        if(!expected.equals(result))
            throw new RuntimeException("Expected the two strings to be equal");

        // Test case 2
        String key = "abc";
        String message1 = "Hello there";
        String initial = key + message1;
        String expectedHMAC1 = "42d424cb164e5936cf0d11d749e3edde967fa89d";
        String resultHMAC1_1 = sha1Impl.getHashDigest(initial.getBytes(), null);
        if(!expectedHMAC1.equals(resultHMAC1_1))
            throw new RuntimeException("Expected the two strings to be equal");

        System.out.println();
    }
}
