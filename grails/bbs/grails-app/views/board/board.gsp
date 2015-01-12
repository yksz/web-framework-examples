<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'bbs.css')}" type="text/css">
  <title>${board.name}</title>
  <script type="text/javascript">
  <!--
    function validate() {
        var title = document.form.title.value;
        var message = document.form.message.value;
        if (title == "" || message == "") {
            alert("<g:message code="bbs.error.enter.fields" />");
            return false;
        }
        return true;
    }
  // -->
  </script>
</head>
<body class="main">
  <div id="header" align="right">
    <a class=sidebar href="/bbs/main">top</a>
  </div>

  <div id="contents">
    <div class="section">
      <h1 align="center">${board.name}</h1>
    </div>
    <g:form url="/bbs/${board.id}/add" method="post"
      name="form" onsubmit="return validate()" useToken="true">
      <table align="center">
        <tbody>
          <tr>
            <td class="item"><g:message code="bbs.thread.title" /></td>
            <td>
              <input type="text" name="title">
              <input type="submit" name="submit" value="<g:message code="bbs.thread.create" />">
            </td>
          </tr>
          <tr>
            <td class="item"><g:message code="bbs.response.username" /></td>
            <td><input type="text" name="username"></td>
          </tr>
          <tr>
            <td class="item"><g:message code="bbs.response.comment" /></td>
            <td>
              <textarea name="message" rows="10" cols="60"></textarea>
            </td>
          </tr>
        </tbody>
      </table>
    </g:form>
    <hr>
    <p>
    <g:each in="${threads}" status="i" var="thread">
      <a href="/bbs/${board.id}/${thread.id}/" target="mainFrame">
        ${i+1}: ${thread.title} (${thread.responseCount})
      </a>
      &nbsp;
    </g:each>
    </p>
  </div>

  <div id="footer" align="right">
    <a class=sidebar href="/bbs/main">top</a>
  </div>
</body>
</html>
