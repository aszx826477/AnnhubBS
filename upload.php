
<!DOCTYPE html>
<html >
	<header>
		<title>PHP文件上传练习</title>
	</header>

	<body>
		<h1>PHP文件上传</h1>
		<form action = "click.php" method="post" enctype="multipart/form-data">
			<input type="file" name = "myfile">
			<button type="submit" >上传</button>
			<button type="submit">保存</button>
			
		</form>
	</body>

<!-- 1.实现文件上传的功能，将test.txt上传至网站的根目录-->
<!-- 2.思考除了使用form的方式上传，还有其他的方式吗，若有请尽量实现-->
<!-- 3.思考标签中type属性的含义，若button的type=button能实现功能吗？-->
<!-- 4.当php无法运行时，尝试学会查看错误日志进行调试-->
<!-- 5.button如果不在form内，能实现功能吗？-->
<!-- 6.如果form里边有两个或多个buttton存在时，会发生什么情况？-->
<!-- 7.借此熟悉PHP的基本语法，以及PHP如何和HTML混着写，PHP与HTML是什么关系？-->

<!--拓展题：当文件比较大的时候，还能正常上传吗，会遇到什么问题？上传大文件时，能显示一个上传的进度条-->

</html>