package com.codecool.bfsexample.model;

import java.util.*;

public class BreadthFirstSearch {
    private List<UserNode> users;

    public BreadthFirstSearch(List<UserNode> users) {
        this.users = users;
    }

    public int getDistance(UserNode start,UserNode end) {
        Queue<UserNode> queue = new LinkedList<>();
        HashMap<UserNode, Integer> distanceCounter = new HashMap<>();

        queue.add(start);
        int counter = 0;

        while (!queue.isEmpty()) {
            Set<UserNode> friends = queue.remove().getFriends();
            counter++;

            for (UserNode friend : friends) {
                if (friend == end) {
                    return counter;
                }
                queue.add(friend);
            }
        }
        return 0;
    }
}
