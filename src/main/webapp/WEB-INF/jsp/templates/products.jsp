<!-- Content
            ============================================= -->
<section id="content">

	<div class="content-wrap">

		<div class="container clearfix">

			<!-- Post Content
                        ============================================= -->
			<div class="postcontent nobottommargin col_last">

				<!-- Shop
                            ============================================= -->
				<div id="shop" class="shop product-3 grid-container clearfix" style="margin-block-end: 3em;">

					<!--For each product-->
					<c:forEach items="${ products.getContent() }" var="product">


						<div class="product  clearfix">
							<input type="hidden" value="${product.getId()}" id="product_id">
							<div class="product-image">
								<c:choose>
									<c:when test="${ product.getImages().size() > 2 }">
										<div class="fslider" data-arrows="false">
											<div class="flexslider">
												<div class="slider-wrap">
													<c:forEach items="${product.getImages()}" var="image">
														<div class="slide"><a
																href="/product/${product.getId()}-${product.getName()}"><img
																	src="/images/${image.getImageUrl()}"
																	alt="${product.getName()} "></a></div>
													</c:forEach>

												</div>
											</div>
										</div>

									</c:when>
									<c:otherwise>
										<c:forEach items="${product.getImages()}" var="image">
											<a href="/product/${product.getId()}-${product.getName()}"><img
													src="/images/${image.getImageUrl()}" alt="Checked Short Dress"></a>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								<c:if test="${product.onSale()}">
									<div class="sale-flash">${product.getSaleAmount()}% Off*</div>
								</c:if>
								<div class="product-overlay">
									<a onclick="return addToCart(${product.getId()},1)"  href="#" class="add-to-cart"><i class="icon-shopping-cart"></i><span> Add to
											Cart</span></a>
									<a href="/product/${product.getId()}-${product.getName()}">
										<i class="icon-zoom-in2"></i><span>Show Product</span></a>
								</div>
							</div>
							<div class="product-desc center">
								<div class="product-title">
									<h3><a
											href="/product/${product.getId()}-${product.getName()}">${product.getName()}</a>
									</h3>
								</div>
								<c:choose>
									<c:when test="${product.onSale()}">
										<div class="product-price"><del>$${product.getOriginalPrice()}</del>
											<ins>$${product.getPrice()}</ins>
										</div>
									</c:when>
									<c:otherwise>
											<div class="product-price"> <ins>$${product.getPrice()}</ins></div>
									</c:otherwise>
								</c:choose>
							
							</div>
						</div>


					</c:forEach>


				</div><!-- #shop end -->

				<!--Pagination-->
				<c:if test="${products.getTotalPages() > 1}">
					<ul class="pagination justify-content-center pagination-dark ">
						<c:if test="${!products.isFirst()}">
							<li class="page-item"><a class="page-link"
									href="?page=${products.getNumber()}&sb=${sb}&sd=${sd}" tabindex="-1"
									aria-disabled="true">Previous</a></li>
						</c:if>

						<c:forEach begin="0" end="${products.getTotalPages()-1}" var="number">
							<c:choose>
								<c:when test="${number == products.getNumber()}">
									<li class="page-item active"><a class="page-link"
											href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
								</c:when>

								<c:otherwise>
									<li class="page-item"><a class="page-link"
											href="?page=${number+1}&sb=${sb}&sd=${sd}">${number + 1}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${!products.isLast()}">
							<li class="page-item"><a class="page-link"
									href="?page=${products.getNumber()+2}&sb=${sb}&sd=${sd}">Next</a></li>
						</c:if>
					</ul>
				</c:if>
				<!--End pagination-->

			</div><!-- .postcontent end -->