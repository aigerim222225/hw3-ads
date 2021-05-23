import java.util.Scanner;
import java.util.ArrayList;

public class Quick {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		QuickSort<String> q = new QuickSort<String>();
		int n = input.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; ++i) {
		    a[i] = input.next();
		}
		q.quickSort(a, n);
		for (int i = 0; i < n; ++i) {
		    System.out.println(a[i]);
		}
		input.close();
	}
}


class QuickSort<T extends Comparable<T>> {	
    QuickSort() {}
    
	public void quickSort(Object[] a, int n) {
	    if (n <= 1) {
	        return;
	    }
	    T pivot = (T) a[0];
	    
	    Object[] left = new Object[n];
	    Object[] middle = new Object[n];
	    Object[] right = new Object[n];
	    
	    int sz_left = 0;
	    int sz_middle = 0;
	    int sz_right = 0;
	    
	    for (int i = 0; i < n; ++i) {
	        T ai = (T) a[i];
	        if (ai.compareTo(pivot) < 0.0) {
	            left[sz_left++] = ai;
	        } else if (ai.compareTo(pivot) > 0.0) {
	            right[sz_right++] = ai;
	        } else {
	            middle[sz_middle++] = ai;
	        }
	    }
	    
	    quickSort(left, sz_left);
	    quickSort(right, sz_right);
	    
	    for (int i = 0; i < sz_left; ++i) {
	        a[i] = left[i];
	    }
	    
	    for (int i = 0; i < sz_middle; ++i) {
	        a[i+sz_left] = middle[i];
	    }
	    
	    for (int i = 0; i < sz_right; ++i) {
	        a[i+sz_left+sz_middle] = right[i];
	    }
	    
	}
}
