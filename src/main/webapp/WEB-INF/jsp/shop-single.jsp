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
            <h1>${product.getName()}</h1>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Home</a></li>
                <li class="breadcrumb-item"><a href="/products">Shop</a></li>
                <li class="breadcrumb-item"><a
                        href="/products/${product.getProdCategory().getCategoryLink()}">${product.getProdCategory().getName()}</a>
                </li>
                <li class="breadcrumb-item"><a
                        href="/products/${product.getProdCategory().getCategoryLink()}/${product.getSubcategory().getLink()}">${product.getSubcategory().getName()}</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">${product.getName()}</li>
            </ol>
        </div>

    </section><!-- #page-title end -->

    <!-- Content
            ============================================= -->
    <section id="content">

        <div class="content-wrap">

            <div class="container clearfix">

                <div class="single-product">

                    <div class="product">

                        <div class="col_two_fifth">

                            <!-- Product Single - Gallery
                                    ============================================= -->
                            <div class="product-image">
                                <div class="fslider" data-pagi="false" data-arrows="false" data-thumbs="true">
                                    <div class="flexslider">
                                        <div class="slider-wrap" data-lightbox="gallery">
                                            <c:forEach items="${product.getImages()}" var="image">
                                                <div class="slide" data-thumb="/images/${image.getImageUrl()}">
                                                    <a href="/images/${image.getImageUrl()}"
                                                        title="${product.getTitle()} - image${image.getId()}"
                                                        data-lightbox="gallery-item">
                                                        <img src="/images/${image.getImageUrl()}"
                                                            alt="${product.getTitle() }- image${image.getId()}"></a>
                                                </div>
                                            </c:forEach>


                                        </div>
                                    </div>
                                </div>
                                <c:if test="${product.onSale()}">
                                	 <div class="sale-flash">Sale!</div>
                                </c:if>
                               
                            </div><!-- Product Single - Gallery End -->

                        </div>

                        <div class="col_two_fifth product-desc">

                            <!-- Product Single - Price
                                    ============================================= -->
                            <c:choose>
                                <c:when test="${product.onSale()}">
                                    <div class="product-price"><del>$${product.getOriginalPrice()}</del>
                                        <ins>$${product.getPrice()}</ins>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="product-price"> <ins>$${product.getPrice()}</ins></div>
                                </c:otherwise>
                            </c:choose><!-- Product Single - Price End -->

               

                            <div class="clear"></div>
                            <div class="line"></div>

                            <!-- Product Single - Quantity & Cart Button
                                    ============================================= -->
                            <form class="cart nobottommargin clearfix" method="post"  action="/add-to-cart">
                                <div class="quantity clearfix">
                                    <input type="button" value="-" class="minus">
                                    <input type="hidden" value="${product.getId()}" name="prod_id" />
                                    <input type="text" step="1" min="1" name="quantity" value="1" title="Qty"
                                        class="qty" size="4" />
                                    <input type="button" value="+" class="plus">
                                </div>
                                <button id="to-cart-btn" type="submit" class="add-to-cart button nomargin">Add to cart</button>
                            </form><!-- Product Single - Quantity & Cart Button End -->

                            <div class="clear"></div>
                            <div class="line"></div>

                            <!-- Product Single - Short Description
                                    ============================================= -->
                            <p>${product.getDescription()}
                                <ul class="iconlist">
                                    <li><i class="icon-caret-right"></i> Dynamic Color Options</li>
                                    <li><i class="icon-caret-right"></i> Lots of Size Options</li>
                                    <li><i class="icon-caret-right"></i> 30-Day Return Policy</li>
                                </ul><!-- Product Single - Short Description End -->



                                <!-- Product Single - Share
                                    ============================================= -->
                                <div class="si-share noborder clearfix">
                                    <span>Share:</span>
                                    <div>
                                        <a href="#" class="social-icon si-borderless si-facebook">
                                            <i class="icon-facebook"></i>
                                            <i class="icon-facebook"></i>
                                        </a>
                                        <a href="#" class="social-icon si-borderless si-twitter">
                                            <i class="icon-twitter"></i>
                                            <i class="icon-twitter"></i>
                                        </a>
                                        <a href="#" class="social-icon si-borderless si-pinterest">
                                            <i class="icon-pinterest"></i>
                                            <i class="icon-pinterest"></i>
                                        </a>
                                        <a href="#" class="social-icon si-borderless si-gplus">
                                            <i class="icon-gplus"></i>
                                            <i class="icon-gplus"></i>
                                        </a>
                                        <a href="#" class="social-icon si-borderless si-rss">
                                            <i class="icon-rss"></i>
                                            <i class="icon-rss"></i>
                                        </a>
                                        <a href="#" class="social-icon si-borderless si-email3">
                                            <i class="icon-email3"></i>
                                            <i class="icon-email3"></i>
                                        </a>
                                    </div>
                                </div><!-- Product Single - Share End -->

                        </div>



                        <div class="col_full nobottommargin">

                            <div class="tabs clearfix nobottommargin" id="tab-1">

                                <ul class="tab-nav clearfix">
                                    <li><a href="#tabs-1"><i class="icon-align-justify2"></i><span
                                                class="d-none d-md-inline-block"> Description</span></a></li>
                                    <li><a href="#tabs-2"><i class="icon-info-sign"></i><span
                                                class="d-none d-md-inline-block"> Additional Information</span></a></li>
                                   
                                </ul>

                                <div class="tab-container">

                                    <div class="tab-content clearfix" id="tabs-1">
                                        <p>${product.getDescription()}
                                    </div>
                                    <div class="tab-content clearfix" id="tabs-2">

                                        <table class="table table-striped table-bordered">
                                            <tbody>
                                                <tr>
                                                    <td>Size</td>
                                                    <td>Small, Medium &amp; Large</td>
                                                </tr>
                                                <tr>
                                                    <td>Color</td>
                                                    <td>Pink &amp; White</td>
                                                </tr>
                                                <tr>
                                                    <td>Waist</td>
                                                    <td>26 cm</td>
                                                </tr>
                                                <tr>
                                                    <td>Length</td>
                                                    <td>40 cm</td>
                                                </tr>
                                                <tr>
                                                    <td>Chest</td>
                                                    <td>33 inches</td>
                                                </tr>
                                                <tr>
                                                    <td>Fabric</td>
                                                    <td>Cotton, Silk &amp; Synthetic</td>
                                                </tr>
                                                <tr>
                                                    <td>Warranty</td>
                                                    <td>3 Months</td>
                                                </tr>
                                            </tbody>
                                        </table>

                                    </div>
                               

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

                <div class="clear"></div>
                <div class="line"></div>

                <div class="col_full nobottommargin">

                    <h4>Related Products</h4>

                    <div id="oc-product" class="owl-carousel product-carousel carousel-widget" data-margin="30"
                        data-pagi="false" data-autoplay="5000" data-items-xs="1" data-items-md="2" data-items-lg="3"
                        data-items-xl="4">
                        <c:forEach items="${releated}" var="prod">
                            <div class="oc-item">
                                <div class="product iproduct clearfix">
                                    <div class="product-image">
                                        <c:forEach items="${prod.getImages()}" var="image">
                                            <a href="/product/${prod.getId()}-${prod.getName()}"><img
                                                    src="/images/${image.getImageUrl()}" alt="Checked Short Dress"></a>
                                        </c:forEach>
                                        <div class="product-overlay">
                                            <a href="#" class="add-to-cart"><i class="icon-shopping-cart"></i><span> Add
                                                    to Cart</span></a>
                                            <a href="include/ajax/shop-item.html" class="item-quick-view"
                                                data-lightbox="ajax"><i class="icon-zoom-in2"></i><span> Quick
                                                    View</span></a>
                                        </div>
                                    </div>

                                    <div class="product-desc center">
                                        <div class="product-title">
                                            <h3><a href="#">${prod.getName()}</a></h3>
                                        </div>
                                        <div class="product-price"><del>$24.99</del> <ins>$12.49</ins></div>
                                     
                                    </div>
                                </div>
                            </div>

                        </c:forEach>


                    </div>

                </div>




            </div>

        </div>

    </section><!-- #content end -->

    <!--Footer -->
    <%@include file="templates/footer.jsp" %>
    <!--Footer end-->

    <!--Cookies-->
    <%@include file="templates/cookies.jsp"%>
</div><!-- #wrapper end -->

<%@ include file="templates/bottom.jsp" %>