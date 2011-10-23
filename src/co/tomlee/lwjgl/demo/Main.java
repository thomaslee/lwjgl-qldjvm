package co.tomlee.lwjgl.demo;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.util.glu.GLU.*;

import static org.lwjgl.opengl.GL11.*;

public class Main {
	private static float rotation = 0.0f;
	
	public static void main(String[] args) {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			Display.setTitle("OHAI :)");
			try {
				initialize();
				Timer timer = new Timer();
				while (!Display.isCloseRequested()) {
					glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
					update(timer.tick());
					render();
					Display.update();
				}
			}
			finally {
				Display.destroy();
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	private static void initialize() {
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glClearDepth(1.0f);
		
		glDisable(GL_LIGHTING);
		// glDisable(GL_DEPTH_TEST);
		glEnable(GL_DEPTH_TEST);
		glDisable(GL_CULL_FACE);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(45.0f, 800.0f/600.0f, 1.0f, 1000.0f);
		
		glMatrixMode(GL_MODELVIEW);
	}
	
	private static void update(float elapsed) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			rotation -= 45.0f * elapsed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			rotation += 45.0f * elapsed;
		}
	}
	
	private static void render() {
		glLoadIdentity();
		
		glTranslatef(0.0f, 0.0f, -5.0f);
		glRotatef(rotation, 0.0f, 0.0f, -1.0f);
		glBegin(GL_TRIANGLES);
			glColor3f(1.0f, 0.0f, 0.0f);
			glVertex3f(0.0f, 0.5f, 0.0f);
			
			glColor3f(0.0f, 1.0f, 0.0f);
			glVertex3f(0.5f, -0.5f, 0.0f);
			
			glColor3f(0.0f, 0.0f, 1.0f);
			glVertex3f(-0.5f, -0.5f, 0.0f);
		glEnd();
	}
}
