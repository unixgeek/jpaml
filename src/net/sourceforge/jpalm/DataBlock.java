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
package net.sourceforge.jpalm;

/**
 * An abstract representation of a block of data in a file.
 */
public abstract class DataBlock {
    /**
     * Populate class properties from a <code>byte</code> array.
     * 
     * @param data
     *            the <code>byte</code> array
     */
    public abstract void deserialize(byte[] data);

    /**
     * Create a <code>byte</code> array of the class properties.
     * 
     * @return the <code>byte</code> array
     */
    public abstract byte[] serialize();

    /**
     * Gets the string representation of this class as a hexadecimal string.
     * 
     * @return a hexadecimal representation of this class
     */
    @Override
    public String toString() {
        return Utilities.byteArrayToHexString(serialize());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DataBlock))
            return false;

        byte[] thisBytes = serialize();
        byte[] objectBytes = ((DataBlock) object).serialize();
        return Utilities.isEqual(thisBytes, objectBytes);
    }
}
