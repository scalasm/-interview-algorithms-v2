/*******************************************************************************
 * Copyright (c) 2020 Mario Scalas 
 * via F. De Pinedo, 1/a - http://www.marioscalas.me
 * All rights reserved. 
 *
 * Contributors:
 *     Mario Scalas - initial API and implementation
 *******************************************************************************/
package me.marioscalas.interviews.algorithms.findpeak;


import lombok.Data;
import lombok.Getter;

/**
 * Findind a peak in 1-dimensional and 2-dimensional arrays.
 *
 * For 1-dimensional arrays, complexity is O(lg2n)
 * For 2-dimnensional arrays, complexity is O(rows*lg2Columns)
 */
public class FindPeak {

    @Data(staticConstructor = "of")
    @Getter
    public static class Peak2D {
        private final int row;
        private final int column;
    }

    public static final int NO_PEAK = -1;
    public static final Peak2D NO_PEAK_2D = new Peak2D(-1, -1);

    /**
     * Find any peak in the 1-dimensional array. By definition, an array "a" contains a peak only if, for a given
     * element at position "i", we have that a[i] >= a[i-1] and a[i] >= a[i+1].
     *
     * @param array the 1-D array
     * @return the position of the peak in the array or -1 if none was found
     */
    public static int findPeak1D(final int[] array) {
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

    private static int findPeak1D(final int[] array, int start, int end) {
        int middle = (start + end) / 2;

        int peakPosition = NO_PEAK;
        if (middle > 0 && array[middle] < array[middle - 1]) {
            peakPosition = findPeak1D(array, start, middle - 1);
        } else if (middle < array.length - 1 && array[middle] < array[middle + 1]) {
            peakPosition = findPeak1D(array, middle + 1, end);
        } else {
            peakPosition = middle;
        }

        return peakPosition;
    }

    /**
     * In a matrix, there is a peak if and only if, given an element (i,j), the elements respectively on top, bottom,
     * left and right are all lesser or equal than (i,j).
     *
     * Note that this function will return the first peak that meets the criteria, not the highest peak!
     * @param matrix the input matrix
     * @return the position of the peak
     */
    public static Peak2D findPeak2D(int[][] matrix) {
        // Check for empty matrix
        if (matrix.length == 0) {
            return NO_PEAK_2D;
        }
        return findPeak2D(matrix, 0, matrix.length - 1);
    }

    private static Peak2D findPeak2D(final int[][] matrix, final int startRow, final int endRow) {
        final var middleRow = (startRow + endRow) / 2;

        final var maxValueCol = findPeak1D(matrix[middleRow]);

        Peak2D peak2D;
        if (middleRow > 0 && matrix[middleRow - 1][maxValueCol] > matrix[middleRow][maxValueCol]) {
            peak2D = findPeak2D(matrix, startRow, middleRow - 1);
        } else if (middleRow < matrix.length - 1 && matrix[middleRow + 1][maxValueCol] > matrix[middleRow][maxValueCol]) {
            peak2D = findPeak2D(matrix, startRow + 1, middleRow);
        } else {
            peak2D = Peak2D.of(middleRow, maxValueCol);
        }
        return peak2D;
    }
}
