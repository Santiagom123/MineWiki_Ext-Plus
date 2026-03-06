package org.santiagom123;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.santiagom123.libs.K.XRcheck;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Window {

    public void mainWindow() {
        XRcheck.XRinit();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MineWiki");
            URL fileIcon = Window.class.getResource("textures/iconTemp.png");

            if (fileIcon != null) {
                frame.setIconImage(new ImageIcon(fileIcon).getImage());
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(Color.red);
            JLabel label = new JLabel(getURL.obtainURL(), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 40));
            panel.add(label, BorderLayout.CENTER);
            frame.add(panel, BorderLayout.NORTH);

            JFXPanel fxPanel = new JFXPanel();
            createScene(fxPanel);
            frame.add(fxPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private void createScene(JFXPanel jfxPanel) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            String targetUrl = getURL.obtainURL();

            new Thread(() -> {
                String processedHtml = fetchBypassedHtml(targetUrl);


                String baseUrl = targetUrl.substring(0, targetUrl.lastIndexOf("/") + 1);
                String fixedHtml = processedHtml.replaceFirst("<head>", "<head><base href=\"" + baseUrl + "\">");

                Platform.runLater(() -> {

                    engine.loadContent(fixedHtml, "text/html");
                    jfxPanel.setScene(new Scene(webView));
                });
            }).start();
        });
    }

    private String fetchBypassedHtml(String url) {
        try {

            ProcessBuilder pb = new ProcessBuilder(UnPackHandler.getJarPath() + "/worker.exe", url);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            InputStream is = process.getInputStream();
            Scanner s = new Scanner(is, "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "<html><body>Error: No data from worker</body></html>";
        } catch (Exception e) {
            return "<html><body>Error: " + e.getMessage() + "</body></html>";
        }
    }

}




/*
package org.santiagom123;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Window {

    public void mainWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MineWiki");
            URL fileIcon = Window.class.getResource("textures/icon.png");

            if (fileIcon != null) {
                frame.setIconImage(new ImageIcon(fileIcon).getImage());
            }

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(Color.red);
            JLabel label = new JLabel(getURL.obtainURL(), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 40));
            panel.add(label, BorderLayout.CENTER);
            frame.add(panel, BorderLayout.NORTH);

            JFXPanel fxPanel = new JFXPanel();
            createScene(fxPanel);
            frame.add(fxPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private void createScene(JFXPanel jfxPanel) {
        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine engine = webView.getEngine();
            String targetUrl = getURL.obtainURL();

            new Thread(() -> {
                String processedHtml = fetchBypassedHtml(targetUrl);

                String baseUrl = targetUrl.substring(0, targetUrl.lastIndexOf("/") + 1);
                String fixedHtml = processedHtml.replaceFirst("<head>", "<head><base href=\"" + baseUrl + "\">");

                Platform.runLater(() -> {
                    engine.loadContent(fixedHtml, "text/html");
                    jfxPanel.setScene(new Scene(webView));
                });
            }).start();
        });
    }

    private String fetchBypassedHtml(String url) {
        try {
            // Correct Google Translate endpoint for website translation
            String encodedUrl = URLEncoder.encode(url, "UTF-8");
            String bypassUrl = "https://translate.google.com" + encodedUrl;

            HttpURLConnection conn = (HttpURLConnection) new URL(bypassUrl).openConnection();
            // Essential: Real User-Agent to avoid immediate block
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

            InputStream is = conn.getInputStream();
            Scanner s = new Scanner(is, "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "<html><body>Error: No data from worker</body></html>";
        } catch (Exception e) {
            return "<html><body><h1>Bypass Error</h1><p>" + e.getMessage() + "</p></body></html>";
        }
    }
}


 */