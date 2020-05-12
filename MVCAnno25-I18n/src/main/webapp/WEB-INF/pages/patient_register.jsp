<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    <h1 style="color:blue;text-align:center"><spring:message code="form.title"></spring:message></h1>
    
    <form:form modelAttribute="patCmd">
    	<spring:message code="form.patName"/><form:input path="patName"/><br>
    	<spring:message code="form.patAddrs"/><form:input path="patAddrs"/><br>
    	<spring:message code="form.patAge"/><form:input path="patAge"/><br>
		<input type="submit" value='<spring:message code="form.submit"/>'/>
    </form:form>
    
    <fmt:setLocale value="${pageContext.response.locale}"/>
    <h3>current Locale=${pageContext.response.locale}</h3>
    
    <jsp:useBean id="dt" class="java.util.Date"/>
    <fmt:formatDate var="fdt" value="${dt}"/>
    <h3>System Date:: ${fdt}</h3>
    
    <fmt:formatNumber var="fprice" value="5675378953" type="currency"/>
    <h3>Product price:: ${fprice}</h3>
    
    <br><br>
    <a href="?language=fr_FR">French</a>&nbsp;&nbsp;
    <a href="?language=de_DE">German</a>&nbsp;&nbsp;
    <a href="?language=ru_RU">Russian</a>&nbsp;&nbsp;  
    <a href="?language=zh_CN">Chineses</a>&nbsp;&nbsp;
    <a href="?language=hi_IN">Hindi</a>&nbsp;&nbsp;
    <a href="?language=te_IN">Telugu</a>&nbsp;&nbsp;

