package chatset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain2 {

    private static final Charset EUC_KR =  Charset.forName("EUC-KR");
    private static final Charset MS_949 =  Charset.forName("MS949");

    public static void main(String[] args) {
        test("A", StandardCharsets.US_ASCII, StandardCharsets.US_ASCII);
        test("A", StandardCharsets.US_ASCII, EUC_KR);
        test("A", StandardCharsets.US_ASCII, MS_949);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_8);
        test("A", StandardCharsets.US_ASCII, StandardCharsets.UTF_16BE);
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);

        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text, encodingCharset, Arrays.toString(encoded), encoded.length, decodingCharset, decoded);
    }
}
