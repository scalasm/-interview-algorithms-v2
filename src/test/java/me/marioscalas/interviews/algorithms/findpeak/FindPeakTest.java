/*******************************************************************************
 * Copyright (c) 2021 Mario Scalas
 * via F. De Pinedo, 1/a - http://www.marioscalas.me
 * All rights reserved.
 *
 * Contributors:
 *     Mario Scalas - initial API and implementation
 *******************************************************************************/
package me.marioscalas.interviews.algorithms.findpeak;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindPeakTest {

    @Test
    void findPeak1D() {
        assertThat(FindPeak.findPeak1D(new int[] {1,2,3,0})).isEqualTo(2);
        assertThat(FindPeak.findPeak1D(new int[] {1,2})).isEqualTo(1);
        assertThat(FindPeak.findPeak1D(new int[] {2,1})).isEqualTo(0);
        assertThat(FindPeak.findPeak1D(new int[] {1,2,3,4})).isEqualTo(3);
        assertThat(FindPeak.findPeak1D(new int[] {4,3,2,1})).isEqualTo(0);
        assertThat(FindPeak.findPeak1D(new int[] {1})).isEqualTo(0);
        assertThat(FindPeak.findPeak1D(new int[] {})).isEqualTo(-1);
    }
}