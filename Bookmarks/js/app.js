var idd=document.getElementById('myForm').addEventListener('submit', savebookmark);


function savebookmark(e) {
  var siteName = document.getElementById('sitename').value;
  var siteUrl = document.getElementById('siteurl').value;

  var Bookmark = {
    name : siteName,
    url : siteUrl
  }

  //localStorage.setItem("imran", "Programmer");


  if (localStorage.getItem('bookmarks') === null) {
    var bookmarks =[];
    bookmarks.push(Bookmark);
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
  }else {
    var bookmarks = JSON.parse(localStorage.getItem('bookmarks'));
    bookmarks.push(Bookmark);
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
  }

  //console.log(Bookmark);

  //console.log(siteName + "\n" + siteUrl);

  e.preventDefault();
}
