<div class="widget widget-filter-links clearfix">

    <h4>Select Category</h4>
    <ul >

        <c:forEach items="${categories}" var="category">
               <li><a href="/products/${category.getCategoryLink()}">
                       ${category.getName()}
                     </a>
               </li>
          </c:forEach>

    </ul>

</div>
