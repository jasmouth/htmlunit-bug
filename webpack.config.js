const path = require('path');

module.exports = {
	entry: {
		app: './src/main/resources/assets/js/application.js'
	},
	module: {
		loaders: [{
			test: /\.js$/,
			loaders: ['babel-loader'],
			exclude: /node_modules/
		}]
	},
	output: {
		path: path.join(__dirname, './target/frontend/static/'),
		filename: 'bundle.js'
	}
};
