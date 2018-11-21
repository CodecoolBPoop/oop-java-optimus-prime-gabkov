package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class OptimusPrime {

/*
    [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113]
*/

    private int limit;
    private boolean[] primePlaces;

    OptimusPrime(Integer limit){
        this.limit = limit;
        primePlaces = new boolean[limit+1];
    }

    void basicSolution(){
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit ; i++) {
            if(!primePlaces[i]) primes.add(i);
            for (int j = 2; j <= limit; j++) {
                if(j % i == 0 && !primePlaces[j]){
                    primePlaces[j] = true;
                }
            }
        }
        System.out.println(primes);

    }

    public static void main(String[] args) {
	    OptimusPrime op = new OptimusPrime(120);
	    op.basicSolution();
    }
}
