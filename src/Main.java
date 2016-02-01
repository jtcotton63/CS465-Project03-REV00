/**
 * Created by josepher on 1/29/16.
 */
public class Main {

    public static void main(String[] args) {
        int[] newH = { 0xf4b645e8, 0x9faaec2f, 0xf8e443c5, 0x95009c16, 0xdbdfba4b };
        String HMAC2 = sha1Impl.getHashDigest("def".getBytes(), newH, 1024);
        System.out.println(HMAC2);
    }
}
