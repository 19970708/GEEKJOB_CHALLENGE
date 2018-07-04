class Main{
  public static void main(String[] args) {
    for(int i=1;i<=40;i++){
      System.out.print(i);
      if(i%3==0 || String.valueOf(i).indexOf("3") != -1){
        System.out.print("アホになる");
      }
      System.out.println("");
    }
  }
}
