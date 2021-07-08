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
    @MethodSource("provideForFindPeak1D")
    void findPeak1D(final int[] array, final int expectedPeakPosition) {
        assertThat(FindPeak.findPeak1D(array)).isEqualTo(expectedPeakPosition);
    }

    private static Stream<Arguments> provideForFindPeak1D() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,0}, 2),
                Arguments.of(new int[] {1,2}, 1),
                Arguments.of(new int[] {2,1}, 0),
                Arguments.of(new int[] {1,2,3,4}, 3),
                Arguments.of(new int[] {4,3,2,1}, 0),
                Arguments.of(new int[] {1}, 0),
                Arguments.of(new int[] {}, -1)
        );
    }

}