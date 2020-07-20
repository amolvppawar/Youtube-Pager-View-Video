package com.amol.ytfinal;

import java.util.Random;

public class VideoIdsProvider {
    private static String[] videoIds = {"6JYIGclVQdw", "LvetJ9U_tVY", "S0Q4gqBUs7c", "zOa-rSM4nms"};
    private static Random random = new Random();
    public static String getNextVideoId() {
        return videoIds[random.nextInt(videoIds.length)];
    }


}
