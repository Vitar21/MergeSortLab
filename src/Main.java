import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        int cnt = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>(cnt);
        for (int i = 0; i < cnt; i++){
            numbers.add(scanner.nextInt());
        }

        Sorting<Integer> sorter = new MergeSort();
        sorter.sort(numbers);

        for ( int i = 0; i < numbers.size(); i++){
            builder.append(numbers.get(i));
            builder.append(i < (numbers.size() - 1) ? " " : "");
        }

        System.out.println(builder.toString());
    }
}