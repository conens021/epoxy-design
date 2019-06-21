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
            <h1>${subcategory.getName()}</h1>
            <span>${subcategory.getDescription()}</span>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item"><a href="/products">Shop</a></li>
                <li class="breadcrumb-item"><a href="/products/${category.getCategoryLink()}">${category.getName()}</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page" style="text-transform:capitalize;">
                    ${subcategory.getName()}</li>
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






            <div class="widget widget-filter-links clearfix">

                <h4>Sort By</h4>
                <ul class="shop-sorting">
                    <li class="widget-filter-reset active-filter"><a href="#" data-sort-by="original-order">Clear</a>
                    </li>
                    <li><a href="#" data-sort-by="name">Name</a></li>
                    <li><a href="#" data-sort-by="price_lh">Price: Low to High</a></li>
                    <li><a href="#" data-sort-by="price_hl">Price: High to Low</a></li>
                </ul>

            </div>

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