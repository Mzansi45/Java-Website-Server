# Java Webserver

This is a simple Java webserver that allows anyone to host a website and perform basic server functions like serving mobile and desktop applications. The server is designed to be lightweight, easy to use, and customizable.

## Getting Started

To get started with the webserver, you need to have Java installed on your machine. You can download Java from the official website here.

Once you have Java installed, you can download the webserver code from this repository and extract it to a folder on your machine.

### Running the Server(Still to cum!!)

To run the server, simply open a command prompt or terminal window and navigate to the folder where you extracted the webserver code.

Then, run the following command:

Copy code
java -jar webserver.jar
This will start the webserver and listen for incoming requests on port 2023. You can access the webserver by navigating to the IP address of the machine where the server is running in your web browser.

## Hosting a Website

To host a website on the webserver, simply place the website files in the data folder in the webserver directory. The server will automatically serve these files when a user navigates to the IP address of the machine in their web browser.

## Customizing the Server

You can customize the server by modifying the config.properties file in the webserver directory. This file contains settings for the server, including the port number and various server options.

## Handling POST Requests

The webserver can handle POST requests and transmit data back and forth between any platform. To handle a POST request, simply create a new Java class that implements the HTTPRequestHandler interface and add it to the handlers package in the webserver code.

## Contributing

This project is an ongoing development effort, and contributions are welcome. If you would like to contribute to the project, please submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE] file for details.

## Acknowledgments

This project was inspired by the [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) project. Thanks to [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd) team for creating such a great lightweight webserver.
