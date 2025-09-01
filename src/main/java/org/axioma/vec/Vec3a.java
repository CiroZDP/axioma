package org.axioma.vec;

// TODO: javadoc
public final class Vec3a {

	public static final int X = 0, Y = 1, Z = 2;
	
	private Vec3a() {}

	
	
	public static final float[] set(final float[] dst, final float x, final float y, final float z) {
		dst[X] = x;
		dst[Y] = y;
		dst[Z] = z;
		return dst;
	}
	
	public static final float[] set(final float[] dst, final float[] src) {
		return set(dst, src[X], src[Y], src[Z]);
	}
	
	
	
	public static final float[] add(final float[] v, final float tx, final float ty, final float tz, final float[] dst) {
		dst[X] = v[X] + tx;
		dst[Y] = v[Y] + ty;
		dst[Z] = v[Z] + tz;
		return dst;
	}
	
	public static final float[] add(final float[] dst, final float tx, final float ty, final float tz) {
		return add(dst, tx, ty, tz, dst);
	}
	
	public static final float[] add(final float[] v, final float[] t, final float[] dst) {
		return add(v, t[X], t[Y], t[Z], dst);
	}
	
	public static final float[] add(final float[] dst, final float[] t) {
		return add(dst, t[X], t[Y], t[Z], dst);
		
	}

	
	
	public static final float[] sub(final float[] v, final float tx, final float ty, final float tz, final float[] dst) {
		return add(v, -tx, -ty, -tz, dst);
	}
	
	public static final float[] sub(final float[] dst, final float tx, final float ty, final float tz) {
		return sub(dst, tx, ty, tz, dst);
	}
	
	public static final float[] sub(final float[] v, final float[] t, final float[] dst) {
		return sub(v, t[X], t[Y], t[Z], dst);
	}
	
	public static final float[] sub(final float[] dst, final float[] t) {
		return sub(dst, t[X], t[Y], t[Z], dst);
	}
	
	
	
	public static final float[] scale(final float[] v, final float f, final float[] dst) {
		dst[X] = v[X] * f;
		dst[Y] = v[Y] * f;
		dst[Z] = v[Z] * f;
		return dst;
	}
	
	public static final float[] scale(final float[] dst, final float f) {
		return scale(dst, f, dst);
	}
	
	
	
	public static final float[] mul(final float[] v, final float sx, final float sy, final float sz, final float[] dst) {
		dst[X] = v[X] * sx;
		dst[Y] = v[Y] * sy;
		dst[Z] = v[Z] * sz;
		return dst;
	}
	
	public static final float[] mul(final float[] dst, final float sx, final float sy, final float sz) {
		return mul(dst, sx, sy, sz, dst);
	}
	
	public static final float[] mul(final float[] v, final float[] s, final float[] dst) {
		return mul(v, s[X], s[Y], s[Z], dst);
	}
	
	public static final float[] mul(final float[] dst, final float[] s) {
		return mul(dst, s[X], s[Y], s[Z], dst);
	}
	
}
