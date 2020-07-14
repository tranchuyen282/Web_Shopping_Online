<%@page import="model.customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>
        <link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css" media="all" >
    </head>
    <body>
        <%
            Customer customer = null;
            if(session.getAttribute("customer") != null){
                customer = (Customer)session.getAttribute("customer");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie: cookies){
                    if(cookie.getName().equals("user")) userName = cookie.getValue();
                    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                }
            }
            
            %>
        <div class="header">
           <div class="header-logo">
               <center><a href="home"><img src="<%=request.getContextPath()%>/img/logo1.png" width="147px" height="50px" style="border-radius: 8px;"></a></center>
            </div>
            <div class="header-content">
                <div class="header-search">
                    <form action="searchitem" method="GET">
                        <input type="text" name="searchname" class="txtsearch" placeholder=" Search">
                        <button type="submit" class="btnsearch"><img src="<%=request.getContextPath()%>/img/search.png" with="25px" height="25px"></button>
                    </form>
                </div>
                <div class="header-menu">
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/viewcart"><b>Giỏ hàng</b></a></li>
                        <li><a href="<%=request.getContextPath()%>/order"><b>Đơn hàng</b> </a></li>
                        <%if(customer != null){%>
                        <li><a href=""><img src="img/account.png" width="20x" height="20px"><b> </b><%=userName%></a></li>
                        <li><a href="<%=request.getContextPath()%>/logout"><b>Đăng Xuất</b> </a></li>
                        <%}else{%>
                        <li><a href=""><b>Đăng ký</b> </a></li>
                        <li><a href="<%=request.getContextPath()%>/login"><b>Đăng nhập</b> </a></li>
                        <%}
                        %>
                    </ul>
                </div>
            </div>      
            <div class="topnav">
                <ul>
                    <li><a href="home">Trang chủ</a></li>
                    <li><a href="type?type=Samsung">SamSung</a></li>
                    <li><a href="type?type=Iphone">Iphone</a></li>
                    <li><a href="type?type=Xiaomi">Xiaomi</a></li>
                    <li><a href="type?type=Oppo">Oppo</a></li>
                    <li><a href="type?type=Vsmart">Vsmart</a></li>
                    <li><a href="type?type=phukien">Phụ kiện</a></li>
                </ul>
            </div>
        </div>
        <br/><br/><br/><br/>
    </body>
</html>