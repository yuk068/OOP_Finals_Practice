package yukwork.algorithm.mysort;

public class Sorter {

    private MySort sortType;

    public MySort getSortType() {
        return sortType;
    }

    public void setSorter(MySort sortType) {
        this.sortType = sortType;
    }

    public void sort(int[] arr) {
        sortType.sort(arr);
    }

}
