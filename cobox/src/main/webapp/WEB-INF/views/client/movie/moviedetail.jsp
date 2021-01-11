<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../inc/header.jsp"%>
</head>
<body class="single-cin">
	<div class="wrapper">
		<%@include file="../inc/top.jsp"%>
		<!-- Main content -->
		<section class="container">
			<div class="col-sm-12">
				<div class="movie">
					<h2 class="page-heading">The Hobbit: An Unexpected Journey</h2>

					<div class="movie__info">
						<div class="col-sm-4 col-md-3 movie-mobile">
							<div class="movie__images">
								<img alt='' src="/resources/images/movie/single-movie.jpg">
							</div>
						</div>

						<div class="col-sm-8 col-md-9">
							<p class="movie__time">169 min</p>

							<p class="movie__option">
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

							<a href="#" class="comment-link">Comments: 15</a>
						</div>
					</div>
						<div class="clearfix"></div>
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

				<div class="comment-wrapper">
					<form id="comment-form" class="comment-form" method='post'>
						<textarea class="comment-form__text"
							placeholder='Add you comment here'></textarea>
						<label class="comment-form__info">250 characters left</label>
						<button type='submit'
							class="btn btn-md btn--danger comment-form__btn">add
							comment</button>
					</form>

					<div class="comment-sets">

						<div class="comment">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar.jpg">
							</div>

							<a href='#' class="comment__author"><span
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

						<div class="comment comment--answer">
							<div class="comment__images">
								<img alt='' src="/resources/images/comment/avatar-dmitriy.jpg">
							</div>

							<a href='#' class="comment__author"><span
								class="social-used fa fa-vk"></span>Dmitriy Pustovalov</a>
							<p class="comment__date">today | 10:19</p>
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