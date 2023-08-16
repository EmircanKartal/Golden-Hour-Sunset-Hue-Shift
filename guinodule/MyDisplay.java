package guinodule;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet {

    PImage img;
    int frameCounter = 0;

    public void setup() {
        size(1300, 800);
        background(255);
        stroke(0);
        img = loadImage("https://ca-times.brightspotcdn.com/dims4/default/b9550f2/2147483647/strip/true/crop/1575x1050+84+0/resize/2400x1600!/quality/80/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F4b%2Fa9%2Fe470c1df4480a9ae1f5f91eb5e75%2Fbeaches-in-the-surf-long-beach.jpeg", "jpg");
        img.resize(0, height);
        image(img, 0, 0);
    }

    public void draw() {
        int[] color = sunsetColors(frameCounter);
        fill(color[0], color[1], color[2], color[3]);
        ellipse((width / 4), (height / 4) - 80, width / 8, height / 6);
        
        frameCounter = (frameCounter + 1) % 720; // Loop the frame counter from 0 to 719
    }

    public int[] sunsetColors(int frame) {
        int[] rgba = new int[4];
        float percentage = frame / 720.0f; // Calculate the percentage of the animation

        if (percentage < 0.25) {
            // Yellow to orange transition
            rgba[0] = 255;
            rgba[1] = (int) (255 - 420 * percentage);
            rgba[2] = 0;
            rgba[3] = 255;
        } else if (percentage < 0.5) {
            // Orange to transparent transition
            rgba[0] = 255;
            rgba[1] = (int) (150 + 210 * (percentage - 0.25));
            rgba[2] = 0;
            rgba[3] = (int) (255 - 255 * (percentage - 0.25));
        } else if (percentage < 0.75) {
            // Transparent to yellow transition
            rgba[0] = 255;
            rgba[1] = (int) (255 - 255 * (percentage - 0.5));
            rgba[2] = 0;
            rgba[3] = (int) (255 * (percentage - 0.5));
        } else {
            // Yellow to transparent transition
            rgba[0] = 255;
            rgba[1] = (int) (255 * (1 - (percentage - 0.75)));
            rgba[2] = 0;
            rgba[3] = (int) (255 * (1 - (percentage - 0.75)));
        }

        return rgba;
    }

    public static void main(String[] args) {

    }
}
