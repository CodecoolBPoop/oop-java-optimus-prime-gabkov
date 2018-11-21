package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    void secondSolutionWithStream(){
        Stream<Integer> primesStream = IntStream
                                            .rangeClosed(2, limit)
                                            .filter(num -> isPrime(num))
                                            .boxed();
        List<Integer> primes = primesStream.collect(Collectors.toList());
        System.out.println(primes);
    }


    private boolean isPrime(Integer num){
        boolean flag = true;
        for(int i = 2; i <= num/2; ++i) {
            if(num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        long start;

	    OptimusPrime op = new OptimusPrime(40000);
        start = System.currentTimeMillis();
	    op.basicSolution();
        System.out.println("Basic " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
	    op.secondSolutionWithStream();
        System.out.println("Stream " + (System.currentTimeMillis() - start) + " ms");
    }
}
