<%@page import="ispace.model.LoaiVanBan"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException"%>
<%@page import="javax.portlet.filter.ActionRequestWrapper"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />

<%
	List<LoaiVanBan> data = (List<LoaiVanBan>)request.getAttribute("data");
	PortletURL interatorURL = renderResponse.createActionURL();
	interatorURL.setParameter(ActionRequest.ACTION_NAME, "vanBan");
	int delta = GetterUtil.getInteger(request.getAttribute("delta"));
	int tong = GetterUtil.getInteger(request.getAttribute("tong"));
%>
<liferay-portlet:actionURL var="danhsachURL" name="vanBan"></liferay-portlet:actionURL>
<form name=frm method=POST action="<%=danhsachURL%>">
	<table>
		<tr>
			<td>
				Tên:<input type= text value="" name="<portlet:namespace/>ten">
				<button>TÌM KIẾM</button>
			</td>
		</tr>
	</table>
</form>
<liferay-ui:search-container iteratorURL="<%=interatorURL%>" 
											delta="<%=delta%>" 
											emptyResultsMessage="khong tim thay" 
											deltaConfigurable="true" var="searchContainer">
	<liferay-ui:search-container-results results="<%=data%>" total="<%=tong%>"/>	
	<liferay-ui:search-container-row className="ispace.model.LoaiVanBan"
		modelVar="item" indexVar="itemIdex" escapedModel="<%=true%>"
		rowVar="itemRow">
		<liferay-ui:search-container-column-text name="STT">
			<%=String.valueOf(itemIdex)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên">
			<%=item.getTen()%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Chức năng">
			<liferay-portlet:actionURL var="deleteURL" name="delete">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item.getId())%>"/>
			</liferay-portlet:actionURL>
			<a href="<%=deleteURL%>">Xoá</a>
			<liferay-portlet:actionURL var="updateURL" name="input">
				<liferay-portlet:param name="id" value="<%=String.valueOf(item.getId())%>"/>
			</liferay-portlet:actionURL>
			<a href="<%=updateURL%>">Sửa</a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true"/>
	</liferay-ui:search-container>
<liferay-portlet:actionURL var="inputURL" name="input"></liferay-portlet:actionURL>
<a href=<%=inputURL%>>Thêm Mới</a>


