package com.codecool.bfsexample.model;

import java.lang.reflect.Array;
import java.util.*;

public class BreadthFirstSearch {
    private List<UserNode> users;

    public BreadthFirstSearch(List<UserNode> users) {
        this.users = users;
    }

    public int getDistance(UserNode start,UserNode end) {
        Queue<UserNode> queue = new LinkedList<>();
        HashMap<UserNode,Integer> distances = new HashMap<>();

        queue.add(start);
        distances.put(start,0);

        while (!queue.isEmpty()) {
            UserNode nextFriend = queue.remove();
            if (nextFriend == end){
                return distances.get(nextFriend);
            }
            for (UserNode friend : nextFriend.getFriends()) {
                queue.add(friend);
                distances.put(friend,distances.get(nextFriend)+1);
            }
        }
        return 0;
    }
    public Set<UserNode> friendsOfFriends(UserNode user,int distance){
        Set<UserNode> resultList;

        resultList = user.getFriends();
        int distanceCounter = 1;
        while (!(distanceCounter ==distance)) {
            distanceCounter++;
            for (UserNode userNode: resultList){
                System.out.println(userNode);
                System.out.println("ezen megyünk végig most");
                for (UserNode friend: userNode.getFriends()) {
                    if (!resultList.contains(friend)) {
                        System.out.println(friend);
                        System.out.println("done");
                        resultList.add(friend);
                    }
                }
            }
        }
        return resultList;
    }
}
