/**
 * See s09.html
 *
 * Requires
 *	jQuery - AJAX support
 *	access to the DOM
 */

function callback() {
	if (this.readyState == XMLHttpRequest.DONE) {
		let target = document.getElementById('target');

		if (this.status != 200) {
			target.value = `[Error: ${this.status}]`;
		} else {
			target.value = this.responseText;
		}
	}
}

document.getElementById('btnServlet').addEventListener('click', () => {
	let request = new XMLHttpRequest();
	request.onload = callback;
	request.open('GET', 's09/timerPlain');
	request.send();
});


document.getElementById('btnServlet2').addEventListener('click', () => {
	$.getJSON('s09/users', (json) => {
		let target = document.getElementById('target2');
		
		target.value = '';
		json.forEach((user) => {
			target.value += `[${user.name}: ${user.id}]`;
		});
	});
});
