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
                    <h1>Shop</h1>
                    <span>Start Buying your Favorite Products</span>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Shop</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
		 <!-- Products -->
         <%@include file="templates/products.jsp" %>

       
        
         
                <!-- Sidebar
                        ============================================= -->
                        <div class="sidebar nobottommargin">
                            <div class="sidebar-widgets-wrap">

                              
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

		</div>
		<!-- End wrapper -->
      
<%@ include file="templates/bottom.jsp" %>