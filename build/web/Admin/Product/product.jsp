
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
    <h2>Product</h2>
    <form action="/product-manage?action=Create&id=-1" method="get">
        <input type="text" value="-1" name="id" hidden>
        <input type="submit" value="Create" name="action" class="btn btn-success"/>
    </form>
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Image</th>
        <th>Name</th>
        <th>Cost($)</th>
        <th>Available</th>
        <th>Handle</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${listProduct}" var="o" >
              <tr>
                <td><img src="/images/products/${o.img[0]}" alt="alt" style="height: 100px;"/></td>
                <td>${o.name}</td>
                <td>${o.cost}</td>
                <td>${o.available}</td>
                <td>
                    <button class="btn btn-success" onclick="openEditForm(${o.id})" >Edit</button>
                    <c:if test="${o.getIsDeleted() == 0}">
                        <button class="btn btn-danger" onclick="Delete(${o.id})">Delete</button>
                    </c:if>
                    <c:if test="${o.getIsDeleted() == 1}">
                        <button class="btn btn-success" onclick="Retrieve(${o.id})">Retrieve</button>
                    </c:if>
                </td>
                <td>
                    <form action="/product-manage?action=Detail&id=${o.id}" method="get">
                        <input type="text" value="${o.id}" name="id" hidden/>
                        <input type="submit" value="Detail" name="action" class="btn btn-success"/>
                    </form>
                </td>
              </tr>
        </c:forEach>
    </tbody>
    </table>
  
    <div class="form-popup" id="edit-form">
        
    </div>
    
    <script>
        function openEditForm(id) {
            document.getElementById("edit-form").style.display = "block";
            var id = id;
            var action = "Edit";
            
            $.ajax({
                type: "post",
                url: "/product-manage",
                data: {id:id,action:action},
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
        
        function Delete(id) {
            var id = id;
            var action = "Delete";
            $.ajax({
                type: "post",
                url: "/product-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
        function Retrieve(id) {
            var id = id;
            var action = "Retrieve";
            $.ajax({
                type: "post",
                url: "/product-manage",
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