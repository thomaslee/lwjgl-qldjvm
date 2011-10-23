package co.tomlee.lwjgl.demo;

public class Timer {
	private long lastTime = 0;
	
	public float tick() {
		long thisTime = System.nanoTime();
		float elapsed = 0.0f;
		if (lastTime != 0) {
			elapsed = (thisTime - lastTime) / 1000000000.0f;
		}
		lastTime = thisTime;
		return elapsed;
	}
}
