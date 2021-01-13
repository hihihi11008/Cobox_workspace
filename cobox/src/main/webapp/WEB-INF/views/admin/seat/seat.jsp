<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../inc/header.jsp" %>
</head>
<Style>
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #45a049;
}
.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</Style>
<body>
<%@ include file="../inc/main_navi.jsp" %>
<h3>좌석관리</h3>

<div class="container">
  <form>
    <label for="fname">좌석번호(행)</label>
    <select id="country" name="country">
      <option value="1">1</option>
    </select>
    
    <label for="country">좌석이름(열)</label>
    <select id="country" name="country">
      <option value="australia">A</option>
      <option value="canada">B</option>
      <option value="usa">C</option>
    </select>
    
    <label for="country">Hold</label>
    <select id="country" name="country">
      <option value="australia">X</option>
      <option value="canada">O</option>
    </select>

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>