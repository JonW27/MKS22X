public class Merge {
    
    public static void mergesort( int[] ary ) {
	if ( ary.length <= 1 ) {
	    return;
	}
	else {
	    int[] left = new int[ ary.length / 2 ];
	    fill( 0, ary.length/2, ary, left );
	    int[] right = new int[ ary.length / 2 ];
	    fill( ary.length/2, ary.length, ary, right );
	    
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
		
    }

    public static void merge( int[] a, int[] b, int[] dest ) {

	int i = 0, j = 0, count = 0;
	while ( i < a.length && j < b.length ) {
	    if ( a[i] < b[j] ) {
		dest[count] = a[i];
		i++;
	    }
	    else {
		dest[count] = b[j];
		j++;
	    }
	    count++;
	}

	while ( i < a.length ) {
	    dest[count] = a[i];
	    i++;
	    count++;
	}
	while ( j < b.length ) {
	    dest[count] = b[j];
	    j++;
	    count++;
	}

    }

    private static void fill( int start, int end, int[] ary, int[] dest ) {
	for ( int i = start, count = 0; i < end-start; i++,count++ ) {
	    dest[count] = ary[i];
	}
    }
	
}
