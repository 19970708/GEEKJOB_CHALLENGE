/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardCalass;
/**
 *
 * @author hatano
 */
public class mojiretsu {
    public static void main(String[] args){
        System.out.println("課題ここから<br>");
        String word =" あいうえおかきくけこい";
        //ながさ
        System.out.println(word.length());
        //5番目以降
        System.out.println(word.substring(4));
        //5番目ー７
        System.out.println(word.substring(4,6));
        //前後の空白を消す
        System.out.println(word.trim());
        //何番目の文字か
        System.out.println(word.indexOf("い"));
        //文字の置き換え
        System.out.println(word.replace("い","あ"));
        
        String word2 = "ケーキ,クッキー,アイス";
        String[] sweets = word2.split(",");
        System.out.println(sweets[0]);
        
        
        //課題
        //自分の氏名について，バイト数と文字数を取得してください。また，それぞれの値を画面に表示してください。
        String name="波多野陽平";
        System.out.println("バイト数:"+name.getBytes().length);
        System.out.println("文字数:"+name.length());
        
        //変数を宣言し，自分のメールアドレス（架空のものでも構いません）をその値としてください。
        //その後，String クラスのメソッドを利用して，メールアドレスの「@」以降の文字数を画面に表示してください。
        String male="hatano@mail";
        System.out.println("@以降のの文字数:"+male.substring(male.indexOf("@")+1).length());

        //文字列型の変数を宣言して，"きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます" をその値としてください。 
        //宣言した変数について，「I」を「い」に，「U」を「う」に置換した文字列を表示してください。
        String moji="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        System.out.println(moji.replace("I","い").replace("U","う"));
        
    }
}
