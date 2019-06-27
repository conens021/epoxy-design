 <%@include file="templates/admin/admin-top.jsp" %>

        <!-- Document Wrapper
        ============================================= -->
        <div id="wrapper" class="clearfix">


            <!--Header-->
            <%@include file="templates/admin/admin-header.jsp" %>

            <!-- Page Title
            ============================================= -->
            <section id="page-title">

                <div class="container clearfix">
                    <h1>Product list</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/admin">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Create Product</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					<h1>${ message }</h1>

							
				</div>
			</div>
	</section>
		

            <!--Footer-->
            <%@include file="templates/footer.jsp" %>

     

		</div>
		<!-- End wrapper -->
		

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- External JavaScripts
	============================================= -->
	<script src="/scripts/jquery.js"></script>
	<script src="/scripts/plugins.js"></script>
	
	

	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>
	

</body>
</html>