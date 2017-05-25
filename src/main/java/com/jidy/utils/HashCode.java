package com.jidy.utils;

/**
 * Created by jidy on 2017/5/21.
 */
import java.util.*;


public class HashCode {
    public static String[]  findMaxString(String[] arr){
        List<ListBean> list=new ArrayList<ListBean>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] strings=arr;
        for (String str:strings) {
            int count =0;
            for(int i=0;i<strings.length;i++){
                if (str.equals(strings[i])) {
                    map.put(str, ++count);
                }
            }
        }

        for (String key:map.keySet()) {
            ListBean bean=new  ListBean();
            bean.setCount(map.get(key));
            bean.setKeyWord(key);
            list.add(bean);
        }

        Collections.sort(list,new Comparator<ListBean>(){
            public int compare(ListBean arg0, ListBean arg1) {
                return arg0.getCount().compareTo(arg1.getCount());
            }
        });
        String[] keyword=new String[3];
        for (int i = 0; i < 3; i++) {
            keyword[i]=list.get(list.size()-i-1).getKeyWord();
        }
        return keyword;
    }

}
