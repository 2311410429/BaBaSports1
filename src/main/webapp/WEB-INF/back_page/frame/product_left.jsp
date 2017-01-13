<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>product-left</title>
    <link href="/res/itcast/css/admin.css" rel="stylesheet" type="text/css"/>
    <link href="/res/common/css/theme.css" rel="stylesheet" type="text/css"/>
    <link href="/res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
    <link href="/res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
    <link href="/res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

    <!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
    <!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
    <script type="text/javascript" src="/res/fckeditor/fckeditor.js"></script>
    <script src="/res/common/js/jquery.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.ext.js" type="text/javascript"></script>
    <script src="/res/common/js/jquery.form.js" type="text/javascript"></script>
    <script src="/res/common/js/itcast.js" type="text/javascript"></script>
    <script src="/res/itcast/js/admin.js" type="text/javascript"></script>
</head>
<body class="lbody">
<div class="left">
    <%@ include file="/WEB-INF/back_page/date.jsp" %>
    <ul class="w-lful">
        <li><a href="product/list.do" target="rightFrame">商品管理</a></li>
        <li><a href="${pageContext.request.contextPath}/brand/list.do" target="rightFrame">品牌管理</a></li>
        <li><a href="back.do?url=type/list" target="rightFrame">类型管理</a></li>
    </ul>
</div>
</body>
</html>