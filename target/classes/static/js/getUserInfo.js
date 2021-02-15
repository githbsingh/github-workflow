/**
 * 
 */

$(document).ready(
		function() {

			// GET REQUEST
			$("#submit-getProfile").click(function(event) {
				event.preventDefault();
				$('.um--container2, .um--container3').hide();
				$('#um--spinner').hide();
				if($("#userPin").val() == ''  && $("#userName").val() == ''){
					$("#usersearch-error").html("Enter user name or user pin");
					return;
				}
				else {
					$("#usersearch-error").html("");
				}
				var postURL = "getUserProfileInfo";
				var formData = {
					userPin: $("#userPin").val(),
					userName: $("#userName").val()
				}
				ajaxPostUserRole(formData,postURL);
			});
			
			$('#userName, #userPin').on('keyup', function(e) {
				$("#usersearch-error").html("");
            });
			
			
			function ajaxGetStaticValues(formData,postURL) {
				$.ajax({
					type : "GET",
					url : "getStaticValues",
					success : function(result) {
						if (null != result) {
							
							/*Empty and load values for "Focus division" list box*/
							$("#js-addDivision").empty();
							$.each(result.divList[0], function (i, d) {
								$('#js-addDivision').append('<option value="' + d.focusDivId + '">' + d.focusDivisionName + '</option>');
							});
							
							$('.um--container2, .um--container3').show();
							$('#um--spinner').hide();
							$('.um--footer').css('position', 'relative');
							
							/*Empty and load values for "Focus division" list box*/
							$("#js-addAccount").empty();
							$.each(result.accList[0], function (i, d) {
								$('#js-addAccount').append('<option value="' + d.focusAccId + '">' + d.focusAccountName + '</option>');
							});
							
							/*Empty and load values for "Focus Country" list box*/
							$("#js-addCountry").empty();
							$.each(result.ctryList[0], function (i, d) {
								$('#js-addCountry').append('<option value="' + d.focusCtryId + '">' + d.focusCountryName + '</option>');
							});
							
							/*Empty and load values for "Focus Technology" list box*/
							$("#js-addTechnology").empty();
							$.each(result.techList[0], function (i, d) {
								$('#js-addTechnology').append('<option value="' + d.focusTechId + '">' + d.focusTechnologyName + '</option>');
							});
							
							/*Empty and load values for "Focus Technology" list box*/
							$("#js-addMarketVertical").empty();
							$.each(result.mrktVrtlvl1List[0], function (i, d) {
								$('#js-addMarketVertical').append('<option value="' + d.focusMrktVrtLvl1Id + '">' + d.focusMrktVrtLvl1Name + '</option>');
							});
							
							/*Empty and load values for "Focus Profit Center" list box*/
							$("#js-addPrftCtrCode").empty();
							$.each(result.focusPrftCtrList[0], function (i, d) {
								$('#js-addPrftCtrCode').append('<option value="' + d.focusPrftCtrId + '">' + d.focusPrftCtrName + '</option>');
							});
							
						} else {
							$('.um--container2, .um--container3').hide();
							$('#um--spinner').hide();
							$('.um--footer').css('position', 'fixed');
							$(".notify-serachResult").notify("User Profile not found, please enter valid user pin or name","warn");
						}
					},
					error : function(e) {
						$('.um--container2, .um--container3').hide();
						$('#um--spinner').hide();
						$('.um--footer').css('position', 'fixed');
						$(".notify-serachResult").notify("Error searching user!","error");
					}
				});
			}

			function ajaxPostUserRole(formData,postURL) {
				
				$('#um--spinner').show();
				
				$.ajax({
					type: "POST",
					contentType: "application/json",
					url: postURL,
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function (result,status) {
						
						if (null != result) {
							
							console.log(result);
							
							$('#userProfileFormId')[0].reset(); 
							
							$("#js-assignRole").empty();
							$("#js-assignRole").append('<option selected disabled value="">Assign Role</option>');
							$.each(result.roleList[0], function (i,d) {
								$('#js-assignRole').append('<option value="' + d + '">' + d + '</option>');
							});
							
							$("input[name=hiddenUserPinInfo]:hidden").val(result.userProfileInfo[0].userPin);
							$("input[name=hiddenUserPin]:hidden").val(result.userProfileInfo[0].userPin);
							$('#userProfileInfo-userPin').text(result.userProfileInfo[0].userPin);
							$('#userProfileInfo-firstName').text(result.userProfileInfo[0].firstName);
							$('#userProfileInfo-lastName').text(result.userProfileInfo[0].lastName);
							$('#userProfileInfo-primaryCountry').text(result.userProfileInfo[0].primaryCountry);
							$('#userProfileInfo-primaryDivision').text(result.userProfileInfo[0].primaryDivision);
							$('#userProfileInfo-emailAddress').text(result.userProfileInfo[0].emailAddress);
							$('#userProfileInfo-jobDescription').text(result.userProfileInfo[0].jobDescription);
							$("#js-assignRole").val(result.userProfileInfo[0].userRole);

							/*Load assigned divisions for user*/
							$("#js-listDivision").empty();
							$.each(result.userDivisionList[0], function (i, d) {
								$('#js-listDivision').append('<option value="' + d.focusDivId + '">' + d.focusDivisionName + '</option>');
							});
							
							/*Load assigned accounts for user*/
							$("#js-listAccount").empty();
							$.each(result.userAccountList[0], function (i, d) {
								$('#js-listAccount').append('<option value="' + d.focusAccId + '">' + d.focusAccountName + '</option>');
							});
							
							/*Load assigned countries for user*/
							$("#js-listCountry").empty();
							$.each(result.userCountryList[0], function (i, d) {
								$('#js-listCountry').append('<option value="' + d.focusCtryId + '">' + d.focusCountryName + '</option>');
							});
							
							/*Load assigned Technologies for user*/
							$("#js-listTechnology").empty();
							$.each(result.userTechnologyList[0], function (i, d) {
								$('#js-listTechnology').append('<option value="' + d.focusTechId + '">' + d.focusTechnologyName + '</option>');
							});
							
							/*Load Market Vertical Level1 for user*/
							$("#js-listMarketVertical").empty();
							$.each(result.userMarketVerticalLevel1List[0], function (i, d) {
								$('#js-listMarketVertical').append('<option value="' + d.focusMrktVrtLvl1Id + '">' + d.focusMrktVrtLvl1Name + '</option>');
							});
							
							/*Empty user market vertical 2 on get profile*/
							$("#js-listMarketVerticalLvl2").empty();
							
							/*Load assigned Profit Center for user*/
							$("#js-listPrftCtrCode").empty();
							$.each(result.userPrftCtrList[0], function (i, d) {
								$('#js-listPrftCtrCode').append('<option value="' + d.focusPrftCtrId + '">' + d.focusPrftCtrName + '</option>');
							});
							
							/*Empty GSC code on get profile*/
							$("#js-listGSCCode").empty();
							
							var divListLength = $('#js-addDivision').children('option').length;
							var accListLength = $('#js-addAccount').children('option').length;
							var ctryListlength = $('#js-addCountry').children('option').length;
							var techListlength = $('#js-addTechnology').children('option').length;
							var mrktListlength = $('#js-addMarketVertical').children('option').length;
							var prftCtrListlength = $('#js-addPrftCtrCode').children('option').length;
							
							if (divListLength <= 0 && accListLength <= 0 && ctryListlength <= 0 && techListlength <= 0 && mrktListlength <= 0 && prftCtrListlength <= 0) {
								ajaxGetStaticValues(formData, postURL);
							} else {
								$('.um--container2, .um--container3').show();
							    $('#um--spinner').hide();
							    $('.um--footer').css('position', 'relative');
							}
							
						} else {
							$('.um--container2, .um--container3').hide();
							$('.um--footer').css('position', 'fixed');
							$("#usersearch-error").html("User Profile not found, please enter valid user pin or name");
						}
					},
					error: function (e) {
						
						$('.um--container2, .um--container3').hide();
						$('.um--footer').css('position', 'fixed');
						$('#um--spinner').hide();
						
						if(e.responseJSON.status == "404"){
							$("#usersearch-error").html(e.responseJSON.error);
						}else{
							$("#usersearch-error").html("Internal error searching user, Please contact support");
						}
						
					}
				});
			}
		})