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

        // Reflects the part that I am supposed to do
        int[] newH = {0x42d424cb, 0x164e5936, 0xcf0d11d7, 0x49e3edde, 0x967fa89d};
        String message2 = " Joseph";
        String HMAC2 = sha1Impl.getHashDigest(message2.getBytes(), newH);
        byte[] rtn1 = extendMessage(message1, message2);

        byte[] theirRun = new byte[key.getBytes().length + rtn1.length];
        System.arraycopy(key.getBytes(), 0, theirRun, 0, key.getBytes().length);
        System.arraycopy(rtn1, 0, theirRun, key.getBytes().length, rtn1.length);
        String HMAC3 = sha1Impl.getHashDigest(theirRun, null);
        if(!HMAC3.equals(HMAC2))
            throw new RuntimeException("Expected the two strings to be equal");

        System.out.println();
    }

    private static byte[] extendMessage(String message1, String message2) {
        byte[] message1PaddedBytes = sha1Impl.padTheMessage(message1.getBytes());
        // increase the length at the end of the byte[] by 128
        // TODO!!!
        message1PaddedBytes[message1PaddedBytes.length - 1] = (byte) 0xd8;
        byte[] rtn1 = new byte[message1PaddedBytes.length + message2.getBytes().length];
        System.arraycopy(message1PaddedBytes, 0, rtn1, 0, message1PaddedBytes.length);
        System.arraycopy(message2.getBytes(), 0, rtn1, message1PaddedBytes.length, message2.getBytes().length);
        return rtn1;
    }
}
