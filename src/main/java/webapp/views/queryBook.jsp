<%--
  Created by IntelliJ IDEA.
  User: 南风
  Date: 2024/6/3
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<tbody>

<!--循环显示图书信息-->
<c:forEach items = "${books}" var = "book">
    <tr>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.press}</td>
        <td>${book.isbn}</td>
        <td>${book.publishTime}</td>
        <td>${book.price}</td>
        <td>${book.storage}</td>
        <td class = "text-center">
            <!--如果图书库存大于0，节约按钮有效，否则无效-->
            <c:if text = "${book.storage>0}">
                <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                        data-target="#bookModal" onclick="borrowBook('${book.isbn}')">借阅</button>
            </c:if>
            <c:if text="${book.storage==0}" >
                <button type="button" class="btn bg-olive btn-xs" disabled="true">借阅</button>
            </c:if>
        </td>
    </tr>
</c:forEach>
</tbody>

<!--引入图书信息模态窗口页面-->
<jsp:include page="/views/bookModal.jsp"></jsp:include>
<script type="text/javascript">
    //定义js方法
    function borrowBook(isbn){
        var url = "${pageContext.request.contextPath}/book/queryBookVByIsbn?isbn = " + isbn;
        $.get(url,function (data){
            $("#mark").val("借阅");
            $("#name").val("data.name");
            $("#author").val("data.author");
            $("#press").val("data.press");
            $("#isbn").val("data.isbn");
            $("#publishTime").val("data.publishTime");
            $("#price").val("data.price");
            $("#storage").val("data.storage");
        })
    }
</script>

<script type="text/javascript">
    //定义js方法
    function manage(){
        var mark = $("#mark").val();
        if (mark == "借阅"){
            var url = "${pageContext.request.contextPath}/book/borrow";
            $.post(url,$("#manageBook").serialize(),function (status){
                if(status == true){
                    window.location.herf = "${pageContext.request.contextPath}/book/query";
                }
            })
        }
    }
</script>


</html>
