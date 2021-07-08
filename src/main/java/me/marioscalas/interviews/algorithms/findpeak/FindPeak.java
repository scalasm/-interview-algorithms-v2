/*******************************************************************************
 * Copyright (c) 2020 Mario Scalas 
 * via F. De Pinedo, 1/a - http://www.marioscalas.me
 * All rights reserved. 
 *
 * Contributors:
 *     Mario Scalas - initial API and implementation
 *******************************************************************************/
package me.marioscalas.interviews.algorithms.findpeak;

/**
 * An array "a" contains a peak only if, for a given element at position "i", we have that a[i] >= a[i-1] and a[i] >= a[i+1].
 */
public class FindPeak {
    /**
     * Find any peak in the 1-dimensional array.
     * @param array the 1-D array
     * @return the position of the peak in the array or -1 if none was found
     */
    public static int findPeak1D(final int array[]) {
        // Empty array
        if (array == null || array.length == 0) {
            return -1;
        }
        // Single element array (trivial case)
        if (array.length == 1) {
            return 0;
        }

        return findPeak1D(array, 0, array.length - 1);
    }

    private static int findPeak1D(final int array[], int start, int end) {
        int n2 = (start + end) / 2;

        int peakPosition = -1;

        if (n2 > 0 && array[n2] < array[n2-1]) {
            peakPosition = findPeak1D(array,start, n2-1);
        } else if (n2 < array.length - 1 && array[n2] < array[n2+1]) {
            peakPosition = findPeak1D(array,n2+1, end);
        } else {
            peakPosition = n2;
        }

        return peakPosition;
    }
}
