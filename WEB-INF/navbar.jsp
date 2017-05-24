<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<div id="nav-bar">
  <ul>
    <li class="cat-nav-item">
    <a href="${context}/home">Home</a>
    </li>


    <c:forEach items="${categories}" var="cat">
      <li class="cat-nav-item">
      <a href="${context}/category?name=${cat.name}">${cat.label}</a>
      </li>
    </c:forEach>
  </ul>
</div>
