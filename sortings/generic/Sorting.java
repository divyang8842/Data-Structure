package sortings.generic;

public interface Sorting<T extends Comparable<T>> {
	public T[] doSort(T[] dataArry);
}
