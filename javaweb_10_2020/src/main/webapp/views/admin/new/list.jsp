<%@include file="/common/taglib.jsp"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Danh sách bài viết</title>
  </head>
  <body>
   <div class="main-content">
    <form method="get" id="formSubmit" action="<c:url value='/admin-new'/>" >
        <div class="main-content-inner">
          <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
              <li>
                <i class="ace-icon fa fa-home home-icon"></i>
                <a href="#">Trang chủ</a>
              </li>
            </ul>
            <!-- /.breadcrumb -->
          </div>
          <div class="page-content">
            <div class="row">
              <div class="col-xs-12"></div>
              <div class="row">
                <div class="col-xs-12">
                  <div class="table-reponsive">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>Tên bài viết</th>
                          <th>Mô tả ngắn</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="item" items="${model.listResult}">
                          <tr>
                            <td>${item.title}</td>
                            <td>${item.shortDescription}</td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="" id="page" name="page" />
                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    </form>
     </div>
    <script>
      $(function () {
	  	var totalPages = ${model.totalPage};
   		var currentPage = ${model.page};
      	var limit = 2;     // tong so item hien thi tren 1 page
        window.pagObj = $("#pagination").twbsPagination({
          totalPages: totalPages,
          visiblePages: 4,
          startPage: currentPage,
          onPageClick: function (event, page) {
            /* 	console.info(page + ' (from options)'); */
            if(currentPage != page){
            $('#maxPageItem').val(limit);
            $('#page').val(page);
            $('#formSubmit').submit();
            }
          }
        });
      });
    </script>
  </body>
</html>