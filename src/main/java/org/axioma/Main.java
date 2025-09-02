package org.axioma;

import java.util.Arrays;

import org.axioma.vec.Vec3a;

public class Main {

	public static void main(String[] args) {
		final float[] vec = new float[3]; // TODO: Vec3a.create
		Vec3a.add(vec, 1, 1, 0);
		
		// TODO: 2. Inverse length
		final float length = Vec3a.length(vec);
		
		// TODO: 3. normalize()
		Vec3a.div(vec, length, length, length);
		
		System.out.println(Arrays.toString(vec));
	}
	
}
