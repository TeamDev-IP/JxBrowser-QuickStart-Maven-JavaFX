/*
 *  Copyright 2025, TeamDev. All rights reserved.
 *
 *  Redistribution and use in source and/or binary forms, with or without
 *  modification, must retain the above copyright notice and the following
 *  disclaimer.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.teamdev.jxbrowser.quickstart.maven.javafx;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This example demonstrates how to initialize Chromium, create a browser instance
 * (equivalent of the Chromium tab), embed a JavaFX BrowserView component into JavaFX
 * scene to display content of the loaded web page, load the required web page.
 */
public final class App extends Application {

    public static void main(String[] args) {
        launch(args); // Start the JavaFX application.
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize Chromium.
        var engine = Engine.newInstance(HARDWARE_ACCELERATED);

        var browser = engine.newBrowser();

        // Load the required web page.
        browser.navigation().loadUrl("https://html5test.teamdev.com");

        // Create and embed JavaFX BrowserView component to display web content.
        var view = BrowserView.newInstance(browser);

        var scene = new Scene(new BorderPane(view), 1280, 800);
        primaryStage.setTitle("JxBrowser JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Shutdown Chromium and release allocated resources.
        primaryStage.setOnCloseRequest(event -> engine.close());
    }
}
