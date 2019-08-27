package com.zzp.game.util;


/**
 * @author:
 * @date: 2019/8/26 16:46
 */
public final class MapUtil {
    private MapUtil() {
    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println("—————————————————————————————————");
            System.out.println("|\t\t|\t\t|\t\t|\t\t|");
            System.out.print("|\t");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0) {
                    System.out.print(map[i][j] + "\t|\t");
                } else {
                    System.out.print("\t|\t");
                }
            }
            System.out.println();
            System.out.println("|\t\t|\t\t|\t\t|\t\t|");

        }
        System.out.println("—————————————————————————————————");
        System.out.println("---------------------------------------------");
    }

}
