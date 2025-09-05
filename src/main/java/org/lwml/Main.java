package org.lwml;

import org.lwml.exp.Vec4;

public class Main {

    public static void main(String[] args) {
    	Vec4 vec = new Vec4();
        bench("LWTK Vector Set Manual", () -> {
        	vec.set(1, 2, 3, 4);
        });
    }

    private static float bench(String name, Runnable task) {
        long begin = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        float ms = (end - begin) * 1e-6f;
        System.out.printf("%s%stook %.7f ms\n", name, " ".repeat(35 - name.length()), ms);
        return ms;
    }
}
