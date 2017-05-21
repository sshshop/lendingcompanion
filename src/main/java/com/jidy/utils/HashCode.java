package com.jidy.utils;

/**
 * Created by jidy on 2017/5/21.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashCode {

    public static class AlarmInfoDTO  {
        private String alarmsType;
        private String timestamp;

        private String numberPlate;
        public AlarmInfoDTO(String alarmsType,String timestamp,String numberPlate) {
            // TODO Auto-generated constructor stub
            this.alarmsType = alarmsType;
            this.numberPlate = numberPlate;
            this.timestamp = timestamp;
        }
        @Override
        public boolean equals(Object obj) {
            if(this==obj){
                return true ;
            }
            if(!(obj instanceof AlarmInfoDTO)){
                return false ;
            }
            AlarmInfoDTO alarmInfo = (AlarmInfoDTO)obj ;    // 向下转型
            return this.alarmsType.equals(alarmInfo.alarmsType)&&
                    this.timestamp.equals(alarmInfo.timestamp)&&
                    this.numberPlate.equals(alarmInfo.numberPlate);//&&
        }
        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return this.numberPlate.hashCode()*Integer.parseInt(this.alarmsType);
        }
        private void print(){
            System.out.println(this.alarmsType+","+this.numberPlate+","+this.timestamp);
        }
    }
}
