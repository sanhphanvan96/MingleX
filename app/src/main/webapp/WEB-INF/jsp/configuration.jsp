<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Security Configuration">
    <div class="container">
        <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th>Protection</th>
                <th>Status</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr class="${securitySetting.getSqlInjection() ? "success" : "warning"}">
                <td>SQL Injection</td>
                <td>${securitySetting.getSqlInjection() ? "True" : "False"}</td>
                <td>Lorem ipsum dolor sit amet</td>
            </tr>
            <tr class="success">
                <td>Store Password Solution</td>
                <td>${securitySetting.getStorePasswordSolution()}</td>
                <td>Lorem ipsum dolor sit amet</td>
            </tr>
            <tr class="${securitySetting.getStoredXSS() ? "success" : "warning"}">
                <td>Stored XSS</td>
                <td>${securitySetting.getStoredXSS() ? "True" : "False"}</td>
                <td>Lorem ipsum dolor sit amet</td>
            </tr>
            </tbody>
        </table>
    </div>
</t:wrapper>