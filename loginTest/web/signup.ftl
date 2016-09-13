<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery validation plug-in - main demo</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/base.css" />
</head>
<body>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/signupvalidate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function check () {
        //判断用户名是否为空
        $("#username").blur("click", function () {//
            var username = $("#username").val(); //获取用户名文本框的值
            if (username == null || username == "") {//验证是否为空
                $("#msg1").html("Username cannot be empty");
            } else {
                $("#msg1").html("");
            }
        });

        //判断密码是否为空
        $("#password").blur("click", function () {//绑定文本框失去焦点事件
            var password = $("#password").val(); //获取用户名文本框的值
            if (password == null || password == "") {//验证是否为空
                $("#msg2").html("Password cannot be empty");
            } else {
                $("#msg2").html("");
            }
        });
    });

    function check() {
        $(function() {
            $.post("check.do",
                    {  username:  $("#username").val(),
                        password:  $("#password").val() },
                    function(data){
                $("#info").replaceWith('<div id="info">'+ data + '</div>');
            });
        });
    }
</script>

<form class="cmxform" id="signupForm" method="post" action="signup.do">
    <div id="info"></div>
	<fieldset>
		<legend>Validating a complete form</legend>
			<table>
				<tr>
					<td><label for="username">Username</label></td>
					<td><input id="username" name="username" type="text"/></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input id="password" name="password" type="password" /></td>
				</tr>
				<tr>
					<td><label for="confirm_password">Confirm password</label></td>
					<td><input id="confirm_password" name="confirm_password" type="password" /></td>
				</tr>
				<tr>
					<td><label for="email">Email</label></td>
					<td><input id="email" name="email" type="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
                        <input type="button" id="button" value="check" onclick="check()"  />
						<input class="submit" type="submit" value="Submit"/>
					</td>
				</tr>
			</table>
	</fieldset>
</form>
</body>
</html>
