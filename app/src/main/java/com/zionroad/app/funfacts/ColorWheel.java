package com.zionroad.app.funfacts;

import android.graphics.Color;
import java.util.Random;

class ColorWheel {
    // Store the colors here
    private static final String[] COLORS = {
            "#51b46d", // green
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    // Return the first element as default (as Color for android)
    static Integer getDefaultColor() {return Color.parseColor(COLORS[0]);}

    // Get a random color and return it
    static Integer getColors() {return Color.parseColor(COLORS[new Random().nextInt(COLORS.length)]);}
}
