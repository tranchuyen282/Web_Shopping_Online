<%-- 
    Document   : index
    Created on : Jun 17, 2020, 3:26:34 AM
    Author     : ADM
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="model.item.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.cart.Cart"%>
<%@ page import="currency.ShowMoney" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOStore</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/cart.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Cart cart = (Cart)session.getAttribute("cart");
            ArrayList<Item> listItem = (ArrayList<Item>) request.getAttribute("listItem");
            Map<String,Integer> lineItem  = cart.getLineItem();
            int totalPrice = 0;
        %>
        
        
            <br>
            <div style="min-height: calc(100vh + 900px);">
                <span style="font-size: 48px; color: orangered; height:100px; width:100px; margin-left: 50px;">
                    <i class="fas fa-shopping-cart" ><b> Giỏ hàng</b></i>
                </span>
                <table >
                    <tr class="info_topnav">
                        <th name="1"><b>Hình ảnh</b></th>
                        <th name="2"><b>Tên sản phẩm</b></th>
                        <th name="3"><b>Số lượng</b></th>
                        <th name="4"><b>Đơn giá</b></th>
                        <th name="5"><b>Thành tiền</b></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <% if(lineItem.size() > 0) { 
                        Set<String> set = lineItem.keySet();
                        for(String key : set){
                            int idItem = Integer.parseInt(key);
                            int quantity = lineItem.get(key);
                            int index = 0;
                            Item item = null;
                            for(int i = 0; i < listItem.size(); i++){
                                if(listItem.get(i).getId() == idItem){
                                    index = i;
                                    item = listItem.get(i);;
                                    break;
                                }
                            }
                            int price = item.getPrice() * quantity;
                            totalPrice += price;
                            String nameQuantity = "quantity" + String.valueOf(idItem);
                    %>
                        <tr class="detail">
                        <td>
                            <a href="item?id=<%=idItem%>">
                            <img src="img/<%=item.getDetail().getImage()%>" width="120px" height="120px">
                            </a>
                        </td>
                        <td><%=item.getNameItem()%></td>
                        <form action ="editcart" id="addCart" method="get">
                            <td><input type="number"  name="quantity" value="<%=quantity%>" min = 1 /></td>
                            <td><%=currency.ShowMoney.fomartMoney(item.getPrice())%></td>
                            <td><%=ShowMoney.fomartMoney(price)%></td>
                            <td>
                                <input type="hidden" name="idItem" value="<%=idItem%>">
                                <a name="btn2" href=""><b><input type="submit" id="edititem" value="Sửa" /></b></a>
                        </form>

                            <form action ="deletecart" id="" method="get">
                                <input type="hidden" id="idItem" name="idItem" value="<%=idItem%>">
                                <a><b><input type="submit" id="deleteitem" value="Xóa" /></b></a>
                            </form>
                            </td>
                        </tr>
                        <% } %>
                    <% } %>
                    
                </table>
                <div>
                <div class="total" >
                    <h3><b> Tổng tiền: <%=ShowMoney.fomartMoney(totalPrice)%></b></h3>
                </div>
                <div class="buy">
                    <form action ="selectaddress" id="addCart" method="get">
                        <input class="btn_buy" type="submit" id="deleteitem" value="Đặt hàng" /> 
                    </form>
                </div>
                </div>
            </div>
        </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
