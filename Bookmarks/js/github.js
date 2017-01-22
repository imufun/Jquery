$(document).ready(function(){

  $("#searchUser").on('keyup', function(e){
    let username = e.target.value;

    //make request
    $.ajax({
      url:'https://api.github.com/users/' + username,
      data:{
        client_id:'cdd25ced894dc2e59a8d',
        client_secret: 'd70eac5bb6ac633894266495189cb9ba3f2b7768'
      }
    }).done(function(user){
        $("#profile").html(`
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${user.name}</h3>
  </div>
  <div class="panel-body">
  <div class="row">
  <div class="col-md-3 col-sm-3">
  <img class="thumbnail img-responsive" src="${user.avatar_url}"  alt="profile avater" />
  <a href="${user.html_url}" target="_blank" class="btn btn-primary">View</a>
  </div>
  <div class="col-md-9 col-sm-9">
      <span class="label label-default">Public Repo: ${user.public_repos}</span>
      <span class="label label-primary">Public Gist: ${user.public_gists}</span>
      <span class="label label-success">Followers: ${user.followers}</span>
      <span class="label label-info">Following: ${user.following}</span>

    <br><br>
    <ul class="list-group">
      <li class="list-group-item">company: ${user.company}</li>
      <li class="list-group-item">Blog: ${user.blog}</li>
      <li class="list-group-item">location : ${user.location}</li>
      <li class="list-group-item">Create Date: ${user.created_at}</li>
 
    </ul>
  </div>
  </div>
  </div>
</div>
        `);
    });


  });
});
