import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> numbers){
        if ( numbers == null || numbers.isEmpty()){
            return;
        }
        slice(numbers, 0, numbers.size() - 1);
    }

    private void merge(List<Integer> numbers, int start, int middle, int end){
        List<Integer> _thisList = new ArrayList<>(end - start + 1);

        int left = start, right = middle + 1;

        while (left <= middle && right <= end){
            if (numbers.get(left) <= numbers.get(right)){
                _thisList.add(numbers.get(left));
                left++;
            }
            else{
                _thisList.add(numbers.get(right));
                right++;
            }
        }

        while (left <= middle){
            _thisList.add(numbers.get(left));
            left++;
        }

        while (right <= end){
            _thisList.add(numbers.get(right));
            right++;
        }

        for ( int i = 0; i < _thisList.size(); i++){
            numbers.set(start + i, _thisList.get(i));
        }
    }

    private void slice(List<Integer> numbers, int start, int end){
        if (start >= end){
            return;
        }
        int middle = (end - start) / 2 + start;

        slice(numbers, start, middle);
        slice(numbers, middle+1, end);
        merge(numbers, start, middle, end);

    }
}
