<%-- 
    Document   : orders
    Created on : Jun 19, 2020, 8:54:38 AM
    Author     : lanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIOStore</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/orders.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <br><br><br><br><br><br>
            <div style="min-height: calc(100vh + 900px);">
                <span style="font-size: 40px; color: orangered; height:100px; width:100px; margin-left: 50px;">
                    <i class="fas fa-bullhorn">  Lịch sử đơn mua</i>
                </span>
                <div class="a-order" style="margin-bottom: 150px">
                    <p class="id-order"><b>ID đơn hàng: 1 - Trạng thái đơn hàng: Giao thành công</b></p>
                    <table >
                        <tr class="info_topnav">
                            <th name="1"><b>Hình ảnh</b></th>
                            <th name="2"><b>Tên sản phẩm</b></th>
                            <th name="3"><b>Số lượng</b></th>
                            <th name="4"><b>Thành tiền</b></th>
                        </tr>

                        <tr class="detail">
                            <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                            <td>Túi channel</td>
                            <td>1</td>
                            <td>25000000</td>
                        </tr>
                        <tr class="detail">
                            <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                            <td>Túi channel</td>
                            <td>1</td>
                            <td>25000000</td>
                        </tr>
                    </table>
                    <div class="total"> <b>Tổng tiền: 250000000</b></div>
                    <div>
                        <button class="btn_buy_again">Mua lần nữa</button>
                        <button class="btn_detail">Xem chi tiết đơn hàng</button>
                    </div>
                </div>
                <div class="a-order">
                    <p class="id-order"><b>ID đơn hàng: 1 - Trạng thái đơn hàng: Giao thành công</b></p>
                    <table >
                        <tr class="info_topnav">
                            <th name="1"><b>Hình ảnh</b></th>
                            <th name="2"><b>Tên sản phẩm</b></th>
                            <th name="3"><b>Số lượng</b></th>
                            <th name="4"><b>Thành tiền</b></th>
                        </tr>

                        <tr class="detail">
                            <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                            <td>Túi channel</td>
                            <td>1</td>
                            <td>25000000</td>
                        </tr>
                        <tr class="detail">
                            <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                            <td>Túi channel</td>
                            <td>1</td>
                            <td>25000000</td>
                        </tr>
                    </table>
                    <div class="total"> <b>Tổng tiền: 250000000</b></div>
                    <div>
                        <button class="btn_buy_again">Mua lần nữa</button>
                        <button class="btn_detail">Xem chi tiết đơn hàng</button>
                    </div>
                </div>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>

</html>
