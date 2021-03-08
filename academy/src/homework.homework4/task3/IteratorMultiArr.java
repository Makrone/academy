package by.academy.homework.homework4.task3;

import java.util.Iterator;

public class IteratorMultiArr<T> implements Iterator<T> {

	private T[][] array;
	private int cursorI = 0;
	private int cursorJ = 0;

	public IteratorMultiArr(T[][] array) {
		super();
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		if (array == null) {
			return false;
		}
		return cursorI < array.length && cursorJ < array[cursorI].length;
	}

	@Override
	public T next() {
		T r = array[cursorI][cursorJ++];
		if (cursorJ >= array[cursorI].length) {
			cursorI++;
			cursorJ = 0;
		}
		return r;
	}
}
