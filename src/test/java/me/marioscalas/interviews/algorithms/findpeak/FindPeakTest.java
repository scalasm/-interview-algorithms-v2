/*******************************************************************************
 * Copyright (c) 2021 Mario Scalas
 * via F. De Pinedo, 1/a - http://www.marioscalas.me
 * All rights reserved.
 *
 * Contributors:
 *     Mario Scalas - initial API and implementation
 *******************************************************************************/
package me.marioscalas.interviews.algorithms.findpeak;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindPeakTest {

    @ParameterizedTest
    @MethodSource("testDataForFindPeak1D")
    void findPeak1D(final int[] array, final int expectedPeakPosition) {
        assertThat(FindPeak.findPeak1D(array)).isEqualTo(expectedPeakPosition);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> testDataForFindPeak1D() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0}, 2),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{2, 1}, 0),
                Arguments.of(new int[]{1, 2, 3, 4}, 3),
                Arguments.of(new int[]{4, 3, 2, 1}, 0),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{}, FindPeak.NO_PEAK)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataForFindPeak2D")
    void findPeak2D(final int[][] matrix, final FindPeak.Peak2D expectedPeakPosition, final int expectedPeakValue) {
        final var peak2D = FindPeak.findPeak2D(matrix);
        assertThat(peak2D).isEqualTo(expectedPeakPosition);

        if (expectedPeakPosition != FindPeak.NO_PEAK_2D) {
            assertThat(matrix[peak2D.getRow()][peak2D.getColumn()]).isEqualTo(expectedPeakValue);
        }
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> testDataForFindPeak2D() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3, 0},
                        {2, 3, 2, 0},
                        {1, 4, 7, 1},
                        {1, 5, 3, 0},
                }, FindPeak.Peak2D.of(2, 2), 7),
                Arguments.of(new int[][]{
                }, FindPeak.NO_PEAK_2D, -1),
                Arguments.of(new int[][]{
                        {1},
                }, FindPeak.Peak2D.of(0, 0), 1),
                Arguments.of(new int[][]{
                        {1, 2, 3, 0},
                }, FindPeak.Peak2D.of(0, 2), 3),
                Arguments.of(new int[][]{
                        {1},
                        {2},
                        {5},
                        {1},
                }, FindPeak.Peak2D.of(2, 0), 5),
                Arguments.of(new int[][]{
                        {1, 2, 3, 0},
                        {2, 8, 2, 0},
                        {1, 4, 2, 1},
                        {1, 5, 1, 0},
                }, FindPeak.Peak2D.of(1, 1), 8),
                Arguments.of(new int[][]{
                        {1, 2, 9, 0},
                        {1, 1, 2, 0},
                        {1, 4, 2, 1},
                        {1, 5, 1, 0},
                }, FindPeak.Peak2D.of(0, 2), 9)
            );
    }
}