
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="../../css/popup-form.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<jsp:include page="../Common/HeaderAndNav.jsp" />

<div class="section">

    <div class="container">
        <h2>Brand</h2>

        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#create-form" aria-expanded="false" aria-controls="collapseExample">
            Create
        </button>

        <div class="card card-body collapse" id="create-form">

              <label for="psw"><b>Name</b></label>
              <input type="text" class="form-control" placeholder="Brand name" name="name" required>

              <button class="btn btn-success" onclick="Create($('#create-form input').val())">Submit</button>
        </div>

        <table class="table table-striped">
        <thead>
          <tr>
            <th>Brand ID</th>
            <th>Brand name</th>
            <th>Handle</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${listBrand}" var="o" >
                  <tr>
                    <td>${o.bID}</td>
                    <td>${o.bName}</td>
                    <td>
                        <button class="btn btn-success" onclick="openEditForm(${o.bID},'${o.bName}')" >Edit</button>
                        <c:if test="${o.getIsDeleted()==0}">
                            <button class="btn btn-danger" onclick="Delete(${o.bID})">Delete</button>
                        </c:if>
                        <c:if test="${o.getIsDeleted()==1}">
                            <button class="btn btn-warning" onclick="Retrieve(${o.bID})">Retrieve</button>
                        </c:if>
                    </td>
                  </tr>
            </c:forEach>
        </tbody>
        </table>

        <div class="form-popup" id="edit-form">
            <h2>Edit Form</h2>
            <form action="/brand-manage" class="form-container">

              <label for="email"><b>ID</b></label>
              <input type="text" placeholder="" name="bID" required>

              <label for="psw"><b>Name</b></label>
              <input type="text" placeholder="" name="name" required>

              <button type="submit" class="btn" name="action" value="Edit">Save</button>
              <button type="button" class="btn cancel" onclick="closeEditForm()">Close</button>
            </form>
        </div>

        <script>
            function openEditForm(bID,bName) {
                document.getElementById("edit-form").style.display = "block";

                $('input[name="bID"]').val(bID);
                $('input[name="name"]').val(bName);
            }

            function closeEditForm() {
              document.getElementById("edit-form").style.display = "none";
            }

            function Delete(bID) {
                var bID = bID;
                var action = "Delete";
                $.ajax({
                    type: "get",
                    url: "/brand-manage",
                    data: {bID:bID,action:action},
                    success: function(){
                        $('.section .container').load(' .section .container');
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("lỗi rồi bro: "+bID);
                    }
                  });
            }

            function Retrieve(bID) {
                var bID = bID;
                var action = "Retrieve";
                $.ajax({
                    type: "get",
                    url: "/brand-manage",
                    data: {bID:bID,action:action},
                    success: function(){
                        $('.section .container').load(' .section .container');
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("lỗi rồi bro: "+ bID);
                    }
                  });
            }

            function Create(bName) {
                var bID = -1;
                var name = bName;
                var action = "Create";
                $.ajax({
                    type: "post",
                    url: "/brand-manage",
                    data: {bID:bID,action:action,name:name},
                    success: function(){
                        $('.section .container').load(' .section .container');
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("lỗi rồi bro: "+ bID);
                    }
                  });
            }

        </script>
    </div>

</div>
