<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
<c:if test="${ result eq 'success'}">
alert("휴게소가 수정되었습니다.");
self.close();
</c:if>
</script>