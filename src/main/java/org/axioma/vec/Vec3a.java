package org.axioma.vec;

import static org.axioma.FloatMath.*;

// TODO: javadoc
public final class Vec3a {

	public static final int X = 0, Y = 1, Z = 2;
	
	private Vec3a() {}

	public static final float[] create() {
		return new float[3];
	}
	
	public static final float[] wrap(final float x, final float y, final float z) {
		return Vec3a.set(Vec3a.create(), x, y, z);
	}
	
	
	
	public static final float[] set(final float[] dst, final float x, final float y, final float z) {
		dst[X] = x;
		dst[Y] = y;
		dst[Z] = z;
		return dst;
	}
	
	public static final float[] set(final float[] dst, final float[] src) {
		return Vec3a.set(dst, src[X], src[Y], src[Z]);
	}
	
	
	
	public static final float[] add(final float[] v, final float tx, final float ty, final float tz, final float[] dst) {
		dst[X] = v[X] + tx;
		dst[Y] = v[Y] + ty;
		dst[Z] = v[Z] + tz;
		return dst;
	}
	
	public static final float[] add(final float[] dst, final float tx, final float ty, final float tz) {
		return Vec3a.add(dst, tx, ty, tz, dst);
	}
	
	public static final float[] add(final float[] v, final float[] t, final float[] dst) {
		return Vec3a.add(v, t[X], t[Y], t[Z], dst);
	}
	
	public static final float[] add(final float[] dst, final float[] t) {
		return Vec3a.add(dst, t[X], t[Y], t[Z], dst);
		
	}

	
	
	public static final float[] sub(final float[] v, final float tx, final float ty, final float tz, final float[] dst) {
		return Vec3a.add(v, -tx, -ty, -tz, dst);
	}
	
	public static final float[] sub(final float[] dst, final float tx, final float ty, final float tz) {
		return Vec3a.sub(dst, tx, ty, tz, dst);
	}
	
	public static final float[] sub(final float[] v, final float[] t, final float[] dst) {
		return Vec3a.sub(v, t[X], t[Y], t[Z], dst);
	}
	
	public static final float[] sub(final float[] dst, final float[] t) {
		return Vec3a.sub(dst, t[X], t[Y], t[Z], dst);
	}
	
	
	
	public static final float[] scale(final float[] v, final float f, final float[] dst) {
		dst[X] = v[X] * f;
		dst[Y] = v[Y] * f;
		dst[Z] = v[Z] * f;
		return dst;
	}
	
	public static final float[] scale(final float[] dst, final float f) {
		return Vec3a.scale(dst, f, dst);
	}
	
	
	
	public static final float[] mul(final float[] v, final float sx, final float sy, final float sz, final float[] dst) {
		dst[X] = v[X] * sx;
		dst[Y] = v[Y] * sy;
		dst[Z] = v[Z] * sz;
		return dst;
	}
	
	public static final float[] mul(final float[] dst, final float sx, final float sy, final float sz) {
		return Vec3a.mul(dst, sx, sy, sz, dst);
	}
	
	public static final float[] mul(final float[] v, final float[] s, final float[] dst) {
		return Vec3a.mul(v, s[X], s[Y], s[Z], dst);
	}
	
	public static final float[] mul(final float[] dst, final float[] s) {
		return Vec3a.mul(dst, s[X], s[Y], s[Z], dst);
	}
	
	
	public static final float[] div(final float[] v, final float sx, final float sy, final float sz, final float[] dst) {
		dst[X] = v[X] / sx;
		dst[Y] = v[Y] / sy;
		dst[Z] = v[Z] / sz;
		return dst;
	}
	
	public static final float[] div(final float[] dst, final float sx, final float sy, final float sz) {
		return Vec3a.div(dst, sx, sy, sz, dst);
	}
	
	public static final float[] div(final float[] v, final float[] s, final float[] dst) {
		return Vec3a.div(v, s[X], s[Y], s[Z], dst);
	}
	
	public static final float[] div(final float[] dst, final float[] s) {
		return Vec3a.div(dst, s[X], s[Y], s[Z], dst);
	}
	
	
	
	public static final float lengthSquared(final float[] v) {
		return fma(v[X], v[X], fma(v[Y], v[Y], v[Z] * v[Z]));
	}
	
	public static final float length(final float[] v) {
		return sqrt(Vec3a.lengthSquared(v));
	}
	
	public static final float invLength(final float[] v) {
		return invsqrt(Vec3a.lengthSquared(v));
	}
	
	
	
	public static final float[] normalize(final float[] v) {
		final float invLength = Vec3a.invLength(v);
		return scale(v, invLength);
	}

	public static final float[] normalize(final float[] v, final float[] dst) {
		final float invLength = Vec3a.invLength(v);
		return scale(v, invLength, dst);
	}
	
	
	
	public static final float dot(final float[] v, float x, float y, float z) {
		return fma(v[X], x, fma(v[Y], y, z));
	}
	
	public static final float dot(final float[] v1, final float[] v2) {
		return Vec3a.dot(v1, v2[X], v2[Y], v2[Z]);
	}
	
	
	
	public static final float[] mulAddTo(final float[] dst, final float[] va, final float[] vb, final float[] vc) {
		dst[X] = fma(va[X], vb[X], vc[X]);
		dst[Y] = fma(va[Y], vb[Y], vc[Y]);
		dst[Z] = fma(va[Z], vb[Z], vc[Z]);
		return dst;
	}
	
	
	
	public static final float[] cross(final float[] v, final float x, final float y, final float z, final float[] dst) {
        dst[X] = fma(v[Y], z, -v[Z] * y);
        dst[Y] = fma(v[Z], x, -v[X] * z);
        dst[Z] = fma(v[X], y, -v[Y] * x);
        return dst;
    }
	
	public static final float[] cross(final float[] dst, final float x, final float y, final float z) {
		return Vec3a.cross(dst, x, y, z, dst);
	}
	
	public static final float[] cross(final float[] v1, final float[] v2, final float[] dst) {
		return Vec3a.cross(v1, v2[X], v2[Y], v2[Z], dst);
	}
	
	public static final float[] cross(final float[] dst, final float[] v) {
		return Vec3a.cross(dst, v[X], v[Y], v[Z], dst);
	}
	
	
	
	public static final float distance(final float[] v1, final float[] v2) {
		final float[] tmp = Vec3a.create();
		Vec3a.sub(v1, v2, tmp);		// Distance as a vector
		return Vec3a.length(tmp);	// Length of the distance vector
	}
	
	public static final float distance(final float[] v1, final float x2, final float y2, final float z2) {
		final float[] tmp = Vec3a.create();
		Vec3a.sub(v1, x2, y2, z2, tmp);	// Distance as a vector
		return Vec3a.length(tmp);		// Length of the distance vector
	}
	
}
