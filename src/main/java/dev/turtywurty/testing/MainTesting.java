package dev.turtywurty.testing;

import dev.turtywurty.rendermaster.core.Rendermaster;
import dev.turtywurty.rendermaster.window.Window;

public class MainTesting {
    private final Rendermaster rendermaster;
    private final Window window;
    
    public MainTesting() {
        this.window = Window.Builder.create("Test Window").centerOnScreen().disableVsync().build();
        this.rendermaster = new Rendermaster(this.window);
    }
    
    public void init() {
        this.rendermaster.init();
        this.rendermaster.start();
    }
}
