<?php
header ( "Content-type:text/html;charset=utf-8" ); 
$insertSQL=isset($_POST["S1"]);
$con = mysqli_connect("localhost","root","0000","pccu_project");//("伺服器名稱","使用者帳號","使用者密碼","資料庫名稱")
    if($con){

        echo"登入成功";//(登入成功就輸出ok)

    }else{

        echo"未登入資料庫";//(失敗就輸出error)    

    }
$con->set_charset('utf8');
mysqli_query($con,"set names utf8");//$con使用此資料庫，逗點後面使用mysqli語法執行
mysqli_query($con,"SELECT * FROM users_table");//("SELECT * FROM 資料表名稱")
$result=$con->query("SELECT * FROM users_table");//("SELECT * FROM 資料表名稱")


?>


 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>資料庫網頁建置</title>

</head>


<body>
　　<hr color="#ff8000"> 
  
  <?php 
  echo '<table>'; 
  while ($data=$result->fetch_object()) {//fetch_object迴圈                             
  print_r(json_encode($data,JSON_UNESCAPED_UNICODE));//印出資料庫所有資料
  }

   ?>
  
　　<hr color="#ff8000">

</body>

</html>