"use strict";

module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
	jshint: {
		options: {
			jshintrc: '.jshintrc',
			reporter: require('jshint-stylish')
		},
		all: {
			src: [
				'Gruntfile.js',
				'src/js/*.js',
			]
		}
	},
    sass: {                              // Task 
		dist: {                            // Target 
		  options: {                       // Target options 
			style: 'expanded'
		  },
		  files: {                         
			'dist/css/style.css': 'src/scss/style.scss',       // 'destination': 'source' 
		  }
		}
    },
	
	/*copy: {
		dist: {
			    expand: true,
				cwd:'src/js',
				src: '*.js',
				dest: 'dist/js/',
		}
	},*/
	watch: {
        src: {
		files: ['src/scss/style.scss'],
            tasks: ['sass:dist'],
            options: {
                spawn: false,
				livereload: true
            }
        } 
    },
	 connect: {
		server: {
		  options: {
			port: 9000,
			hostname: '0.0.0.0',
			base: '',
			open:true
		  }
		}
	},
	  
});

  // Load all plugins.
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-sass');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-connect');
  //grunt.loadNpmTasks('grunt-contrib-copy');
 
  // Register all Tasks.
  grunt.registerTask('default',  ['sass:dist','jshint:all','connect:server','watch:src']);
  grunt.registerTask('sass-compile',  ['sass:dist','watch:src']);
};