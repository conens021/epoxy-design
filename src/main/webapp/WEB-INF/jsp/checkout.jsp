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
			<h1>Checkout</h1>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/">Home</a></li>
				<li class="breadcrumb-item"><a href="/products">Shop</a></li>
				<li class="breadcrumb-item active" aria-current="page">Checkout</li>
			</ol>
		</div>

	</section><!-- #page-title end -->

	<!-- Content
		============================================= -->
	<section id="content">

		<div class="content-wrap">

			<div class="container clearfix">



				<div class="row clearfix justify-content-center">
					<div class="col-lg-6">
						<h3>Personal Info</h3>

						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde, vel odio non dicta
							provident sint ex autem mollitia dolorem illum repellat ipsum aliquid illo similique
							sapiente fugiat minus ratione.</p>

						<form id="billing-form" name="billing-form" class="nobottommargin" action="#" method="post">

							<div class="col_half">
								<label for="billing-form-name">Name:</label>
								<input type="text" id="billing-form-name" name="billing-form-name" value=""
									class="sm-form-control" />
							</div>

							<div class="col_half col_last">
								<label for="billing-form-lname">Last Name:</label>
								<input type="text" id="billing-form-lname" name="billing-form-lname" value=""
									class="sm-form-control" />
							</div>

							<div class="clear"></div>

							<div class="col_full">
								<label for="billing-form-companyname">Company Name:</label>
								<input type="text" id="billing-form-companyname" name="billing-form-companyname"
									value="" class="sm-form-control" />
							</div>





							<div class="col_half">
								<label for="billing-form-email">Email Address:</label>
								<input type="email" id="billing-form-email" name="billing-form-email" value=""
									class="sm-form-control" />
							</div>

							<div class="col_half col_last">
								<label for="billing-form-phone">Phone:</label>
								<input type="text" id="billing-form-phone" name="billing-form-phone" value=""
									class="sm-form-control" />
							</div>
							<div class="col_full col_last">
								<label for="billing-form-phone">Personal ID Number:</label>
								<input type="text" id="billing-form-phone" name="billing-form-phone" value=""
									class="sm-form-control" />
							</div>
							<div class="col_full">
								<label for="shipping-form-message">Notes <small>*</small></label>
								<textarea class="sm-form-control" id="shipping-form-message"
									name="shipping-form-message" rows="10" cols="30"></textarea>
							</div>


						</form>
					</div>

					<div class="w-100 bottommargin"></div>
					<div class="col-lg-12">
						<h4>Your Orders</h4>

						<div class="table-responsive">
							<table class="table cart">
								<thead>
									<tr>
										<th class="cart-product-thumbnail">&nbsp;</th>
										<th class="cart-product-name">Product</th>
										<th class="cart-product-quantity">Quantity</th>
										<th class="cart-product-subtotal">Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cartItems}" var="prod">


										<tr class="cart_item">
											<td class="cart-product-thumbnail">
												<a href="/product/${prod.getId()}-${prod.getName()}"><img width="64" height="64"
														src="images/${prod.getImages().get(0).getImageUrl()}"
														alt="${prod.getName()}"></a>
											</td>

											<td class="cart-product-name">
												<a href="/product/${prod.getId()}-${prod.getName()}">${prod.getName()}</a>
											</td>

											<td class="cart-product-quantity">
												<div class="quantity clearfix">
													${prod.getQuantity()}
												</div>
											</td>

											<td class="cart-product-subtotal">
												<span class="amount">$${prod.totalPrice()}</span>
											</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
					<div class="col-lg-12">
						<h4>Cart Totals</h4>

						<div class="table-responsive">
							<table class="table cart">
								<tbody>
									<tr class="cart_subtotal">
										<td class="cart-product-name">
											<strong>Cart Subtotal</strong>
										</td>

										<td class="cart-product-name">
											<span id="cart-subtotal" class="amount">$${cartSubtotal}</span>
										</td>
									</tr>
									<tr class="cart_tax">
										<td class="cart-product-name">
											<strong>TAX 5%</strong>
										</td>

										<td class="cart-product-name">
											<span id="cart-tax" class="amount">+$${tax}</span>
										</td>
									</tr>
									<tr class="cart_total">
										<td class="cart-product-name">
											<strong>Total</strong>
										</td>

										<td class="cart-product-name">
											<span id="cartTotal" class="amount color lead"><strong>$${cartTotal}</strong></span>
										</td>
									</tr>
								</tbody>

							</table>
						</div>
						<a href="#" class="button button-3d fright">Place Order</a>
					</div>
				</div>


			</div>

		</div>

	</section><!-- #content end -->

	<!--Footer -->
	<%@include file="templates/footer.jsp" %>

	<!--Cookies-->
	<%@include file="templates/cookies.jsp"%>

</div><!-- #wrapper end -->
<%@ include file="templates/bottom.jsp" %>