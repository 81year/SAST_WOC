package com.sast.sast_woc.pojo.data;

import lombok.Data;

import java.util.List;

@Data
public class Pancakes {
    private List<Pancake> pancakes;

    public Pancakes(List<Pancake> pancakes) {
        this.pancakes = pancakes;
    }
}
