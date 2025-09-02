package org.lwml;

import java.util.Arrays;

import org.lwml.vec.Vec3a;

public class Main {

	public static void main(String[] args) {
		final float[] vec = Vec3a.wrap(1, 1, 0);
		Vec3a.normalize(vec);
		
		System.out.println(Arrays.toString(vec));
	}
	
}
