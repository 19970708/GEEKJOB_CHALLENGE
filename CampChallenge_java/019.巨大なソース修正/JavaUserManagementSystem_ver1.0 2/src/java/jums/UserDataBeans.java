/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;
import java.util.*;

/**
 *
 * @author hatano
 */
public class UserDataBeans {
    private String name;
    private String year;
    private String month;
    private String day;
    private String type;
    private String tell;
    private String comment;
    
    public UserDataBeans(){
        this.name="";
        this.year="";
        this.month="";
        this.day="";
        this.type="";
        this.tell="";
        this.comment="";
    }
    //name
    public void setname(String name){
        this.name=name;
    }
    public String getname(){
        return this.name;
    }
    //year
    public void setyear(String year){
        this.year=year;
    }
    public String getyear(){
        return this.year;
    }
    //month
    public void setmonth(String month){
        this.month=month;
    }
    public String getmonth(){
        return this.month;
    }
    //day
    public void setday(String day){
        this.day=day;
    }
    public String getday(){
        return this.day;
    }
    //type
    public void settype(String type){
        this.type=type;
    }
    public String gettype(){
        return this.type;
    }
    //tell
    public void settell(String tell){
        this.tell=tell;
    }
    public String gettell(){
        return this.tell;
    }
    //comment
    public void setcomment(String comment){
        this.comment=comment;
    }
    public String getcomment(){
        return this.comment;
    }
    
    
    ArrayList<String> list = new ArrayList();
    //不足している要素のArrayListを作成
    public ArrayList<String> getlist(){
        if(this.name.equals("")) this.list.add("名前");
        if(this.year.equals("")) this.list.add("年");
        if(this.month.equals("")) this.list.add("月");
        if(this.day.equals("")) this.list.add("日");
        if(this.type.equals("")) this.list.add("種別");
        if(this.tell.equals("")) this.list.add("電話番号");
        if(this.comment.equals("")) this.list.add("自己紹介文");
        
        return this.list;
    } 
    //不足している要素をコメントする
    public String print(ArrayList<String> list){
        String comment="";
        for(String lis : list){
                comment+=lis+"、";
           }
        return comment+"が不足しています";
    }
    //不足があるか否か
    public boolean check(ArrayList<String> list){
        if(list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
