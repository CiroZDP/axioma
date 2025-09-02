package org.lwml.vec;

import java.nio.*;
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

	public final Vec3 x(final float x) {
		this.c[X] = x;
		return this;
	}

	public final Vec3 y(final float y) {
		this.c[Y] = y;
		return this;
	}

	public final Vec3 z(final float z) {
		this.c[Z] = z;
		return this;
	}

	public final Vec3 add(final float tx, final float ty, final float tz, final Vec3 dst) {
		dst.c[X] = c[X] + tx;
		dst.c[Y] = c[Y] + ty;
		dst.c[Z] = c[Z] + tz;
		return dst;
	}

	public final Vec3 add(final float tx, final float ty, final float tz) {
		return add(tx, ty, tz, this);
	}

	public final Vec3 add(final Vec3 t, final Vec3 dst) {
		return add(t.x(), t.y(), t.z(), dst);
	}

	public final Vec3 add(final Vec3 t) {
		return add(t.x(), t.y(), t.z(), this);
	}

	public final FloatBuffer toBuffer() {
		final FloatBuffer buf = ByteBuffer.allocateDirect(12)
				.order(ByteOrder.nativeOrder())
				.asFloatBuffer()
				.limit(3);
		buf.put(c).rewind();
		return buf;
	}

	@Override
	public String toString() {
		return "(" + x() + ", " + y() + ", " + z() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Vec3 v && Arrays.equals(this.c, v.c);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(c);
	}

}
