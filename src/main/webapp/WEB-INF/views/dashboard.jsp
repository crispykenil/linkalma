
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>
				<div id="user-info-panel" class="clear-fix">
					<div class="profile-pic fl">
						<img src="images/profile-pic.png" width="162px" height="158px" />
					</div>
					<div class="user-info fl">
						<h2>Gautam Sharma</h2>
						<ul>
							<li> <label>Email:</label> gautam.sharma@rediffmail.com</li>
							<li> <label>Contact No:</label> gautam.sharma@rediffmail.com</li>
							
						</ul>
						<div class="posting-panel">
							<form:form action="addwallpost" method="post">
								<textarea placeholder="Share your views" name="wallPost"></textarea>
								<div class="posting-options border-box clear-fix">
									<div class="fl">
										Post At: <input type="checkbox" name="postTo" value="1" /> LinkAlma  
									</div>
									<div class="fr">
										<input type="submit" value="Post" class="smalbtn"/>
									</div>
									
								</div>
								</form:form>
						</div>
					</div>
					
				</div>
				<div class="left-column border-box">
				<div class="vertical-main-nav">
					<ul>
						<li><a href="javascirpt:;">My Activities</a>
							<ul>
								<li><a href="javascirpt:;">My Alumnus</a></li>
								<li><a href="javascirpt:;">My Schools</a></li>
								<li><a href="javascirpt:;">My Groups</a></li>
							</ul>
						</li>
						
					</ul>
					<ul>
						<li><a href="javascirpt:;">My Associates</a>
							<ul>
								<li><a href="javascirpt:;">Group1 Name</a></li>
								<li><a href="javascirpt:;">School1 Name</a></li>
								<li><a href="javascirpt:;">School2 Name</a></li>
								<li><a href="javascirpt:;">Group1 Name</a></li>
							</ul>
						</li>
						
					</ul>
					<ul>
						<li><a href="javascirpt:;">Privacy Settings</a>
							<ul>
								<li><a href="javascirpt:;">My Alumnus</a></li>
								<li><a href="javascirpt:;">My Schools</a></li>
								<li><a href="javascirpt:;">My Groups</a></li>
							</ul>
						</li>
						
					</ul>
				</div>
				</ul>
				
					
					
				</div><!-- left-side-wrapper -->
				<div class="main-content border-box">
						<div class="panel">
						<div class="panel-header">
							<h3>My School's Update</h3>
						</div>
						<div class="panel-content">
							<c:forEach var='schoolMap' items='${model.schoolUpdatesDtoMap}'>
									<h3>${schoolMap.key}</h3>
							    <c:forEach var='schoolUpdateDto' items='${schoolMap.value}' >
									<p><b>${schoolUpdateDto.title } </b></p>
									<p>${schoolUpdateDto.description }</p>
							    </c:forEach>
							</c:forEach>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My Updates</h3>
							</div>
							<div class="panel-content">
								<c:forEach var='userUpdateDto' items='${model.userUpdateDto}' >
								<p><b>${userUpdateDto.subject }</b></p>
								<p>${userUpdateDto.description } <br> ${userUpdateDto.createDttm }</p>
						    </c:forEach>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My Group's Updates</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My School's News & Event</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
						<div class="panel">
							<div class="panel-header">
								<h3>My School's Update</h3>
							</div>
							<div class="panel-content">
								<h3>Ryan International</h3>
								<p>Lorum epusm kapsup repsm kolika,lorum epsum kapsu usssum kaliupam dihlka, lorum epsum</p>
							</div>
						</div>
				</div>
				

			</div>


<%@ include file="footer.jsp" %>