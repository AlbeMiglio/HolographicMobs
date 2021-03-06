/*
 * Copyright (c) 2020, Wild Adventure
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 * 4. Redistribution of this software in source or binary forms shall be free
 *    of all charges or fees to the recipient of this software.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gmail.filoghost.holographicmobs.nms.v1_8_R3;

import net.minecraft.server.v1_8_R3.AxisAlignedBB;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.MovingObjectPosition;
import net.minecraft.server.v1_8_R3.Vec3D;

public class NullBoundingBox extends AxisAlignedBB {

	public NullBoundingBox() {
		super(0, 0, 0, 0, 0, 0);
	}

	@Override
	public double a() {
		return 0.0;
	}

	@Override
	public double a(AxisAlignedBB arg0, double arg1) {
		return 0.0;
	}

	@Override
	public AxisAlignedBB a(AxisAlignedBB arg0) {
		return this;
	}

	@Override
	public AxisAlignedBB a(double arg0, double arg1, double arg2) {
		return this;
	}

	@Override
	public MovingObjectPosition a(Vec3D arg0, Vec3D arg1) {
		return super.a(arg0, arg1);
	}

	@Override
	public boolean a(Vec3D arg0) {
		return false;
	}

	@Override
	public double b(AxisAlignedBB arg0, double arg1) {
		return 0.0;
	}

	@Override
	public boolean b(AxisAlignedBB arg0) {
		return false;
	}

	@Override
	public double c(AxisAlignedBB arg0, double arg1) {
		return 0.0;
	}

	@Override
	public AxisAlignedBB c(double arg0, double arg1, double arg2) {
		return this;
	}

	@Override
	public AxisAlignedBB grow(double arg0, double arg1, double arg2) {
		return this;
	}

	public AxisAlignedBB shrink(double arg0) {
		return this;
	}

	public AxisAlignedBB a(BlockPosition arg0) {
		return this;
	}

	public static AxisAlignedBB a(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) {
		return AxisAlignedBB.a(arg0, arg1, arg2, arg3, arg4, arg5);
	}


	public boolean b(Vec3D arg0) {
		return false;
	}

	public boolean c(Vec3D arg0) {
		return false;
	}

	public boolean d(Vec3D arg0) {
		return false;
	}

	public AxisAlignedBB e(double arg0) {
		return this;
	}

	public AxisAlignedBB g(double arg0) {
		return this;
	}

	

}
