package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 模拟行走机器人
 **/
public class WalkingRobotSimulation {

    /**
     * 主要是维护一个障碍点的集合来快速判断是否走过的某个点是否是障碍点
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        // 障碍集合
        Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            obstacleMap.computeIfAbsent(obstacle[0], key -> new HashSet<>()).add(obstacle[1]);
        }
        // 分别为 x坐标 y坐标 朝向0123代表北东南西
        int[] cur = new int[]{0, 0, 0};
        for (int command : commands) {
            if (command > 0) {
                // 前进
                move(obstacleMap, cur, command);
                ans = Math.max(ans, (int) (Math.pow(cur[0], 2) + Math.pow(cur[1], 2)));
            } else if (command == -1) {
                // 右转
                cur[2] = (cur[2] + 1) % 4;
            } else if (command == -2) {
                // 左转
                cur[2] = (cur[2] - 1 + 4) % 4;
            }
        }
        return ans;
    }

    private void move(Map<Integer, Set<Integer>> obstacleMap, int[] cur, int command) {
        int x = 0, y = 0;
        if (cur[2] == 0) {
            y = 1;
        } else if (cur[2] == 1) {
            x = 1;
        } else if (cur[2] == 2) {
            y = -1;
        } else {
            x = -1;
        }
        for (int i = 0; i < command; i++) {
            int nextX = cur[0] + x;
            int nextY = cur[1] + y;
            if (isObstacles(nextX, nextY, obstacleMap)) {
                break;
            } else {
                cur[0] = nextX;
                cur[1] = nextY;
            }
        }
    }

    private boolean isObstacles(int nextX, int nextY, Map<Integer, Set<Integer>> obstacleMap) {
        return obstacleMap.getOrDefault(nextX, new HashSet<>()).contains(nextY);
    }

}