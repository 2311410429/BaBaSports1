<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>babasport-list</title>
    <script type="text/javascript">
        function getTableForm() {
            return document.getElementById('tableForm');
        }
        function optDelete() {
            if (Pn.checkedCount('ids') <= 0) {
                alert("请至少选择一个!");
                return;
            }
            if (!confirm("确定删除吗?")) {
                return;
            }
            var f = getTableForm();
            f.action = "o_delete.do";
            f.submit();
        }
        function changePageNo() {
            $("input[name='pageNo']").val(1);
        }
    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 商品管理 - 列表</div>
    <form class="ropt">
        <input class="add" type="button" value="添加" onclick="javascript:window.location.href='${pageContext.request.contextPath}/product/add.do'"/>
    </form>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form action="/product/list.do" method="post" style="padding-top:5px;">
        <input type="hidden" value="1" name="pageNo"/>
        名称: <input type="text" value="${name}" name="name"/>
        <select name="brandId">
            <option value="">请选择品牌</option>
            <c:forEach items="${allBrands}" var="brand">
                <option value="${brand.id}" <c:if test="${brandId ==brand.id}">selected="selected" </c:if>   >
                      ${brand.name}
                </option>
            </c:forEach>
        </select>

        <select onchange="changePageNo()" name="isShow">
                <option value="1" <c:if test="${isShow ==1}">selected="selected"</c:if> >上架</option>
                <option  value="0" <c:if test="${isShow ==0}">selected="selected"</c:if> >下架</option>
        </select>
        <input type="submit" class="query" value="查询"/>
    </form>
    <form method="post" id="tableForm">
        <input type="hidden" value="" name="pageNo"/>
        <input type="hidden" value="" name="queryName"/>
        <table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>图片</th>
                <th width="4%">新品</th>
                <th width="4%">热卖</th>
                <th width="4%">推荐</th>
                <th width="4%">上下架</th>
                <th width="12%">操作选项</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">
            <c:forEach items="${productListPageBean.data}" var="item">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="${item.id}"/></td>
                    <td>${item.no}</td>
                    <td align="center">${item.name}</td>
                    <td align="center">${item.description}</td>

                    <td align="center">
                        <c:if test="${item.isNew == 1}"><c:out value="是"></c:out></c:if>
                        <c:if test="${item.isNew == 0}"><c:out value="×"></c:out></c:if>
                    </td>

                    <td align="center">
                        <c:if test="${item.isHot==1}"><c:out value="是"></c:out></c:if>
                        <c:if test="${item.isHot==0}"><c:out value="×"></c:out></c:if>
                    </td>
                    <td align="center">
                        <c:if test="${item.isCommend==1}"><c:out value="是"></c:out></c:if>
                        <c:if test="${item.isCommend==0}"><c:out value="×"></c:out></c:if>
                    </td>
                    <td align="center">
                        <c:if test="${item.isShow==1}"><c:out value="是"></c:out></c:if>
                        <c:if test="${item.isShow==0}"><c:out value="×"></c:out></c:if>
                    </td>

                    <td align="center">
                        <a href="#" class="pn-opt">查看</a> | <a href="#" class="pn-opt">修改</a> | <a href="#"
                                                                                                   onclick="if(!confirm('您确定删除吗？')) {return false;}"
                                                                                                   class="pn-opt">删除</a>
                        |
                        <a href="../sku/list.jsp" class="pn-opt">库存</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="page pb15">
		<span class="r inb_a page_b">
			<c:forEach items="${productListPageBean.pageView}" var="page">
                ${page}
            </c:forEach>
		</span>
        </div>

        <div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/><input
                class="add" type="button" value="上架" onclick="optDelete();"/><input class="del-button" type="button"
                                                                                    value="下架" onclick="optDelete();"/>
        </div>
    </form>
</div>
</body>
</html>