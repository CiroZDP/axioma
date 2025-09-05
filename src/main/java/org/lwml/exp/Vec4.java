package org.lwml.exp;

import java.lang.reflect.Field;
import java.lang.ref.Cleaner;
import sun.misc.Unsafe;

@SuppressWarnings("removal")
public final class Vec4 {

	static final Unsafe UNSAFE;
	static final Cleaner CLEANER = Cleaner.create();

	public final long baseAddr, addr;
	private final long padX, padY, padZ, padW;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAFE = (Unsafe) f.get(null);
		} catch (Exception e) {
			throw new UnsupportedOperationException("Unsafe not available", e);
		}
	}

	public Vec4() {
		this.baseAddr = UNSAFE.allocateMemory(16 + 15);
		this.addr = (baseAddr + 15) & ~0xF;
		{
			this.padX = addr + 0;
			this.padY = addr + 4;
			this.padZ = addr + 8;
			this.padW = addr + 12;
		}

		CLEANER.register(this, this::free);
		
		// Initialization
		this.w(1.0f);		// Set 'W' component to 1.0f
	}

	/// -- Setters -- ///
	public final Vec4 set(float[] arr) {
		final long baseOffset = UNSAFE.arrayBaseOffset(float[].class);
		UNSAFE.copyMemory(arr, baseOffset, null, addr, 16);
		return this;
	}
	
	public final Vec4 set(final float x, final float y, final float z, final float w) {
		this.x(x);
		this.y(y);
		this.z(z);
		this.w(w);
		return this;
	}

	public final Vec4 zero() {
		UNSAFE.setMemory(addr, 16, (byte) 0);
		return this;
	}

	public final Vec4 x(final float x) {
		UNSAFE.putFloat(padX, x);
		return this;
	}

	public final Vec4 y(final float y) {
		UNSAFE.putFloat(padY, y);
		return this;
	}

	public final Vec4 z(final float z) {
		UNSAFE.putFloat(padZ, z);
		return this;
	}

	public final Vec4 w(final float w) {
		UNSAFE.putFloat(padW, w);
		return this;
	}

	/// -- Getters -- ///
	
	public final float x() {
		return UNSAFE.getFloat(padX);
	}

	public final float y() {
		return UNSAFE.getFloat(padY);
	}

	public final float z() {
		return UNSAFE.getFloat(padZ);
	}

	public final float w() {
		return UNSAFE.getFloat(padW);
	}

	/// -- Manual memory managment -- ///
	
	public final void free() {
		UNSAFE.freeMemory(baseAddr);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("(")
				.append(x())
				.append(", ")
				.append(y())
				.append(", ")
				.append(z())
				.append(", ")
				.append(w())
				.append(")").toString();
	}
}
