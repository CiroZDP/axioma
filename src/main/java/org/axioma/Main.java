package org.axioma;

import java.util.Arrays;

import org.axioma.vec.Vec3a;

public class Main {

	public static void main(String[] args) {
		final float[] vec = new float[3]; // TODO: Vec3a.create
		Vec3a.add(vec, 1, 1, 0);
		
		// TODO: 2. Inverse length
		final float length = Vec3a.length(vec);
		
		// TODO: 1. div function
		Vec3a.mul(vec, 1f / length, 1f / length, 1);
		
		System.out.println(Arrays.toString(vec));
	}
	
}
