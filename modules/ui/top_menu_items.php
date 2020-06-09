			
			<!-- Top Menu Items -->
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<a id="toggle_nav_btn" class="toggle-left-nav-btn inline-block mr-20 pull-left" href="javascript:void(0);"><i class="fa fa-bars"></i></a>
				<a href="index.php"><img class="brand-img pull-left" src="dist/img/logo.png" alt="brand" style="height: 50px; width: 70px"/></a>
				<ul class="nav navbar-right top-nav pull-right">
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle pr-0" data-toggle="dropdown"><img src="<?php echo $user_info['head_url']; ?>" alt="user_auth" class="user-auth-img img-circle"/><span class="user-online-status"></span></a>
						<ul class="dropdown-menu user-auth-dropdown" data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">

							<li>
								<a><i class="fa fa-fw fa-user"></i> <?php echo $user_info['nickname']; ?> </a>
							</li>
							<li>
								<a style="text-transform: lowercase;"><i class="fa fa-fw fa-envelope" ></i> <?php echo $user_info['email']; ?> </a>
							</li>
							<li>
								<a href="information.php"><i class="fa fa-fw fa-cog"></i> 信息与设置</a>
							</li>
							<li class="divider"></li>
						
							<li>
														
								<a id="logout-option" href='modules/class/authenticate.php?fun=logout'><i class="fa fa-fw fa-power-off"></i> 登出</a>
								
    
							</li>
						</ul>
					</li>
				</ul>
				<div class="collapse navbar-search-overlap" id="site_navbar_search">
					<form role="search">
						<div class="form-group mb-0">
							<div class="input-search">
								<div class="input-group">	
									<input type="text" id="overlay_search" name="overlay-search" class="form-control pl-30" placeholder="Search">
									<span class="input-group-addon pr-30">
									<a  href="javascript:void(0)" class="close-input-overlay" data-target="#site_navbar_search" data-toggle="collapse" aria-label="Close" aria-expanded="true"><i class="fa fa-times"></i></a>
									</span> 
								</div>
							</div>
						</div>
					</form>
				</div>
			</nav>
			<!-- /Top Menu Items -->