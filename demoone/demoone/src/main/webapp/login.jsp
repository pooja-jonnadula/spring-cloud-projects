<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>

<h3>Login Form Demo</h3>

<div>
  <form modelAttribute="loginForm" method="POST" action="/login" >
    <label for="fname">User Name</label>
    <input type="text" id="uname" name="username" placeholder="Your name..">

    <label for="lname">Password</label>
    <input type="text" id="pwd" name="password" placeholder="Your Password..">
  
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
