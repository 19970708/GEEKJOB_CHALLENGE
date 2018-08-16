<%-- 
    Document   : kueristring
    Created on : 2018/06/20, 11:16:38
    Author     : hatano


▼フォームで入力できる値
・total ... 購入した商品の総額
・count ... 購入した商品の数量
・type ... 商品種別
（type の数値は， 1 が「雑貨」，2 が「生鮮食品」， 3 が「その他」になります）

※GETでデータを送信する様にしましょう。


■出力画面
・query_string_output.jsp ... クエリストリングを取得する処理をします

▼処理内容
1.total,count,type の値を取得し，値が画面に表示される
　※typeは数字ではなく，対応する商品種別が表示される様にしましょう
　
2.商品の単価が画面に表示される

3.商品購入総額に応じてポイントを計算し，その値が画面に表示される
　※ポイントは商品購入総額を基準にして，以下の様に算出する 
　　3000 円未満 ... 0% 
　　3000 円以上で5000円未満 ... 購入総額の 4% 
　　5000 円以上 ... 購入総額の 5%
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           request.setCharacterEncoding("UTF-8");
            
           int total=Integer.valueOf(request.getParameter("total"));
           int count=Integer.valueOf(request.getParameter("count"));
           int type=Integer.valueOf(request.getParameter("type"));
           String typeName;
           int tannka=total/count;
           double point=0;
           
           if(type==1){
               typeName="雑貨";
           }else if(type==2){
               typeName="生鮮食品";
           }else if(type==3){
               typeName="その他";
           }else{
               typeName="1~3を入力してください";
           }
           
           if(total<3000 && total>=0){
           }else if(total<5000){
               point=total*0.04;
           }else{
               point=total*0.05;
           }
           
           out.print("総額:"+total+"円<br>");
           out.print("数量:"+count+"個<br>");
           out.print("種類:"+typeName+"<br>");
           out.print("購入した商品の単価:"+tannka+"円<br>");
           out.print("ポイント:"+point+"<br>");
        %>
    </body>
</html>
