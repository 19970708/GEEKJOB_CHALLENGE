/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileClass;

import java.io.*;
/**
 *
 * @author hatano
 */
public class File1 {
    public static void main(String[] args){
        try{
            File fp = new File("profile.txt");
            FileWriter fw = new FileWriter(fp);
            
            fw.write("波多野陽平です");
            fw.close();
            
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            
            System.out.println(br.readLine());
            br.close();
        }
        catch(Exception e){
            System.out.println("エラー");
        }
                     
                
    }
    
}
