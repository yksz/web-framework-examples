<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'bbs.css')}" type="text/css">
  <title><g:message code="bbs.menu.page.title" /></title>
</head>
<body id="menu">

<g:each in="${bbs.Board.list()}" status="i" var="board">
  <a class=menu href="/bbs/${board.id}" target="mainFrame">
    ${board.name}
  </a>
  <br>
</g:each>

</body>
</html>