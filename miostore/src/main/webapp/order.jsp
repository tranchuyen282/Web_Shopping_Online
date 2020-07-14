<%-- 
    Document   : index
    Created on : Jun 17, 2020, 3:26:34 AM
    Author     : ADM
--%>

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
            <br><br><br><br><br><br>
            <div style="min-height: calc(100vh + 900px);">
                <span style="font-size: 40px; color: orangered; height:100px; width:100px; margin-left: 50px;">
                    <i class="fas fa-bullhorn">  Đơn hàng của bạn</i>
                </span>
                <table >
                    <tr class="info_topnav">
                        <th name="1"><b>Hình ảnh</b></th>
                        <th name="2"><b>Tên sản phẩm</b></th>
                        <th name="3"><b>Số lượng</b></th>
                        <th name="4"><b>Đơn giá</b></th>
                        <th name="5"><b>Thành tiền</b></th>
                    </tr>

                    <tr class="detail">
                        <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                        <td>Túi channel</td>
                        <td>1</td>
                        <td>25000000</td>
                        <td>25000000</td>
                    </tr>
                    <tr class="detail">
                        <td><img src="img/B2.jpg" width="120px" height="120px"></td>
                        <td>Túi channel</td>
                        <td>1</td>
                        <td>25000000</td>
                        <td>25000000</td>
                    </tr>
                </table>
                <div style="font-size: 20px; width: 60%; margin: auto; margin-top: 20px;">
                    <p>Tên người nhận: Nguyễn Văn A - Địa chỉ: Km10 Trần Phú Hà Đông Hà Nội</p>
                    <p>Số điện thoại: 035894558</p>
                    <p>Phương thức giao hàng: Giao hàng tiết kiệm</p>
                    <p>Phương thức thanh toán: Tiền mặt</p>
                </div>
                <div class="total" >
                    <h3><b> Tổng tiền: 25000 VNĐ </b></h3>
                </div>
                <div class="buy">
                    <button href="" class="btn_buy">Thanh toán</button>
                </div>
                
            </div>
        </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
