/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

/*
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public
 License as published by the Free Software Foundation; either
 version 2 of the license, or (at your option) any later version.
 */

package org.gjt.jclasslib.structures.attributes

import org.gjt.jclasslib.structures.AttributeInfo
import org.gjt.jclasslib.structures.ClassFile
import java.io.DataInput
import java.io.DataOutput

/**
 * Describes a ModuleTarget attribute structure.
 */
class ModuleTargetAttribute(classFile: ClassFile) : AttributeInfo(classFile) {

    /**
     * Constant pool index of the CONSTANT_Utf8_info structure containing the OS name.
     */
    var osNameIndex: Int = 0
    /**
     * Constant pool index of the CONSTANT_Utf8_info structure containing the OS architecture.
     */
    var osArchIndex: Int = 0

    override fun readData(input: DataInput) {
        osNameIndex = input.readUnsignedShort()
        osArchIndex = input.readUnsignedShort()
    }

    override fun writeData(output: DataOutput) {
        output.writeShort(osNameIndex)
        output.writeShort(osArchIndex)
    }

    override fun getAttributeLength(): Int =  4

    override val debugInfo: String
        get() = ""

    companion object {
        /**
         * Name of the attribute as in the corresponding constant pool entry.
         */
        val ATTRIBUTE_NAME = "ModuleTarget"
    }
}