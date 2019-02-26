package com.xiaowei;

import java.util.Arrays;

public class HeapSort {

	//1、建立一个大（小）顶堆，可用数组表示
	//2、根和最后一个元素兑换，size-1，重新建立堆
	//3、重复以上过程直到全部遍历
	public void sortAsc(int[] arr){
		int n = arr.length;

		// 1、从下往上(尾节点的父节点开始)，倒着遍历整理整个树
		for (int i=n/2-1; i>=0; i--) {
			heapifyMax(arr, n, i);
		}

		// 2、排序，根和最后一个元素兑换，size-1，重新建立堆
		for (int i=n-1; i>=0; i--) {
			int swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;

			//交换完成，再梳理一下减1后的全堆
			heapifyMax(arr, i, 0);
		}
	}


	public void sortDesc(int[] arr){
		int n = arr.length;

		// 1、从下往上(尾节点的父节点开始)，倒着遍历整理整个树
		for (int i=n/2-1; i>=0; i--) {
			heapifyMin(arr, n, i);
		}

		// 2、排序，根和最后一个元素兑换，size-1，重新建立堆
		for (int i=n-1; i>=0; i--) {
			int swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;

			//交换完成，再梳理一下减1后的全堆
			heapifyMin(arr, i, 0);
		}
	}

	private void heapifyMin(int[] arr, int n, int i) {
		int smallest = i;
		int l = i*2+1;
		int r = i*2+2;

		// 左节点是否小于root
		if (l < n && arr[l] < arr[smallest]) {
			smallest = l;
		}

		// 再看右节点是否小于当前的largest
		if (r < n && arr[r] < arr[smallest]) {
			smallest = r;
		}

		// 根不是最小，就交换，并递归整理被替换的子树
		if (smallest != i) {
			int swap = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = swap;

			//递归整理子树
			heapifyMin(arr, n, smallest);
		}
	}

	private void heapifyMax(int[] arr, int n, int i) {
		int largest = i;
		int l = i*2+1;
		int r = i*2+2;

		// 左节点是否大于root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// 再看右节点是否大于当前的largest
		if (r<n && arr[r] > arr[largest]) {
			largest = r;
		}

		// 根不是最大，就交换，并递归整理被替换的子树
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			//递归整理子树
			heapifyMax(arr, n, largest);
		}
	}

    public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();

		int[] test = {3,4,2,5,17,41,35,5};
    	heapSort.sortDesc(test);
		System.out.println(Arrays.toString(test));
    }
}
