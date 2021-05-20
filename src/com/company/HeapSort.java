package com.company;

class HeapSort{

	private int len;
	private int[] heap;
	private int temp;
	public void setHeap(int[] heap) {
		this.heap=heap;
		this.len=heap.length;
	}
	
	public void print() {
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println();
	}
	
	public int[] ascOrder() {
		while(len>=2) {
			for(int i=(len/2-1);i>=0 && i<len;i--) {
				ascNode(i);
			}
			heap[0]=heap[len-1];
			heap[len-1]=temp;
			len--;	
			print();
		}
		return heap;
	}
	public void ascNode(int n) {
		temp=heap[n];
		if((2*n+1)<len && temp<heap[2*n+1]) {
			heap[n]=heap[2*n+1];
			heap[2*n+1]=temp;
			temp=heap[n];
		}
		if((2*n+2)<len && temp<heap[2*n+2]) {
			heap[n]=heap[2*n+2];
			heap[2*n+2]=temp;
			temp=heap[n];
		}
	}
	public int[] desOrder() {
		while(len>=2) {
			for(int i=(len/2-1);i>=0 && i<len;i--) {
				desNode(i);
			}
			heap[0]=heap[len-1];
			heap[len-1]=temp;
			len--;	
		}
		return heap;
	}
	public void desNode(int n) {
		temp=heap[n];
		if((2*n+1)<len && temp>heap[2*n+1]) {
			heap[n]=heap[2*n+1];
			heap[2*n+1]=temp;
			temp=heap[n];
		}
		if((2*n+2)<len && temp>heap[2*n+2]) {
			heap[n]=heap[2*n+2];
			heap[2*n+2]=temp;
			temp=heap[n];
		}
	}
}