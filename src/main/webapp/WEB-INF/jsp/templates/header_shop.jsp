
<!-- Header
============================================= -->
<header id="header" class="dark">
    <!-- Top Bar
============================================= -->
    <div id="top-bar" class="dark" style="background-color: #121212;">

        <div class="container clearfix" style="width: 80%;margin:auto;">

            <div class="row lg-justify-content-end md-justify-content-center sm-justify-content-center">


    <!-- Top Social
                            ============================================= -->
                            <div id="top-social">
                                <ul>
                                    <li><a href="https://www.facebook.com/Epoxy-Design-Furniture-2319153338406403/" target="_blank" class="social-icon si-borderless si-facebook">
                                            <i class="icon-facebook"></i>
                                            <i class="icon-facebook"></i>
                                        </a>
                                    </li>
                                    <li><a href="https://www.instagram.com/epoxy_design_furniture_/" target="_blank" class="social-icon si-borderless si-instagram">
                                            <i class="icon-instagram"></i>
                                            <i class="icon-instagram"></i>
                                        </a></li>
                                        <li><a href="https://www.pinterest.com/epoxydesign1/" target="_blank" class="social-icon si-borderless si-pinterest">
                                            <i class="icon-pinterest"></i>
                                            <i class="icon-pinterest"></i>
                                        </a></li>

                                </ul>
                            </div><!-- #top-social end -->

            </div>
        </div>

    </div>
    <div id="header-wrap" style="background: #1C1C1C">

        <div class="container clearfix">

            <div id="primary-menu-trigger"><i class="icon-reorder"></i></div>

            <!-- Logo
            ============================================= -->
            <div id="logo" >
                <a href="/" class="standard-logo" >Epoxy Design</a>

            </div><!-- #logo end -->

            <!-- Primary Navigation
            ============================================= -->
            <nav id="primary-menu" class="style-2 with-arrows"
                 style="display: flex;justify-content: space-around;flex-wrap: wrap">

                <ul>
                
                     <li class="current"><a href="/products">
                            <div>ALL</div>
                        </a>
                     </li>
                     
                <c:forEach items="${categories}" var="category">
         			 <li><a href="/products/${category.getCategoryLink()} ">
                            <div>${category.getName()}</div>
                        </a>
                     </li>
      			</c:forEach>
     

                </ul>

            </nav><!-- #primary-menu end -->

       <%@ include file="header-cart.jsp" %>
        </div>

    </div>

</header><!-- #header end -->