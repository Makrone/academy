package by.academy.homework.homework4.task2;

import java.util.Arrays;

public class TArrClass<T> {

	public static final int DEFAULT_ARR_SIZE = 2;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	T[] arr;
	int objectCounter;

	@SuppressWarnings("unchecked")
	public TArrClass() {
		this.arr = (T[]) new Object[16];

	}

	@SuppressWarnings("unchecked")
	public TArrClass(int capasity) {
		if (capasity > 0) {
			this.arr = (T[]) new Object[capasity];
		} else if (capasity == 0) {
			this.arr = (T[]) EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + capasity);
		}
	}

	@SuppressWarnings("unchecked")
	public void add(T Object) {
		if (arr == null) {
			arr = (T[]) new Object[DEFAULT_ARR_SIZE];
		} else {
			if (objectCounter + 1 > arr.length) {
				T[] tempArray = Arrays.copyOf(arr, arr.length * 2 + 1);
				arr = tempArray;
			}
		}
		arr[objectCounter++] = Object;
	}

	public T[] getArr() {
		return (T[]) arr;
	}

	public T get(int index) {
		return (T) arr[index];
	}

	public T getLast() {
		return (T) arr[arr.length - 1];
	}

	public T getFirst() {
		return (T) arr[0];
	}

	public int getLength() {
		return arr.length;
	}

	public T getLastObject() {
		return (T) arr[objectCounter - 1];
	}

	public int getLastObjectIndex() {
		return objectCounter - 1;
	}

	public void remove(int index) {
		if (index > arr.length || index < 0) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		} else if (objectCounter != index) {
			System.arraycopy(arr, index + 1, arr, index, arr.length - index - objectCounter);
			System.out.println(Arrays.toString(arr));
			System.out.println(getLastObjectIndex());
			System.out.println(getLastObject());
			System.out.println();
		}
		arr[objectCounter] = null;
		objectCounter--;
	}

	public void remove(T obj) {
		for (int i = 0; i < arr.length; i++) {
			if (obj.equals(arr[i])) {
				remove(i);
				i--;
			}
		}
	}

}
