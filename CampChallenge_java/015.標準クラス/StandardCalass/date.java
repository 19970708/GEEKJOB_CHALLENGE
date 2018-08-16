/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardCalass;


import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 *
 * @author hatano
 */

public class date {
    public static void main(String[] args){
        Date now=new Date();
        //現在時刻
        System.out.println("今日の日付 :"+now);
        System.out.println("今日のタイムスタンプ :"+now.getTime());
        
        Calendar c=Calendar.getInstance();
        //2016年1月1日 0時0分0秒」の情報を持つタイムスタンプ（ミリ秒）を生成し，画面に表示してください。
        // time stampは1970年1月1日から何ミリ秒後かの値
        //約9時間ずれている
        //2016年1月1日0:00:00
        c.set(2016,0,1,0,0,0);
        Date d1=c.getTime();
        Date d2=c.getTime();
        Date d3=c.getTime();
        System.out.println("2016年1月1日 0時0分0秒のタイムスタンプ :"+d1.getTime());
        //現在の日時を「1988年5月21日 1時23分45秒」といった形式で表現してください。
        SimpleDateFormat sfd =new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        System.out.println(sfd.format(d1));
        
        //「2016年11月4日 10時0分0秒」の情報を持つタイムスタンプ（ミリ秒）を生成し，画面に表示してください。
        //その後，さらにこの情報を「2016-11-04 10:00:00」の形式で画面に表示してください。
        c.set(2016,10,4,10,0,0);
        d1=c.getTime();
        System.out.println("2016年11月4日 10時0分0秒のタイムスタンプ :"+d1.getTime());
        SimpleDateFormat sfd2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sfd2.format(d1));
        
        //2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        
        //2015年1月1日 0時0分0秒
        c1.set(2015,0,1,0,0,0);
        //2015年12月31日 23時59分59秒
        c2.set(2015,11,31,23,59,59);
        
        d1=c1.getTime();
        d2=c2.getTime();
        
        System.out.println(c2.getTimeInMillis()-c1.getTimeInMillis());
        System.out.println(d2.getTime()-d1.getTime());
        
	
        c.set(1970,0,1,9,0,0);
        d1=c.getTime();
        System.out.println("1970年1月1日 9時0分0秒のタイムスタンプ :"+d1.getTime());
        //ほぼゼロ
    }
}
