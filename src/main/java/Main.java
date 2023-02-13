

import engine.Window;
import org.lwjgl.opengl.GL;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw. GLFW.*;

public class Main {

    public Window window = new Window(800,800,"hello");
    public static void main(String[] args) {
        new Main().run();
    }

    public void run(){
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init(){
        window.init();
        GL.createCapabilities();

//        code ditaruh di sini jangan diatas winodw.init atau gl.createcapabilities
//        biarin gk error karna gak load gl ny jadi error

    }

    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

//            code

//            restore state
            glDisableVertexAttribArray(0);
//            POLL WINDOWS event
//            the key callback above will only be
//            invoked during this call
            glfwPollEvents();
        }
    }
}