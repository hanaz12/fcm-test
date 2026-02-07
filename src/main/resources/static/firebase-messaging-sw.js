importScripts('https://www.gstatic.com/firebasejs/10.7.1/firebase-app-compat.js');
importScripts('https://www.gstatic.com/firebasejs/10.7.1/firebase-messaging-compat.js');

firebase.initializeApp({
    apiKey: "AIzaSyAkjvjqKqOTdWogm2r2D3CI5EmWDeh3vvI",
    authDomain: "test-notifications-5593a.firebaseapp.com",
    projectId: "test-notifications-5593a",
    storageBucket: "test-notifications-5593a.firebasestorage.app",
    messagingSenderId: "334568132059",
    appId: "1:334568132059:web:561f2ebd149b930f602bfe"
});

const messaging = firebase.messaging();