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
                    <h1>Order #${ order.getId() }</h1>
                   
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                         <li class="breadcrumb-item"><a href="/djeke-djole">Admin</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Order</li>
                    </ol>
                </div>

            </section><!-- #page-title end -->
	
	
				<!-- Content
		============================================= -->
		<section id="content">

			<div class="content-wrap">

				<div class="container clearfix">
				
					
					<h2>Order Info</h2>
					<div class="table-responsive mb-5">
				
						<table id="datatable1" class="table table-striped table-bordered table-right-justify"  cellspacing="0" >
						
							
								<tr>
									<th> ID </th>
									<td>${order.getId() }</td>
								</tr>
								<tr>
									<th> Order Subtotal </th>
									<td>$${order.getSubtotal() }</td>
								</tr>
								<tr>
									<th> TAX </th>
									<td>${order.getTax() }%</td>
								</tr>
								<tr>
									<th> Order Total </th>
									<td>$${order.getTotal() }</td>
								</tr>
								<tr>
									<th> Order Time </th>
									<td>${order.getOrderDate() }</td>
								</tr>
								<tr>
									<th> Order Note </th>
									<td>${order.getNote() }</td>
								</tr>
								<tr>
									<th> Products </th>
									<td>
										 <c:forEach items="${products }" var="product">
										 	<a href="/product/${product.getId() }-${product.getName()}"><span>${product.getName() } x${product.getQuantity() }</span></a>
										 	<br/>
										 </c:forEach>
									</td>
								</tr>
						
						</table>
								
					</div>
					
					
					
					<h2>Customer Info</h2>
					<div class="table-responsive">
				
						<table id="datatable1" class="table table-striped table-bordered table-right-justify"  cellspacing="0" >
						
							
								<tr>
									<th> ID </th>
									<td><a href="/djeke-djole/customer/${customer.getId()}" class="admin-href">${customer.getId() }</a></td>
								</tr>
								<tr>
									<th> First Name </th>
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
							
								<tr>
									<th>Company Name</th>
									<td>${customer.getCompany() }</td>
								</tr>
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