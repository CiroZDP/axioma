package org.lwml;

import org.lwml.vec.Vec3;

public class Main {

	public static void main(String[] args) {
		final Vec3 vec = new Vec3()
				.add(1, 2, 3)
				.add(1, 2, 3);
		
		System.out.println(vec);
	
	}
	
}
