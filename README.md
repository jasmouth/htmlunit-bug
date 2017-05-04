# Project Purpose
The purpose of this project is to demonstrate a bug in [HtmlUnit](http://htmlunit.sourceforge.net) when using the [React](https://github.com/facebook/react) and [React-Router](https://github.com/ReactTraining/react-router) libraries.

# Reproducing the Bug
1. Install the JavaScript dependencies by running the `npm install` command.
2. Generate the bundle by running the `npm run bundle` command.
3. Run the provided JUnit test.

# Description of the Bug
As the exception thrown by the JUnit test indicates, there is an attempt made to call a non-existing function on an object (the exact message in the exception is: 
`Caused by: net.sourceforge.htmlunit.corejs.javascript.EcmaError: TypeError: Cannot find function attachEvent in object scroll.`).
The offending line in `bundle.js` is ln#22825. This line corresponds to a function named `addEventListener` defined by the [history](https://github.com/ReactTraining/history) library which is a dependency of React-Router. The caller of this function (as determined by logging `arguments.callee.caller`) is a function named `listen` defined on ln#18513. This function is defined by React, and is ultimately called as a result of rendering a component via `ReactDOM.render()`.

For a reason unknown to me, the `addEventListener` function defined by the `history` library appears to somehow override `window.addEventListener`. This causes all calls to `window.addEventListener` to instead delegate to the incorrect function.

## Impact of the Bug
The existence of this bug prevents using HtmlUnit to test any web application that uses React and React-Router.
