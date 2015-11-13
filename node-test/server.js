var http = require('http');
console.log('Test server');

http.createServer((req, res) => {
    if (req.method == 'POST') {
        req.on('data', data => {
            console.log(data.toString());
        }).on('end', () => { res.end() })
    }
}).listen(9999);