package com.practice.java8.stream;

/**
 * Created by rsinghal on 2/4/2018.
 */
public class Goldman {

    public static void main(String[] args) {
int i =Goldman.method1("MMN");
        System.out.println(i);

    }

    public  static  int method1(String input){

        int[] asci_arr = new int[256];
        final String M= "M";
        final String N= "N";
        int output = -1;

        if(input != null && input.trim().length() >= 1 && input.trim().length() <= 8 && !input.contains("\\s+") ){
            input = input.trim();

            int count =  M.equals(String.valueOf(input.charAt(0)))?input.split(M, -1).length - 1 : input.split(N, -1).length - 1;

            if(input.length() == count ){
                String out_temp = "";
                if(M.equals(String.valueOf(input.charAt(0)))){

                    for(int t1= count * 2 ; t1 >= 1 ; t1--){
                        out_temp = out_temp + String.valueOf(t1);
                    }

                }else{
                    for(int t1= 1 ; t1 <= count *2 ; t1++){
                        out_temp = out_temp + String.valueOf(t1);
                    }
                }
                output = Integer.parseInt(out_temp);

            }else{
                char[] ch = input.toCharArray();
                char startingChar = ch[0];
                int temp = 1;
                for(int t2 = 1 ; t2 < ch.length ; t2++){
                    temp = t2;
                    if( ! (startingChar == ch[t2])){
                            break;
                    }

                }
                if(temp > 1 )
                {
                    String s = input.substring(0,temp);
                    String s1 = input.substring(temp -1);
                    if (s.length() + s1.length() == input.length()){
                        String out_temp = "";
                        if(M.equals(String.valueOf(input.charAt(0)))){

                            for(int t1= count * 2 ; t1 >= 1 ; t1--){
                                out_temp = out_temp + String.valueOf(t1);
                            }

                        }else{
                            for(int t1= 1 ; t1 <= count *2 ; t1++){
                                out_temp = out_temp + String.valueOf(t1);
                            }
                        }
                        output = Integer.parseInt(out_temp);
                    }
                }
            }


        }




        return  output;
    }
}
