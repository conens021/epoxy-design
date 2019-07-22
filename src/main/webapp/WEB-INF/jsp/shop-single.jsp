<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">

    <head>

        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="Nemanja Rackovic" />
        <meta property="og:url" content="http://www.epoxydesignshop.com/product/${product.getId() }-${product.getName()}" />
		<meta property="og:type"  content="website" />
		<meta property="og:title"  content="${title }" />
		<meta property="og:description"  content="${description }" />
		<meta property="og:image"   content="http://www.epoxydesignshop.com/images/${fbImage}" />

        <!-- Stylesheets
        ============================================= -->
        <link
            href="https://fonts.googleapis.com/css?family=Crete+Round|Nunito+Sans:300,400,400i,700|Ramabhadra&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="/css/bootstrap.css" type="text/css" />
        <link rel="stylesheet" href="/css/canvas.css" type="text/css" />
        <link rel="stylesheet" href="/css/dark.css" type="text/css" />
        <link rel="stylesheet" href="/css/font-icons.css" type="text/css" />
        <link rel="stylesheet" href="/css/animate.css" type="text/css" />
        <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css" />

        <link rel="stylesheet" href="/css/canvas-responsive.css" type="text/css" />
        <link rel="stylesheet" href="/css/custom.css">
        <link rel="stylesheet" href="/css/colors.css" type="text/css" />
        <link rel="stylesheet" href="/css/fonts.css" type="text/css" />

        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <!-- Document Title
        ============================================= -->
        <title>${title}</title>

    </head>

    <body data-loader="10" class="stretched">

<div id="fb-root"></div>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" 
src="https://connect.facebook.net/sr_RS/sdk.js#xfbml=1&version=v3.3&appId=349164129101779&autoLogAppEvents=1"></script>
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
							<div class="mb-3">
							<c:choose>
								<c:when test="${product.getOnStock() > 0 }">
									 <button class="btn btn-sm btn-success" disabled>On Stock</button>
								</c:when>
								<c:otherwise>
									 <button class="btn btn-sm btn-danger" disabled>Out of Stock</button>
								</c:otherwise>
							</c:choose>
                            
                            </div>
                            <!-- Product Single - Price
                                    ============================================= -->
                            <c:choose>
                                <c:when test="${product.onSale()}">
                                    <div class="product-price"><del>$${product.getOriginalPrice()}</del>
                                        <ins>$${product.getPrice()}</ins><br/>
                                      
                                    </div>
                                    <div class="clear"></div>
                                    <div>
                                      <span class="you-save text-success">You Save : $${product.calcSaveAmount() }</span></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="product-price"> Price: <ins>$${product.getPrice()}</ins></div>
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
                                    <input type="text" step="1" min="1" max="${product.getOnStock() }" name="quantity" value="1" title="Qty"
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
                                <div class="row align-items-center">
	                                <div class="col-2">
	                               		 <span>Share:</span>
	                                </div>
	                                    
	                                    <div class="col-2">      
	                                     	<a data-href="http://epoxydesignshop.com/product/${product.getId() }-${product.getName()}"
	                                    		 target="_blank"
	                                      		 href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse"
	                                       	     class="social-icon si-borderless si-facebook">
	                                            <i class="icon-facebook"></i>
	                                            <i class="icon-facebook"></i></a>
	                   
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
                                               <c:forEach items="${additionalInfo }" var="additional">
	                                                <tr>
	                                                    <td>${ additional.getKey() }</td>
	                                                    <td>${ additional.getValue() }</td>
	                                                </tr>
                                               </c:forEach>
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