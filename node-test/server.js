var http = require('http');
console.log('Test server');

http.createServer(function (req, res) {
    if (req.method == 'POST') {
        req.on('data', function(data) {
            console.log(data.toString());
        }).on('end', function() { res.end() })
    }
}).listen(9999);