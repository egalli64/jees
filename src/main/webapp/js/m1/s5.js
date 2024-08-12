/* 
 * Introduction to Jakarta Enterprise Edition - Servlet
 * https://github.com/egalli64/jees
 * 
 * See s05/checker.html
 * Requires access to the DOM
 */

/**
 * AJAX callback
 * 
 * Expect a string in the response and put it in the target element
 */
function checkedManager() {
  if (this.readyState == XMLHttpRequest.DONE) {
    let target = document.getElementById('target');
    target.textContent = this.status == 200 ? this.responseText : `[Error ${this.status}]`;
  }
}

/*
 * Event listener for checker
 * 
 * Perform an XHR GET for the user specified name
 * @see checkedManager() the callback
 */
document.getElementById('btnCheck').onclick = () => {
  let request = new XMLHttpRequest();
  request.onload = checkedManager;

  let target = '/jees/m1/s5/checkerPlain?user=' + document.getElementById('name').value;
  request.open('GET', target);
  request.send();
};
