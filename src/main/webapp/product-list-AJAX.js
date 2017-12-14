/**
 * 
 */

$(document).ready(function() {

			$("#search-form").submit(function(event) {

				event.preventDefault();

				search_prod_ajax_submit();
			});

			list_prod();

			$("#list-form").submit(function(event) {

				event.preventDefault();

				list_prod_ajax_submit();

			});

		});

		function search_prod_ajax_submit() {

			var search = {}
			search["searchText"] = $("#searchProduct").val();
			$("#bth-search").prop("disabled", true);

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "products/search",
				data : JSON.stringify(search),
				dataType : 'json',
				success : function(data) {
					selectRoleToDisplay(data);
					$("#bth-search").prop("disabled", false);
				}
			});
		}

		function list_prod() {
			var search = {}
			search["idArr"];
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "products/del",
				data : JSON.stringify(search),
				dataType : 'json',
				success : function(data) {
					selectRoleToDisplay(data);
				}
			});
		}

		function list_prod_ajax_submit() {

			var search = {}
			var ingredients = document.querySelectorAll('input[type=checkbox][name=del]:checked');
			var temp = ""
			for(var i = 0; i < ingredients.length; i++) {
			    temp += ingredients[i].value + " ";
			}

			search["idArr"] = temp;
			$("#bth-del").prop("disabled", true);

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "products/del",
				data : JSON.stringify(search),
				dataType : 'json',
				success : function(data) {		
					selectRoleToDisplay(data);
					$("#bth-del").prop("disabled", false);
				}
			});
		}
		
		function selectRoleToDisplay(data) {
			if(data.role == '[ROLE_ADMIN]'){
				displayToAdmin(data.products);						
			} else if(data.role == '[ROLE_USER]') {
				displayToUser(data.products);
			} else {
				displayToAnon(data.products);
			}
		}
		
		function displayToAnon(data) {

			var json = "<ul class='prod-list'>";

			for (var i = 0; i < data.length; i++) {
				json += "<li class='prod-item'>"
						+ product(data[i])
						+ "<div class='action-box'>";
				if(data[i].balance){
					json += "<a href='/cart?add&prodId=" + data[i].id + "' class='btn btn-info' role='button'>Add to Cart</a>"
					+ "<a href='/contact/" + data[i].id + "' class='btn btn-info' role='button'>Buy</a>";
							
				} else {
					json += "<p class='error-message'>Not available </p>";
				}
						json += "</div>" 
						+ "</li>";
			}
			json += "</ul>";
			$('#feedback').html(json);
		}
		
		function displayToUser(data) {

			var json = "<ul class='prod-list'>";

			for (var i = 0; i < data.length; i++) {
				json += "<li class='prod-item'>"
						+ product(data[i])
						+ "<div class='action-box'>";
				if(data[i].balance){							
					json += "<a href='/cart?add&prodId=" + data[i].id + "' class='btn btn-info' role='button'>Add to Cart</a>"
					+ "<a href='/order/" + data[i].id + "' class='btn btn-info' role='button'>Buy</a>";
				} else {
					json += "<p class='error-message'>Not available </p>";
				}
						json += "</div>" 
						+ "</li>";
			}
			json += "</ul>";
			$('#feedback').html(json);
		}
		
		function displayToAdmin(data) {

			var json = "<ul class='prod-list'>";

			for (var i = 0; i < data.length; i++) {
				json += "<li class='prod-item'>"
						+ product(data[i])
						+ "<input type='checkbox' name='del' value=" + data[i].id + ">"
						+ "<div class='action-box'>";
				
				if(data[i].balance){
					json += "<a href='/cart?add&prodId=" + data[i].id + "' class='btn btn-info' role='button'>Add to Cart</a>"
						+ "<a href='/order/" + data[i].id + "' class='btn btn-info' role='button'>Buy</a>";
				}else{
					json += "<span class='error-message'>Not available </span>";
				}
				
				json += "<a href='/product/" + data[i].id + "' class='btn btn-warning' role='button'>Edit</a>"
						+ "</div>" 
						+ "</li>";
			}
			json += "</ul>";
			$('#feedback').html(json);
		}
		
		function product(data) {
			return "<a href='/productview/" + data.id + "' class='title' role='button'><h3>" 
				+ data.title + "</h3></a>"
				+ "<p class='g-price-uah'> " + data.cost 
				+ "<span class='g-price-uah-sign'>grn</span></p>"
		}