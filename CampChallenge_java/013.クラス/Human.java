/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.*;
/**
 *
 * @author hatano
 */
public abstract class Human {
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    public abstract int open(); //myCardsのカードの合計値を返却する
    public abstract void setCard(ArrayList<Integer> list); //ArrayListで受けたカード情報をmyCardsに追加する
    public abstract boolean checkSum(); //myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却する
}

class Dealer extends Human{
    ArrayList<Integer> cards = new ArrayList<Integer>();//cardsというArrayListの変数を用意し、初期処理でこのcardsに全てのトランプを持たせてください。
    
    public Dealer(){
        for(int j=0;j<4;j++){
            for(int i=1;i<14;i++){
                if(i>10){this.cards.add(10);} //ここでi=10とすると無限ループしてしまい危険
                else{this.cards.add(i);}
            }
        }
    }
     
    public int open(){
        int sum=0;
        for(int list : myCards){
            sum+=list;
        }
        return sum;
    }
    
    public void setCard(ArrayList<Integer> list){
        for(int lis : list){
            this.myCards.add(lis);
        }
    }
    
    public boolean checkSum(){
        if(this.open()<17){
            return true;
        }
        return false;
    }
    
    
    public ArrayList<Integer> deal(){//cardsからランダムで2枚のカードをArrayListにして返却してください。
        ArrayList<Integer> selected2 = new ArrayList<Integer>();
        for(int i=0;i<2;i++){
            Random r = new Random();
            int index =r.nextInt(cards.size());
            selected2.add(cards.get(index));
            cards.remove(index);
        }
        return selected2;
    }
    
    public ArrayList<Integer>  hit(){//cardsからランダムで1枚のカードをArrayListにして返却してください
        ArrayList<Integer> selected1 = new ArrayList<Integer>();
        Random r = new Random();
        int index =r.nextInt(cards.size());
        selected1.add(cards.get(index));
        cards.remove(index);
        return selected1;
    }
}
    
    
    class User extends Human{
        public User(){
        //this.myCards = new ArrayList();
         }
        public int open(){
           int sum=0;
           for(int list : myCards){
                sum+=list;
           }
           return sum;
        } 
       
        public void setCard(ArrayList<Integer> list){
           for(int lis : list){
                this.myCards.add(lis);
           }
        }
    
        public boolean checkSum(){
            if(this.open()<17){
              return true;
            }
            return false;
        }
    }
 
