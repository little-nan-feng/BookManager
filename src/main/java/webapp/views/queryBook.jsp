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

</tbody>
</html>
