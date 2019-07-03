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
                    <h1>Customer ${ customer.getFirstName() }</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/djeke-djole">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Customer</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					
					<h2>Customer Info</h2>
					<div class="table-responsive mb-5">
				
						<table id="datatable1" class="table table-striped table-bordered table-right-justify"  cellspacing="0" >
						
							
								<tr>
									<th> ID </th>
									<td>${customer.getId() }</td>
								</tr>
								<tr>
									<th>First Name</th>
									<td>${customer.getFirstName() }</td>
								</tr>
								<tr>
									<th> Last Name </th>
									<td>${customer.getLastName() }</td>
								</tr>
								<tr>
									<th> Email Address </th>
									<td><a href="mailto:${customer.getEmail()}" class="admin-href">${customer.getEmail() }</a></td>
								</tr>
								<tr>
									<th> Contact Number </th>
									<td><a href="tel:${customer.getPhoneNumber()}" class="admin-href">${customer.getPhoneNumber() }</a></td>
								</tr>
							
							
						
						</table>
								
					</div>
					
					
					
					<h2>Orders</h2>
				
					<div class="table-responsive">
				
						<table id="datatable1" class="table table-striped table-bordered " cellspacing="0" width="100%">
						
							<thead>
								<tr>
									<th>ID </th>
									<th > Subtotal </th>
									<th > Tax </th>
									<th >Total </th>
									
									<th >Order Time </th>	
								</tr>
							</thead>
					
							<tbody>
							<c:forEach items="${orders }" var="orders">
									<tr>
										<td><a href="/djeke-djole/order/${orders.getId()}" class="admin-href">${ orders.getId() } </a>  </td>
									
										<td>$${ orders.getSubtotal() }</td>									
																		
										<td>${ orders.getTax() }%</td>
																
										<td>$${ orders.getTotal() }</td>
																		
																	
										<td>${ orders.getOrderDate() }</td>
									</tr>
							</c:forEach>
							
								</tbody>
								</table>
								
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