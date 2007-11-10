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
package net.sourceforge.jpalm.mobiledb.field.definition;

import junit.framework.TestCase;
import net.sourceforge.jpalm.Utilities;
import net.sourceforge.jpalm.mobiledb.field.definition.CheckboxDefinition;

public class TestCheckboxDefinition extends TestCase {
    public void testCheckbox() {
        CheckboxDefinition checkboxDefinition = new CheckboxDefinition();
        assertFalse(checkboxDefinition.isDefaultToTrue());
        assertEquals("B", checkboxDefinition.getIndicator());
    }

    public void testCheckboxString() {
        CheckboxDefinition checkboxDefinition = new CheckboxDefinition("B!");
        assertTrue(checkboxDefinition.isDefaultToTrue());
        assertEquals("B!", checkboxDefinition.getIndicator());
    }

    public void testGetIndicator() {
        CheckboxDefinition checkboxDefinition = new CheckboxDefinition("B!");
        checkboxDefinition.setDefaultToTrue(false);
        assertEquals("B", checkboxDefinition.getIndicator());
    }

    public void testGetRegex() {
        String regex = new CheckboxDefinition().getRegex();

        assertTrue("1", Utilities.isMatch("B", regex));
        assertTrue("2", Utilities.isMatch("B!", regex));
        assertFalse("3", Utilities.isMatch(" B! ", regex));
        assertFalse("4", Utilities.isMatch("b!", regex));
        assertFalse("5", Utilities.isMatch("Booyah", regex));
    }
}
