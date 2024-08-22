import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompressString {

    private static String compressString(String input) throws IOException {

        char last = ' ';
        int count = 0;
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i <= input.length(); i++) {

            if (i == input.length()) {
                newStr.append(count);
                break;
            }

            if (input.charAt(i) == last) {
                count++;
            } else {
                if (count != 0) {
                    newStr.append(count);
                }

                newStr.append(input.charAt(i));
                last = input.charAt(i);
                count = 1;
            }
        }
        String compressed = new String(newStr);

        if (input.length() <= compressed.length()) {
            return input;
        }

        return compressed;
    }

    private char[] compressStringWithArray(char[] chars) {

        if (chars.length == 1) {
            return chars;
        }
        // char[] compressed = new char[chars.length];
        StringBuilder sb = new StringBuilder();

        char x = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == x) {
                count++;
            } else {
                sb.append(x);
                if (count != 0) {
                    sb.append(count);
                }
                x = chars[i];
                count = 1;
            }
            System.out.println("compressed so far " + sb.toString());
        }
        sb.append(x);
        sb.append(count);
        String n = new String(sb);
        char[] compArray = n.toCharArray();
        chars = compArray;
        System.out.println("compressed at end " + new String(chars) + " " + new String(compArray));

        return chars;
    }

    public static void main(String[] args) throws IOException {
        /*
         * InputStreamReader irs = new InputStreamReader(System.in);
         * BufferedReader br = new BufferedReader(irs);
         * 
         * System.out.println("Enter string:");
         * System.out.println(compressString(br.readLine()));
         */

        CompressString cs = new CompressString();
        char[] x = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(new String(cs.compressStringWithArray(x)));

    }

}
