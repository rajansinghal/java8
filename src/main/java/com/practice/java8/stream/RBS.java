package com.practice.java8.stream;

/**
 * Created by rsinghal on 5/2/2018.
 */
public class RBS {

    public static void main(String[] args) {

        int m = 3;
        int[] input = {80,48,82 };

        System.out.println(cal(m,input));
    }

    private static int cal(int n, int[] input){

        if(n > input.length){
            return 0;
        }else{
            int maxsofar = 0;int maxcurrent = 1;

            for(int i=0; i< input.length;i++){
                if(i < input.length-1 && input[i] > input[i+1]){
                    maxsofar = input[i];
                }else {
                    if(maxcurrent == 1){
                        maxcurrent = input[i];
                    }
                    if (maxcurrent > maxsofar)
                        maxsofar = maxcurrent;
                    if(input[i]/maxcurrent >=1)
                        maxcurrent = maxcurrent * i;
                }
            }
            return maxsofar;
        }

    }
}
