package org.axioma;

import java.util.Arrays;

import org.axioma.vec.Vec3a;

public class Main {

	public static void main(String[] args) {
		final float[] vec = new float[3]; // TODO: Vec3a.create
		Vec3a.add(vec, 0, 1, 0);
		Vec3a.add(vec, 0, 2f, 0);
		Vec3a.sub(vec, 1, 3f, 0);
		
		System.out.println(Arrays.toString(vec));
	
	}
	
}
