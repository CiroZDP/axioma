package org.lwml.vec;

import java.util.Arrays;

public final record Vec3(float[] c) {

	public static final int X = 0, Y = 1, Z = 2;
	
	public Vec3() {
		this(new float[3]);
	}
	
	public Vec3(float x, float y, float z) {
		this(new float[3]);
		this.set(x, y, z);
	}
	
	public final Vec3 set(final float x, final float y, final float z) {
		this.c[X] = x;
		this.c[Y] = y;
		this.c[Z] = z;
		return this;
	}
	
	public final Vec3 zero() {
		Arrays.fill(c, 0);
		return this;
	}
	
	public final float x() {
		return c[X];
	}
	
	public final float y() {
		return c[Y];
	}
	
	public final float z() {
		return c[Z];
	}
	
	public final Vec3 _x(final float x) {
		this.c[X] = x;
		return this;
	}
	
	public final Vec3 _y(final float y) {
		this.c[Y] = y;
		return this;
	}

	public final Vec3 _z(final float z) {
		this.c[Z] = z;
		return this;
	}
	
	
}
