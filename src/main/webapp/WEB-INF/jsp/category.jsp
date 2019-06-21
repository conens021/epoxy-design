<%@include file="templates/top.jsp" %>
<!-- Document Wrapper
        ============================================= -->
<div id="wrapper" class="clearfix">


    <!--Header-->
     <%@include file="templates/header_shop.jsp" %>

     <!-- Page Title
     ============================================= -->
    <section id="page-title">

        <div class="container clearfix">
            <h1>${category.getName()}</h1>
            <span>${category.getDescription()}</span>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item"><a href="/products">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page" style="text-transform:capitalize;">
                    ${category.getName()}</li>
            </ol>
        </div>

    </section><!-- #page-title end -->

    <!-- Products -->
    <%@include file="templates/products.jsp" %>

    <!-- Sidebar
      ============================================= -->
    <div class="sidebar nobottommargin">
        <div class="sidebar-widgets-wrap">


            <c:if test="${subcategories.size() >= 1}">
                <div class="widget widget-filter-links clearfix">

                    <h4>Select Subcategory</h4>
                    <ul>

                        <c:forEach items="${subcategories}" var="subcat">
                            <li>
                                <a href="/products/${subcat.getCategory().getCategoryLink()}/${subcat.getLink()}">
                                    ${ subcat.getName()}
                                </a>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
            </c:if>

            <%@ include file= "templates/sortByCategory.jsp" %>
            <%@ include file="templates/sorting.jsp" %>
        </div>
    </div><!-- .sidebar end -->

</div>

</div>

</section><!-- #content end -->


            <!--Footer-->
            <%@include file="templates/footer.jsp" %>

              <!--Cookies-->
	    	<%@include file="templates/cookies.jsp"%>


        </div><!-- #wrapper end -->

        <%@ include file="templates/bottom.jsp" %>