<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MIOSTORE</title>
        <link rel="stylesheet" type="text/css" href="css/LogIn.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
                String msg = null;
                String err = (String)request.getParameter("err");
                if("1".equals(err)){
                    msg = "Đăng nhập không thành công!";
                }else{
                    msg = null;
                }
            %>
        <div id="login" >
            <h2 name="top_login" style="font: Time New Romand; size: 18px">ĐĂNG NHẬP</h2>
            <br></br>
            <form action="<%=request.getContextPath()%>/login" method="post"/>
            <%
                if(msg != null){                
            %>
                <label><b style="size: 16px; color: red"><%=msg%></b></label></br>
                <br></br>
             <%   }
            %>
            <label for="user"><b style="size: 16px">Tên đăng nhập:</b></label></br>
            <input type="text" name ="username" placeholder="Username..."></br>
            <label for="pass"><b style="size: 16px">Mật khẩu:</b></label></br>
            <input type="password" name ="password" placeholder="Password..."></br>
            <br> <br>
            <input type="submit" value="Đăng nhập"/>
            <button><a href="SignIn.jsp">Đăng kí</a></button>
        </div>
        <br/><br/><br/><br/><br/>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>