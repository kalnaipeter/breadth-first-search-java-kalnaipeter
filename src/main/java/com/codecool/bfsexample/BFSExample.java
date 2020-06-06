package com.codecool.bfsexample;

import com.codecool.bfsexample.model.BreadthFirstSearch;
import com.codecool.bfsexample.model.UserNode;
import java.util.List;

public class BFSExample {

    private static List<UserNode> populateDB() {

        RandomDataGenerator generator = new RandomDataGenerator();
        List<UserNode> users = generator.generate();

        GraphPlotter graphPlotter = new GraphPlotter(users);
        
        System.out.println("Done!");
        return users;
    }

    public static void main(String[] args) {
        List<UserNode> userNodes = populateDB();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(userNodes);
        
        System.out.println(breadthFirstSearch.getDistance(userNodes.get(107),userNodes.get(91)));
        System.out.println(breadthFirstSearch.friendsOfFriends(userNodes.get(10),3));
    }
}
