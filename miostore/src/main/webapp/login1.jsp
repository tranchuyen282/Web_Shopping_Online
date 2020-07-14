<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/login1.css"/>
    </head>
    <body>
        <%
            String msg = null;
            String err = (String)request.getParameter("err");
            if("1".equals(err)){
                msg = "Đăng nhập không thành công!";
            }else{
                msg = null;
            }
        %>
        <div class="login">
            <div class="title">
                <h2 style="size: 24px">ĐĂNG NHẬP</h2>
                <p id="dang_ky"><a href="SignIn.jsp" style="color: red">Đăng ký</a></p>
                <p id="cau_hoi">Bạn mới biết đến MIOStore?</p>
            </div>
            <div class="middle">
                <form action="<%=request.getContextPath()%>/login" method="post"/>
                <%
                    if(msg != null){                
                %>
                    <label><b style="size: 16px; color: red"><%=msg%></b></label></br>
                    <br></br>
                 <%   }
                %>
                <label><b style="size: 18px">Tên đăng nhập:</b></label></br>
                <input type="text" name ="username" placeholder="Username..."></br>
                <label><b style="size: 18px">Mật khẩu:</b></label></br>
                <input type="password" name ="password" placeholder="Password..."></br>
            </div>
            <div class="button">
                <input type="submit" value="Đăng nhập"/>
            </div>
            <div class="icon">
                <p>----------------------------------HOẶC---------------------------------</p>
<%--                <a href="<%=fbConnection.getFBAuthUrl()%>">--%>
<%--                    <img id="fb" src="img/fb.png"/>--%>
<%--                </a>--%>
                <a href="https://www.facebook.com/dialog/oauth?client_id=326058148403130&redirect_uri=https://localhost:8081/miostore/loginfb">
                    <img id="fb" src="img/fb.png"/>
                </a>

                <img id="gp" src="img/gp.png"/>
            </div>
        </div>
    </body>
</html>
