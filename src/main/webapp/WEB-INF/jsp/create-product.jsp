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
                    <h1>Create product</h1>
                   
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

			<div class="content-wrap bg-light">

				<div class="container">

					<div class="row justify-content-center">
						<div class="col-lg-7 col-md-10">
							<div class="card shadow-sm">
								<div class="card-header">
									<h4 class="mb-0" style="font-size:22px">Product Details</h4>
								</div>
								<div class="card-body">

									<div class="form-widget">

										<div class="form-result"></div>

										<div class="form-process css3-spinner">
											<div class="css3-spinner-double-bounce1"></div>
											<div class="css3-spinner-double-bounce2"></div>
										</div>

										<form 
											class="nobottommargin" 
											  action="/djeke-djole/upload-product" method="POST" enctype="multipart/form-data">

											<div class="row">

												<div class="col-12 bottommargin-sm">
													<label for="productName">Product Name<small class="text-danger">*</small></label>
													<input type="text" id="template-contactform-name" name="productName"  class="form-control required" placeholder="Enter product name" />
												</div>
												<div class="col-12 bottommargin-sm">
													<label for="productTitle">Product Title (Google)<small class="text-danger">*</small></label>
													<input type="text" id="template-contactform-name" name="productTitle" value="" class="form-control required" placeholder="Enter product title" />
												</div>
												


												<div class="col-12 bottommargin-sm">
													<label for="category">Product Category*</label>
													<select id="template-contactform-default-select" name="category" class="form-control">
														<option value="0" disabled selected>Select One</option>
														<option value="1">Tables</option>
													
													</select>
												</div>
												<div class="col-12 bottommargin-sm">
													<label for="subcategory">Product Subcategory</label>
													<select id="template-contactform-default-select" name="subcategory" class="form-control">
														<option value="0" disabled selected>Select One</option>
														<option value="1">Coffee Tables</option>
														<option value="2">Dinner Tables</option>
														
													</select>
												</div>
												
											

												<div class="col-12 bottommargin-sm">
													<label for="price">Product price*</label>
													<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text">$</span>
													</div>
													<input id="template-contactform-budget" name="price" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="Enter product price">
													
													</div>
												</div>


												<div class="col-12 bottommargin-sm">
													 <div class="d-flex align-items-center">
														<div class="switch">
															<input id="template-contactform-checked-switch" name="onSale" class="switch-toggle switch-toggle-round" checked type="checkbox">
															<label for="template-contactform-checked-switch"></label>
														</div>
														<label class="media-body text-muted ml-3" for="template-contactform-checked-switch">
													        <span class="d-block text-dark mb-1 nott ls0">Checked Switch</span>
													        <span class="d-block nott ls0 t400">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quas, aut?</span>
													    </label>
												    </div>
												  
												</div>
												<div class="col-12 bottommargin-sm">
													<label for="saleAmount">Sale amount</label>
													<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text">%</span>
													</div>
													<input id="template-contactform-budget" name="saleAmount" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="Enter sale amount">
													
													</div>
												</div>

											

											<div class="col-lg-12 bottommargin">
												<label>Product Images:</label><br>
												<input id="input-3" name="images" type="file" class="file" multiple data-show-upload="false" data-show-caption="true" data-show-preview="true">
											</div>
											
												<div class="col-lg-12 bottommargin">
													<label for="description">Product description</label><br>
													<textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="10"></textarea>
												</div>
									
												<div class="col-12">
													<button type="submit" class="btn btn-secondary btn-block btn-lg">Save</button>
												</div>

											

											</div>

										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

		</section><!-- #content end -->
			
		

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

	<!-- Bootstrap File Upload Plugin -->
	<script src="/scripts/bs-filestyle.js"></script>

	<!-- Select-Boxes Plugin -->
	<script src="/scripts/select-boxes.js"></script>

	<!-- Bootstrap Select Plugin -->
	<script src="/scripts/bs-select.js"></script>

	<!-- Date & Time Picker JS -->
	<script src="/scripts/moment.js"></script>
	<script src="/scripts/datepicker.js"></script>
	<script src="/scripts/timepicker.js"></script>

	


	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>

	<script>

		jQuery(document).ready( function(){


			jQuery(".select-tags").select2({
				tags: true,
				placeholder: "Add Values and Press Enter"
			});

			jQuery('.datetimepicker1').datetimepicker();

	


		});


	</script>


</body>
</html>