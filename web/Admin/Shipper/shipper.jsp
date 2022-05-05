
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
    <h2>Shipper</h2>
    
    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#create-form" aria-expanded="false" aria-controls="collapseExample">
        Create
    </button>
    
    <div class="card card-body collapse" id="create-form">
        <form action="/shipper-manage" class="form-container">
          <input type="hidden" class="form-control" placeholder="Category name" name="id" value="-1">

          <label for="psw"><b>Name</b></label>
          <input type="text" class="form-control" placeholder="Category name" name="name" required>
          
          <label for="psw"><b>Phone</b></label>
          <input type="text" class="form-control" placeholder="Phone" name="sdt" required>

          <button type="submit" class="btn" name="action" value="Create">Save</button>
        </form>
    </div>
    
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Category ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Handle</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${listShipper}" var="o" >
              <tr>
                <td>${o.id}</td>
                <td>${o.name}</td>
                <td>${o.sdt}</td>
                <td>
                    <button class="btn btn-success" onclick="openEditForm(${o.id},'${o.name}','${o.sdt}')" >Edit</button>
                    <c:if test="${o.getDeleted()==0}">
                        <button class="btn btn-danger" onclick="Delete(${o.id})">Delete</button>
                    </c:if>
                    <c:if test="${o.getDeleted()==1}">
                        <button class="btn btn-warning" onclick="Retrieve(${o.id})">Retrieve</button>
                    </c:if>
                </td>
              </tr>
        </c:forEach>
    </tbody>
    </table>
  
    <div class="form-popup" id="edit-form">
        <h2>Edit Form</h2>
        <form action="/shipper-manage" class="form-container">

          <label for="id"><b>ID</b></label>
          <input type="text" placeholder="" name="id" required>

          <label for="name"><b>Name</b></label>
          <input type="text" placeholder="" name="name" required>
          
          <label for="sdt"><b>Phone</b></label>
          <input type="text" placeholder="" name="sdt" required>

          <button type="submit" class="btn" name="action" value="Edit">Save</button>
          <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
        </form>
    </div>
    
    <script>
        function openEditForm(id,name,sdt) {
            document.getElementById("edit-form").style.display = "block";
            
            $('input[name="id"]').val(id);
            $('input[name="name"]').val(name);
            $('input[name="sdt"]').val(sdt);
        }

        function closeEditForm() {
          document.getElementById("edit-form").style.display = "none";
        }
        
        function Delete(id) {
            var id = id;
            var action = "Delete";
            $.ajax({
                type: "get",
                url: "/shipper-manage",
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
                type: "get",
                url: "/shipper-manage",
                data: {id:id,action:action},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: "+id);
                }
              });
        }
        
        function Create(name,sdt) {
            var id = -1;
            var name = name;
            var sdt = sdt;
            var action = "Create";
            $.ajax({
                type: "post",
                url: "/category-manage",
                data: {id:id,sdt:sdt,action:action,name:name},
                success: function(){
                    $('.section .container').load(' .section .container');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("lỗi rồi bro: ");
                }
              });
        }

    </script>
</div>

</div>