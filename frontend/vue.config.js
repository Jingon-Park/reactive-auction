
module.exports = {
  outputDir: "../src/main/resources/templates",
  pages:{
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