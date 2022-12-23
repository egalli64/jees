/* 
 * Introduction to Jakarta Enterprise Edition - Servlet
 * https://github.com/egalli64/jees
 * 
 * See s05/checker.html
 * Requires access to the DOM
 */

function callback() {
  if (this.readyState == XMLHttpRequest.DONE) {
    let target = document.getElementById('target');

    if (this.status != 200) {
      target.textContent = `[Something went wrong: ${this.status}]`;
      return;
    }

    target.textContent = this.responseText;
  }
}

document.getElementById('btnCheck').onclick = () => {
  let name = document.getElementById('name');
  let target = '/jees/s05/checkerPlain?user=' + name.value;

  let request = new XMLHttpRequest();
  request.onload = callback;
  request.open('GET', target);
  request.send();
};
