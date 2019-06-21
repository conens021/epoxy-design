<%@include file="templates/top.jsp"%>

<!-- Document Wrapper
	============================================= -->
<div id="wrapper" class="clearfix">

	<!--Header-->
	<%@include file="templates/header_shop.jsp" %>


	<!-- Page Title
		============================================= -->
	<section id="page-title">

		<div class="container clearfix">
			<h1>Cart</h1>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/">Home</a></li>
				<li class="breadcrumb-item"><a href="/products">Shop</a></li>
				<li class="breadcrumb-item active" aria-current="page">Cart</li>
			</ol>
		</div>

	</section><!-- #page-title end -->

	<!-- Content
		============================================= -->
	<section id="content">

		<div class="content-wrap">

			<div class="container clearfix">

				<div class="table-responsive">
					<table class="table cart">
						<thead>
							<tr>
								<th class="cart-product-remove">&nbsp;</th>
								<th class="cart-product-thumbnail">&nbsp;</th>
								<th class="cart-product-name">Product</th>
								<th class="cart-product-price">Unit Price</th>
								<th class="cart-product-quantity">Quantity</th>
								<th class="cart-product-subtotal">Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cartItems}" var="prod">
							
								<tr class="cart_item" id="prod-${prod.getId()}">
									<input type="hidden" name="prod_id" value="${prod.getId()}" />
									<td class="cart-product-remove">
										<a href="#" onclick="return removeFromCart(${prod.getId()})" class="remove" title="Remove this item"><i
												class="icon-trash2"></i></a>
									</td>

									<td class="cart-product-thumbnail">
										<a href="/product/${prod.getId()}-${prod.getName()}"><img width="64" height="64"
												src="images/${prod.getImages().get(0).getImageUrl()}"
												alt="${prod.getName()}"></a>
									</td>

									<td class="cart-product-name">
										<a href="/product/${prod.getId()}-${prod.getName()}">${prod.getName()}</a>
									</td>

									<td class="cart-product-price">
										<span class="amount">$${prod.getPrice()}</span>
									</td>

									<td class="cart-product-quantity">
										<div class="quantity clearfix">
											<input type="button" value="-" class="minus">
											<input type="text" name="quantity" value="${prod.getQuantity()}"
												class="qty" />
											<input type="button" value="+" class="plus">
										</div>
									</td>

									<td class="cart-product-subtotal">
										<span id="prod-subtotal" class="amount">$${prod.totalPrice()}</span>
									</td>
								</tr>
							</c:forEach>
							<tr class="cart_checkout">
									<td colspan="6">
										<div class="row clearfix">
											<div class="col-lg-4 col-4 nopadding">
												<div class="row">
													<div class="col-lg-8 col-7">
														<input type="text" value="" class="sm-form-control" placeholder="Enter Coupon Code.." />
													</div>
													<div class="col-lg-4 col-5">
														<a href="#" class="button button-3d button-black nomargin">Apply Coupon</a>
													</div>
												</div>
											</div>
											<div class="col-lg-8 col-8 nopadding">
												<a href="#" onclick="return updateCart()" class="button button-3d nomargin fright">Update Cart</a>
												<a href="/checkout" class="button button-3d notopmargin fright">Proceed to Checkout</a>
											</div>
										</div>
									</td>
							</tr>
						</tbody>

					</table>
				</div>

				<div class="row clearfix justify-content-end">


					<div class="col-lg-12 clearfix ">
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
					</div>
				</div>

			</div>

		</div>

	</section><!-- #content end -->

	<!--Footer-->
	<%@include file="templates/footer.jsp" %>

	<!--Cookies-->
	<%@include file="templates/cookies.jsp"%>

</div><!-- #wrapper end -->

<%@ include file="templates/bottom.jsp" %>