<%@page import="thuvien.porlet.model.PhieuMuon"%>
<%@page import="thuvien.porlet.model.TheLoai"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="/WEB-INF/tld/liferay-theme.tld" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects />

	<%PhieuMuon Phieumuon = (PhieuMuon)request.getAttribute("PhieuMuon");%>

<liferay-portlet:actionURL var="saveURL" name="save"></liferay-portlet:actionURL>
<form name=frm method=POST action="<%=saveURL%>">
	<input type= "hidden" value="<%=Phieumuon.getId()%>" name="<portlet:namespace/>id">
	<table>
		<tr>
			<td>
				<aui:input type="text" value="<%=Phieumuon.getUserId()%>" name="userid"></aui:input>
				<aui:button type="submit" value="Save"></aui:button>
			</td>
		</tr>
	</table>
</form>