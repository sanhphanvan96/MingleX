$(document).ready(function(){
	$("#btn_edit_gender").click(function(){
		$("#gender").html('\
			<form action="/profile" method="POST" id="gender-update">\
				<div class="form-group">\
					<label class="radio-inline">\
						<input type="radio" name="gender" value="male" checked="checked"/>\
						Male\
					</label>\
					<label class="radio-inline">\
						<input type="radio" name="gender" value="female"/>\
						Female\
					</label>\
					<label class="radio-inline">\
						<input type="radio" name="gender" value="other"/>\
						Other\
					</label>\
				</div>\
				<div class="form-group form-actions text-right">\
					<input type="submit" class="btn btn-primary" value="Done">\
				</div>\
			</form:form>\
		');

	});
	$("#btn_edit_lookingfor").click(function(){
		$("#lookingfor").html('\
				<form action="/profile" method="POST" id="gender-update">\
					<div class="form-group">\
						<label class="radio-inline">\
							<input type="radio" name="lookingfor" value="man" checked="checked"/>\
							Man\
						</label>\
						<label class="radio-inline">\
							<input type="radio" name="lookingfor" value="woman"/>\
							Woman\
						</label>\
						<label class="radio-inline">\
							<input type="radio" name="lookingfor" value="both"/>\
							Both\
						</label>\
					</div>\
					<div class="form-group form-actions text-right">\
						<input type="submit" class="btn btn-primary" value="Done">\
					</div>\
				</form:form>\
		');

	});

});
// $('body').delegate('#gender-update','submit',function(e){
// 	e.preventDefault();
//     var form = $(this);
//     var post_url = form.attr('/profile');
//     var post_data = form.serialize();
// 	console.log(post_data);
//     $.ajax({
//         type: 'POST',
//         url: post_url, 
//         data: post_data,
//         success: function(msg) {
//             $(form).fadeOut(500, function(){
//                 form.html(msg).fadeIn();
//             });
//         }
//     });
// });