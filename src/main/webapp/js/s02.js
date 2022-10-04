/*
 * See s02/ajax.html
 *
 * Requires access to the DOM
 */

function timerResponseManager() {
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
	request.onload = timerResponseManager;
	request.open('GET', '/jees/s02/timerPlain');
	request.send();
});

function usersResponseManager() {
	if (this.readyState == XMLHttpRequest.DONE) {
		let target = document.getElementById('target2');

		if (this.status != 200) {
			target.value = `[Error: ${this.status}]`;
		} else {
			target.value = '';
			let json = JSON.parse(this.responseText);
			json.forEach(user => {
				target.value += `[${user.name}: ${user.id}]`;
			});
		}
	}
}

document.getElementById('btnServlet2').addEventListener('click', () => {
	let request = new XMLHttpRequest();
	request.onload = usersResponseManager;
	request.open('GET', '/jees/s02/users');
	request.send();
});
