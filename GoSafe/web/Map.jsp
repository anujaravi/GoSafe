<!DOCTYPE html>
<!-- Website template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Map</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if IE 7]>
			<link rel="stylesheet" href="css/ie7.css" type="text/css">
		<![endif]-->
        <script
src="http://maps.googleapis.com/maps/api/js">
</script>



<script>

function initialize() {
    var latitude = "<%=(Double)request.getAttribute("latitude")%>";
    var longitude = "<%=(Double)request.getAttribute("longitude")%>";
    //document.write("Anuja " + latitude +" "+ longitude)
var myLatlng = new google.maps.LatLng(latitude,longitude);
var mapProp = {
center: myLatlng,
zoom:15
};
var map=new google.maps.Map(document.getElementById("nav"), mapProp);
var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Hello World!'
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>
</head>
<body>
	<div class="page">
		<div class="header">
			<div>
				<a href="index.html" id="logo"><img src="images/modified_4.jpg" alt="logo" height="50" width="200" ></a>
				<ul>
					<li>
						<a href="index.html">Home</a>
					</li>
					
				</ul>
			</div>
		</div>
		<div >
			
				<center>
				<div id="nav" style="width:1500px;height:450px;"></div>	
                                <div>
                                    <h4>
                                            This place falls under Severity level 
                                        <%
                                            Integer level = (Integer) request.getAttribute("severity");
                                            if(level!=null)
                                                out.println(" " +level + "</br>");
                                        %>
                                    </h4>
                                        <h3>Details:</h3>
                                        <h4>
                                        <%
                                            String comments = (String) request.getAttribute("comments");
                                            if(comments!=null)
                                                out.println(" " +comments +"<br><br>");
                                        %>
                                        </h4>
                                </div>
                                                      </center>

                </div>
		<div class="footer">
			<div>
				
				<p class="footnote">&#169; Copyright &#169; 2011. Go Safe. All rights reserved</p>
			</div>
		</div>
	</div>
</body>
</html>
