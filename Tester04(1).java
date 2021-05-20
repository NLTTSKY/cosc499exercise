package exam;

import java.util.Arrays;

public class Tester04 {
	
	public static void main(String[] args) {
		
//		int[] arry = {5,6,2,3,9,7,1};
		int[] arry = {12,2,16,30,8,28,4,10,20,6,18};
		HeapSort heap = new HeapSort();
		heap.setHeap(arry);
		System.out.println(Arrays.toString(heap.ascOrder()));
		int[] arry1 = {8,4,6,32,54,2,51};
		heap.setHeap(arry1);
		System.out.println(Arrays.toString(heap.desOrder()));
		
		System.out.println(Math.sqrt(784));
		System.out.println();
		
		int N = 5;
		int V = 36;
		int [] v = new int [N+1];
		int [] w = new int [N+1];
		v[0] = 45;
		v[1] = 28;
		v[2] = 91;
		v[3] = 20;
		v[4] = 10;
		
		w[0] = 15;
		w[1] = 10;
		w[2] = 30;
		w[3] = 8;
		w[4] = 7;
		
		int val[] = new int[] { 45, 28, 91, 20, 10 }; 
        int wt[] = new int[] { 15, 10, 30, 8, 7 }; 
        int W = 36; 
        int n = val.length; 
        System.out.println(Knapsack.knapSack(W, wt, val, n)); 
	}
	
}

class Knapsack { 
	  
    // A utility function that returns 
    // maximum of two integers 
    static int max(int a, int b)  
    {  
      return (a > b) ? a : b;  
    } 
  
    // Returns the maximum value that 
    // can be put in a knapsack of 
    // capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // Base Case 
        if (n == 0 || W == 0) 
            return 0; 
  
        // If weight of the nth item is 
        // more than Knapsack capacity W, 
        // then this item cannot be included 
        // in the optimal solution 
        if (wt[n - 1] > W) 
            return knapSack(W, wt, val, n - 1); 
  
        // Return the maximum of two cases: 
        // (1) nth item included 
        // (2) not included 
        else
            return max(val[n - 1] 
                       + knapSack(W - wt[n - 1], wt, 
                                  val, n - 1), 
                       knapSack(W, wt, val, n - 1)); 
    } 
  
     
} 

class HeapSort{
	/**
	 * @len 记录每次循环后，下次数组长度
	 * @heap 接受堆排序的数组
	 * @temp 用于交换元素位置时的辅助指针
	 */
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
	
	public int[] ascOrder() {//大顶推完成数组升序排序
		while(len>=2) {
			//第一轮
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
	public void ascNode(int n) {//非页子节点的比较和交换过程
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
	public int[] desOrder() {//小顶堆完成数组降序排序
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