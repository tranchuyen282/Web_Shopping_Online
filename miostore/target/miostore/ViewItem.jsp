<%-- 
    Document   : ViewItem
    Created on : Jun 18, 2020, 4:31:23 PM
    Author     : ADM
--%>

<%@page import="model.customer.Customer"%>
<%@page import="java.util.Map"%>
<%@page import="model.item.Item"%>
<%@ page import="currency.ShowMoney" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOSTORE</title>
        <link rel="stylesheet" type="text/css" href="css/ViewItem.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
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
        <%
            Item item = (Item)request.getAttribute("item");
            String nameItem = item.getNameItem();
            int price = item.getPrice() ;
            String urlImage = item.getDetail().getImage();
            String quantity = String.valueOf(item.getQuantity()) + " sản phẩm có sẵn";
            String msg = request.getParameter("add");
        %>
        
        
        <div class="view_item">
            <div class="item_info">
                <div class="image">
                    <img src="img/<%=urlImage%>" width="400px" height="400px">
                </div>
                <div class="item_info_right">
                    <div class="name">
                        <h3 style="color: blue"><%=nameItem%></h3>
                    </div>
                    <div class="price">
                        <h2 style="color: red"><%=ShowMoney.fomartMoney(price)%></h2>
                    </div>
                    <div class="discount">
<%--                        <ul>--%>
<%--                            <li><b style="color: black; size: 16px">Mã giảm giá</b></li>--%>
<%--                            <li>abc</li>--%>
<%--                            <li>def</li>--%>
<%--                            <li>ghk</li>--%>
<%--                        </ul>--%>
                    </div>
                    </br></br></br>
                    <div class="color">
                        <ul>
                            <li><b style="color: black; size: 16px">Màu sắc</b></li>
                            <li><%=item.getDetail().getColor()%></li>
                        </ul>
                    </div>
                    </br></br></br></br>
                    <form action ="addcart" id="addCart" method="get">
                        <div class="number">
                            <ul>
                                <li><b style="color: black; size: 16px">Số lượng</b></li>
                                <li><input type="number" name="quantity" value="1" min = 1 /></li>
                                <input type="hidden" id="custId" name="id" value="<%=item.getId()%>">
                                <li><b><%=quantity%></b></li>
                            </ul>
                        </div>
                        </br></br></br></br>
                        <div class="button">
                            <ul>
                                <li><input type="submit" id="addCart" value="Thêm vào giỏ hàng" /></li>
                                <% if("1".equals(msg)){ %>
                                <script type="text/javascript">
                                    alert("Đã thêm sản phẩm");
                                </script>
                                    
                                <%}%>
                            </ul>
                        </div>
                    </form>
                   
                </div>
            </div>
            <div class="item_detail">
                <h3>CHI TIẾT SẢN PHẨM</h3>
                <ul>
                    <li><b>Hệ điều hành: <%=item.getDetail().getModel()%></b></li>
                    <li><b>Bộ nhớ:       <%=item.getDetail().getMemory() +"GB"%></b></li>
                    <li><b>Hãng sản xuất:   <%=item.getDetail().getProvider()%></b></li>
                    <li><b>Màu sắc:       <%=item.getDetail().getColor()%></b></li>
                    <li><b>......</b></li>
                    <li><b>......</b></li>
                </ul>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
