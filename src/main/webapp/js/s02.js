/* 
 * Introduction to Jakarta Enterprise Edition - Servlet
 * https://github.com/egalli64/jees
 * 
 * See s02/ajax.html
 * Requires access to the DOM
 */

/**
 * AJAX callback
 * 
 * Expect server current time as a string in the response 
 * and put it in the target element
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

/*
 * Event listener for time
 * 
 * Perform an XHR GET
 * @see timerResponseManager() the callback
 */
document.getElementById('btnTime').addEventListener('click', () => {
  let request = new XMLHttpRequest();
  request.onload = timerResponseManager;
  request.open('GET', '/jees/s02/timerPlain');
  request.send();
});

/**
 * AJAX callback
 * 
 * Expect a JSON user list in the response.
 * Loop on the list, put the user components in the target
 */
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

/*
 * Event listener for user
 * 
 * Perform an XHR GET
 * @see usersResponseManager() the callback
 */
document.getElementById('btnUsers').addEventListener('click', () => {
  let request = new XMLHttpRequest();
  request.onload = usersResponseManager;
  request.open('GET', '/jees/s02/users');
  request.send();
});
