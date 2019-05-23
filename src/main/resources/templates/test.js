<script type="text/javascript">
	
		$(document).ready(function(){
			$('#subscribe').submit(function(e) {
			console.log("in submit");
			e.preventDefault();
			sendData();
			console.log("return false");
			return false;
			});
		});

		$(document).ready(function clear(){
			//$('#firstName').val('');
			//$('#lastName').val('');
			$('#email').val('');
		})

		clear();

		

		function sendData(){
			var formData = new FormData();
			formData.set('email', $('#email').val());
			//formData.set('firstName', $('#firsName').val());
			//formData.set('lastName', $('#lastName').val());

			axios({
			method: 'post',
			url: 'http://localhost:8080/',
			data: formData,
			config: { headers: {'Content-Type': 'multipart/form-data' }}
		})
		.then(function (response){
			if(!alert('Thank you for Subscribing')){window.location.reload()};
		})
		.catch(function (response) {
			if(!alert('You have already subscribed!')){window.location.reload()};
		})

		}
			
</script>