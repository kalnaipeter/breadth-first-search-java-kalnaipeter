package com.codecool.bfsexample.model;

import java.util.List;

public class BreadthFirstSearch {
    private List<UserNode> users;

    public BreadthFirstSearch(List<UserNode> users) {
        this.users = users;
    }

    public int getDistance(UserNode start,UserNode end){
        return 5;
    }
}
