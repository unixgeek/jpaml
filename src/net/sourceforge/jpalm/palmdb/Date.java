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
package net.sourceforge.jpalm.palmdb;

import net.sourceforge.juint.UInt32;

/**
 * A date in a Palm database.
 */
public class Date {
    /**
     * The Palm's epoch (January 1, 1904) relative to Java's epoch (January 1, 1970) in
     * milliseconds.<br>
     * {@value}
     */
    public static final long PALM_EPOCH_MILLISECONDS = -2082844800000L;
    private UInt32 seconds;

    /**
     * Creates a new date from the number of seconds since the Palm epoch.
     * 
     * @param seconds
     *            the number of seconds since the Palm epoch
     */
    public Date(UInt32 seconds) {
        this.seconds = seconds;
    }

    /**
     * Creates a new date from a java date.
     * 
     * @param date
     *            a date
     */
    public Date(java.util.Date date) {
        this.seconds = convertDate(date);
    }

    /**
     * Creates a new date from the current date.
     */
    public Date() {
        this(new java.util.Date());
    }

    /**
     * Gets the of seconds since the Palm epoch.
     * 
     * @return the number of seconds since the Palm epoch
     */
    public UInt32 getSeconds() {
        return seconds;
    }

    /**
     * Gets the java date representation of this date.
     * 
     * @return the java date
     */
    public java.util.Date getDate() {
        return convertDate(seconds);
    }

    private UInt32 convertDate(java.util.Date date) {
        return new UInt32((date.getTime() - PALM_EPOCH_MILLISECONDS) / 1000L);
    }

    private java.util.Date convertDate(UInt32 seconds) {
        return new java.util.Date((seconds.uint32Value() * 1000L) + PALM_EPOCH_MILLISECONDS);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Date))
            return false;

        return getSeconds().equals(((Date) object).getSeconds());
    }
}
