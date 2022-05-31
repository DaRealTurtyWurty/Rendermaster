package dev.turtywurty.rendermaster.image;

import java.nio.ByteBuffer;

public record Image(ByteBuffer image, int width, int height) {

}
