package com.jidy.utils;

/**
 * Created by jidy on 2017/5/21.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class HashCode {
    public static String  findMaxString(String[] arr){
        Map<Integer,String> map=new HashMap<Integer,String>();
        for(int i=0;i<arr.length-1;i++){
            int count=0;
            String temp=null;
            for(int j=i+1;j<arr.length;j++){
                if (!arr[i].equals(" ")&&arr[i]!=null&&!arr[j].equals(" ")&&arr[j]!=null){
                    if(arr[i].equals(arr[j])){
                        count++;
                        temp=arr[i];
                    }
                }
            }
            map.put(count+1, temp);
        }
        int[] countArr= new int[map.size()];
        for(int c:map.keySet()){
            for(int i=0;i<map.size();i++){
                countArr[i]=c;
            }
        }
        Arrays.sort(countArr);
        int MAXCOUNT=countArr[countArr.length-1];
        String maxvalue= map.get(MAXCOUNT);
        return maxvalue;
    }

}
