<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!-- tao url cho ajax -->
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
                                ${messageResponse}
                            </div>
                        </c:if>
                        
                        <!-- submit form len API -->
                        <form id="formSubmit">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                <div class="col-sm-9">
                               <!--  khong dung categoryID vi no o dang Long. -->
                                    <select class="form-control" id="categoryCode" name="categoryCode">
                                        <c:if test="${empty model.categoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.categoryCode}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}"<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${model.shortDescription}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="content" name="content" style="width: 820px;height: 175px">${model.content}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input name="edit" type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input name="add" type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                         <input type="hidden" value="${model.id}" id="id" name="id"/> 
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    	var editor = '';
		//nhung ham trong ham nay se chay khi giao dien duoc load len
		$(document).ready(function(){
			editor = CKEDITOR.replace('content');
        });
        
		$('#btnAddOrUpdateNew').click(function(e){
            e.preventDefault();
             // serializeArray chuyen field trong form thanh mot mang
             var data = {};
             var formData = $('#formSubmit').serializeArray();
             //duyet mang
             $.each(formData, function (i, v){
                 /*test du lieu console.log(value); */
             	data["" + v.name + ""] = v.value;//key-value
             });
             data["content"] = editor.getData();
             var id = $('#id').val();
             if (id == ""){
            	 addNew(data);
             }else {
            	 updateNew(data);
             }
		});
		
		function addNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'POST',
				//kieu du lieu tu client gui ve server
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
                    window.location.href = "${NewURL}?type=edit&message=insertSuccess&id="+result.id+"";
				},
				error: function (error) {
                    window.location.href = "${NewURL}?type=list&page=1&maxPageItem=4&message=errorSystem";
				}
			});
		}
		
		function updateNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
                    window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=updateSuccess";
				},
				error: function (error) {
                    window.location.href = "${NewURL}?type=edit&id="+data.id+"&message=errorSystem";
				}
			});
		}
</script>

</body>
</html>
