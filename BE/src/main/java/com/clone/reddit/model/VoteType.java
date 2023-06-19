package com.clone.reddit.model;

import com.clone.reddit.exceptions.SpringRedditException;

import java.util.Arrays;
import java.util.Objects;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1);

    private int direction;

    VoteType(int direction){
    }

    public static VoteType lookup(int direction){
        return Arrays.stream(VoteType.values())
                .filter(value -> Objects.equals(value.getDirection(), direction))
                .findAny()
                .orElseThrow(()-> new SpringRedditException("Vote not found"));
    }

    public int getDirection() {
        return direction;
    }
}
