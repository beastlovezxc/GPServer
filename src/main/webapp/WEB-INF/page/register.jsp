<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="javascript/jquery.min.js"></script>
<!----webfonts--->
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->  
<!-- Bootstrap Core JavaScript -->
<script src="javascript/bootstrap.min.js"></script>
</head>
<body id="login">
  <div class="login-logo">
    <a href="index.html"><img src="images/logo.png" alt=""/></a>
  </div>
  <h2 class="form-heading">Register</h2>
  <form class="form-signin app-cam" action="register.html" method="post">
      <p>请输入如下信息</p>
      <input type="text" name="userName" class="form-control1" placeholder="用户名" autofocus="">
      <input type="password" name="password" class="form-control1" placeholder="password" autofocus="">
      <div class="radios">
        <label for="radio-01" class="label_radio">
            <input type="radio" checked=""> 管理员
        </label>
        <label for="radio-02" class="label_radio">
            <input type="radio"> 普通用户
        </label>
	  </div>
      <label class="checkbox-custom check-success">
          <input type="checkbox" value="agree this condition" id="checkbox1"> <label for="checkbox1">I agree to the Terms of Service and Privacy Policy</label>
      </label>
      <button class="btn btn-lg btn-success1 btn-block" type="submit">注册</button>
      <div class="registration">
          已有账户.
          <a class="" href="login.html">
              登录
          </a>
      </div>
  </form>
   <div class="copy_layout login register">
      <p>Copyright &copy; 2016.Bean.Cb All rights reserved.
   </div>
</body>
</html>
