package dev.turtywurty.rendermaster.core;

import static org.lwjgl.glfw.GLFW.glfwInit;

import org.lwjgl.glfw.GLFWErrorCallback;

import dev.turtywurty.rendermaster.exceptions.GLFWInitException;
import dev.turtywurty.rendermaster.window.Window;

public class Rendermaster {
    public final Actions beforeClear = new Actions();
    public final Actions afterClear = new Actions();
    public final Actions afterSwap = new Actions();
    public final Actions afterKeypress = new Actions();
    public final Actions beforeClose = new Actions();
    public final Actions afterClose = new Actions();

    private final Window window;

    public Rendermaster(Window window) {
        this.window = window;
    }

    public void init() {
        try (GLFWErrorCallback callback = GLFWErrorCallback.createPrint(System.err).set()) {
            if (!glfwInit())
                throw new GLFWInitException();
        }

        Window.init(this.window);
    }

    public void start() {
        while (!this.window.shouldClose()) {
            this.beforeClear.forEach(Runnable::run);
            this.window.clear();
            this.afterClear.forEach(Runnable::run);

            this.window.swapBuffers();
            this.afterSwap.forEach(Runnable::run);

            this.window.handleKeypress();
            this.afterKeypress.forEach(Runnable::run);
        }
        
        this.beforeClose.forEach(Runnable::run);
        this.window.terminate();
        this.afterClose.forEach(Runnable::run);
    }
}
