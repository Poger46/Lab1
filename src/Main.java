import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //  FormattedInput input1 = new FormattedInput();
        //   System.out.println(Arrays.toString(input1.scanf("%d %s %c %f %a", "10 ven c 10.555 {1,2,3,4}")));

        //   FormattedInput input2 = new FormattedInput();
        //     System.out.println(Arrays.toString(input2.scanff("%d %s %c %f")));

        EncodingConverter ec = new EncodingConverter();
        ec.EConverter("C:\\Users\\Poger46\\untitled7\\src\\input.txt","C:\\Users\\Poger46\\untitled7\\src\\output.txt", "utf8","utf16" );
    }

}
