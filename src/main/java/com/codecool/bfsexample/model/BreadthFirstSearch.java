package com.codecool.bfsexample.model;

import java.lang.reflect.Array;
import java.util.*;

public class BreadthFirstSearch {

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
        Queue<UserNode> queue = new LinkedList<>();
        HashMap<UserNode, Integer> distances = new HashMap<>();
        Set<UserNode> resultSet = new HashSet<>();

        queue.add(user);
        distances.put(user,0);

        while (!queue.isEmpty()){
            UserNode nextFriend = queue.remove();
            if (distances.get(nextFriend) > distance){
                resultSet.remove(user);
                return resultSet;
            }else {
                resultSet.add(nextFriend);
            }
            for (UserNode friend: nextFriend.getFriends()){
                queue.add(friend);
                distances.put(friend,distances.get(nextFriend)+1);
            }
        }
        return null;
    }
}
