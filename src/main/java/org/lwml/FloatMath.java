package org.lwml;

/**
 * A specialized math utility class for operations using {@code float}.
 * <p>
 * Unlike {@link java.lang.Math}, which operates primarily with {@code double},
 * this class provides constants and methods directly in {@code float} precision
 * to avoid unnecessary widening conversions and improve performance in
 * performance-critical applications such as graphics, physics, and games.
 * </p>
 *
 * <p>
 * Initially, this class delegates some calculations to {@link java.lang.Math},
 * but in the future it may include its own optimized implementations of
 * trigonometric and other functions.
 * </p>
 *
 * <h2>Features:</h2>
 * <ul>
 * <li>Common mathematical constants in {@code float} precision (PI, TAU,
 * HALF_PI, QUARTER_PI, E).</li>
 * <li>Conversion between degrees and radians with precomputed conversion
 * constants.</li>
 * <li>Utility methods like {@link #toRadians(float)} and
 * {@link #toDegrees(float)}.</li>
 * </ul>
 *
 * <h2>Example usage:</h2>
 * 
 * <pre>{@code
 * float angleDeg = 90f;
 * float angleRad = FloatMath.toRadians(angleDeg); // ~1.5708
 * }</pre>
 */
public final class FloatMath {

	/** The mathematical constant π (pi), as a float. */
	public static final float PI = (float) java.lang.Math.PI;

	/** The mathematical constant τ (tau), equal to 2π, as a float. */
	public static final float TAU = (float) java.lang.Math.TAU;

	/** Half of π (π/2), as a float. */
	public static final float HALF_PI = (float) (java.lang.Math.PI * 0.5);

	/** Quarter of π (π/4), as a float. */
	public static final float QUARTER_PI = (float) (java.lang.Math.PI * 0.25);

	/** The base of the natural logarithm e, as a float. */
	public static final float E = (float) java.lang.Math.E;

	/**
	 * Constant by which to multiply an angle in degrees to obtain the equivalent
	 * value in radians.
	 */
	public static final float DEG2RAD = 0.017453292519943295f;

	/**
	 * Constant by which to multiply an angle in radians to obtain the equivalent
	 * value in degrees.
	 */
	public static final float RAD2DEG = 57.29577951308232f;
	
	public static final float ROUNDING_ERROR = 1.0E-7f; // 0.0000001f

	/** Private constructor to prevent instantiation. */
	private FloatMath() {}

	/**
	 * Converts an angle measured in degrees to an approximately equivalent angle
	 * measured in radians.
	 *
	 * @param deg the angle in degrees
	 * @return the angle in radians
	 */
	public static final float toRadians(float deg) {
		return deg * DEG2RAD;
	}

	/**
	 * Converts an angle measured in radians to an approximately equivalent angle
	 * measured in degrees.
	 *
	 * @param rad the angle in radians
	 * @return the angle in degrees
	 */
	public static final float toDegrees(float rad) {
		return rad * RAD2DEG;
	}

	public static final float sqrt(float n) {
		return (float) Math.sqrt(n);
	}

	public static final float invsqrt(float n) {
		return 1f / (float) Math.sqrt(n);
	}

	public static final float sinDeg(final float deg) {
		return (float) Math.sin(toRadians(deg));
	}

	public static final float cosDeg(final float deg) {
		return (float) Math.cos(toRadians(deg));
	}

	public static final float cosDeg(final float deg, final float sin) {
		return (float) Math.cos(toRadians(deg));
	}

	public static final float fma(final float a, final float b, final float c) {
		return a * b + c;
	}

	public static final float hypot2(float x, float y) {
		return fma(x, x, y * y);
	}

	public static final float hypot(float x, float y) {
		return sqrt(fma(x, x, y * y));
	}

	public static float hypot2(float x, float y, float z) {
		return fma(x, x, fma(y, y, z * z));
	}

	public static float hypot(float x, float y, float z) {
		return sqrt(fma(x, x, fma(y, y, z * z)));
	}

}
