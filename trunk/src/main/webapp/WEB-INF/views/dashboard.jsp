
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>
<div class="three-column-layout">

		<div id="user-info-panel" class="clear-fix">
			<div class="profile-pic fl">
				<img src="images/profile-pic.png" width="162px" height="158px" />
			</div>
			<div class="user-info fl">
				<h2>${model.userBean.firstName} &nbsp; ${model.userBean.lastName}</h2>
				<ul>
					<li> <label>Email:</label> ${model.userBean.emailId }</li>
					
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
		<div class="left-column">
			<div class="vertical-main-nav">
				<ul>
					<li><a href="javascirpt:;">Personalize</a>
						<ul>
							<li><a href="viewprofile" title="Update Profile">Update Profile</a></li>
							<li><a href="javascirpt:;" title="Add Groups">Add Groups</a></li>
							<li><a href="javascirpt:;" title="Add Friends">Add Alumnus</a></li>
						</ul>
					</li>
					
				</ul>
				<ul>
					<li><a href="javascirpt:;">Links</a>
						<ul>
							<li><a href="myalumnus">My Alumnus</a></li>
							<li><a href="viewprofile">My Schools</a></li>
							<li><a href="javascirpt:;">My Groups</a></li>
						</ul>
					</li>
					
				</ul>
				<ul>
					<li><a href="javascirpt:;">Privacy Settings</a>
						<ul>
							<li><a href="javascirpt:;">My Data</a></li>
							<li><a href="javascirpt:;">My Updates</a></li>
						</ul>
					</li>
					
				</ul>
			</div>
		</div><!-- left-side-column -->
		<div class="main-content border-box">
		<div class="post-update-section">
			<c:forEach var='userUpdateDto' items='${model.userUpdateDto}'>
					<div class="panel">
						<div class="panel-content">
							<div class="my-updates">
								<h3>${userUpdateDto.userFirstName} ${userUpdateDto.userLastName}</h3> 
								<div class="smallestFont post-timestamp">${userUpdateDto.createDttm }</div>
								<p>${userUpdateDto.description }  	</p>
							</div>
							
							
							
							<div class="icon-tool-bar">
								<ul class="inline-element-container clear-fix">
									<li><a href="javascript:;">Like</a></li>
									<li><a href="javascript:;">Comments</a></li>
									<li><a href="javascript:;">Share</a></li>
								</ul>
							</div>
							<div class="user-comments-section">
								<ul>
									<li class="smallFont">
									<h3>Gautam Sharma -</h3>
									dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfsa f dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfs</li>
									<li class="smallFont">
									<h3>Kenil Doshi -</h3>
									dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfsa f dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfs</li>
									<li class="smallFont">
									<h3>Ram Narayan Shiv Dasani-</h3>
									dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfsa f dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfs</li>
									<li class="smallFont">
									<h3>Suhas Shinde -</h3>
									dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfsa f dfdsaf sadf sdafsa fsad fsdaf sadf asfsa dfsadf asdf asdf sadf asdf asdfsafdsa fasdfs</li>
								</ul>
							</div>
						</div>
						
					</div>
			
			 </c:forEach>
		</div>

			
			
		</div>
		<div class="right-column">
			<div class="vertical-main-nav">
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
			</div>
		</div><!-- right-side-wrapper -->

</div>

<%@ include file="footer.jsp" %>