/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileClass;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 *
 * @author hatano
 */

//Java の標準クラスについて，これまでに扱っていないものを自身で調査し，その標準クラスを利用した処理を記述してください。 
//その際，「ファイル操作編」の単元で学習した内容を利用して，以下の内容が記載されたログファイルを作成してください。 

//1. 処理の内容（例：文字列の置換） 
//2. 処理を開始する旨と，その時刻（例：2000-01-01 12:00 開始） 
//3. 処理を終了する旨と，その時刻（例：2000-04-04 11:00 終了） 
//※ なお，ログファイルとは，一定の記録（Log）が記述されたファイルの一般的な名称です（特定のファイル形式を指すものではありません）。6/15

public class File2 {
    static void time(String input){
        try{
            Date now=new Date();
            SimpleDateFormat sfd =new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
            System.out.println(sfd.format(now)+" 開始");
            
            File fp = new File("log.txt");
            FileWriter fw=new FileWriter(fp,true);
            fw.write(input+" \n");
            fw.close();
        
            Date later=new Date();
            System.out.println(sfd.format(later)+" 終了");
        
        }catch(IOException e){
            System.out.println("エラー");
        }
        
    }
    public static void main(String[] args){
        time("書き込みました。");
    }
    
}
