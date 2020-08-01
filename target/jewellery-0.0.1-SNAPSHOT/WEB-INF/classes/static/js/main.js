(function ($) {
 "use strict";   
   /*-------------------------------------------
	scrollUp
	-------------------------------------------- */	
	jQuery.scrollUp({
        scrollText: '<i class="fa fa-angle-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });	
	/*-------------------------------------------
	sticky header
	-------------------------------------------- */
	$("#main-header").sticky({ topSpacing: 0 });
	/*-------------------------------------------
	tooltip
	-------------------------------------------- */	
		$('[data-toggle="tooltip"]').tooltip();
	/*---------------------------------------------
	jQuery MeanMenu
	--------------------------------------------- */
		$('nav#dropdown').meanmenu();
	/*-------------------------------------------
	wolCarousels
	-------------------------------------------- */	
	 $(".brand-carousel").owlCarousel({
		autoPlay: false,
		items: 5,
		navigation:true,
		itemsDesktop : [1199,5],
		itemsDesktopSmall : [979,4],
		itemsMobile : [767,2],
		rewindNav : false,
		lazyLoad : true
	});
    $(".product-carausel").owlCarousel({
		autoPlay: false,
		items: 4,
		navigation:true,
		itemsDesktop : [1199,4],
		itemsDesktopSmall : [979,3],
		itemsMobile : [767,1],
		rewindNav : false,
		lazyLoad : true
	});
	$(".features-curosel").owlCarousel({
		autoPlay: false,
		items: 4,
		navigation:true,
		itemsDesktop : [1199,4],
		itemsDesktopSmall : [979,3],
		itemsMobile : [767,1],
		rewindNav : false,
		lazyLoad : true
	});
	$(".trend-curosel").owlCarousel({
		autoPlay: false,
		items: 2,
		navigation:true,
		itemsDesktop : [1199,2],
		itemsDesktopSmall : [979,2],
		itemsTablet: [767,1],
		rewindNav : false,
		lazyLoad : true
	});
	$(".newspost-slider").owlCarousel({
		autoPlay: false,
		items: 3,
		navigation:true,
		itemsDesktop : [1199,3],
		itemsDesktopSmall : [979,3],
		itemsTablet: [600,1],
		rewindNav : false,
		lazyLoad : true
	});
	$(".testimonial-carousel").owlCarousel({
		autoPlay: false,
		items: 1,
		navigation:true,
		itemsDesktop : [1199,1],
		itemsDesktopSmall : [979,1],
		itemsTablet: [600,1],
		rewindNav : false,
		lazyLoad : true
	});
	$(".img-carousel").owlCarousel({
		autoPlay: false,
		items: 1,
		navigation:true,
		itemsDesktop : [1199,1],
		itemsDesktopSmall : [979,1],
		itemsTablet: [600,1],
		rewindNav : false,
		lazyLoad : true
	});
	/*-------------------------------------------
	countdown
	-------------------------------------------- */	
	$('[data-countdown]').each(function() {
	  var $this = $(this), finalDate = $(this).data('countdown');
	  $this.countdown(finalDate, function(event) {
		$this.html(event.strftime('<span class="cdown days"><span class="time-count">%-D</span> <p>Days</p></span> <span class="cdown hour"><span class="time-count">%-H</span> <p>Hour</p></span> <span class="cdown minutes"><span class="time-count">%M</span> <p>Min</p></span> <span class="cdown second"> <span class="time-count">%S</span> <p>Sec</p></span>'));
	  });
	});
	/*-------------------------------------------
	progressbar
	-------------------------------------------- */		
	var div_top = $('body').offset().top;
		$(window).scroll(function (){
			if($(window).scrollTop() > div_top){
				$('.pro-width').each(function() {
				$(this).find('.pro-dev').animate({
				  width: $(this).attr('data-percent'),
				}, 2000, function() {
				});
			  });	
			}
		});	
	/*-------------------------------------------
	checkout toggle functions
	-------------------------------------------- */	
	// -- showlogin toggle function
	$( '#showlogin' ).on('click', function() {
        $( '#checkout-login' ).slideToggle(900);
    }); 
	// ---  showcoupon toggle function
	$( '#showcoupon' ).on('click', function() {
		$( '#checkout_coupon' ).slideToggle(900);
	});
	// ---  Create an account toggle function
	$( '#cbox' ).on('click', function() {
		$( '#cbox_info' ).slideToggle(900);
	});
	// --- Create an account toggle function
	$( '#ship-box' ).on('click', function() {
		$( '#ship-box-info' ).slideToggle(1000);
	});
	/*-------------------------------------------
	checkout payment-accordion
	-------------------------------------------- */	
	$(".payment-accordion").collapse({
		accordion:true,
	  open: function() {
		this.slideDown(550);
	  },
	  close: function() {
		this.slideUp(550);
	  }		
	});
	/*-------------------------------------------
	price range slider
	-------------------------------------------- */		  
		$( "#slider-range" ).slider({
			range: true,
			min: 40,
			max: 600,
			values: [ 60, 570 ],
		slide: function( event, ui ) {
			$( "#amount" ).val( "£" + ui.values[ 0 ] + " - £" + ui.values[ 1 ] );
			}
		});
		$( "#amount" ).val( "£" + $( "#slider-range" ).slider( "values", 0 ) +
			" - £" + $( "#slider-range" ).slider( "values", 1 ) );
	/*-------------------------------------------
	option chosen
	-------------------------------------------- */	
		$(".orderby").chosen();
	/*-------------------------------------------
	bxSlider
	-------------------------------------------- */	
	$('.bxslider').bxSlider({
		slideWidth: 102,
		slideMargin:15,
		minSlides: 4,
		maxSlides: 4,
		pager: false,
		speed: 500,
		pause: 3000,
		mode: 'vertical',
		adaptiveHeight: true
	});
	/*-------------------------------------------
	elevateZoom
	-------------------------------------------- */	
	$("#zoom1").elevateZoom({
		gallery:'gallery_01', 
		cursor: 'pointer', 
		galleryActiveClass: "active", 
		imageCrossfade: true
	});
	/*-------------------------------------------
	mixItUp
	-------------------------------------------- */		
	$('.portfolio-content').mixItUp();
	$("li:first-child.filter").addClass("active");
	/*-------------------------------------------
	faq-accordion
	-------------------------------------------- */	
	$('.panel-heading a').on('click', function() {
		$('.panel-default').removeClass('actives');
		$(this).parents('.panel-default').addClass('actives');
	})
	/*-------------------------------------------
	jQuery MeanMenu
	-------------------------------------------- */
	$('nav#dropdown').meanmenu();
   
})(jQuery);


/*$(document).ready(function(){
	
	var links = document.getElementsByClassName('changeable');

	function changeColor(e) {
	    e.target.style.color = e.target.style.color ? null : '#afa376';
	}
	for (var i = 0; i < links.length; i++) {
	    links[i].addEventListener('click', changeColor);
	}
	
});*/