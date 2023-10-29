# ⚙️ Basic authentication with JSP, Servlets

Based on Java Servlets, Java EE.

## 📦 Try it with Apache Tomcat

1. Download an **Apache Tomcat** [archive] (I recommend Tomcat 10.1).
2. Build `.war` via [Eclipse] or other IDE, Text Editor.
3. Untar your Tomcat archive.
4. **Running:**

- Run it with [Eclipse] on Apache Tomcat server that you've previously downloaded.
- **Or** copy your `.war` file to `<your-tomcat-server-folder>/webapps/`.

Then run it with `<your-tomcat-server-folder>/bin/startup.sh`.\
*See logs:* `tail -f <your-tomcat-server-folder>/logs/catalina.out`.\
*Shutdown:* `<your-tomcat-server-folder>/bin/shutdown.sh`.

**P.S.:** You can use **the** `.war` **file from that target folder.**

5. Then you just open in your browser `localhost:8080/basic-auth-ee/` (Obviously, with HTTP)

**P.S.:** Also you need change DB url, user, password in `Context.java`.

### Contributors

<div align="center">
    <a href="https://github.com/kenkoro/Alarm-bot/graphs/contributors">
      <img src="https://contrib.rocks/image?repo=kenkoro/Alarm-bot" />
    </a>
</div>

[archive]: https://tomcat.apache.org/download-10.cgi
[Eclipse]: https://www.eclipse.org/
