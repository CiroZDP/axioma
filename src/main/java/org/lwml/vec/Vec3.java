package org.lwml.vec;

import java.util.Arrays;

public final record Vec3(float[] c) {

	public static final int X = 0, Y = 1, Z = 2;
	
	public Vec3() {
		this(new float[3]);
	}
	
	public Vec3(final float x, final float y, final float z) {
		this(new float[3]);
		this.set(x, y, z);
	}
	
	public final Vec3 set(final float x, final float y, final float z) {
		this.c[X] = x;
		this.c[Y] = y;
		this.c[Z] = z;
		return this;
	}
	
	public final Vec3 set(final Vec3 other) {
		System.arraycopy(other.c, 0, this.c, 0, 3);
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
	
	public final Vec3 translate(final float tx, final float ty, final float tz, final Vec3 dst) {
		dst._x(x() + tx);
		dst._y(y() + ty);
		dst._z(z() + tz);
		return dst;
	}
	
	public final Vec3 translate(final float tx, final float ty, final float tz) {
		return translate(tx, ty, tz, this);
	}
	
	public final Vec3 translate(final Vec3 t, final Vec3 dst) {
		return translate(t.x(), t.y(), t.z(), dst);
	}
	
	public final Vec3 translate(final Vec3 t) {
		return translate(t.x(), t.y(), t.z(), this);
	}
	
	public String toString() {
		return Arrays.toString(c);
	}
	
}
