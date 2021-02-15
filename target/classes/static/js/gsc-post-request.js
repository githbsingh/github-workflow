/**
 * Method to get list of GSC based on the selection of profit center
 */
$(document).ready(
	function () {
		$("#js-addPrftCtrCode").change(function (event) {
			event.preventDefault();
			var postURL = "getGscCode";
			var formData = {
				prftCtrId: $("#js-addPrftCtrCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxGetGSCList(formData, postURL);
		});

		$("#js-listPrftCtrCode").change(function (event) {
			event.preventDefault();
			var postURL = "getUserGscCode";
			var formData = {
				userPrftCtrId: $("#js-listPrftCtrCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxGetGSCList(formData, postURL);
		});

		function ajaxGetGSCList(formData, postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {

						if (postURL == "getGscCode") {
							/*Empty and load values for "GSC Code" list box on select of Profit Center*/
							$("#js-addGSCCode").empty();
							$.each(result, function (i, d) {
								$('#js-addGSCCode').append('<option value="' + d.focusGscId + '">' + d.focusGscName + '</option>');
							});
						} else if (postURL == "getUserGscCode") {
							/*Empty and load values for "GSC Code" list box on select of Profit Center - USER ASSIGNED*/
							$("#js-listGSCCode").empty();
							$.each(result, function (i, d) {
								$('#js-listGSCCode').append('<option value="' + d.focusGscId + '">' + d.focusGscName + '</option>');
							});
						} else {
							$(".notify-GSC-result").notify("Error loading GSC Code", "error");
						}

					} else {
						$(".notify-GSC-result").notify("No results found", "warn");
					}
				},
				error: function (e) {
					$(".notify-GSC-result").notify("Error loading GSC Code", "error");
				}
			});
		}
		
		/**
		 * Method to assign the selected profit center to user
		 */

		$('#submit-addListPrftCtr').on('click', function (e) {

			event.preventDefault();
			if (null == $("#js-addPrftCtrCode").val() || '' == $("#js-addPrftCtrCode").val()) {
				$(".notify-GSC-result").notify("Please select a Profit Center", "warn");
				return;
			}
			var postURL = "updateUserProfitCenter";
			var formData = {
				prftCtrId: $("#js-addPrftCtrCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUpdateUserProfitCenter(formData, postURL);
		});
		
		$('#submit-removeListPrftCtr').on('click', function (e) {

			event.preventDefault();
			if (null == $("#js-listPrftCtrCode").val() || '' == $("#js-listPrftCtrCode").val()) {
				$(".notify-GSC-result").notify("Please select a Profit Center", "warn");
				return;
			}
			var postURL = "deleteUserProfitCenter";
			var formData = {
				userPrftCtrId: $("#js-listPrftCtrCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUpdateUserProfitCenter(formData, postURL);
		});
		
		function ajaxPostUpdateUserProfitCenter(formData, postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						
						$("#js-listPrftCtrCode").empty();
						
						$.each(result, function (i, d) {
							$('#js-listPrftCtrCode').append('<option value="' + d.focusPrftCtrId + '">' + d.focusPrftCtrName + '</option>');
						});

						$("#js-listGSCCode").empty();

						$(".notify-GSC-result").notify("User Profit Center Updated Successfully", "success");
					} else {
						$(".notify-GSC-result").notify("Error updating user Market Vertical", "error");
					}
				},
				error: function (e) {
					$(".notify-GSC-result").notify("Error updating user Market Vertical", "error");
				}
			});
		}
		
		/**
		 * Method to assign the selected GSC Code to user
		 */

		$('#submit-addListGSCCode').on('click', function (e) {

			event.preventDefault();
			if (null == $("#js-addGSCCode").val() || '' == $("#js-addGSCCode").val()) {
				$(".notify-GSC-result").notify("Please select a Profit Center and GSC Code", "warn");
				return;
			}
			var postURL = "updateUserGscCode";
			var formData = {
				prftCtrId: $("#js-addPrftCtrCode").val(),
				gscId: $("#js-addGSCCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUpdateUserGscCode(formData, postURL);
		});
		
		$('#submit-removeListGSCCode').on('click', function (e) {

			event.preventDefault();
			if ((null == $("#js-listPrftCtrCode").val() || '' == $("#js-listPrftCtrCode").val())
					|| (null == $("#js-listGSCCode").val() || '' == $("#js-listGSCCode").val())) {
				$(".notify-GSC-result").notify("Please select a Profit Center and GSC Code", "warn");
				return;
			}
			var postURL = "deleteUserGscCode";
			var formData = {
				userPrftCtrId: $("#js-listPrftCtrCode").val(),
				userGscId: $("#js-listGSCCode").val(),
				userPin: $("#hiddenUserPin").val()
			}
			ajaxPostUpdateUserGscCode(formData, postURL);
		});
		
		function ajaxPostUpdateUserGscCode(formData, postURL) {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: postURL,
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function (result) {
					if (null != result) {
						//console.log(result);

						$("#js-listPrftCtrCode").empty();
						$.each(result.userPrftCtrList[0], function (i, d) {
							$('#js-listPrftCtrCode').append('<option value="' + d.focusPrftCtrId + '">' + d.focusPrftCtrName + '</option>');
						});
						
						$("#js-listGSCCode").empty();
						$.each(result.userGscList[0], function (i, d) {
							$('#js-listGSCCode').append('<option value="' + d.focusGscId + '">' + d.focusGscName + '</option>');
						});
						
						$(".notify-GSC-result").notify("GSC Code Updated Successfully", "success");
					} else {
						$(".notify-GSC-result").notify("Error updating GSC Code", "error");
					}
				},
				error: function (e) {
					$(".notify-GSC-result").notify("Error updating GSC Code", "error");
				}
			});
		}
	})