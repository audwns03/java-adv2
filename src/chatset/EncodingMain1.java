package chatset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");


    public static void main(String[] args) {
        encoding("A", StandardCharsets.US_ASCII);
        encoding("A",StandardCharsets.UTF_16BE);
        encoding("강", StandardCharsets.UTF_16BE);
        encoding("강", StandardCharsets.UTF_8);
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n", text, charset, Arrays.toString(bytes), bytes.length);
    }
}
