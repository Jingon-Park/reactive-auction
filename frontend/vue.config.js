
module.exports = {
  outputDir: "../src/main/resources/static/",
  indexPath: '../templates/index.html',
  pages:{
    default:{
      entry: 'src/main.js',
      template: 'public/index.html',
      filename: 'index.html'
    },
    login:{
        entry: 'src/pages/login/main.js',
        template: 'public/login.html',
        filename: 'login.out.html'
    },
    welcome:{
        entry: 'src/pages/welcome/main.js',
        template: 'public/welcome.html',
        filename: 'welcome.out.html'
    }
},
}