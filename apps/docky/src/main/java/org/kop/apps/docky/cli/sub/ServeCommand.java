package org.kop.apps.docky.cli.sub;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import picocli.CommandLine;

import java.io.File;
import java.io.PrintWriter;

@CommandLine.Command(name = "serve")
@Slf4j
public class ServeCommand implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        log.info("serve");
        var tc = new Tomcat();
        tc.setBaseDir("temp");
        tc.setPort(8080);

        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();

        Context context = tc.addContext(contextPath, docBase);

        class SampleServlet extends HttpServlet {

            @SneakyThrows
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
                PrintWriter writer = resp.getWriter();

                writer.println("<html><title>Welcome</title><body>");
                writer.println("<h1>Have a Great Day!</h1>");
                writer.println("</body></html>");
            }
        }

        String servletName = "SampleServlet";
        String urlPattern = "/aa";

        tc.addServlet(contextPath, servletName, new SampleServlet());
        context.addServletMappingDecoded(urlPattern, servletName);

        tc.start();
        tc.getServer().await();
    }
}
