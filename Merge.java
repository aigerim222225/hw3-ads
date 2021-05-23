import java.util.*;

public class Merge {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        MergeSort<String> m = new MergeSort();
        int n = input.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; ++i) {
            s[i] = input.next();
        }
        m.MergeSort(s);
        for (int i = 0; i < n; ++i) {
            System.out.println(s[i]);
        }
        input.close();
    }
}

class MergeSort<T extends Comparable<T>>{
    
    MergeSort() {}
    
	public void MergeSort(Object[] a) {
	    int n = a.length;
	    if (n <= 1) {
	        return;
	    }
	    int middle = n/2;
	    Object[] left = new Object[middle];
	    Object[] right = new Object[n-middle];
	    for (int i = 0; i < middle; ++i) {
	        left[i] = a[i];
	    }
	    for (int i = 0; i < n-middle; ++i) {
	        right[i] = a[i+middle];
	    }
	    MergeSort(left);
	    MergeSort(right);
	    merge(a, left, right);
	}
	
	public void merge(Object[] c, Object[] a, Object[] b) {
	    int n = c.length;
	    int ptr_a = 0, ptr_b = 0;
	    for (int i = 0; i < n; ++i) {
	        if (ptr_a == a.length) {
	            c[i] = (T) b[ptr_b];
	            ptr_b++;
	        } else if (ptr_b == b.length) {
	            c[i] = (T) a[ptr_a];
	            ptr_a++;
	        } else if (((T)a[ptr_a]).compareTo((T)b[ptr_b]) <= 0) { 
	            c[i] = (T) a[ptr_a];
	            ptr_a++;
	        } else { 
	            c[i] = (T) b[ptr_b];
	            ptr_b++;
	        }
	    }
	}
}
