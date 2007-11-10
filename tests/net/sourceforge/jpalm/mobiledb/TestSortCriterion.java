/*
 * $Id$
 * 
 * Copyright (c) 2006, Gunter Wambaugh
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of the author nor the names of its contributors may be
 *      used to endorse or promote products derived from this software without 
 *      specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.sourceforge.jpalm.mobiledb;

import junit.framework.TestCase;
import net.sourceforge.jpalm.mobiledb.SortCriterion;
import net.sourceforge.juint.Int8;

public class TestSortCriterion extends TestCase {
    private SortCriterion criterion;

    public TestSortCriterion() {
        byte[] data = new byte[SortCriterion.DATA_LENGH];
        data[0] = 0x04;
        data[1] = 0x01;
        criterion = new SortCriterion(data);
    }

    public void testIsDescending() {
        assertTrue(criterion.isDescending());
    }

    public void testGetFieldNumber() {
        assertEquals(new Int8(4), criterion.getFieldNumber());
    }

    public void testGetReserved() {
        assertEquals(2, criterion.getReserved().length);
    }
}
