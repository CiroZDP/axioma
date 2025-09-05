package org.lwtk.math;

import org.lwtk.math.exp.Vec4;

public class Main {

	public static void main(String[] args) {
		Vec4 a = new Vec4();
		Vec4 b = new Vec4();
		a.set(1, 2, 3, 4);
		b.set(4, 3, 2, 1);
		bench("LWTK Vec4 add (JNI + SIMD)", () -> {
			a.addJNI(b);
		});
		a.set(1, 2, 3, 4);
		b.set(4, 3, 2, 1);
		bench("LWTK Vec4 add", () -> {
			a.add(b);
		});
		System.out.println();
		System.out.println("Final result: " + a);
	}

	private static float bench(String name, Runnable task) {
		long begin = System.nanoTime();
		task.run();
		long end = System.nanoTime();
		float ms = (end - begin) * 1e-6f;
		System.out.printf("%s%stook %.7f ms\n", name, " ".repeat(27 - name.length()), ms);
		return ms;
	}
}
