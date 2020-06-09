<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>卓护加固-Annhub</title>
	<meta name="description" content="Annhub是一个安卓应用加固平台" />
	<meta name="keywords" content="卓护, Android, 安卓, 保护, 应用, 平台, 可视化, 软件, UI, 管理" />
	<meta name="author" content="Annhub"/>

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Bootstrap core CSS -->
    <link href="vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="dist/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendors/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dist/css/creative.min.css" rel="stylesheet">
    
  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">卓护Annhub</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">简介Localhost</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">服务</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">技术栈</a>
            </li>
          
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">联系我们</a>
            </li>
            <li class="nav-item">
              <?php include 'modules/class/authenticate.php';
                    if(check_cookie() == 0): ?>
                <a class="nav-link js-scroll-trigger" href="manage_index.php">控制台</a>
              <?php else: ?>
                <a class="nav-link js-scroll-trigger" href="login.php">登录/注册</a>
              <?php endif ?>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <img width="250" height="180" src="dist/img/logo2.png"/>
            <hr>
          </div>
          <div class="col-lg-8 mx-auto">
            <span style="font-size:30px">
              专注于Android App加固与检测的平台
            </span>
            <br/>
           
            <br/>
            <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">了解平台</a>
          </div>
        </div>
      </div>
    </header>

    <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-white">大道至简的解决方案</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">
              面对日益增长的安卓应用威胁我们提供解决方案，我们只专注于Android加固和检测技术，汲取最新的技术手段，为您的应用提供最安全的保障
            </p>
            <a class="btn btn-light btn-xl js-scroll-trigger" href="#services">了解服务</a>
          </div>
        </div>
      </div>
    </section>
  

    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading">服务</h2>
            <hr class="my-4">
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-shield text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">免费加固</h3>
              <p class="text-muted mb-0">提供基础的加固服务，能够满足一般的加固需求</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-search text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">免费检测</h3>
              <p class="text-muted mb-0">提供基础的检测服务，检测常见的代码漏洞与缺陷</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-sliders text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">定制功能</h3>
              <p class="text-muted mb-0">您可以选择定制服务以获得更好的加固与检测服务</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-heart text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">自主管理</h3>
              <p class="text-muted mb-0">每位注册的用户可以在网页端自主管理自己的应用</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="p-0" id="portfolio">
      <div class="container-fluid p-0">
        <div class="row no-gutters popup-gallery">
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/1.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/1.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    审核开发语言生成详细的整改报告
                  </div>
                  <div class="project-name">
                    源码审计
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/2.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/2.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Android应用动静态检测，自主评估风险
                  </div>
                  <div class="project-name">
                    安全检测
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/3.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/3.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    专注Android应用加固技术最优化
                  </div>
                  <div class="project-name">
                    安全加固
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/4.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/4.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    采用机器学习引擎采集恶意行为，自动完善加固方案
                  </div>
                  <div class="project-name">
                    智能加固引擎
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/5.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/5.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    检测结果多维图表展示，生成清晰简明的报告
                  </div>
                  <div class="project-name">
                    可视化
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="dist/img/portfolio/fullsize/6.jpg">
              <img class="img-fluid" src="dist/img/portfolio/thumbnails/6.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    用户的数据和通信均采用统一的安全策略，构建敏感数据城墙
                  </div>
                  <div class="project-name">
                    数据城墙
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>

    <section id="experience" class="bg-dark text-white">
      <div class="container text-center">
        <h2 class="mb-4">免费开始Android保护体验</h2>
        <a class="btn btn-light btn-xl sr-button" href="login.php">开始</a>
      </div>
    </section>

    <section id="contact" >
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">联系我们</h2>
            <hr class="my-4">
            <p class="mb-5">想了解更多关于Android加固和检测的信息吗？想了解更详细的“卓护”细节吗？请联系我们，我们会尽快给您答复。</p>
          </div>
        </div>
        <div class="row">
          <style type="text/css">
            .choose:hover {
              color: #3A7DD8;
              transition:color 0.2s ease
            }
          </style>
          <div class="col-lg-4 ml-auto text-center choose" >
            <i class="fa fa-phone fa-3x mb-3 sr-contact"></i>
            <p>123-456-6789</p>
          </div>
          <div class="col-lg-4 mr-auto text-center choose">
            <i class="fa fa-envelope-o fa-3x mb-3 sr-contact"></i>
            <p>yelbee@qq.com</p>
          </div>
        </div>
       
      </div>
    </section>
    <div class="text-center" style="background-color: #2E3033; margin: 0; padding: 20px">
        <a style="color: #ffffff; font-size: 12px">版权所有 卓护开发团队 All Right Reserved.Annuhub 2018-2019</a>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendors/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="vendors/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendors/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendors/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendors/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="dist/js/creative.min.js"></script>

  </body>

</html>
