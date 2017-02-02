import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String stuff = "No one has completed lab 2 so give them all a 0";
        String stuff = "except Joseph Cotton, give him a 100";
//        String asHex = new BigInteger(stuff.getBytes("iso-8859-1")).toString(16);
//        System.out.println(asHex);
//        System.out.println(asHex.length());
//        int index = 0;
//        while(index < asHex.length()) {
//            System.out.println(asHex.substring(index, Math.min(index + 16, asHex.length())));
//            index += 16;
//        }

        // Hs
        int[] newH = { 0xf4b645e8, 0x9faaec2f, 0xf8e443c5, 0x95009c16, 0xdbdfba4b };
        int[] H = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0};

        // Run
        String HMAC2 = sha1Impl.getHashDigest(stuff.getBytes(), newH, 1024);
        System.out.println(HMAC2);
    }
}
