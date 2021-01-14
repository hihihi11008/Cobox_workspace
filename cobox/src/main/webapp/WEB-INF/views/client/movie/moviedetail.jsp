<<<<<<< HEAD
<%@page import="com.koreait.cobox.model.domain.Movie"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
Movie movie=(Movie)request.getAttribute("movie"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<script>
$(function(){
	
	
	$($("input[type='button']")[0]).click(function(){
		regist();
	});
		
});
//글등록 요청
function regist(){
	$("form").attr({
		action:"/client/comments/regist"
		method:"post"
	});
	$("form").submit();
}



</script>


=======
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
<%@ include file="../inc/header.jsp"%>
</head>
<body class="single-cin">
	<div class="wrapper">
		<%@include file="../inc/top.jsp"%>
		<!-- Main content -->
		<section class="container">
			<div class="col-sm-12">
				<div class="movie">
<<<<<<< HEAD
					<h2 class="page-heading"><%=movie.getMovie_name() %></h2>
=======
					<h2 class="page-heading">The Hobbit: An Unexpected Journey</h2>
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523

					<div class="movie__info">
						<div class="col-sm-4 col-md-3 movie-mobile">
							<div class="movie__images">
<<<<<<< HEAD
								<img alt='' src="/resources/data/<%=movie.getMovie_id()%>.<%=movie.getPoster()%>">
=======
								<img alt='' src="/resources/images/movie/single-movie.jpg">
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
							</div>
						</div>

						<div class="col-sm-8 col-md-9">
							<p class="movie__time">169 min</p>

							<p class="movie__option">
<<<<<<< HEAD
								<strong>장르: </strong><a>장르 테이블에서 꺼내기</a>
							</p>
							<p class="movie__option">
								<strong>개봉일: </strong><a ><%=movie.getRelease() %></a>
							</p>
							<p class="movie__option">
								<strong>감독: </strong><a><%=movie.getDirector() %></a>
							</p>
							<p class="movie__option">
								<strong>배우: </strong><%=movie.getActor() %>
							</p>
							<p class="movie__option">
								<strong>관람연령: </strong><a ><%=movie.getRating_id() %></a>
							</p>
							<p class="movie__option">
								<strong>줄거리: </strong><a><%=movie.getStory() %></a>							
							</p>
							
						<a href="#" class="btn btn-md btn--warning"><%=movie.getMovie_name() %> 예매하기</a>
							<p>
=======
								<strong>Country: </strong><a href="#">New Zeland</a>, <a
									href="#">USA</a>
							</p>
							<p class="movie__option">
								<strong>Year: </strong><a href="#">2012</a>
							</p>
							<p class="movie__option">
								<strong>Category: </strong><a href="#">Adventure</a>, <a
									href="#">Fantazy</a>
							</p>
							<p class="movie__option">
								<strong>Release date: </strong>December 12, 2012
							</p>
							<p class="movie__option">
								<strong>Director: </strong><a href="#">Peter Jackson</a>
							</p>
							<p class="movie__option">
								<strong>Actors: </strong><a href="#">Martin Freeman</a>, <a
									href="#">Ian McKellen</a>, <a href="#">Richard Armitage</a>, <a
									href="#">Ken Stott</a>, <a href="#">Graham McTavish</a>, <a
									href="#">Cate Blanchett</a>, <a href="#">Hugo Weaving</a>, <a
									href="#">Ian Holm</a>, <a href="#">Elijah Wood</a> <a href="#">...</a>
							</p>
							<p class="movie__option">
								<strong>Age restriction: </strong><a href="#">13</a>
							</p>
							<p class="movie__option">
								<strong>Box office: </strong><a href="#">$1 017 003 568</a>
							</p>

>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
							<a href="#" class="comment-link">Comments: 15</a>
						</div>
					</div>
						<div class="clearfix"></div>
<<<<<<< HEAD
					<h2 class="page-heading">줄거리 요약</h2>

					<p class="movie__describe">영화 상세내용 올곳(json??)</p>
				</div>
				
				<div class="clearfix"></div>
				<h2 class="page-heading">영화 후기 (15)</h2>
=======
					<h2 class="page-heading">The plot</h2>

					<p class="movie__describe">Bilbo Baggins is swept into a quest
						to reclaim the lost Dwarf Kingdom of Erebor from the fearsome
						dragon Smaug. Approached out of the blue by the wizard Gandalf the
						Grey, Bilbo finds himself joining a company of thirteen dwarves
						led by the legendary warrior, Thorin Oakenshield. Their journey
						will take them into the Wild; through treacherous lands swarming
						with Goblins and Orcs, deadly Wargs and Giant Spiders,
						Shapeshifters and Sorcerers. Although their goal lies to the East
						and the wastelands of the Lonely Mountain first they must escape
						the goblin tunnels, where Bilbo meets the creature that will
						change his life forever ... Gollum. Here, alone with Gollum, on
						the shores of an underground lake, the unassuming Bilbo Baggins
						not only discovers depths of guile and courage that surprise even
						him, he also gains possession of Gollum's "precious" ring that
						holds unexpected and useful qualities ... A simple, gold ring that
						is tied to the fate of all Middle-earth in ways Bilbo cannot begin
						to ...</p>
				</div>
				<div class="clearfix"></div>
				<h2 class="page-heading">comments (15)</h2>
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523

				<div class="comment-wrapper">
					<form id="comment-form" class="comment-form" method='post'>
						<textarea class="comment-form__text"
<<<<<<< HEAD
							placeholder='후기를 작성하세요' name="content" id="content"></textarea>
						<label class="comment-form__info">250 characters left</label>
						<input type="button" class="btn btn-md btn--danger comment-form__btn" value="댓글등록">
=======
							placeholder='Add you comment here'></textarea>
						<label class="comment-form__info">250 characters left</label>
						<button type='submit'
							class="btn btn-md btn--danger comment-form__btn">add
							comment</button>
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
					</form>

					<div class="comment-sets">

						<div class="comment">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar.jpg">
							</div>

							<a href='#' class="comment__author"><span
<<<<<<< HEAD
								class="social-used fa fa-facebook" name="member_id"></span>Roberta Inetti</a>
							<p class="comment__date">today | 03:04</p>
							<p class="comment__message" name="msg">아주 재밌어요</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>

					
=======
								class="social-used fa fa-facebook"></span>Roberta Inetti</a>
							<p class="comment__date">today | 03:04</p>
							<p class="comment__message">Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod
								erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante
								justo, volutpat at viverra a, mattis in velit. Morbi molestie
								rhoncus enim, vitae sagittis dolor tristique et.</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>

						<div class="comment">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar-olia.jpg">
							</div>

							<a href='#' class="comment__author"><span
								class="social-used fa fa-vk"></span>Olia Gozha</a>
							<p class="comment__date">22.10.2013 | 14:40</p>
							<p class="comment__message">Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod
								erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante
								justo, volutpat at viverra a, mattis in velit. Morbi molestie
								rhoncus enim, vitae sagittis dolor tristique et.</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>

>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
						<div class="comment comment--answer">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar-dmitriy.jpg">
							</div>

							<a href='#' class="comment__author"><span
								class="social-used fa fa-vk"></span>Dmitriy Pustovalov</a>
							<p class="comment__date">today | 10:19</p>
<<<<<<< HEAD
							<p class="comment__message">진짜여???</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>
						
						<div id="list-area"></div>

						
=======
							<p class="comment__message">Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod
								erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante
								justo, volutpat at viverra a, mattis in velit. Morbi molestie
								rhoncus enim, vitae sagittis dolor tristique et.</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>

						<div class="comment comment--last">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar-sia.jpg">
							</div>

							<a href='#' class="comment__author"><span
								class="social-used fa fa-facebook"></span>Sia Andrews</a>
							<p class="comment__date">22.10.2013 | 12:31</p>
							<p class="comment__message">Lorem ipsum dolor sit amet,
								consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod
								erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante
								justo, volutpat at viverra a, mattis in velit. Morbi molestie
								rhoncus enim, vitae sagittis dolor tristique et.</p>
							<a href='#' class="comment__reply">Reply</a>
						</div>

						<div id='hide-comments' class="hide-comments">
							<div class="comment">
								<div class="comment__images">
									<img alt='' src="/resources/images/comment/avatar.jpg">
								</div>

								<a href='#' class="comment__author"><span
									class="social-used fa fa-facebook"></span>Roberta Inetti</a>
								<p class="comment__date">today | 03:04</p>
								<p class="comment__message">Lorem ipsum dolor sit amet,
									consectetur adipiscing elit. Ut vitae enim sollicitudin,
									euismod erat id, fringilla lacus. Cras ut rutrum lectus. Etiam
									ante justo, volutpat at viverra a, mattis in velit. Morbi
									molestie rhoncus enim, vitae sagittis dolor tristique et.</p>
								<a href='#' class="comment__reply">Reply</a>
							</div>

							<div class="comment">
								<div class="comment__images">
									<img alt='' src="/resources/images/comment/avatar-olia.jpg">
								</div>

								<a href='#' class="comment__author"><span
									class="social-used fa fa-vk"></span>Olia Gozha</a>
								<p class="comment__date">22.10.2013 | 14:40</p>
								<p class="comment__message">Lorem ipsum dolor sit amet,
									consectetur adipiscing elit. Ut vitae enim sollicitudin,
									euismod erat id, fringilla lacus. Cras ut rutrum lectus. Etiam
									ante justo, volutpat at viverra a, mattis in velit. Morbi
									molestie rhoncus enim, vitae sagittis dolor tristique et.</p>
								<a href='#' class="comment__reply">Reply</a>
							</div>
						</div>
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523

						<div class="comment-more">
							<a href="#" class="watchlist">Show more comments</a>
						</div>
					</div>
				</div>
			</div>
	</section>

	<%@include file="../inc/footer.jsp"%>
	</div>
	<%@include file="../inc/script.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			init_MovieList();
		});
	</script>
</body>
</html>