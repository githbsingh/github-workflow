$(document).ready(
	function () {
		
		$('#submit-assignRoleUpdate').on('click', function (e) {

			event.preventDefault();
			
			var postURL = "updateUserRole";
			var formData = {
				userPin: $("#hiddenUserPinInfo").val(),
				userRole: $("#js-assignRole").val()
			}
			ajaxPostUserRole(formData,postURL);
		});
				
		function ajaxPostUserRole(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				success : function(result) {
					if (null != result && result == "success") {
						$(".notify-roleUpdateResult").notify("User Role Updated!",{ position:"right top", className: "success" });
						$('#submit-assignRoleUpdate').prop('disabled', true);
					} else {
						$(".notify-roleUpdateResult").notify("Error updating user Role",{ position:"right top", className: "error" });
					}
				},
				error: function (e) {
					$(".notify-roleUpdateResult").notify("Error updating user Role",{ position:"right top", className: "error" });
				}
			});
		}
		
		//FOCUS DIVISON UPDATE / DELETE POST REQUESTS STARTS
		$('#submit-addListDivision').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-addDivision").val() || '' == $("#js-addDivision").val()){
				$(".notify-division-result").notify("Please select a Division","warn");
				return;
			}
			var postURL = "updateUserDivision";
			var formData = {
				divId: $("#js-addDivision").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserDivision(formData,postURL);
		});
		
		$('#submit-removeListDivision').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-listDivision").val() || '' == $("#js-listDivision").val()){
				$(".notify-division-result").notify("Select valid Division","warn");
				return;
			}
			var postURL = "deleteUserDivision";
			var formData = {
				userDivId: $("#js-listDivision").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserDivision(formData,postURL);
		});

		function ajaxPostUserDivision(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						$("#js-listDivision").empty();
						$.each(result, function (i, d) {
							$('#js-listDivision').append('<option value="' + d.focusDivId + '">' + d.focusDivisionName + '</option>');
						});
						$(".notify-division-result").notify("User Division updated Successfully","success");
					} else {
						$(".notify-division-result").notify("Error updating user Division","error");
					}
				},
				error: function (e) {
					$(".notify-division-result").notify("Error updating user Division","error");
				}
			});
		}
		//FOCUS DIVISON UPDATE / DELETE POST REQUESTS ENDS
		
		//FOCUS ACCOUNT UPDATE / DELETE POST REQUESTS STARTS
		$('#submit-addListAccount').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-addAccount").val() || '' == $("#js-addAccount").val()){
				$(".notify-account-result").notify("Please select an Account ","warn");
				return;
			}
			var postURL = "updateUserAccount";
			var formData = {
				accId: $("#js-addAccount").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserAccount(formData,postURL);
		});
		$('#submit-removeListAccount').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-listAccount").val() || '' == $("#js-listAccount").val()){
				$(".notify-account-result").notify("Select valid Account","warn");
				return;
			}
			var postURL = "deleteUserAccount";
			var formData = {
				userAccId: $("#js-listAccount").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserAccount(formData,postURL);
		});
		function ajaxPostUserAccount(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						$("#js-listAccount").empty();
						$.each(result, function (i, d) {
							$('#js-listAccount').append('<option value="' + d.focusAccId + '">' + d.focusAccountName + '</option>');
						});
						$(".notify-account-result").notify("User Account updated Successfully","success");
					} else {
						$(".notify-account-result").notify("Error updating user Account","error");
					}
				},
				error: function (e) {
					$(".notify-account-result").notify("Error updating user Account","error");
				}
			});
		}
		//FOCUS ACCOUNT UPDATE / DELETE POST REQUESTS ENDS
		
		//FOCUS COUNTRY UPDATE / DELETE POST REQUESTS STARTS
		$('#submit-addListCountry').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-addCountry").val() || '' == $("#js-addCountry").val()){
				$(".notify-country-result").notify("Please select a Country ","warn");
				return;
			}
			var postURL = "updateUserCountry";
			var formData = {
				ctryId: $("#js-addCountry").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserCountry(formData,postURL);
		});
		$('#submit-removeListCountry').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-listCountry").val() || '' == $("#js-listCountry").val()){
				$(".notify-country-result").notify("Select valid Country","warn");
				return;
			}
			var postURL = "deleteUserCountry";
			var formData = {
				userCtryId: $("#js-listCountry").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserCountry(formData,postURL);
		});
		function ajaxPostUserCountry(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						$("#js-listCountry").empty();
						$.each(result, function (i, d) {
							$('#js-listCountry').append('<option value="' + d.focusCtryId + '">' + d.focusCountryName + '</option>');
						});
						$(".notify-country-result").notify("User Country updated Successfully","success");
					} else {
						$(".notify-country-result").notify("Error updating user Country","error");
					}
				},
				error: function (e) {
					$(".notify-country-result").notify("Error updating user Country","error");
				}
			});
		}
		//FOCUS COUNTRY UPDATE / DELETE POST REQUESTS ENDS
		
		//FOCUS TECHNOLOGY UPDATE / DELETE POST REQUESTS STARTS
		$('#submit-addListTechnology').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-addTechnology").val() || '' == $("#js-addTechnology").val()){
				$(".notify-technology-result").notify("Please select a Technology ","warn");
				return;
			}
			var postURL = "updateUserTechnology";
			var formData = {
				techId: $("#js-addTechnology").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserTechnology(formData,postURL);
		});
		$('#submit-removeListTechnology').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-listTechnology").val() || '' == $("#js-listTechnology").val()){
				$(".notify-technology-result").notify("Select valid Technology","warn");
				return;
			}
			var postURL = "deleteUserTechnology";
			var formData = {
				userTechId: $("#js-listTechnology").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUserTechnology(formData,postURL);
		});
		function ajaxPostUserTechnology(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						$("#js-listTechnology").empty();
						$.each(result, function (i, d) {
							$('#js-listTechnology').append('<option value="' + d.focusTechId + '">' + d.focusTechnologyName + '</option>');
						});
						$(".notify-technology-result").notify("User Technology updated Successfully","success");
					} else {
						$(".notify-technology-result").notify("Error updating user Technology","error");
					}
				},
				error: function (e) {
					$(".notify-technology-result").notify("Error updating user Technology","error");
				}
			});
		}
		//FOCUS TECHNOLOGY UPDATE / DELETE POST REQUESTS ENDS
		
		$("#js-addMarketVertical").change(function(event) {
			event.preventDefault();
			var postURL = "getMarketVerticalLevel2";
			var formData = {
				mrktVrtLvl1Id: $("#js-addMarketVertical").val(),
				userPin: $("#hiddenUserPin").val()
			}
			//console.log(formData);
			ajaxGetMarketVerticalLevel2(formData, postURL);
		});
		
		function ajaxGetMarketVerticalLevel2(formData, postURL) {
		    $.ajax({
		        type: "POST",
		        contentType: "application/json",
		        url: postURL,
		        data: JSON.stringify(formData),
		        dataType: 'json',
		        success: function(result) {
		            if (null != result) {
		            	//console.log(result);	
		                /*Empty and load values for "Focus MarketVerticalLvl2" list box on select of MarketVerticalLvl1*/
		                $("#js-addMarketVerticalLvl2").empty();
		                $.each(result, function(i, d) {
		                    $('#js-addMarketVerticalLvl2').append('<option value="' + d.focusMrktVrtLvl2Id + '">' + d.focusMrktVrtLvl2Name + '</option>');
		                });

		            } else {
		                $(".notify-marketVertical-result").notify("No results found", "warn");
		            }
		        },
		        error: function(e) {
		            $(".notify-marketVertical-result").notify("No results found", "error");
		        }
		    });
		}
		
		//ONCHANGE EVENT FOR USER MARKET VERTICAL LEVEL1 - STARTS
		$("#js-listMarketVertical").change(function(event) {
			event.preventDefault();
			var postURL = "getUserMarketVerticalLevel2";
			var formData = {
				userMrktVrtLvl1Id: $("#js-listMarketVertical").val(),
				userPin: $("#hiddenUserPin").val()
			}
			//console.log(formData);
			ajaxGetUserMarketVerticalLevel2(formData, postURL);
		});
		
		function ajaxGetUserMarketVerticalLevel2(formData, postURL) {
		    $.ajax({
		        type: "POST",
		        contentType: "application/json",
		        url: postURL,
		        data: JSON.stringify(formData),
		        dataType: 'json',
		        success: function(result) {
		            if (null != result) {
		            	//console.log(result);	
		                /*Empty and load values for "Focus MarketVerticalLvl2" list box on select of MarketVerticalLvl1*/
		                $("#js-listMarketVerticalLvl2").empty();
		                $.each(result, function(i, d) {
		                    $('#js-listMarketVerticalLvl2').append('<option value="' + d.focusMrktVrtLvl2Id + '">' + d.focusMrktVrtLvl2Name + '</option>');
		                });

		            } else {
		                $(".notify-marketVertical-result").notify("No results found", "warn");
		            }
		        },
		        error: function(e) {
		            $(".notify-marketVertical-result").notify("No results found", "error");
		        }
		    });
		}
		//ONCHANGE EVENT FOR USER MARKET VERTICAL LEVEL1 - ENDS
		
		//FOCUS MARKET VERTICAL UPDATE / DELETE POST REQUESTS STARTS
		$('#submit-addListMarketVertical').on('click', function (e) {

			event.preventDefault();
			if(null == $("#js-addMarketVerticalLvl2").val() || '' == $("#js-addMarketVerticalLvl2").val()){
				$(".notify-marketVertical-result").notify("Please select a Level 2 vertical ","warn");
				return;
			}
			var postURL = "updateUserMarketVerticalLevel2";
			var formData = {
				mrktVrtLvl1Id: $("#js-addMarketVertical").val(),
				mrktVrtLvl2Id: $("#js-addMarketVerticalLvl2").val(),
				userPin: $("#hiddenUserPin").val()
			}
			//console.log(formData);
			ajaxPostUserMarketVerticalLevel2(formData,postURL);
		});
		
		$('#submit-removeListMarketVertical').on('click', function (e) {

			event.preventDefault();
			if((null == $("#js-listMarketVerticalLvl2").val() || '' == $("#js-listMarketVerticalLvl2").val())
					|| (null == $("#js-listMarketVertical").val() || '' == $("#js-listMarketVertical").val())){
				$(".notify-marketVertical-result").notify("Please select one Level1 and Level2 segment to delete","warn");
				return;
			}
			var postURL = "deleteUserMarketVerticalLevel2";
			var formData = {
				userMrktVrtLvl1Id: $("#js-listMarketVertical").val(),
				userMrktVrtLvl2Id: $("#js-listMarketVerticalLvl2").val(),
				userPin: $("#hiddenUserPin").val()
			}
			//console.log(formData);
			ajaxPostUserMarketVerticalLevel2(formData,postURL);
		});
		
		function ajaxPostUserMarketVerticalLevel2(formData,postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						console.log(result);
						
						$("#js-listMarketVertical").empty();
						$.each(result.userMrktVrtlvl1List[0], function (i, d) {
							$('#js-listMarketVertical').append('<option value="' + d.focusMrktVrtLvl1Id + '">' + d.focusMrktVrtLvl1Name + '</option>');
						});
						
						$("#js-listMarketVerticalLvl2").empty();
						$.each(result.userMrktVrtlvl2List[0], function (i, d) {
							$('#js-listMarketVerticalLvl2').append('<option value="' + d.focusMrktVrtLvl2Id + '">' + d.focusMrktVrtLvl2Name + '</option>');
						});
						
						$(".notify-marketVertical-result").notify("User Market Vertical updated Successfully","success");
					} else {
						$(".notify-marketVertical-result").notify("Error updating user Market Vertical","error");
					}
				},
				error: function (e) {
					$(".notify-marketVertical-result").notify("Error updating user Market Vertical","error");
				}
			});
		}
		
	})
	
	