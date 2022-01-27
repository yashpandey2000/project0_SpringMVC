$(function() {
	$("#selectall").click(function() {
		$('.case').attr('checked', this.checked);
	});
	$(".case").click(function() {

		if ($(".case").length == $(".case:checked").length) {
			$("#selectall").attr("checked", "checked");
		} else {
			$("#selectall").removeAttr("checked");
		}

	});
});