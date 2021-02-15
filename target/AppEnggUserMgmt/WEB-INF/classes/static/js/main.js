$(document).ready(function() {
	//initiate as false
	var isMobile = false; 
	// device detection
	if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent) 
	    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4))) { 
	    isMobile = true;
	    }	
	detectDevicetype(isMobile);	
	   //Enable tooltips
    $('[data-toggle="tooltip"]').tooltip({trigger:"click",
      delay:{"show":400,"hide":800}});
  
    // Add minus icon for collapse element which is open by default
    $(".collapse.show").each(function(){
    	$(this).prev(".card-header").find(".fa").addClass("fa-chevron-up").removeClass("fa-chevron-down");
    	$(this).prev(".card-header").addClass("bg-info").addClass("text-white").removeClass("text-primary");
    });
    // Toggle plus minus icon on show hide of collapse element
    $(".collapse").on('show.bs.collapse', function(){
    	$(this).prev(".card-header").find(".fa").removeClass("fa-chevron-down").addClass("fa-chevron-up");
    	$(this).prev(".card-header").addClass("bg-info").addClass("text-white").removeClass("text-primary");
    }).on('hide.bs.collapse', function(){
    	$(this).prev(".card-header").find(".fa").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    	$(this).prev(".card-header").removeClass("bg-info").removeClass("text-white").addClass("text-primary");
    });

              /* AUTO COMPLETE FOR USER NAME AND PIN - STARTS */
    $('#userPin').autocomplete({
        source: 'searchUser/searchUserPin',
        minLength: 3
    });

    $('#userName').autocomplete({
        source: 'searchUser/searchUserName',
        minLength: 3
    });
    
    /* AUTO COMPLETE FOR USER NAME AND PIN - ENDS */

    $('.um--container2, .um--container3').hide();
  
              var getFullDate = new Date();
    $('.js-copyYear').html(getFullDate.getFullYear()); 
               
    if ($('#userName').val() != '' || $('#userPin').val() != '') {
        $('.um--container2, .um--container3').show();
    } else {
        $('.um--container2, .um--container3').hide();
    }

    $('#js-assignRole').on('change', function(e) {
        $('#submit-assignRoleUpdate').prop('disabled', false);
    });

    /* Tabs */
    show_content(0);

    $('.tabs nav a').on('click', function() {
        show_content($(this).index());
    });

    function show_content(index) {
        // Make the content visible
        $('.tabs .content.visible').removeClass('visible');
        $('.tabs .content:nth-of-type(' + (index + 1) + ')').addClass('visible');

        // Set the tab to selected
        $('.tabs nav a.selected').removeClass('selected');
        $('.tabs nav a:nth-of-type(' + (index + 1) + ')').addClass('selected');
        $('#activeTab').val(index + 1);
    }
    // Tooltip        
    var targets = $( '[rel~=tooltip]' ),
        target  = false,
        tooltip = false,
        title   = false,
        concatTooltip = '';

    /***** Start Tooltip web responsiveness *****/
    var targets = $( '[rel~=tooltip]' ),
        target  = false,
        tooltip = false,
        title   = false,
        concatTooltip = '';
     
    targets.bind( 'click', function()
    {
        target  = $( this );
        tip     = target.data( 'title' );
        tooltip = $( '<div class="js-displaytooltip"></div>' );

        if( !tip || tip == '' )
            return false;

        if($('.js-displaytooltip').length > 0) {
            $('.js-displaytooltip').remove();
        }

        //target.removeAttr( 'data-title' );

        concatTooltip = "<span class='js-closeTooltip'>close [X]</span><br><span>" + tip + "</span>";

        tooltip.css( 'opacity', 0 )
               .html( concatTooltip )
               .appendTo( 'body' );

        var init_tooltip = function()
        {
            if($( window ).width() < 768) {
                tooltip.css( 'max-width', $( window ).width() / 2 );
                var pos_left = target.offset().left + ( target.outerWidth() / 2 ) - ( tooltip.outerWidth() / 2 ),
                pos_top  = target.offset().top;
            }
            else {
                tooltip.css( 'max-width', 250 );
                var pos_left = target.offset().left + ( target.outerWidth() / 2 ) - ( tooltip.outerWidth() / 2 ),
                pos_top  = target.offset().top - tooltip.outerHeight() - 20;
            }

            if($( window ).width() > 767) {
                if(target.hasClass('js-showTooltipRight')) {
                  tooltip.addClass('view-right');
                  tooltip.css( { left: pos_left  + 155 , top: pos_top + 40 } )
                      .animate( { top: '+=10', opacity: 1 }, 50 );
                }
                else {
                  tooltip.removeClass('view-right');
                }
                if(target.hasClass('js-showTooltipLeft') && $( window ).width() > 767) {
                  tooltip.addClass('view-left');
                  tooltip.css( { left: pos_left - 85, top: pos_top + 100 } )
                      .animate( { top: '+=10', opacity: 1 }, 50 );
                }
                else {
                  tooltip.removeClass('view-left');
                }
            }
            else {
                if( pos_left < 0 )
                {
                  pos_left = target.offset().left + target.outerWidth() / 2 - 20;
                  tooltip.addClass( 'left' );
                }
                else {
                  tooltip.removeClass( 'left' );
                }

                if( pos_left + tooltip.outerWidth() > $( window ).width() )
                {
                  pos_left = target.offset().left - tooltip.outerWidth() + target.outerWidth() / 2 + 20;
                  tooltip.addClass( 'right' );
                }
                else {
                  tooltip.removeClass( 'right' );
                }  

                if( pos_top < 0 )
                {
                  var pos_top  = target.offset().top + target.outerHeight();
                  tooltip.addClass( 'top' );
                }
                else {
                  tooltip.removeClass( 'top' );
                }

                tooltip.css( { left: pos_left, top: pos_top + 20} )
                      .animate( { top: '+=10', opacity: 1 }, 50 );
            }

            target.bind( 'click', remove_tooltip );
            tooltip.bind( 'click', remove_tooltip );
        };

        init_tooltip();
        $( window ).resize( init_tooltip );

        var remove_tooltip = function()
        {
            tooltip.animate( { top: '-=10', opacity: 0 }, 50, function()
            {
                $( this ).remove();
            });

            target.data( 'title', tip );
        };

        // to close the tooltip
        $('.js-closeTooltip').on('click', function (e) {
            remove_tooltip();
        });

        $('.tabs nav a, .um--addButton, .um--removeButton').on('click', function() {
            remove_tooltip();
        });

    });
    /***** End Tooltip web responsiveness *****/

    $('.um--inputButton').on('mouseover', function(e) {
        var randColor = [['#FFF000','#AAE600','#00B432'], ['#FAAA19','#AAE600 ','#00B432'],['#AAE600',' #00B432',' #00C8E6'], ['#00B432','#00C8E6','#1E1E96'],['#00B432','#00C8E6','#003CE6'], ['#00C8E6','#003CE6','#1E1E96'], ['#003CE6','#1E1E96','#8228B4'], ['#1E1E96','#8228B4','#8C006E'], ['#8228B4','#8C006E','#FF0000'], ['#8228B4','#8C006E','#DC14AA'], ['#8C006E','#DC14AA','#FF0000'], ['#DC14AA','#FF0000','#F5821E'], ['#8C006E','#FF0000','#F5821E'], ['#FF0000','#F5821E','#FAAA19'], ['#F5821E','#FAAA19','#AAE600'], ['#F5821E','#FAAA19','#FFF000'], ['#FAAA19','#FFF000','#AAE600']];
        var randIndex = Math.floor(Math.random() * randColor.length);
        
        $('body').append('<style>.um--animated-button.um--inputButton:after { background-image: linear-gradient(to bottom, '+randColor[randIndex][0]+', '+randColor[randIndex][1]+', '+randColor[randIndex][2]+');}</style>');
    });
    
    //Detect the type of device users are using for this application
    function detectDevicetype(isMobile)      
    {
    	 var formData={isMobile:isMobile}
    	 var postURL="checkDeviceType";
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: postURL,
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function (result) {
				if (null != result) {
					console.log(result);
					}
				},
			error: function (e) {
				console.log(e);
			   }
		 });
    }


});
