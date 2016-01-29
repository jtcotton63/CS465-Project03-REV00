/**
 * Created by josepher on 1/29/16.
 */
public class Main {

    public static void main(String[] args) {
        String result = sha1Impl.digestIt("abc".getBytes());
        String expected = "a9993e364706816aba3e25717850c26c9cd0d89d";
        System.out.println();
    }
}
