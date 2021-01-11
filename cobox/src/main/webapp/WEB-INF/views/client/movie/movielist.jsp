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
                <h2 class="page-heading">Movies</h2>
                <div class="select-area">
                    <form class="select" method='get'>
                          <select name="select_item" class="select__sort" tabindex="0">
                            <option value="1" selected='selected'>London</option>
                            <option value="2">New York</option>
                            <option value="3">Paris</option>
                            <option value="4">Berlin</option>
                            <option value="5">Moscow</option>
                            <option value="3">Minsk</option>
                            <option value="4">Warsawa</option>
                            <option value="5">Kiev</option>
                        </select>
                    </form>

                    <div class="datepicker">
                      <span class="datepicker__marker"><i class="fa fa-calendar"></i>Date</span>
                      <input type="text" id="datepicker" value='03/10/2014' class="datepicker__input">
                    </div>

                    <form class="select select--cinema" method='get'>
                          <select name="select_item" class="select__sort" tabindex="0">
                            <option value="1" selected='selected'>Cineworld</option>
                            <option value="2">Empire</option>
                            <option value="3">Everyman</option>
                            <option value="4">Odeon</option>
                            <option value="5">Picturehouse</option>
                        </select>
                    </form>

                    <form class="select select--film-category" method='get'>
                          <select name="select_item" class="select__sort" tabindex="0">
                            <option value="2" selected='selected'>Children's</option>
                            <option value="3">Comedy</option>
                            <option value="4">Drama</option>
                            <option value="5">Fantasy</option>
                            <option value="6">Horror</option>
                            <option value="7">Thriller</option>
                        </select>
                    </form>
                </div>
                <!-- Movie preview item -->
                <div class="movie movie--preview movie--full release">
                     <div class="col-sm-3 col-md-2 col-lg-2">
                            <div class="movie__images">
                                <img alt='' src="/resources/images/movie/movie-sample1.jpg">
                            </div>
                    </div>

                    <div class="col-sm-9 col-md-10 col-lg-10 movie__about">
                            <a href='/movie/detail' class="movie__title link--huge">Last Vegas (2013)</a>

                            <p class="movie__time">105 min</p>

                            <p class="movie__option"><strong>Country: </strong><a href="#">USA</a></p>
                            <p class="movie__option"><strong>Category: </strong><a href="#">Comady</a></p>
                            <p class="movie__option"><strong>Release date: </strong>November 1, 2013</p>
                            <p class="movie__option"><strong>Director: </strong><a href="#">Jon Turteltaub</a></p>
                            <p class="movie__option"><strong>Actors: </strong><a href="#">Robert De Niro</a>, <a href="#">Michael Douglas</a>, <a href="#">Morgan Freeman</a>, <a href="#">Kevin Kline</a>, <a href="#">Mary Steenburgen</a>, <a href="#">Jerry Ferrara</a>, <a href="#">Romany Malco</a> <a href="#">...</a></p>
                            <p class="movie__option"><strong>Age restriction: </strong><a href="#">13</a></p>
                    </div>
                </div>
                <!-- end movie preview item -->
                <div class="coloum-wrapper">
                    <div class="pagination paginatioon--full">
                            <a href='#' class="pagination__prev">prev</a>
                            <a href='#' class="pagination__next">next</a>
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