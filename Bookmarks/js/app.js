var idd=document.getElementById('myForm').addEventListener('submit', savebookmark);


function savebookmark(e) {
  var siteName = document.getElementById('sitename').value;
  var siteUrl = document.getElementById('siteurl').value;

  //bookmarks object
  var Bookmark = {
    name : siteName,
    url : siteUrl
  }

  //localStorage.setItem("imran", "Programmer");

  var bookmarks =[];

  if (localStorage.getItem('bookmarks') === null) {
    bookmarks.push(Bookmark);
    //save localStorage
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
  }else {
    var bookmarks = JSON.parse(localStorage.getItem('bookmarks'));
    bookmarks.push(Bookmark);
    //fectch data from localStorage
    localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
  }
  fetchBookmarks();
  e.preventDefault();
}

function deleteBookmarks(url){
   var bookmarks = JSON.parse(localStorage.getItem('bookmarks'));
   for (var i = 0; i <bookmarks.length; i++) {
     if(bookmarks[i].url == url){
       bookmarks.splice(i, 1 );
     }
   }
   //fetchBookmarks();
  localStorage.setItem('bookmarks', JSON.stringify(bookmarks));
  fetchBookmarks();
}


//
 function fetchBookmarks(){
   var bookmarks = JSON.parse(localStorage.getItem('bookmarks'));
   //get ouputid
   var bookmarksResult = document.getElementById('BookMarskResult');
   bookmarksResult.innerHTML = '';

   for (var i = 0; i < bookmarks.length; i++) {
     var name = bookmarks[i].name;
     var url = bookmarks[i].url;

     bookmarksResult.innerHTML +='<div class="well">' +
                                '<h3>' +name+ '</h3>' +
                                '<a href="'+url+'" class="btn btn-info" target="_blank">Visit</a>'+
                                '<a onclick="deleteBookmarks(\''+url+'\')" href="#" class="btn btn-info">Delete</a>'+
                                '</div>';
   }




//   console.log(bookmarks);
 }
