<%@ page import="model.order.Order" %>
<%@ page import="model.cart.Cart" %>
<%@ page import="model.delivery.Delivery" %>
<%@ page import="model.customer.Address" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="model.item.Item" %>
<%@ page import="model.product.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="currency.ShowMoney" %><%--
    Document   : Payment2
    Created on : Jun 30, 2020, 9:36:24 PM
    Author     : ADM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOStore</title>
        <link rel="stylesheet" type="text/css" href="css/Payment2.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Order order = (Order) session.getAttribute("order");
            Cart cart = order.getCart();
            Map<String,Integer> lineItem  = cart.getLineItem();
            ArrayList<Item> listItem = (ArrayList<Item>) request.getAttribute("listItem");
            Delivery delivery = order.getDelivery();
            int totalPrice = 0;
            Address address = delivery.getAddress();

        %>
        <div class="payment">
            <div class="payment_title">
                <h3>XÁC NHẬN - THANH TOÁN</h3>
            </div>
            <div class="payment_address">
                <div class="address_title">
                    <p style="color: red; font-size: 20px"><b>Địa chỉ nhận hàng</b></p>
                </div>
                <div class="address_info">
                    <div class="info1">
                        <p><b><%=address.getNameReceiver()%></b></p></br>
                        <p><b><%=address.getPhoneReceiver()%></b></p>
                    </div>
                    <div class="info2">
                        <p><%=address.getAdd()%></p>
                    </div>
                    <div class="mac_dinh">
                        <p  style="color: #5e5e5e"><i>Mặc định</i></p>
                    </div>
                    <div class="thay_doi">
                        <p style="color: mediumseagreen"><a href="selectaddress">THAY ĐỔI</a></p>
                    </div>
                </div>
            </div>
            <div class="payment_delivery">
                <div class="payment_delivery_title">
                    <p style="color: red; font-size: 20px"><b>Đơn vị vận chuyển</b></p>
                </div>
                <div class="payment_delivery_info">
                    <p>Giao hàng nhanh</p>
                    <p><%="Phương thức: "+delivery.getDeliveryMethod().getShort_name()%></p>
                    <p><%="Phí: "+ShowMoney.fomartMoney(delivery.getDeliveryMethod().getTotalFee())%></p>
                    <p><%="Thời gian giao hàng dự kiến: "+delivery.getDeliveryMethod().getLeadtime()%></p>
                </div>
            </div>
            <div class="list_item">
                <div class="list_item_top">
                    <div class="san_pham">
                        <p style="font-size: 16px"><b>Sản phẩm</b></p>
                    </div>
                    <div class="don_gia">
                        <p style="color: gray">Đơn giá</p>
                    </div>
                    <div class="so_luong">
                        <p style="color: gray">Số lượng</p>
                    </div>
                    <div class="thanh_tien">
                        <p style="color: gray">Thành tiền</p>
                    </div>
                </div>
                <div class="list_item_detail">
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
                            totalPrice += quantity*item.getPrice();


                    %>
                    <ul>
                        <img src="img/<%=item.getDetail().getImage()%>" width="50px" height="50px">
                        <p id="description"><%=item.getNameItem()%></p>
                        <p id="dongia_item"><%=currency.ShowMoney.fomartMoney(item.getPrice())%></p>
                        <p id="soluong_item"><%=quantity%></p>
                        <p id="thanhtien_item"><%=currency.ShowMoney.fomartMoney(quantity*item.getPrice())%></p>
                        </br></br></br></br>
                    </ul>
                    <%}}%>
                </div>
                <div class="list_item_bottom">
                    <div class="title">
                        <p>Tổng số tiền:</p>
                    </div>
                    <div class="total">
                        <p style="color: red; size: 16px"><%=ShowMoney.fomartMoney(totalPrice)%></p>
                    </div>
                </div>
            </div>
            <form action = "checkout" id = "newAddress" method="post">
            <div class="payment_type">
                <p style="color: red; font-size: 20px"><b>Phương thức thanh toán</b></p></br>
                <input type="radio" name="thanhtoan" value = "cod" checked = "checked"> Tiền mặt khi nhận hàng</br>
                <input type="radio" name="thanhtoan" value = "bank"> Thanh toán bằng thẻ
            </div>
            <div class="payment_final">
                <div class="final_left">
                    <ul>
                        <li><p>Tổng tiền hàng:</p></li>
                        <li><p>Phí vận chuyển:</p></li>
                        <li><p>Tổng thanh toán:</p></li>
                    </ul>
                </div>
                <div class="final_right">
                    <ul>
                        <li><%=ShowMoney.fomartMoney(totalPrice)%></li>
                        <li><%=ShowMoney.fomartMoney(delivery.getDeliveryMethod().getTotalFee())%></li>
                        <li><b style="color: red"><%=ShowMoney.fomartMoney(totalPrice+delivery.getDeliveryMethod().getTotalFee())%></b></li>
                    </ul>
                </div>
                <input type="submit" value="Đặt hàng">
            </div>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
