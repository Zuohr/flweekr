    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
      <div class="container" style="width:1140px;" >
        <div class="navbar-header" style="margin-left:26px;">
          <a class="navbar-brand" href="home.do" style="font-family:arial; font-size:24px; color:#fff;">EasyTrip</a>
        </div>
        <div class="navbar-collapse collapse">
        
         <ul class="nav navbar-nav">
         	<li><a href="home.do">Home</a></li>
            <li class="${requestScope.nav_gallery }"><a href="search.do">Gallery</a></li>
            <li class="${requestScope.nav_explore}"><a href="getdetail.do">Explore</a></li>
            <li class="${requestScope.nav_travel}"><a href="mappic.do">Travel</a></li>
            <li class="${requestScope.nav_trend}"><a href="getstats.do">Trend</a></li>
            <li class="${requestScope.nav_about }"><a href="#about">About</a></li>
          </ul>
          
           <form  action="search.do" method="get">
            <div class="input-group" style="margin-top:8px; margin-right:40px; width:300px; float:right;">
              <input type="text" class="form-control" placeholder="Begin a journey" name="key" value="">
              <span class="input-group-btn">
                <button class="btn btn-default" type="submit" value="submit">search</button>
              </span>
            </div><!-- /input-group -->
            </form>
              
        </div><!--/.nav-collapse -->
      </div>
    </div>