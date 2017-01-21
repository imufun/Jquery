var idd=document.getElementById('myForm').addEventListener('submit', savebookmark);


function savebookmark(e) {
  var siteName = document.getElementById('sitename').value;
  var siteUrl = document.getElementById('siteurl').value;

  var Bookmark = {
    name : siteName,
    url : siteUrl
  }
  console.log(Bookmark);
  
  console.log(siteName + "\n" + siteUrl);

  e.preventDefault();
}
