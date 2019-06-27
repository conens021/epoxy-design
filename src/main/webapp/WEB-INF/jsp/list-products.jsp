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
				
					

					<div class="table-responsive">
						<div class="row align-items-center mb-3">
							<div class="col-10 pr-0">
								<input type="text" id="template-contactform-name" name="template-contactform-name"
								 value="" class="form-control required" placeholder="Search product" />
								
							</div>
							<div class="col-2 pl-0">
							
								 <a href="#" class="button button-fill button-rounded"><i class="icon-line-search"></i>Search</a>
							</div>
						</div>
						<table id="datatable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Product</th>
									<th>On Stock</th>
									<th>Price</th>
									<th>On Sale</th>
									<th>Sale Amount</th>
									<th>Price on Sale</th>
									<th>Created</th>
									<th>Last Update</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
								<th>ID</th>
									<th>Product</th>
									<th>On Stock</th>
									<th>Price</th>
									<th>On Sale</th>
									<th>Sale Amount</th>
									<th>Price on Sale</th>
									<th>Created</th>
									<th>Last Update</th>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td>Tiger Nixon</td>
									<td>System Architect</td>
									<td>Edinburgh</td>
									<td>61</td>
									<td>2011/04/25</td>
									<td>$320,800</td>
								</tr>
								</tbody>
								</table>
								
								</div>
								<div class="row justify-content-center mt-3">
									<div class="col-lg-3">
										<ul class="pagination pagination-transparent pagination-rounded">
										  <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">«</span></a></li>
										  <li class="page-item active"><a class="page-link" href="#">1</a></li>
										  <li class="page-item"><a class="page-link" href="#">2</a></li>
										  <li class="page-item"><a class="page-link" href="#">3</a></li>
										  <li class="page-item"><a class="page-link" href="#">4</a></li>
										  <li class="page-item"><a class="page-link" href="#">5</a></li>
										  <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
										</ul>
									</div>
								</div>
						
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