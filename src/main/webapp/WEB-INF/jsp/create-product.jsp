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

										<form id="create-product" 
											class="nobottommargin" 
											>

											<div class="row">

												<div class="col-12 bottommargin-sm">
													<label for="productName">Product Name<small class="text-danger">*</small></label>
													<input type="text" id="template-contactform-name" name="productName"  class="form-control required" placeholder="Enter product name" />
												</div>
												<div class="col-12 bottommargin-sm">
													<label for="productTitle">Product Title (Google)<small class="text-danger">*</small></label>
													<input type="text" id="template-contactform-title" name="productTitle" value="" class="form-control required" placeholder="Enter product title" />
												</div>
												


												<div class="col-12 bottommargin-sm">
													<label for="category">Product Category<small class="text-danger">*</small></label>
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
													<label for="price">Product price<small class="text-danger">*</small></label>
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
															<input id="template-contactform-checked-switch" name="onSale"
															class="switch-toggle switch-toggle-round"  type="checkbox" >
															<label for="template-contactform-checked-switch"></label>
														</div>
														<label class="media-body text-muted ml-3" for="template-contactform-checked-switch">
													        <span class="d-block text-dark mb-1 nott ls0">Product On Sale</span>
													        <span class="d-block nott ls0 t400">Cekirajte ovo ako je product na popustu</span>
													    </label>
												    </div>
												  
												</div>
												<div class="col-12 bottommargin-sm">
													<label for="saleAmount">Sale amount</label>
													<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text">%</span>
													</div>
													<input id="saleAmount" name="saleAmount" type="text" class="form-control"
													 aria-label="Amount (to the nearest dollar)" placeholder="Enter sale amount" disabled="disabled">
													
													</div>
												</div>
											<div class="col-12 bottommargin-sm">
													<label for="template-contactform-age" class="mb-3 clearfix">On Stock (Broj Proizvoda na Stanju)</label>
													<input id="template-contactform-age" name="onStock" class="range_01 input-range-slider" />
												</div>
											

											<div id="images-upload-error"class="col-lg-12 bottommargin">
												<label>Product Images:<small class="text-danger">*</small></label><br>
												<input id="images" name="images" type="file" class="file" multiple data-show-upload="false" data-show-caption="true" data-show-preview="true">
											</div>
											
												<div class="col-lg-12 bottommargin">
													<label for="description">Product description</label><br>
													<textarea class="form-control" id="exampleFormControlTextarea1" name="description" rows="10"></textarea>
												</div>
									
												<div class="col-12">
													<button id="submit-btn" type="submit" class="btn btn-secondary btn-block btn-lg">Save</button>
												</div>
												<div class="col-12">
													<span id="errors" class="error">Popunite sva polja oznacena sa *</span>
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


	<!-- Range Slider Plugin -->
	<script src="/scripts/rangeslider.min.js"></script>
	<script src="/scripts/create-product.js"></script>
	


	<!-- Footer Scripts
	============================================= -->
	<script src="/scripts/functions.js"></script>

	<script>

		jQuery(document).ready( function(){

			jQuery(".range_01").ionRangeSlider({
				grid: true,
				min: 1,
				max: 100,
				from: 20,
				prefix: "Stock ",
				max_postfix: "+"
			});

			
		

		});


	</script>
	

</body>
</html>