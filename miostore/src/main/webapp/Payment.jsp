<%-- 
    Document   : Payment
    Created on : Jun 18, 2020, 6:50:28 PM
    Author     : ADM
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="model.item.Item"%>
<%@page import="model.product.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.cart.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOSTORE</title>
        <link rel="stylesheet" type="text/css" href="css/Payment.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Cart cart = (Cart)session.getAttribute("cart");
            ArrayList<Item> listItem = (ArrayList<Item>) request.getAttribute("listItem");
            Map<String,Integer> lineItem  = cart.getLineItem();
            Double totalPrice = 0d;
            Double feeShip = Double.parseDouble("0");
            
        %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <form action ="checkout" id = "myForm" method="post">
            <div class="payment">
                <div class="payment_title">
                    <h3>XÁC NHẬN - THANH TOÁN</h3>
                </div>
                <div class="payment_left">

                    <div class="left_1">
                        <ul>
                            <li><b>Địa chỉ nhận hàng</b></li>
                            <li><a href="Address.jsp">Thay đổi</a></li></br>
                        </ul>
                        <p>Nguyễn Thị Phương|0989671646</p>
                        <p>Gần đại học Hà Nội, xe bus, Phường Mộ Lao, Quận Hà Đông, Hà Nội</p></br>
                    </div>
                    <div class="left_2">
                        <li><b>Phương thức vận chuyển</b></li></br>                      
                        <input type="radio" id ="ghn" name="vanchuyen" value = "ghtk"> Giao hàng tiết kiệm: 30.000</br>
                        <input type="radio" id = "ghtk" name="vanchuyen" value = "ghn"> Giao hàng nhanh: 35.000
                        
                    </div>
                    <div class="left_3">
                        <li><b>Phương thức thanh toán</b></li></br>
                        <input type="radio" name="thanhtoan" value = "cod"> Tiền mặt khi nhận hàng</br>
                        <input type="radio" name="thanhtoan" value = "bank"> Thanh toán bằng thẻ
                    </div>
                </div>
                <div class="payment_right">
                    <div class="right_1">
                        <li><b>Mã khuyến mãi</b></li>
                        <input type="text" name ="maKhuyenMai" placeholder="Nhập mã giảm giá">
                        <input type="submit" name ="apdung" value="Áp dụng">
                    </div>
                    <div class="right_2">
                        <div class="title">
                            <b>Thông tin đơn hàng</b>
                        </div>
                        <div class="detail">
                            <div class="info_item">
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
                                    Product product = listProduct.get(index);
                                    //String urlItem = item.getUrlImg(product);
                                    Double price = item.getPrice() * quantity;
                                    totalPrice += price;
                                    String nameQuantity = "quantity" +  String.valueOf(idItem);
                            %>
                                <ul>
                                    <img src="img/<%=item.getUrlImg(product)%>" width="80px" height="100px">
                                    <b></b></br></br>
                                    <p><%=item.getNameItem()%></p>
                                    <p>Số lượng: <%=quantity%></p>
                                    <p>Đơn giá: <%=item.getPrice()%></p>
                                    <p><b>Thành tiền: <%=price%></b></p></br>
                                </ul>
                                
                                <% } }%>
                                <script type="text/javascript">
                            $('#myForm input').on('change', function() {
//                                alert($('input[name=vanchuyen]:checked', '#myForm').val());
                                if($('input[name=vanchuyen]:checked', '#myForm').val() == 'ghtk'){
                                    document.getElementById("feeShip").innerHTML = 'Phí ship: 30000 VNĐ';
                                    document.getElementById("totalPrice").innerHTML = 'Tổng tiền: ' + <%=( totalPrice + Double.parseDouble("30000") )%> +'VNĐ';
                                   
                                }else{
                                    document.getElementById("feeShip").innerHTML = 'Phí ship:35000 VNĐ' ;
                                    document.getElementById("totalPrice").innerHTML = 'Tổng tiền: ' + <%=( totalPrice + Double.parseDouble("35000") )%> +'VNĐ';
                                }
                                
                            });
                
                        </script>
                                    <p id = "feeShip"></p>
                                    
                                    <p id = "totalPrice"></p>
                                    <input type="submit" name ="dathang" value="Đặt hàng">
                            </div>

                        </div>
                    </div>
                    
                    
                </div>
            </div>
        </form>
    </body>
</html>
