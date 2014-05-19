/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

package org.gjt.jclasslib.structures.attributes.targettype;

import org.gjt.jclasslib.structures.InvalidByteCodeException;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ExceptionTargetInfo extends TargetInfo {

    private int exceptionTableIndex;

    public int getExceptionTableIndex() {
        return exceptionTableIndex;
    }

    public void setExceptionTableIndex(int exceptionTableIndex) {
        this.exceptionTableIndex = exceptionTableIndex;
    }

    @Override
    public void read(DataInput in) throws InvalidByteCodeException, IOException {
        super.read(in);
        exceptionTableIndex = in.readUnsignedShort();
    }

    @Override
    public void write(DataOutput out) throws InvalidByteCodeException, IOException {
        super.write(out);
        out.writeShort(exceptionTableIndex);
    }

    @Override
    public int getLength() {
        return 2;
    }

    @Override
    public String getVerbose() {
        return "Exception table index: " + exceptionTableIndex;
    }
}
