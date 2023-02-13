

import engine.ShaderProgram;
import engine.Window;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import engine.object2D;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;

public class Main {

    public Window window = new Window(800, 800, "hello");
    ArrayList<object2D> objects = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();

        //Code
        //Contoh
        objects.add(new object2D(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f)
                        )
                )
        ));
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            //Code
            //Contoh
            for (object2D object : objects) {
                object.draw();
            }

            //Restore state
            glDisableVertexAttribArray(0);

            //Poll for windows events
            //The key callback above will only be invokes during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}