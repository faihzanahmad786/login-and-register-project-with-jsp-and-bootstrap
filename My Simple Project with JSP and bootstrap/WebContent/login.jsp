<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.mysimpleproject.dao.LoginDao"%>
<%@page import="com.mysimpleproject.bean.UserBean"%>
<%@page import="com.mysimpleproject.servlet.LoginServlet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link href="https://getbootstrap.com/docs/5.0/examples/sign-in/signin.css" rel="stylesheet">
        <title>Login</title>

</head>
<body class="text-center" data-new-gr-c-s-check-loaded="14.1001.0" data-gr-ext-installed="">
    
<main class="form-signin">
  <form action="<%=request.getContextPath()%>/login" method="post">
    <img class="mb-4" src="https://png.pngtree.com/png-vector/20191110/ourlarge/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396.jpg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="Marydawson@123" name="username">
      <label for="floatingInput">Username</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">Password</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button><br/>
    <a class="btn btn-sm btn-outline-secondary" href="register.jsp">New User Register Here</a><br/>
    <p class="mt-5 mb-3 text-muted">© 2017–2021</p>
  </form>
</main>

</body>
</html>