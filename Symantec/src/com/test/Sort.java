package com.test;

interface Sortable {
	void sort(Object[] arr);
}

class MergeSort implements Sortable {
	@Override
	public void sort(Object[] arr) {

	}
}

class QuickSort implements Sortable {
	@Override
	public void sort(Object[] arr) {

	}
}

public class Sort {

	Object[] sort(Object[] arr) {
		Sortable sortable = getSortableImpl(arr);
		sortable.sort(arr);

		return arr;
	}

	public Sortable getSortableImpl(Object[] arr) {
		int code = getSortableType(arr);
		switch (code) {
		case 1: {
			new MergeSort();
			break;
		}
		case 2: {
			new QuickSort();
			break;
		}
		default: {
			break;
		}

		}
		return null;
	}

	private int getSortableType(Object[] arr) {
		// TODO Auto-generated method stub
		return 0;
	}

}
