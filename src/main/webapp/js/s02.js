/* 
 * Introduction to Jakarta Enterprise Edition - Servlet
 * https://github.com/egalli64/jees
 * 
 * See s02/ajax.html
 * Requires access to the DOM
 */

function timerResponseManager() {
  if (this.readyState == XMLHttpRequest.DONE) {
    let target = document.getElementById('time');

    if (this.status != 200) {
      target.value = `[Error: ${this.status}]`;
    } else {
      target.value = this.responseText;
    }
  }
}

document.getElementById('btnTime').addEventListener('click', () => {
  let request = new XMLHttpRequest();
  request.onload = timerResponseManager;
  request.open('GET', '/jees/s02/timerPlain');
  request.send();
});

function usersResponseManager() {
  if (this.readyState == XMLHttpRequest.DONE) {
    let target = document.getElementById('users');

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

document.getElementById('btnUsers').addEventListener('click', () => {
  let request = new XMLHttpRequest();
  request.onload = usersResponseManager;
  request.open('GET', '/jees/s02/users');
  request.send();
});
