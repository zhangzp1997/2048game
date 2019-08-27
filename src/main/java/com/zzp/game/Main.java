package com.zzp.game;

import com.zzp.game.util.MapUtil;

import java.util.ArrayList;


/**
 * @author:
 * @date: 2019/8/26 16:40
 */
public class Main {
    private static int[][] map = new int[4][4];
    private static int freeCount = 16;

    public static void main(String[] args) {
        init();
        MapUtil.showMap(map);
        left();
        MapUtil.showMap(map);
        right();
        MapUtil.showMap(map);
        up();
        MapUtil.showMap(map);
        down();
        MapUtil.showMap(map);
        System.out.println(freeCount);




    }
    private static boolean detect(){
        return freeCount !=0;
    }

    private static void init() {
        try {
            generate();
            Thread.sleep(200);
            generate();
            Thread.sleep(200);
            generate();
            Thread.sleep(200);
            generate();
            Thread.sleep(200);
            generate();
            Thread.sleep(200);
            generate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean generate() {
        if (freeCount == 0) {
            return false;
        }
        int random = (int) (System.currentTimeMillis() % 16);
        random %= freeCount;
        int generateNumber;
        if (random % 2 == 0) {
            generateNumber = 2;
        } else {
            generateNumber = 4;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    random--;
                }
                if (random == -1) {
                    map[i][j] = generateNumber;
                }
            }
        }
        freeCount--;
        return true;
    }

    private static void left() {
        for (int i = 0; i < map.length; i++) {
            add(map[i]);
        }
    }

    private static void add(int[] row) {
        int[] temp = new int[row.length];
        ArrayList<Integer> hasNum = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            temp[i] = row[i];
            if (row[i] != 0) {
                hasNum.add(i);
            }
        }
        if (hasNum.isEmpty()) {
            return;
        }
        if (hasNum.size() == 1) {
            row[hasNum.get(0)] = 0;
            row[0] = temp[hasNum.get(0)];
        }

        if (hasNum.size() >= 2) {
            ArrayList<Integer> addLater = new ArrayList<>();
            for (int i = 0; i < hasNum.size(); i++) {
                if (i != hasNum.size() - 1 && temp[hasNum.get(i)] == temp[hasNum.get(i + 1)]) {
                    addLater.add(temp[hasNum.get(i)] * 2);
                    freeCount++;
                    i++;
                } else {
                    addLater.add(temp[hasNum.get(i)]);
                }
            }
            for (int i = 0; i < row.length; i++) {
                if (i < addLater.size()) {
                    row[i] = addLater.get(i);
                } else {
                    row[i] = 0;
                }
            }
        }
    }

    private static void right() {
        int[] temp = new int[map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                temp[temp.length - j - 1] = map[i][j];
            }
            add(temp);
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = temp[temp.length - j - 1];
            }
            for (int j = 0; j < temp.length; j++) {
                temp[j] = 0;
            }
        }
    }

    private static void up() {
        int[] temp = new int[map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                temp[j] = map[j][i];
            }
            add(temp);
            for (int j = 0; j < map.length; j++) {
                map[j][i] = temp[j];
            }
            for (int j = 0; j < temp.length; j++) {
                temp[j] = 0;
            }
        }

    }

    private static void down() {
        int[] temp = new int[map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                temp[temp.length - j - 1] = map[j][i];
            }
            add(temp);
            for (int j = 0; j < map.length; j++) {
                map[j][i] = temp[temp.length - j - 1];
            }
            for (int j = 0; j < temp.length; j++) {
                temp[j] = 0;
            }
        }

    }
}


