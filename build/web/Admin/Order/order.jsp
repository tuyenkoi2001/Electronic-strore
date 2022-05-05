
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
    <h2>Order</h2>
    
    
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Order ID</th>
        <th>Date</th>
        <th>Receiver</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Shipper</th>
        <th>Handle</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${listOrder}" var="o" >
              <tr>
                <td>${o.getMahoadon()}</td>
                <td>${o.getNgayLap()}</td>
                <td>${o.getNguoiNhan()}</td>
                <td>${o.getNoiNhan()}</td>>
                <td>${o.getPhone()}</td>
                <td>
                    <select name="shipper" id="shipper" class="bg-light" >
                        <c:forEach items="${listShipper}" var="p">
                            <option value="${p.id}" >${p.name}</option>
                        </c:forEach>
                    </select> 
                </td>
                <td>
                    <button class="btn btn-success" onclick="openDetailForm('${o.getMahoadon()}','${o.getIdUser()}')" >Detail</button>
                    <button class="btn btn-danger" onclick="Accept( '${o.getMahoadon()}' )">Accept</button>    
                    <button class="btn btn-danger" onclick="Refuse( '${o.getMahoadon()}' )">Refuse</button>                    
                </td>
              </tr>
        </c:forEach>
    </tbody>
    </table>
  
    <div class="form-popup" id="edit-form">
        
    </div>
    
    <script>
        function openDetailForm(id,user) {
            document.getElementById("edit-form").style.display = "block";
            var id = id;
            var action = "Detail";
            
            $.ajax({
                type: "post",
                url: "/order-manage",
                data: {id:id,action:action,user:user},
                success: function(data){
                    $('.form-popup').html(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(id+""+action);
                }
              });
        }

        function closeEditForm() {
          document.getElementById("edit-form").style.display = "none";
        }
        
        function Accept(id) {
            var id = id;
            var action = "Accept";
            var shipperid;
            $('.table tr').each(function() {
               shipperid = $(this).find("#shipper").val();    
            });

            $.ajax({
                type: "get",
                url: "/order-manage",
                data: {id:id,action:action,shipperid:shipperid},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
        function Refuse(id) {
            var id = id;
            var action = "Refuse";
            $.ajax({
                type: "get",
                url: "/order-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
    </script>
</div>

</div>