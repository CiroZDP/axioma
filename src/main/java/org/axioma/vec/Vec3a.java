package org.axioma.vec;

// TODO: javadoc
public final class Vec3a {

	public static final int X = 0, Y = 1, Z = 2;
	
	private Vec3a() {}

	
	
	// TODO: javadoc
	public static final float[] set(final float[] dst, final float x, final float y, final float z) {
		dst[X] = x;
		dst[Y] = y;
		dst[Z] = z;
		return dst;
	}
	
	// TODO: javadoc
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
	
	
	
	// TODO: mul, scale,...
	
}
