<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'bbs.css')}" type="text/css">
  <title>${thread.title}</title>
  <script type="text/javascript">
  <!--
    function validate() {
        var message = document.form.message.value;
        if (message == "") {
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
    <a class=sidebar href="/bbs/${board.id}/">board</a>
    |
    <a class=sidebar href="/bbs/main/">top</a>
  </div>

  <div id="contents">
    <div id="thread">
      <h1>${thread.title}</h1>
      <dl>
      <g:each in="${responses}" status="i" var="response">
        <dt>
          ${response.number} <b>${response.username}</b>: ${response.dateCreated} ID:${response.pin}
        </dt>
        <dd>
          <g:lines string="${response.message}" />
        </dd>
      </g:each>
      </dl>
      <hr>
      <g:form url="/bbs/${board.id}/${thread.id}/add" method="post"
        name="form" onsubmit="return validate()" useToken="true">
        <table align="center">
          <tbody>
            <tr>
              <td class="item"><g:message code="bbs.response.username" /></td>
              <td>
                <input type="text" name="username">
                <input type="submit" name="submit" value="<g:message code="bbs.response.post" />">
              </td>
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
    </div>
  </div>

  <div id="footer" align="right">
    <a class=sidebar href="/bbs/${board.id}/">board</a>
    |
    <a class=sidebar href="/bbs/main/">top</a>
  </div>
</body>
</html>
