import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class FormattedInput {

    public static Object[] scanff(String fmt) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading input from console using Scanner in Java ");
        System.out.println("Please enter your input:");
        String input = scanner.nextLine();
        System.out.println("User Input from console: " + input);
        return scanf(fmt, input);
    }

    public static Object[] scanf(String fmt, String str) {
        boolean flag = false;
        ArrayList ans = new ArrayList();
        int s = 0;
        int n = fmt.length();
        String[] strArray = null;
        final String[] substr = str.split(" ");
        for (int i = 0; i < n; i++) {
            char c = fmt.charAt(i);
            if (c == '%') {
                char t = fmt.charAt(++i);
                if (t == '%')
                    c = t;
                else {
                    if (accept(t, substr[s])) {
                        if (t == 'a')
                            ans.add(Arrays.toString(substr[s].substring(1,substr[s].length()-1).split(",")));
                        else if (t == 'd')
                            ans.add(Integer.parseInt(substr[s]));
                        else if (t == 'f')
                            ans.add(Double.parseDouble(substr[s]));
                        else if (t == 'c')
                            ans.add(substr[s].charAt(0));
                        else if (t == 's')
                            ans.add(substr[s]);
                        s++;
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (flag) {
            System.out.println("Please enter your input again: ");
            return scanff(fmt);
        }
        return ans.toArray();
    }

    private static boolean accept(char t, String sub) {
        boolean accept = false;
        if ((t == 'a') && (sub.charAt(0) == '{') && (sub.charAt(sub.length() - 1) == '}'))
            accept = true;
        else {
            for (char l : sub.toCharArray()) {
                if ((t == 'c') && (sub.length() == 1))
                    accept = true;
                else if ((t == 'd') && ("-0123456789.+Ee".indexOf(l) >= 0))
                    accept = true;
                else if ((t == 'f') && ("0123456789".indexOf(l) >= 0))
                    accept = true;
                else if (t == 's')
                    accept = true;
                else
                    accept = false;
                break;
            }
        }
        return accept;
    }
}

