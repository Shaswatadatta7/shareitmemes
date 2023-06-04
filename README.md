# Share It Memes

It's funny because it's true. We love memes because they have the power to make us laugh and see the humorous side of things. Share It Memes is a simple Android app that brings the joy of memes to your fingertips. With this app, you can discover and share hilarious memes with your friends and family.

## Development Setup

To get started with the development of Share It Memes, you will need the latest version of Android Studio (version 4.0 or newer) installed on your machine. Android Studio provides a powerful environment for Android app development and makes it easy to build and test your applications.

### 1. About the API

Share It Memes utilizes the MEME API, an open-source API created by [D3vd](https://github.com/D3vd). This API allows you to fetch random memes from Reddit, a popular online community where users share all sorts of content, including funny memes. The API is available on GitHub, and you can find more information about it [here](https://github.com/D3vd/Meme_Api).

To fetch a random meme from Reddit using the API, you can make a GET request to the following endpoint: [https://meme-api.herokuapp.com/gimme](https://meme-api.herokuapp.com/gimme). This endpoint will return a JSON response containing the details of a random meme, including the title, image URL, and other relevant information.

### 2. Tools Used

Share It Memes utilizes the following tools and libraries:

- **Glide**: Glide is a popular open-source media management and image loading framework for Android. It simplifies the process of loading images from various sources, such as URLs, into your app. Glide offers efficient caching mechanisms and provides a smooth and seamless image loading experience for the users.

- **Volley**: Volley is an HTTP library provided by Google that simplifies network requests in Android apps. It handles network operations asynchronously and efficiently, allowing you to retrieve data from web services with ease. Volley offers features such as request prioritization, caching, and automatic request retries.

- **Intent**: Intent is a fundamental component in Android that allows different components of an app to communicate with each other and with external apps. In the context of Share It Memes, Intent is used to share memes with other apps installed on the user's device. By leveraging Intent, users can share the memes they find amusing via various communication channels like social media, messaging apps, or email.

## Tags

Android, kotlin,Volley,glide,retrofit


Feel free to explore the code and enhance the functionality of Share It Memes. Let the laughter spread and brighten up everyone's day with hilarious memes!
