package org.lwml.vec;

import static org.lwml.FloatMath.*;

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
	
	public final Vec3 negate(final Vec3 dest) {
		dest.c[X] = -c[X];
		dest.c[Y] = -c[Y];
		dest.c[Z] = -c[Z];
		return dest;
	}
	
	public final Vec3 negate() {
		return negate(this);
	}

	public final Vec3 add(final float tx, final float ty, final float tz, final Vec3 dest) {
		dest.c[X] = c[X] + tx;
		dest.c[Y] = c[Y] + ty;
		dest.c[Z] = c[Z] + tz;
		return dest;
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

	public final Vec3 sub(final float tx, final float ty, final float tz, final Vec3 dest) {
		dest.c[X] = c[X] - tx;
		dest.c[Y] = c[Y] - ty;
		dest.c[Z] = c[Z] - tz;
		return dest;
	}

	public final Vec3 sub(final float tx, final float ty, final float tz) {
		return add(tx, ty, tz, this);
	}

	public final Vec3 sub(final Vec3 t, final Vec3 dst) {
		return add(t.x(), t.y(), t.z(), dst);
	}

	public final Vec3 sub(final Vec3 t) {
		return add(t.x(), t.y(), t.z(), this);
	}
	
	public final Vec3 scale(final float s, final Vec3 dest) {
		dest.c[X] = s * c[X];
		dest.c[Y] = s * c[Y];
		dest.c[Z] = s * c[Z];
		return dest;
	}
	
	public final Vec3 scale(final float s) {
		return scale(s, this);
	}
	
	public final Vec3 mul(final float sx, final float sy, final float sz, final Vec3 dest) {
		dest.c[X] = c[X] * sx;
		dest.c[Y] = c[Y] * sy;
		dest.c[Z] = c[Z] * sz;
		return dest;
	}
	
	public final Vec3 mul(final float sx, final float sy, final float sz) {
		return mul(sx, sy, sz, this);
	}
	
	public final Vec3 mul(final Vec3 scale, final Vec3 dest) {
		return mul(scale.c[X], scale.c[Y], scale.c[Z], dest);
	}
	
	public final Vec3 mul(final Vec3 scale) {
		return mul(scale.c[X], scale.c[Y], scale.c[Z], this);
	}
	
	public final Vec3 div(final float nsx, final float nsy, final float nsz, final Vec3 dest) {
		dest.c[X] = c[X] / nsx;
		dest.c[Y] = c[Y] / nsy;
		dest.c[Z] = c[Z] / nsz;
		return dest;
	}
	
	public final Vec3 div(final float nsx, final float nsy, final float nsz) {
		return div(nsx, nsy, nsz, this);
	}
	
	public final Vec3 div(final Vec3 ns, final Vec3 dest) {
		return div(ns.c[X], ns.c[Y], ns.c[Z], dest);
	}
	
	public final Vec3 div(final Vec3 ns) {
		return div(ns.c[X], ns.c[Y], ns.c[Z], this);
	}
	
	public final float lengthSquared() {
		return fma(X, X, fma(Y, Y, Z * Z));
	}
	
	public final float length() {
		return sqrt(lengthSquared());
	}
	
	public final float invLength() {
		return invsqrt(lengthSquared());
	}

	public final FloatBuffer toBuffer() {
		final FloatBuffer buf = ByteBuffer.allocateDirect(12)
				.order(ByteOrder.nativeOrder())
				.asFloatBuffer()
				.limit(3);
		return buf.put(c).rewind();
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
